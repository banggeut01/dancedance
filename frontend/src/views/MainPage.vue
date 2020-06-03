<template>
  <div class="main">
    <Header></Header>
    <video autoplay muted loop id="backgroundVideo">
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
      dances: [],
    };
  },
  components: {
    Header,
    DanceListCarousel,
  },
  mounted() {
    this.$store.dispatch('isLogin', this.$axios);
    this.$axios.get("http://k02b1021.p.ssafy.io:8197/ssafy-dance/api/main")
      .then((response) => {
        this.dances = response.data.video;
      })
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
  z-index: -1;
}
</style>
