<template>
  <div>
    <div class="totalrank-title">
      <p class="rank-neon-h1">RANKING</p>
    </div>
    <div class="totalrank-body">
      <v-row class="totalrank-height">
        <v-col align="center" class="totalrank-width p-zero">
          <!-- 메달 -->
          <i class="fas fa-medal fa-3x"></i>
        </v-col>
        <v-col align="center" class="totalrank-width p-zero">
          <!-- 순위 -->
          <span style="font-size: 100%;">1</span>
        </v-col>
        <v-col align="center" class="totalrank-width p-zero">
          <!-- 아바타 프로필 -->
          <img src="@/assets/logo.png" style="height: 100%; width: 100%;">
        </v-col>
        <v-col class="p-zero">
          <!-- 이름, 총 score -->
          <div>
            김 아무개
          </div>
          <div>
            1000 SCORES
          </div>
        </v-col>
      </v-row>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'TotalRank',
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
  margin-left: 10px;
  margin-right: 10px;
}
</style>