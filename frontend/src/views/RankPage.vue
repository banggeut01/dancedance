<template>
  <div>
    <!-- background sound -->
    <audio class="rank-audio" autoplay loop>
      <source src="../assets/rank_bgm.mp3" type="audio/mpeg">
    </audio>
    <Header class="header-pos header-color"></Header>
    <v-row class="rankpage-div">
      <v-col cols="6" class="rank-border">
        <!-- 춤별 랭킹 -->
        <SongRank class="rank-backcolor"></SongRank>
      </v-col>
      <v-col cols="6" class="rank-border">
        <!-- 총 score 랭킹 -->
        <TotalRank class="rank-backcolor"></TotalRank>
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
  data () {
    return {
    }
  },
  components: {
    Header,
    SongRank,
    TotalRank
  }
}
</script>

<style>
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
  background-color: red; /* 임시 배경 넣으면 바꿀 것! */
}
.rank-border {
  border:20px solid transparent;
}
.rank-backcolor {
  background-color: rgba(0, 0, 0, .8);
  height: 100%;
}
</style>