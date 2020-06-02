<template>
  <div>
    <!-- background video -->
    <video src="@/assets/rankbgmin.mp4" autoplay muted loop class="rankbg"></video>
    <!-- background sound -->
    <audio id="rankbgm" class="rank-audio" autoplay loop>
      <source src="../assets/rank_bgm.mp3" type="audio/mpeg">
    </audio>
    <Header class="header-pos header-color"></Header>
    <v-row class="rankpage-div">
      <v-col cols="6" class="rank-border">
        <!-- 춤별 랭킹 -->
        <SongRank :videoRanking="videoRanking" class="rank-backcolor"></SongRank>
      </v-col>
      <v-col cols="6" class="rank-border">
        <!-- 총 score 랭킹 -->
        <TotalRank :ranking="ranking" :myRanking="myRanking" class="rank-backcolor"></TotalRank>
      </v-col>
    </v-row>
  </div> 
</template>

<script>
import Header from '@/components/common/Header.vue'
import SongRank from '@/components/rank/SongRank.vue'
import TotalRank from '@/components/rank/TotalRank.vue'
export default {
  name: 'RankPage',
  components: {
    Header,
    SongRank,
    TotalRank
  },
  data () {
    return {
      ranking: [],
      myRanking: {},
      videoRanking: [],
    }
  },
  methods: {
    getRankData() {
      this.$axios.get('http://k02b1021.p.ssafy.io:8197/ssafy-dance/api/ranking/score')
        .then((res) => {
          this.ranking = res.data.ranking
          this.myRanking = res.data.myRanking
        })
    },
    getVideoRankData() {
      this.$axios.get('http://k02b1021.p.ssafy.io:8197/ssafy-dance/api/ranking/video')
        .then((res) => {
          this.videoRanking = res.data.ranking
        })
    }
  },
  mounted() {
    this.$store.dispatch('isLogin', this.$axios)
    this.getRankData()
    this.getVideoRankData()
    document.getElementById('rankbgm').volume = 0.05;
  }
}
</script>

<style>
#app {
  background-color: rgba(0, 0, 0, 0) !important;
}
.rankbg {
  position: fixed;
  right: 0;
  top: 0;
  width: 100%;
  min-width: 100%;
  min-height: 100%;
  z-index: -1000;
}
.rank-audio {
  position: absolute;
  bottom: 10px;
  left: 10px;
}
.header-pos {
  position: absolute;
  top: 0px !important;
  left: 0px;
}
.header-color {
  background-color: rgba(0, 0, 0, .8) !important;
}
.rankpage-div {
  height: 100vh;
  padding-top:56px;
  /* background-color: red; 임시 배경 넣으면 바꿀 것! */
}
.rank-border {
  border:20px solid transparent;
}
.rank-backcolor {
  background-color: rgba(0, 0, 0, .8);
  height: 100%;
}
</style>