<template>
  <div>
     <div class="intro">
      <h1 id="test1">The New Dev Ed Pro</h1>
      <video ref="vedio" src="../assets/intro1.mp4"></video>
    </div>
    <section class="test">
      <h1>REVOLUTIONARRY</h1>
    </section>  
  </div>
</template>

<script>
import { TweenMax, TimelineMax } from 'gsap'

export default {
  name: 'IntroPage',
  methods: {
    scrollmagic() {
      const scene = this.$scrollmagic.scene({
        duration: '6000',
        triggerElement: '.intro',
        triggerHook: '0'
      })
      .setPin('.intro')
      .addIndicators()


      let scene2 = this.$scrollmagic.scene({
        duration: '2000',
        triggerElement: '.intro',
        triggerHook: '0'
      }).setTween(TweenLite.fromTo('#test1', 2, 
      {opacity: 1},
      {opacity: 0}
      ))
      .addIndicators()
      this.$scrollmagic.addScene(scene2)
      this.$scrollmagic.addScene(scene)
      let accelamount = 0.1;
      let scrollpos = 0;
      let delay = 0;
      let video = document.querySelector('video')
      scene.on("update", e => {
        scrollpos = e.scrollPos / 1000;
      });

      setInterval(() => {
        delay += (scrollpos - delay) * accelamount;

        video.currentTime = delay;
      }, 30);
    }
  },
  mounted () {
    this.scrollmagic()
  },
}
</script>

<style>
.intro {
  height: 100vh;
}

.intro video {
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