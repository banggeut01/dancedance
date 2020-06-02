<template>
  <div>
    <div id="videoContainer"></div>
    <div class="sketch" id="sketch"></div>
  </div>
</template>

<script>
import sketch from "../components/playPage/sketch";
import p5 from "p5";

export default {
  name: "PlayPage",
  props: ["id"],
  methods: {
    getVideo() {
      window.videoURL = `https://dancedance.kr/video/${this.id}.mp4`;
      window.videoId = this.id;
      this.myp5 = new p5(sketch, document.getElementById("sketch"));
    },
  },
  mounted() {
    console.log(this.id);
    this.getVideo();
  },
  destroyed() {
    location.reload();
  },
};
</script>

<style></style>
