<template>
  <div class="danceDetail">
    <div id="dancePlayInfo" style="background: black; height: 62%;">
      <video id="danceVideo" autoplay loop width="100%" :key="nowDance.id" v-on:mouseover="playMouseOver">
        <source :src="danceVideo" type="video/mp4">
      </video>
      <div id="playBtn" @click="dancePlay" v-on:mouseleave="playMouseLeave">
        <p>Game Play</p>
      </div>
      
      <section class="danceInfo" style="left: -2vw; top: -1vh"> 
        <v-btn
          class="mx-2" 
          color="purple"
          style="background: #E7E600;"
          fab dark x-large
        >
          <v-icon x-large>play_arrow</v-icon>
        </v-btn> / {{this.nowDance.title}} / 난이도 {{this.nowDance.difficulty}}</section>
      <section class="myScore"><i id="scoreStar" class="fas fa-star"></i> <p id="scoreBoard">My Score : {{ this.nowDance.myPoint }}</p></section>
    </div>
    <p id="otherDancesList">다른 노래</p>
    <carousel class="otherDances" :loop="true" :resistanceCoef="100" :scrollPerPage="false" :paginationEnabled="false" :perPage="4">
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
      playMouseOver() {
        document.getElementById('playBtn').style.zIndex = 1;
      },
      playMouseLeave() {
        document.getElementById('playBtn').style.zIndex = -1;
      }
    },
    mounted() {
      document.getElementById('danceVideo').volume = 0.05;
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
#playBtn {
  z-index: -1;
  position: fixed;
  left: 10vw;
  top: 20vh;
  width: 30vw;
  height: 16.9vw;
  text-align: center;
  display: table;
  background-color: rgba(0, 0, 0, 0.4);
  cursor: pointer;
}
#playBtn > p {
  font-family: 'Black Han Sans';
  color: rgba(255, 255, 255, 0.7);
  font-size: 4em;
  display:table-cell;
  vertical-align: middle;
}
.dancePlayInfo {
  position: static;
  display: inline;
}
#otherDancesList{
  color: rgba(255, 255, 255, 0.7);
  position: absolute;
  bottom: 32vh;
  left: 1vw;
  font-size: 2em;
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