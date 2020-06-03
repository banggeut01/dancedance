<template>
  <div>
    <div class="totalrank-title">
      <p class="rank-neon-h1">TOP7 RANKING</p>
    </div>
    <div class="totalrank-body">
      <v-row class="totalrank-height" v-for="i in ranking.length > 7 ? 7 : ranking.length" :key="i">
        <v-col align="center" class="totalrank-width p-zero">
          <!-- 메달 -->
          <i v-if="ranking[i - 1].ranking === 1" class="fas fa-medal fa-3x gold-medal"></i>
          <i v-else-if="ranking[i - 1].ranking === 2" class="fas fa-medal fa-3x silver-medal"></i>
          <i v-else-if="ranking[i - 1].ranking === 3" class="fas fa-medal fa-3x bronze-medal"></i>
        </v-col>
        <v-col align="center" class="totalrank-width p-zero">
          <!-- 순위 -->
          <p class="ranknum-neon" style="vertical-align: middle; font-size: 3em;">{{ ranking[i - 1].ranking }}</p>
        </v-col>
        <v-col align="center" class="totalrank-width p-zero avatar-neon-div">
          <!-- 아바타 프로필 -->
          <img src="@/assets/logo.png" style="height: 100%; width: 100%;">
        </v-col>
        <v-col class="p-zero rank-neon-border1" align="left">
          <!-- 이름 -->
          <span class="totalrank-text" style="margin-left: 10px;">{{ ranking[i - 1].nickname }}</span>
        </v-col>
        <v-col class="p-zero rank-neon-border2" align="right">
          <!-- 총 score -->
          <span class="totalrank-text" style="margin-right: 10px;">{{ ranking[i - 1].point }} SCORES</span>
        </v-col>
      </v-row>
      <v-row class="totalrank-height" v-if="myRanking.ranking > 7">
        <v-col align="center" class="totalrank-width p-zero">
          <!-- 메달 -->
        </v-col>
        <v-col align="center" class="totalrank-width p-zero">
          <!-- 순위 -->
        </v-col>
        <v-col align="center" class="p-zero skip-neon-div">
          <!-- 생략 부분 -->
          <span style="font-family: 'Black Han Sans', sans-serif; font-size: 25px;">...</span>
        </v-col>
      </v-row>
      <v-row class="totalrank-height" v-if="myRanking.ranking > 7">
        <v-col align="center" class="totalrank-width p-zero">
          <!-- 메달 -->
        </v-col>
        <v-col align="center" class="totalrank-width p-zero">
          <!-- 순위 -->
          <p class="ranknum-neon" style="vertical-align: middle; font-size: 3em;">{{ myRanking.ranking }}</p>
        </v-col>
        <v-col align="center" class="totalrank-width p-zero avatar-neon-div">
          <!-- 아바타 프로필 -->
          <img src="@/assets/logo.png" style="height: 100%; width: 100%;">
        </v-col>
        <v-col class="p-zero rank-neon-border1" align="left">
          <!-- 이름 -->
          <span class="totalrank-text" style="margin-left: 10px;">{{ myRanking.nickname }}</span>
        </v-col>
        <v-col class="p-zero rank-neon-border2" align="right">
          <!-- 총 score -->
          <span class="totalrank-text" style="margin-right: 10px;">{{ myRanking.point }} SCORES</span>
        </v-col>
      </v-row>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'TotalRank',
    props: {
      ranking: {
        type: Array,
        default: () => ([])
      },
      myRanking: {
        type: Object,
        default: () => ({})
      }
    }
  }
</script>

<style>
.totalrank-title {
  padding: 10px 0px 10px 0;
}
.rank-neon-h1{
  color: #ffffff;;
  font-family: Iceland;
  text-align: center;
  font-size: 3em;
  text-shadow: 0 0 10px #fff, 0 0 20px #228DFF, 0 0 30px #228DFF, 0 0 40px #228DFF, 0 0 70px #228DFF, 0 0 80px #228DFF, 0 0 100px #228DFF, 0 0 150px #228DFF;
}
.totalrank-body {
  color: white;
  margin: 10px 50px 10px 50px;
  /* height: 50px; */
}
.totalrank-height {
  height: 100%;
}
.totalrank-width {
  width: 50px;
  max-width: 50px !important;
  height: 100%;
}
.p-zero {
  padding: 0px !important;
  margin-left: 2px;
  margin-right: 2px;
  margin-top: 2px;
  margin-bottom: 2px;
}
.gold-medal {
  color: rgb(255, 255, 0);
  text-shadow: 0 0 10px rgb(238, 255, 0), 0 0 20px rgb(238, 255, 0);
}
.silver-medal {
  color: rgb(240, 240, 240);
  text-shadow: 0 0 10px rgb(221, 221, 221), 0 0 20px rgb(221, 221, 221);
}
.bronze-medal {
  color: rgb(231, 157, 88);
  text-shadow: 0 0 10px rgb(231, 157, 88), 0 0 20px rgb(231, 157, 88);
}
.ranknum-neon {
  color: #fff;
  text-shadow: 0 0 10px #228DFF, 0 0 20px #228DFF;
  font-family: Iceland;
  text-align: center;
  font-weight: bold;
}
.avatar-neon-div {
  border-style: solid;
  border-image-width: 1px;
  border-image: #fff;
  border-image-slice: 1;
  box-shadow: 0 0 30px #228DFF inset;
}
.rank-neon-border1 {
  border-style: solid;
  border-image-width: 1px;
  border-image: linear-gradient(to right, #fff 0%, rgb(132, 191, 255) 100%);
  border-image-slice: 1;
  box-shadow: 0 0 30px #228DFF inset;
}
.rank-neon-border2 {
  border-style: solid;
  border-image-width: 1px;
  border-image: linear-gradient(to right, rgb(132, 191, 255) 0%, #228DFF 100%);
  border-image-slice: 1;
  box-shadow: 0 0 30px #228DFF inset;
}
.totalrank-text {
  line-height: 50px; 
  font-family: 'Black Han Sans', sans-serif; 
  font-size: 25px; 
}
.skip-neon-div {
  border-style: solid;
  border-image-width: 1px;
  border-image: linear-gradient(to right, #fff 0%, #228DFF 100%);
  border-image-slice: 1;
  box-shadow: 0 0 30px #228DFF inset;
}
</style>