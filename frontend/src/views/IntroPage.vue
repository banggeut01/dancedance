<template>
  <div>
     <div class="intro">
      <h1 id="text1" class="neon">DANCE_DANCE</h1>
      <h1 id="text2">아무말 아무말</h1>

      <img id="myimg">
    </div>
    <section class="test">
      <h1>REVOLUTIONARRY</h1>
    </section>  
  </div>
</template>

<script>

export default {
  name: 'IntroPage',
  data() {
    return {

    }
  },
  methods: {
    scrollmagic() {
      // img
      const img = document.querySelector('#myimg')
      const imageArray = new Array;
      this.preloading(644, imageArray)
      console.log(imageArray)
      let obj = {curImg: 1};
      let maxlength = imageArray.length - 1;
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
        duration: '25000',
        triggerElement: '.intro',
        triggerHook: '0',
      })
      .setPin('.intro')
      .addIndicators()

      const scene4 = this.$scrollmagic.scene({
        duration: '20000',
        triggerElement: '.intro',
        triggerHook: '0',
        offset: '2000',
      })
      .setTween(tween)
      .addIndicators()
      
      //text1
      let scene2 = this.$scrollmagic.scene({
        duration: '1000',
        triggerElement: '.intro',
        triggerHook: '0'
      }).setTween(TweenLite.fromTo('#text1', 2, 
      {opacity: 1},
      {opacity: 0},
      ))
      .addIndicators()

      //text2
      const text2 = document.querySelector('#text2')
      let tl = new TimelineMax();
      tl.from(text2, 1, { opacity:0, y:200});
      tl.to(text2, 1, { opacity:0 ,y:-200}, 3);
      let scene3 = this.$scrollmagic.scene({
        duration: '3000',
        offset: '1000',
        triggerElement: '.intro',
        triggerHook: 0
      })
      .setTween(tl)
      .addIndicators()
      this.$scrollmagic.addScene(scene2)
      this.$scrollmagic.addScene(scene)
      this.$scrollmagic.addScene(scene3)
      this.$scrollmagic.addScene(scene4)
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
    preloading(n, imageArray) {
      for (let i=1; i <= n; i++) {
        let img = new Image();
        img.src = require(`../assets/introImg/scene${this.pad(i, 5)}.jpg`)
        imageArray.push(img)
      }
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
.intro {
  height: 100vh;
}

.intro img {
  height: 100%;
  width: 100%;
  object-fit: cover;
}

.intro h1 {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  font-size: 80px;
}

#text2 {
  color: white;
}

.test {
  width: 100%;
  height: 100vh;
  color: white;
}
.neon {
  font-family: neon;
  overflow: visible;
  color: #FB4264;
  font-size: 2rem;
  line-height: 2rem;
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
</style>