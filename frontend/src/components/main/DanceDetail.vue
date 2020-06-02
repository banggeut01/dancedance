<template>
  <div 
    class="danceDetail"
    :style="'background: url(' + require('@/assets/danceDetailBackgroundImg.png') + ') no-repeat 100%;'"
  >
    <div id="dancePlayInfo" >
      <video id="danceVideo" autoplay loop width="100%" :key="nowDance.id">
        <source :src="danceVideo" type="video/mp4">
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
      <section class="danceInfo">{{this.nowDance.title}} / 난이도 {{this.nowDance.difficulty}}</section>
      <section class="myScore"><i id="scoreStar" class="fas fa-star"></i> <p id="scoreBoard">My Score : {{ this.nowDance.myPoint }}</p></section>
    </div>
    <carousel class="otherDances" :paginationEnabled="false" :perPage="4">
      <slide v-for="dance in dances" :key="dance.id" v-on:mouseover="cursorOver">
        <img class="otherDanceThumbnail" :src="dance.thumbnail" :alt="dance.title" v-on:mouseover="nextDance=dance" @click="changeDetail" style="width: 20vw">
      </slide>
    </carousel>
  </div>
</template>

<script>
import { Carousel, Slide } from 'vue-carousel';

export default {
    name: 'DanceDetail',
    data() {
      return {
        nextDance: []
      }
    },
    props: ['dances', 'nowDance', 'id'],
    components: {
      Carousel,
      Slide
    },
    methods: {
      dancePlay() {
        this.$router.replace({ name: 'PlayPage', params: {'id': this.nowDance.video_id}})
      },
      changeDetail() {
        this.$router.replace({ name: 'DanceDetailPage', params: {'dances': this.dances, 'nowDance': this.nextDance, 'id': this.nextDance.video_id}})
      },
      cursorOver() {
        
      }
    },
    mounted() {
      document.getElementById('danceVideo').volume = 0;
    },
    computed: {
      danceVideo: function () {
        return this.nowDance.file
      }
    }
}
</script>

<style>
.danceDetail {
  z-index: -1;
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
  display: inline;
}
.otherDances {
  position: fixed;
  bottom: 5vh;
  left: 2vw;
  width: 100%;
}
.otherDanceThumbnail {
  height: 25vh;
  cursor: pointer;
}
.danceInfo {
  display:inline; 
  color: #ffffff;
  font-size: 3em;
}
.myScore {
  position: fixed;
  font-size: 4em;
  top: 15vh;
  left: 50vw;
}
#scoreStar {
  color: rgb(255, 255, 0);
  text-shadow: 0 0 10px rgb(238, 255, 0), 0 0 20px rgb(238, 255, 0);
}
#scoreBoard {
  display: inline;
  color: #ffffff;
}
</style>