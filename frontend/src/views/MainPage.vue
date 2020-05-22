<template>
  <div class="main">
    <Header></Header>
    <DanceListCarousel :dances.sync="dances"></DanceListCarousel>
  </div>
</template>

<script>
import Header from '@/components/common/Header.vue'
import DanceListCarousel from '@/components/main/DanceListCarousel.vue'

export default {
  name: 'MainPage',
  data () {
    return {
      dances: [{
        id: 0,
        title: 'BTS',
        src: "BTS_Boy_With_Luv.webm",
        thumbnail: "BTS.png"
      }, {
        id: 1,
        title: 'PICKME',
        src: "PickMeDance.webm",
        thumbnail: "PICKME.jpg"
      }, {
        id: 2,
        title: 'CHUNGHA',
        src: "CHUNGHA_Stay_Tonight.webm",
        thumbnail: "CHUNGHA.jpg"
      }, {
        id: 3,
        title: 'GANG',
        src: "RAIN_GANG.webm",
        thumbnail: "GANG.jpg"
      }]
    }
  },
  components: {
    Header,
    DanceListCarousel,
  },
}
</script>

<style>
.main {
  height: 100%;
}
</style>