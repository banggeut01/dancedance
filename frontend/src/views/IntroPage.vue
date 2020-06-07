<template>
  <div>
    <Header style="position:fixed; z-index:10;"></Header>
     <div class="intro">
       <div class="black"></div>
      <h1 id="text1" class="neon">DANCE_DANCE</h1>
      <i class="material-icons" id="scroll">arrow_drop_down_circle</i>
      <p id="text2">너도 <br> 나같이 <br> 춤추고 싶니?</p>
      <p id="text3">댄스 댄스를 사용해봐!</p>
      <div class="ctext4">
        <p id="text4">웹캠만 있으면<br> 언제 어디서든 춤출수 있어</p> <br>
        <span>Pose estimation을 이용한 사용자 웹캠의 동영상과 춤 동영상을 비교</span>
      </div>
      <div class="ctext5">
        <p id="text5"><i class="fas fa-medal" text></i> 랭킹에서 다른 사람들에게 <br>  너의 실력을 보여줘!</p>
        <span>랭킹 시스템을 이용하여 <br> 총 스코어 랭킹과 각각의 춤별 랭킹을 볼 수 있습니다</span>
      </div>
        <p id="text6">너의 댄스본능을 깨워봐!</p>
      <div id="endblack"></div>
      <img id="myimg">
    </div>
    <section class="letsStart start">
      <div id="startLogo" class="neon" @click="moveMain">DANCE_DANCE</div>
      <div id="startBtn" @click="moveMain">
        START
      </div>
    </section>  
  </div>
</template>

<script>
import Header from "@/components/common/Header.vue";

export default {
  name: 'IntroPage',
  data() {
    return {

    }
  },
  components: {
    Header,
  },
  methods: {
    scrollmagic() {
      // img
      const img = document.querySelector('#myimg')
      const imageArray = new Array;
      this.preloading(570, imageArray, 'dance')
      let obj = {curImg: 0};
      let maxlength = imageArray.length -1;
      let tween = TweenLite.to(obj, 1, 
          {
              curImg: maxlength,
              roundProps : 'curImg',
              immediateRender: true,
              ease: Linear.easeNone,
              onUpdate: function () {
                  img.src = imageArray[obj.curImg * 1].src
              }
          }
      );

      // intro pin set
      const scene = this.$scrollmagic.scene({
        duration: '19000',
        triggerElement: '.intro',
        triggerHook: '0',
      })
      .setPin('.intro')
       


      const scene4 = this.$scrollmagic.scene({
        duration: '18000',
        triggerElement: '.intro',
        triggerHook: '0',
        offset: '500',
      })
      .setTween(tween)
      
      //text1
      let scene2 = this.$scrollmagic.scene({
        duration: '3000',
        triggerElement: '.intro',
        triggerHook: '0'
      }).setTween(TweenLite.fromTo('#text1', 15, 
      {opacity: 1},
      {opacity: 0},
      ))

      let scene11 = this.$scrollmagic.scene({
        duration: '400',
        triggerElement: '.intro',
        triggerHook: '0'
      }).setTween(TweenLite.fromTo('#scroll', 15, 
      {opacity: 1},
      {opacity: 0},
      ))

      let scene9 = this.$scrollmagic.scene({
        duration: '3000',
        triggerElement: '.intro',
        triggerHook: '0'
      }).setTween(TweenLite.fromTo('.black', 15, 
      {opacity: 1},
      {opacity: 0},
      ))

      let scene10 = this.$scrollmagic.scene({
        duration: '4500',
        triggerElement: '.intro',
        triggerHook: '0',
        offset: '14000'
      }).setTween(TweenLite.fromTo('#endblack', 15, 
      {opacity: 0},
      {opacity: 1},
      ))
       

      //text2
      const text2 = document.querySelector('#text2')
      let tl = new TimelineMax();
      tl.from(text2, 1, { opacity:0, y:200});
      tl.to(text2, 1, { opacity:0 ,y:-200}, 3);
      let scene3 = this.$scrollmagic.scene({
        duration: '3000',
        offset: '4000',
        triggerElement: '.intro',
        triggerHook: 0
      })
      .setTween(tl)
       

      //text3
      const text3 = document.querySelector('#text3')
      let tl3 = new TimelineMax();
      tl3.from(text3, 1, { opacity:0});
      tl3.to(text3, 1, { opacity:0}, 3);
      let scene5 = this.$scrollmagic.scene({
        duration: '3000',
        triggerElement: '.intro',
        triggerHook: '0',
        offset: '4500'
      }).setTween(tl3)
       

      //text4
      const text4 = document.querySelector('.ctext4')
      let tl4 = new TimelineMax();
      tl4.from(text4, 1, { opacity:0});
      tl4.to(text4, 1, { opacity:0}, 3);
      let scene6 = this.$scrollmagic.scene({
        duration: '3000',
        triggerElement: '.intro',
        triggerHook: '0',
        offset: '7500'
      }).setTween(tl4)
       

      //text5
      const text5 = document.querySelector('.ctext5')
      let tl5 = new TimelineMax();
      tl5.from(text5, 1, { opacity:0});
      tl5.to(text5, 1, { opacity:0}, 3);
      let scene7 = this.$scrollmagic.scene({
        duration: '3000',
        triggerElement: '.intro',
        triggerHook: '0',
        offset: '10500'
      }).setTween(tl5)
       

      //text6

      let scene8 = this.$scrollmagic.scene({
        duration: '4000',
        triggerElement: '.intro',
        triggerHook: '0',
        offset: '14500'
      }).setTween(TweenLite.fromTo('#text6', 15, 
      {opacity: 0},
      {opacity: 1},
      ))
       


      this.$scrollmagic.addScene(scene2)
      this.$scrollmagic.addScene(scene)
      this.$scrollmagic.addScene(scene3)
      this.$scrollmagic.addScene(scene4)
      this.$scrollmagic.addScene(scene5)
      this.$scrollmagic.addScene(scene6)
      this.$scrollmagic.addScene(scene7)
      this.$scrollmagic.addScene(scene8)
      this.$scrollmagic.addScene(scene9)
      this.$scrollmagic.addScene(scene10)
      this.$scrollmagic.addScene(scene11)
      // let accelamount = 0.1;
      // let scrollpos = 0;
      // let delay = 0;
      // let video = document.querySelector('video')
      // scene.on("update", e => {
      //   scrollpos = e.scrollPos / 1000;
      // });

      // setInterval(() => {
      //   delay += (scrollpos - delay) * accelamount;

      //   video.currentTime = delay;
      // }, 30);
    },
    pad(n, width) {
      n = n + '';
      return n.length >= width ? n : new Array(width - n.length + 1).join('0') + n;
    },
    preloading(n, imageArray, value) {
      for (let i=1; i <= n; i++) {
        let img = new Image();
        img.src = require(`../assets/introImg/${value}/scene${this.pad(i, 5)}.jpg`)
        imageArray.push(img)
      }
    },
    moveMain() {
      this.$router.push({ name: 'MainPage' })
    }
  },
  mounted () {
    this.$store.dispatch('isLogin', this.$axios)
    // console.log(this.$store.getters.user)
    this.scrollmagic()
  },
}
</script>

<style>
.black {
  width: 100%;
  height: 100vh;
  background-color: black;
  position: fixed;
}

#endblack {
  width: 100%;
  height: 100vh;
  background-color: black;
  position: fixed;
}

.intro {
  height: 100vh;
}

.intro img {
  height: 100%;
  width: 100%;
  object-fit: cover;
}

.intro p {
  font-size: 3.5vw;
}

#scroll {
  position: absolute;
  top: 70%;
  left: 50%;
  transform: translate(-50%, -50%);
  font-size: 4em;
  color: white;
    text-shadow: 0 0 5px #fff, 0 0 10px #fff, 0 0 15px #0073e6, 0 0 20px #0073e6, 0 0 25px #0073e6, 0 0 30px #0073e6, 0 0 35px #0073e6;
}

#text2 {
  position: absolute;
  top: 25%;
  left: 25%;
  transform: translate(-50%, -50%);
  font-weight: 900;
  text-decoration: none;
  color: white;
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  -moz-background-clip: text;
  -moz-text-fill-color: transparent;
  -ms-background-clip: text;
  -ms-text-fill-color: transparent;
  background-clip: text;
  text-fill-color: transparent;
  background-image: linear-gradient(45deg, 
                    #7794ff, 
                    rgb(116, 55, 180),
                    #FF1361,
                    #FFF800);
  /* animation: .8s shake infinite alternate; */
}

#text1 {
  position: absolute;
   top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  font-size: 8em !important;
  z-index: 7;
}

#text3 {
  position: absolute;
  color: white;
   top: 55%;
  left: 80%;
  transform: translate(-55%, -50%);
  font-weight: 900;
  text-decoration: none;
  color: white;
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  -moz-background-clip: text;
  -moz-text-fill-color: transparent;
  -ms-background-clip: text;
  -ms-text-fill-color: transparent;
  background-clip: text;
  text-fill-color: transparent;
  background-image: linear-gradient(45deg, 
                    #7794ff, 
                    rgb(116, 55, 180),
                    #FF1361,
                    #FFF800);
  animation: .8s shake infinite alternate;
}

.ctext4 {
  position: absolute;
  top: 25%;
  left:10%;
  font-weight: 900;
  text-decoration: none;
}

#text4 {
  font-size: 4em;
  color: white;
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  -moz-background-clip: text;
  -moz-text-fill-color: transparent;
  -ms-background-clip: text;
  -ms-text-fill-color: transparent;
  background-clip: text;
  text-fill-color: transparent;
  background-image: linear-gradient(45deg, 
                    #3440ee, 
                    #2af801,
                    #d6fc01);
}
.ctext4 span {
  color: white;
  font-size: 20px;
}

.ctext5 {
  position: absolute;
  top: 35%;
  left:10%;
  font-weight: 900;
  text-decoration: none;
}

#text5 {
  font-size: 4em;
  color: white;
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  -moz-background-clip: text;
  -moz-text-fill-color: transparent;
  -ms-background-clip: text;
  -ms-text-fill-color: transparent;
  background-clip: text;
  text-fill-color: transparent;
  background-image: linear-gradient(45deg, 
                    #F9E54E, 
                    #F8981D,
                    #E12E4B,
                    #5BBDC8);
}
.ctext5 span {
  color: white;
  font-size: 20px;
}

#text6 {
  font-size: 4vw;
  position: absolute;
  font-weight: 800;
  top: 40%;
  left:50%;
  transform: translate(-50%, 0);
  color: white;
  text-shadow: 0 0 5px #fff, 0 0 10px #fff, 0 0 15px #0073e6, 0 0 20px #0073e6, 0 0 25px #0073e6, 0 0 30px #0073e6, 0 0 35px #0073e6;
  z-index: 7;
}


.start {
  width: 100%;
  height: 100vh;
  background: radial-gradient(
    circle,
    #222,
    black 40%
  ) no-repeat;
}
.neon {
  font-family: neon;
  overflow: visible;
  color: #FB4264;
  text-shadow: 0 0 3vw #F40A35;
}
.neon {
  animation: neon 1s ease infinite;
  -moz-animation: neon 1s ease infinite;
  -webkit-animation: neon 1s ease infinite;
}

@keyframes neon {
  0%,
  100% {
    text-shadow: 0 0 1vw #FA1C16, 0 0 3vw #FA1C16, 0 0 10vw #FA1C16, 0 0 10vw #FA1C16, 0 0 .4vw #FED128, .5vw .5vw .1vw #806914;
    color: #FED128;
  }
  50% {
    text-shadow: 0 0 .5vw #800E0B, 0 0 1.5vw #800E0B, 0 0 5vw #800E0B, 0 0 5vw #800E0B, 0 0 .2vw #800E0B, .5vw .5vw .1vw #40340A;
    color: #806914;
  }
}

@keyframes shake {
  0% { transform: skewX(-15deg) translate(-50%, -50%); }
  5% { transform: skewX(15deg) translate(-50%, -50%); }
  10% { transform: skewX(-15deg) translate(-50%, -50%); }
  15% { transform: skewX(15deg) translate(-50%, -50%); }
  20% { transform: skewX(0deg) translate(-50%, -50%); }
  100% { transform: skewX(0deg) translate(-50%, -50%); }  
}
.letsStart {
  width: 100vw;
  line-height: 100%;
  text-align: center;
  height: 100vh;
}
#startLogo {
  position: relative;
  font-size: 5rem !important;
  width: 52vw;
  top:50%; left:50%;
  transform: translate(-50%, -50%);
}
#startBtn {
  position: relative;
  font-size: 4rem !important;
  width: 52vw;
  top:60%; left:50%;
  transform: translate(-50%, -50%);
  color: #FF9900;
  font-family: Pacifico;
  -webkit-transition: all 0.5s;
  -moz-transition: all 0.5s;
  transition: all 0.5s;
  cursor: pointer;
}

#startBtn:hover {
  color: #ffffff;
  -webkit-animation: neon5 1.5s ease-in-out infinite alternate;
  -moz-animation: neon5 1.5s ease-in-out infinite alternate;
  animation: neon5 1.5s ease-in-out infinite alternate;
}
@-webkit-keyframes neon5 {
  from {
    text-shadow: 0 0 10px #fff, 0 0 20px #fff, 0 0 30px #fff, 0 0 40px #FF9900, 0 0 70px #FF9900, 0 0 80px #FF9900, 0 0 100px #FF9900, 0 0 150px #FF9900;
  }
  to {
    text-shadow: 0 0 5px #fff, 0 0 10px #fff, 0 0 15px #fff, 0 0 20px #FF9900, 0 0 35px #FF9900, 0 0 40px #FF9900, 0 0 50px #FF9900, 0 0 75px #FF9900;
  }
}
@-moz-keyframes neon5 {
  from {
    text-shadow: 0 0 10px #fff, 0 0 20px #fff, 0 0 30px #fff, 0 0 40px #FF9900, 0 0 70px #FF9900, 0 0 80px #FF9900, 0 0 100px #FF9900, 0 0 150px #FF9900;
  }
  to {
    text-shadow: 0 0 5px #fff, 0 0 10px #fff, 0 0 15px #fff, 0 0 20px #FF9900, 0 0 35px #FF9900, 0 0 40px #FF9900, 0 0 50px #FF9900, 0 0 75px #FF9900;
  }
}
@keyframes neon5 {
  from {
    text-shadow: 0 0 10px #fff, 0 0 20px #fff, 0 0 30px #fff, 0 0 40px #FF9900, 0 0 70px #FF9900, 0 0 80px #FF9900, 0 0 100px #FF9900, 0 0 150px #FF9900;
  }
  to {
    text-shadow: 0 0 5px #fff, 0 0 10px #fff, 0 0 15px #fff, 0 0 20px #FF9900, 0 0 35px #FF9900, 0 0 40px #FF9900, 0 0 50px #FF9900, 0 0 75px #FF9900;
  }
}
</style>