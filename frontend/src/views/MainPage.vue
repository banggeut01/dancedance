<template>
  <div class="main">
    <Header style="z-index: 10"></Header>
    <video autoplay muted loop width="100%" id="backgroundVideo">
      <source src="@/assets/mainBackground.mp4" type="video/mp4" />
    </video>
    <DanceListCarousel :dances.sync="dances"></DanceListCarousel>
  </div>
</template>

<script>
import Header from "@/components/common/Header.vue";
import DanceListCarousel from "@/components/main/DanceListCarousel.vue";

export default {
  name: "MainPage",
  data() {
    return {
      dances: [{}],
    };
  },
  components: {
    Header,
    DanceListCarousel,
  },
  mounted() {
    this.$axios
      .get("http://k02b1021.p.ssafy.io:8197/ssafy-dance/api/main", {
        headers: {
          Authorization:
            "eyJ0eXAiOiJKV1QiLCJyZWdEYXRlIjoxNTkxMDcxNzE2ODE0LCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1OTExNTgxMTYsInN1YiI6IuuhnOq3uOyduO2GoO2BsCIsIkF1dGhvcml6YXRpb24iOnsibWVtYmVyX2lkIjoyLCJlbWFpbCI6ImRlbGlnaHRfam9vQG5hdmVyLmNvbSIsInBhc3N3b3JkIjpudWxsLCJuaWNrbmFtZSI6Iu2drOq1rCIsImF2YXRhcl9ub3ciOjB9fQ.QNKaTgrnL7wIF-N4me6IVxSyJSXbhc6hlaho5BpQHrI",
        },
      })
      .then((response) => {
        console.log(response.data.video);
        this.dances = response.data.video;
      });
  },
};
</script>

<style>
.main {
  height: 100vh;
  overflow: hidden;
}
#backgroundVideo {
  position: fixed;
  right: 0;
  bottom: 0;
  min-width: 100%;
  min-height: 100%;
  z-index: 0;
}
</style>
