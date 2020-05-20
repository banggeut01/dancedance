<template>
  <div class="main">
    <Header></Header>
    <DanceListCarousel :dances="dances"></DanceListCarousel>
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
        src: "PickMeDance.webm",
        thumbnail: "BTS.jpg"
      }, {
        id: 1,
        title: 'IZONE',
        src: "PickMeDance.webm",
        thumbnail: "IZONE.jpg"
      }, {
        id: 2,
        title: 'TWICE',
        src: "PickMeDance.webm",
        thumbnail: "TWICE.jpg"
      }, {
        id: 3,
        title: 'GANG',
        src: "PickMeDance.webm",
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

</style>