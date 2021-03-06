<template>
	<div class="illustrationDiv">
		<div id="loading">
			<span class="spinner-text" id="status">
				곧 당신의 아바타를 움직일 수 있어요!
			</span>
		</div>
		<div class="canvas-container">
			<div id='main' style='display:none'>
				<video id="video" playsinline style=" -moz-transform: scaleX(-1);
            -o-transform: scaleX(-1);
            -webkit-transform: scaleX(-1);
            transform: scaleX(-1);
            display: none;
            ">
				</video>
				<canvas id="output" class="camera-canvas" style="display: none"></canvas>
				<canvas id="keypoints" class="camera-canvas" style="display: none"></canvas>
			</div>
			<canvas class="illustration-canvas"></canvas>
		</div>
	</div>
</template>

<script>
	import * as posenet_module from '@tensorflow-models/posenet';
	import * as facemesh_module from '@tensorflow-models/facemesh';
	import * as paper from 'paper'
	import {
		toggleLoadingUI,
		setStatusText
	} from './utils/demoUtils';
	import {
		SVGUtils
	} from './utils/svgUtils'
	import {
		PoseIllustration
	} from './illustrationGen/illustration';
	import {
		Skeleton
	} from './illustrationGen/skeleton';

	import * as girlSVG from './resources/illustration/girl.svg';
	import * as boySVG from './resources/illustration/boy.svg';
	import * as owlSVG from './resources/illustration/owl.svg';
	import * as raccoonSVG from './resources/illustration/raccoon.svg';
	import * as yeomSVG from './resources/illustration/yeom.svg';

	export default {
		name: 'FaceMesh',
		props: {
			name: {
				type: String
			}
		},
		data() {
			return {
				// Camera stream video element
				video: {},
				videoWidth: 300,
				videoHeight: 300,
				// Canvas
				faceDetection: null,
				illustration: null,
				canvasScope: null,
				canvasWidth: 500,
				canvasHeight: 500,
				// ML models
				facemesh: null,
				posenet: null,
				tf: null,
				minPoseConfidence: 0.15,
				minPartConfidence: 0.1,
				nmsRadius: 30.0,
				// SVG 이미지
				avatarSvgs: {
					'girl': girlSVG.default,
					'boy': boySVG.default,
					'owl': owlSVG.default,
					'raccoon': raccoonSVG.default,
					'yeom': yeomSVG.default
				},
				selected: {},
				// PoseNet 설정(?)
				defaultPoseNetArchitecture: 'MobileNetV1',
				defaultQuantBytes: 2,
				defaultMultiplier: 1.0,
				defaultStride: 16,
				defaultInputResolution: 200,
			}
		},
		methods: {
			async setupCamera() {
				if (!navigator.mediaDevices || !navigator.mediaDevices.getUserMedia) {
					throw new Error(
						'Browser API navigator.mediaDevices.getUserMedia not available');
				}

				const video = document.getElementById('video');
				video.width = this.videoWidth;
				video.height = this.videoHeight;

				const stream = await navigator.mediaDevices.getUserMedia({
					'audio': false,
					'video': {
						facingMode: 'user',
						width: this.videoWidth,
						height: this.videoHeight,
					},
				});
				video.srcObject = stream;

				return new Promise((resolve) => {
					video.onloadedmetadata = () => {
						resolve(video);
					};
				});
			},
			async loadVideo() {
				const video = await this.setupCamera();
				video.play();

				return video;
			},
			detectPoseInRealTime(video) {
				const canvas = document.getElementById('output');
				const keypointCanvas = document.getElementById('keypoints');
				const videoCtx = canvas.getContext('2d');
				const keypointCtx = keypointCanvas.getContext('2d');

				canvas.width = this.videoWidth;
				canvas.height = this.videoHeight;
				keypointCanvas.width = this.videoWidth;
				keypointCanvas.height = this.videoHeight;

				let th = this;
				async function poseDetectionFrame() {
					let poses = [];

					videoCtx.clearRect(0, 0, th.videoWidth, th.videoHeight);
					// Draw video
					videoCtx.save();
					videoCtx.scale(-1, 1);
					videoCtx.translate(-th.videoWidth, 0);
					videoCtx.drawImage(video, 0, 0, th.videoWidth, th.videoHeight);
					videoCtx.restore();

					// Creates a tensor from an image
					const input = th.tf.browser.fromPixels(canvas);
					th.faceDetection = await th.facemesh.estimateFaces(input, false, false);
					let all_poses = await th.posenet.estimatePoses(video, {
						flipHorizontal: true,
						decodingMethod: 'multi-person',
						maxDetections: 1,
						scoreThreshold: th.minPartConfidence,
						nmsRadius: th.nmsRadius
					});

					poses = poses.concat(all_poses);
					input.dispose();

					keypointCtx.clearRect(0, 0, th.videoWidth, th.videoHeight);
					th.canvasScope.project.clear();
					// 아바타가 따라할 수 있도록 그리는 부분
					if (poses.length >= 1 && th.illustration) {
						Skeleton.flipPose(poses[0]);

						if (th.faceDetection && th.faceDetection.length > 0) {
							let face = Skeleton.toFaceFrame(th.faceDetection[0]);
							th.illustration.updateSkeleton(poses[0], face);
						} else {
							th.illustration.updateSkeleton(poses[0], null);
						}
						th.illustration.draw(th.canvasScope, th.videoWidth, th.videoHeight);

						if (th.guiState.debug.showIllustrationDebug) {
							th.illustration.debugDraw(th.canvasScope);
						}
					}

					th.canvasScope.project.activeLayer.scale(
						th.canvasWidth / th.videoWidth,
						th.canvasHeight / th.videoHeight,
						new th.canvasScope.Point(0, 0));

					requestAnimationFrame(poseDetectionFrame);
				}
				poseDetectionFrame();
			},
			setupCanvas() {
				this.canvasScope = paper.default;
				let canvas = document.querySelector('.illustration-canvas');
				canvas.width = this.canvasWidth;
				canvas.height = this.canvasHeight;
				this.canvasScope.setup(canvas);
			},
			async bindPage() {
				this.setupCanvas();

				toggleLoadingUI(true);
				setStatusText('곧 당신의 아바타를 움직일 수 있어요!');
				// PoseNet 모델 불러오기
				this.posenet = await posenet_module.load({
					architecture: this.defaultPoseNetArchitecture,
					outputStride: this.defaultStride,
					inputResolution: this.defaultInputResolution,
					multiplier: this.defaultMultiplier,
					quantBytes: this.defaultQuantBytes
				});
				setStatusText('FaceMesh 모델을 불러오고 있어요! 인내심을 가져주세요...');
				// FaceMesh 모델 불러오기
				this.facemesh = await facemesh_module.load();

				setStatusText('선택한 아바타 이미지를 입력하고 있어요! 거의 다 되었어요!');
				// 아바타 불러오기
				await this.parseSVG(Object.values(this.selected)[0]);

				setStatusText('캠을 연동하고 있어요! 이제 아바타를 움직일 수 있어요!');
				try {
					this.video = await this.loadVideo();
				} catch (e) {
					let info = document.getElementById('info');
					info.textContent = 'this device type is not supported yet, ' +
						'or this browser does not support video capture: ' + e.toString();
					info.style.display = 'block';
					throw e;
				}

				toggleLoadingUI(false);
				this.detectPoseInRealTime(this.video, this.posenet);
			},
			async parseSVG(target) {
				let svgScope = await SVGUtils.importSVG(target /* SVG string or file path */ );
				let skeleton = new Skeleton(svgScope);
				this.illustration = new PoseIllustration(this.canvasScope);
				this.illustration.bindSkeleton(skeleton, svgScope);
			}
		},
		watch: {
			name: function () {
				if (this.name === 'Boy') {
					this.selected = {
						'boy': boySVG.default
					}
				} else if (this.name === 'Girl') {
					this.selected = {
						'girl': girlSVG.default
					}
				} else if (this.name === 'Owl') {
					this.selected = {
						'owl': owlSVG.default
					}
				} else if (this.name === 'Raccoon') {
					this.selected = {
						'raccoon': raccoonSVG.default
					}
				} else if (this.name === 'Yeom') {
					this.selected = {
						'yeom': yeomSVG.default
					}
				}
				this.guiState = {
					avatarSVG: Object.keys(this.selected)[0],
					debug: {
						showDetectionDebug: true,
						showIllustrationDebug: false,
					},
				}
				this.bindPage();
			},
		},
		mounted() {
			import('@tensorflow/tfjs').then((tf) => {
				this.tf = tf
				import("babel-polyfill").then(() => {
					if (this.name === 'Boy') {
						this.selected = {
							'boy': boySVG.default
						}
					} else if (this.name === 'Girl') {
						this.selected = {
							'girl': girlSVG.default
						}
					} else if (this.name === 'Owl') {
						this.selected = {
							'owl': owlSVG.default
						}
					} else if (this.name === 'Raccoon') {
						this.selected = {
							'raccoon': raccoonSVG.default
						}
					} else if (this.name === 'Yeom') {
						this.selected = {
							'yeom': yeomSVG.default
						}
					}
					this.guiState = {
						avatarSVG: Object.keys(this.selected)[0],
						debug: {
							showDetectionDebug: true,
							showIllustrationDebug: false,
						},
					}
					navigator.getUserMedia = navigator.getUserMedia ||
						navigator.webkitGetUserMedia || navigator.mozGetUserMedia;

					this.bindPage();
				})
			})
		}
	}
</script>

<style>
	.illustrationDiv {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.canvas-container {
		width: 800px;
		max-width: 100%;
		display: flex;
		justify-content: center;
		position: relative;
	}

	.camera-canvas {
		position: absolute;
		transform: scale(0.5, 0.5);
		transform-origin: 0 0;
		left: 10px;
		top: 10px;
	}

	#main {
		left: 0;
		top: 0;
		position: absolute;
	}

	/* .illustration-canvas {
		border: 1px solid #eeeeee;
	} */

	.footer {
		position: fixed;
		left: 0;
		bottom: 0;
		width: 100%;
		color: black;
	}

	.footer-text {
		max-width: 600px;
		text-align: center;
		margin: auto;
	}

	@media only screen and (max-width: 600px) {

		.footer-text,
		.dg {
			display: none;
		}
	}

	@-webkit-keyframes sk-pulseScaleOut {
		0% {
			-webkit-transform: scale(0);
			transform: scale(0);
		}

		100% {
			-webkit-transform: scale(1.0);
			transform: scale(1.0);
			opacity: 0;
		}
	}

	@keyframes sk-pulseScaleOut {
		0% {
			-webkit-transform: scale(0);
			transform: scale(0);
		}

		100% {
			-webkit-transform: scale(1.0);
			transform: scale(1.0);
			opacity: 0;
		}
	}

	.spinner-text {
		float: left;
		font-size: 20px;
		color: white;
	}
</style>