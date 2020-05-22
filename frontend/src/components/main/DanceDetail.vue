<template>
  <div 
    class="danceDetail"
    :style="'background: url(' + require('@/assets/danceDetailBackgroundImg.png') + ') no-repeat 100%;'"
  >
    <div id="dancePlayInfo" >
      <video id="danceVideo" autoplay loop>
        <source :src="require('@/assets/danceList/' + nowDance.src)" type="video/webm">
      </video>
      <v-btn 
        class="mx-2" 
        color="purple" 
        fab dark large 
        @click="dancePlay" 
        style="left: -4vw; top: -3vh; background: #E7E600"
      >
        <v-icon>play_arrow</v-icon>
      </v-btn>
      
    </div>
    <carousel class="otherDances" :paginationEnabled="false" :perPage="4">
      <slide v-for="dance in dances" :key="dance.id">
        <img class="otherDanceThumbnail" :src="require('@/assets/danceList/' + dance.thumbnail)" :alt="dance.title" style="width: 20vw">
      </slide>
    </carousel>
  </div>
</template>

<script>
import { Carousel, Slide } from 'vue-carousel';

export default {
    name: 'DanceDetail',
    props: ['dances', 'nowDance', 'closeDetail'],
    components: {
      Carousel,
      Slide
    },
    methods: {
      dancePlay() {
        this.$router.push('/play')
      }
    },
    mounted() {
      document.getElementById('danceVideo').volume = 0.1;
    }
}
</script>

<style>
.danceDetail {
  z-index: 0;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}
#danceVideo {
  position: static;
  margin-top: 20vh;
  margin-left: 10vw;
  width: 30vw;
}
.dancePlayInfo {
  position: static;
}
.otherDances {
  position: fixed;
  bottom: 5vh;
  left: 2vw;
  width: 100%;
}
.otherDanceThumbnail {
  height: 25vh;
}
</style>