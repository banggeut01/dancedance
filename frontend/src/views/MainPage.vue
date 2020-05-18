<template>
  <div class="main">
    <Header></Header>
    <DanceListCarousel></DanceListCarousel>
  </div>
</template>

<script>
import Header from '@/components/common/Header.vue'
import DanceListCarousel from '@/components/main/DanceListCarousel.vue'

export default {
  name: 'MainPage',
  components: {
    Header,
    DanceListCarousel,
  }
}
</script>

<style>

</style>