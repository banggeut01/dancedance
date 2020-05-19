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
        src: "BTS.jpg"
      }, {
        id: 1,
        title: 'IZONE',
        src: "IZONE.jpg"
      }, {
        id: 2,
        title: 'TWICE',
        src: "TWICE.jpg"
      }, {
        id: 3,
        title: 'GANG',
        src: "GANG.jpg"
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