<template>
  <div>
     <div class="intro">
      <h1 id="text1">아무 말이나 적어야지</h1>
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
      this.preloading(79, imageArray)
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
        duration: '5000',
        triggerElement: '.intro',
        triggerHook: '0'
      })
      .setPin('.intro')
      .setTween(tween)
      .addIndicators()

      
      //text1
      let scene2 = this.$scrollmagic.scene({
        duration: '1000',
        triggerElement: '.intro',
        triggerHook: '0'
      }).setTween(TweenLite.fromTo('#text1', 2, 
      {opacity: 1},
      {opacity: 0}
      ))
      .addIndicators()

      //text2
      const text2 = document.querySelector('#text2')
      let tl = new TimelineMax();
      tl.from(text2, 1, { opacity:0, y:200});
      tl.to(text2, 1, { opacity:0 ,y:-200}, 3);
      let scene3 = this.$scrollmagic.scene({
        duration: '1000',
        offset: '1500',
        triggerElement: '.intro',
        triggerHook: 0
      })
      .setTween(tl)
      .addIndicators()
      this.$scrollmagic.addScene(scene2)
      this.$scrollmagic.addScene(scene)
      this.$scrollmagic.addScene(scene3)
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
  color: white;
}

.test {
  width: 100%;
  height: 100vh;
  color: white;
}
</style>