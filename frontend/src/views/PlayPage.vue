<template>
  <div>
    <div id="videoContainer"></div>
    <div class="sketch" id="sketch"></div>
  </div>
</template>

<script>
import p5 from "p5";

export default {
  name: "PlayPage",
  props: ["id"],
  methods: {
    getVideo(sketch) {
      window.videoURL = `https://dancedance.kr/video/${this.id}.mp4`;
      window.videoId = this.id;
      this.myp5 = new p5(sketch, document.getElementById("sketch"));
    },
  },
  mounted() {
    import("../components/playPage/sketch").then((sketch) => {
      this.getVideo(sketch.default);  
    })
  },
  destroyed() {
    location.reload();
  },
};
</script>

<style></style>
