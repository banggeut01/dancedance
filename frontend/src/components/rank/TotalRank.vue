<template>
  <div>
    <div class="totalrank-title">
      <p class="rank-neon-h1">RANKING</p>
    </div>
    {{ ranking }}
    <div class="totalrank-body">
      <v-row class="totalrank-height">
        <v-col align="center" class="totalrank-width p-zero">
          <!-- 메달 -->
          <i class="fas fa-medal fa-3x gold-medal"></i>
        </v-col>
        <v-col align="center" class="totalrank-width p-zero">
          <!-- 순위 -->
          <p class="ranknum-neon" style="vertical-align: middle; font-size: 3em;">1</p>
        </v-col>
        <v-col align="center" class="totalrank-width p-zero avatar-neon-div">
          <!-- 아바타 프로필 -->
          <img src="@/assets/logo.png" style="height: 100%; width: 100%;">
        </v-col>
        <v-col class="p-zero rank-neon-border1" align="left">
          <!-- 이름 -->
          <span class="totalrank-text" style="margin-left: 20px;">김 아무개</span>
        </v-col>
        <v-col class="p-zero rank-neon-border2" align="right">
          <!-- 총 score -->
          <span class="totalrank-text" style="margin-right: 10px;">1000 SCORES</span>
        </v-col>
      </v-row>
      <i class="fas fa-medal fa-3x silver-medal"></i>
      <i class="fas fa-medal fa-3x bronze-medal"></i>
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
  height: 50px;
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
  line-height: 45px; 
  font-family: 'Black Han Sans', sans-serif; 
  font-size: 25px; 
}
</style>