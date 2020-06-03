import nodeBar from "../../assets/playImg/nodeBar.png";
import badEffect from "../../assets/playImg/badEffect.png";
import goodEffect from "../../assets/playImg/goodEffect.png";
import greatEffect from "../../assets/playImg/greatEffect.png";
import perfectEffect from "../../assets/playImg/perfectEffect.png";

import bombEffect1 from "../../assets/playImg/bombEffect1.gif";
import bombEffect2 from "../../assets/playImg/bombEffect2.gif";
import bombEffect3 from "../../assets/playImg/bombEffect3.gif";
import bombEffect4 from "../../assets/playImg/bombEffect4.gif";

import ml5 from "ml5";
import axios from "axios";
import { poseSimilarity } from "posenet-similarity";

export default async function(sketch) {
  class Node {
    constructor(time, img, pose) {
      this.x = 0;
      this.time = time;
      this.img = img;
      this.img.hide();
      this.pose = pose;
    }
  }
  let SCORE = [0, 0, 0, 0];

  let endTime = 99999;
  let nodeList = [];
  let barNodeList = [];

  let video;
  let videoPosenet;
  let videoPoseResult = [];

  let cam;
  let camPosenet;
  let camPoseResult = [];

  let sig = [false, false, false, false];

  let imgEffect = [
    sketch.createImg(badEffect),
    sketch.createImg(goodEffect),
    sketch.createImg(greatEffect),
    sketch.createImg(perfectEffect),
  ];

  let bombSig = [false, false, false, false];
  let bombEffect = [
    sketch.loadImage(bombEffect1),
    sketch.loadImage(bombEffect2),
    sketch.loadImage(bombEffect3),
    sketch.loadImage(bombEffect4),
  ];

  let img_nodeBar = sketch.createImg(nodeBar);

  let startTime;
  let lastEffectTime = 0;

  async function getNode() {
    return new Promise(function(resolve) {
      axios
        .get(
          "http://k02b1021.p.ssafy.io:8197/ssafy-dance/api/play/" +
            window.videoId
        )
        .then((res) => {
          resolve(res.data.icon);
          endTime = res.data.end;
        })
        .catch((err) => {
          console.log(err);
        });
    });
  }

  function imageHide() {
    img_nodeBar.hide();
    for (var i = 0; i < imgEffect.length; i++) {
      imgEffect[i].hide();
    }
  }

  function getCurtime() {
    var dt = new Date().getTime();
    var curTime = Math.floor((dt - startTime) / 1000);
    return curTime + 2;
  }

  function effectInit() {
    if (getCurtime() - lastEffectTime == 2) {
      for (var i = 0; i < sig.length; i++) {
        sig[i] = false;
      }
    }
    if (getCurtime() - lastEffectTime == 1) {
      for (var j = 0; j < bombSig.length; j++) {
        bombSig[j] = false;
      }
    }
  }

  function effectOn(k) {
    for (var i = 0; i < sig.length; i++) sig[i] = false;
    sig[k] = true;
  }
  function bombEffectOn(k) {
    for (var i = 0; i < bombSig.length; i++) bombSig[i] = false;
    bombSig[k] = true;
  }

  function drawEffect() {
    for (var i = 0; i < sig.length; i++) {
      if (sig[i]) {
        sketch.image(imgEffect[i], 650, 100);
      }

      if (bombSig[i]) {
        if (i == 0) {
          sketch.image(bombEffect[i], 270, 487);
        } else if (i == 1) {
          sketch.image(bombEffect[i], 420, 600);
        } else if (i == 2) {
          sketch.image(bombEffect[2], 295, 560);
        } else if (i == 3) {
          sketch.image(bombEffect[3], 400, 583);
        }
      }
    }
  }

  function addBarNode() {
    if (nodeList.length != 0) {
      let cur = nodeList[0];
      if (cur.time == getCurtime()) {
        nodeList.shift();
        barNodeList.push(cur);
      }
    }
  }

  function drawNode() {
    for (var i = 0; i < barNodeList.length; i++) {
      let cur = barNodeList[i];
      sketch.image(cur.img, cur.x, 665);
      cur.x += 3;
    }

    if (barNodeList.length != 0) {
      if (barNodeList[0].x > 535) {
        let cosineSimilarity = 0;
        if (videoPoseResult[0].pose != null && camPoseResult[0].pose != null) {
          cosineSimilarity = poseSimilarity(
            videoPoseResult[0].pose,
            camPoseResult[0].pose,
            { strategy: "cosineSimilarity" }
          );
        }

        cosineSimilarity *= 100;
        // console.log(cosineSimilarity);
        // console.log(getCurtime() - 2);
        if (cosineSimilarity > 96) {
          SCORE[3]++;
          bombEffectOn(3);
          effectOn(3);
        } else if (cosineSimilarity > 93) {
          SCORE[2]++;
          bombEffectOn(2);
          effectOn(2);
        } else if (cosineSimilarity > 90) {
          SCORE[1]++;
          bombEffectOn(1);
          effectOn(1);
        } else {
          SCORE[0]++;
          bombEffectOn(0);
          effectOn(0);
        }

        lastEffectTime = getCurtime();

        barNodeList.shift();
      }
    }
  }

  async function makeNode(list) {
    let tmpList = [];
    for (var i = 0; i < list.length; i++) {
      let img = sketch.createImg(list[i].img);
      tmpList.push(new Node(list[i].sec, img, 0));
    }

    return new Promise((resolve) => {
      if (tmpList.length == list.length) {
        resolve(tmpList);
      }
    });
  }

  async function bindPage() {
    let urlNodeList = await getNode();
    nodeList = await makeNode(urlNodeList);

    video = await loadVideo();

    videoPosenet = ml5.poseNet(video);
    videoPosenet.on("pose", function(results) {
      videoPoseResult = results;
    });

    cam = await loadCam();

    camPosenet = ml5.poseNet(cam);
    camPosenet.on("pose", function(results) {
      camPoseResult = results;
    });
    cam.hide();
    video.hide();
    video.play();

    startTime = new Date().getTime();
  }

  async function loadCam() {
    let c = null;
    c = sketch.createCapture(window.VIDEO);

    return new Promise((resolve) => {
      if (c != null) {
        resolve(c);
      }
    });
  }

  async function loadVideo() {
    let v = null;
    v = sketch.createVideo(window.videoURL);

    return new Promise((resolve) => {
      if (v != null) {
        resolve(v);
      }
    });
  }

  async function calcScore() {
    return new Promise((resolve) => {
      const scoreDate = {
        video_id: window.videoId,
        bad: SCORE[0],
        good: SCORE[1],
        great: SCORE[2],
        perfect: SCORE[3],
      };
      this.$axios
        .post(
          "http://k02b1021.p.ssafy.io:8197/ssafy-dance/api/play/result",
          scoreDate
        )
        .then((res) => {
          resolve(res.status);
        });
    });
  }

  sketch.preload = async function() {
    // await bindPage();
  };

  sketch.setup = async function() {
    const canvas = sketch.createCanvas(1600, 900);
    canvas.clear();
    canvas.parent("videoContainer");
    sketch.background(100);
    await bindPage();
    imageHide();
  };

  sketch.draw = async function() {
    sketch.translate(1600, 0);
    sketch.scale(-1.0, 1.0);

    if (video != null && video.loadedmetadata) {
      sketch.image(video, 0, 0, 1600, 900);
    }

    if (cam != null && cam.loadedmetadata) {
      sketch.image(cam, 100, 250, 500, 375);
    }
    sketch.image(img_nodeBar, 0, 650);
    effectInit();
    addBarNode();
    drawNode();
    drawEffect();
    drawKeypoints();
    if (endTime != -1 && endTime <= getCurtime() - 2 + 120) {
      video.pause();
      var status = await calcScore();
      console.log(status);
    }
  };

  function drawKeypoints() {
    for (let i = 0; i < camPoseResult.length; i++) {
      let pose = camPoseResult[i].pose;
      for (let j = 0; j < pose.keypoints.length; j++) {
        let keypoint = pose.keypoints[j];
        if (keypoint.score > 0.2) {
          sketch.fill(255, 0, 0);
          sketch.noStroke();
          sketch.ellipse(keypoint.position.x, keypoint.position.y, 10, 10);
        }
      }
    }
    for (let i = 0; i < videoPoseResult.length; i++) {
      let pose = videoPoseResult[i].pose;
      for (let j = 0; j < pose.keypoints.length; j++) {
        let keypoint = pose.keypoints[j];
        if (keypoint.score > 0.2) {
          sketch.fill(255, 0, 0);
          sketch.ellipse(keypoint.position.x, keypoint.position.y, 10, 10);
        }
      }
      sketch.scale(-1.0, -1.0);
    }
  }
}
