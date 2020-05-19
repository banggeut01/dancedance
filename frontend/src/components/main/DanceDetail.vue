<template>
  <div 
    class="danceDetail"
    :style="'background: url(' + require('@/assets/danceDetailBackgroundImg.png') + ') no-repeat'"
  >
    <video id="danceVideo" autoplay loop>
      <source src="@/assets/PickMeDance.webm" type="video/webm">
    </video>
    <v-btn class="mx-2" fab dark large color="purple" @click="play">
      <v-icon dark>play_arrow</v-icon>
    </v-btn>
  </div>
</template>

<script>
export default {
    name: 'DanceDetail',
    props: {
        id: Number,
        title: String,
        src: String,
        closeDetail: Function,
    }
}
</script>

<style>
.DanceDetail {
  position: fixed;
  top: 0;
  left: 0;
  height: 100vh;
}
#danceVideo{
  width: 30vw;
}
</style>