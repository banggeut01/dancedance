<template>
  <div class="carousel">
    <CarouselCard :interval="7000" height="300px" type="card" arrow="always">
      <CarouselCardItem v-for="i in 4" :key="i">
        <img class="thumbnail" v-if="i === 1" src="@/assets/BTS.jpg">
        <img class="thumbnail" v-if="i === 2" src="@/assets/IZONE.jpg">
        <img class="thumbnail" v-if="i === 3" src="@/assets/TWICE.jpg">
        <img class="thumbnail" v-if="i === 4" src="@/assets/GANG.jpg">
      </CarouselCardItem>
    </CarouselCard>
  </div>
</template>

<script>
import { CarouselCard, CarouselCardItem } from 'vue-carousel-card'
import 'vue-carousel-card/styles/index.css'

export default {
  name: 'Carousel',
  dara () {
    return {
      dances: [{
        
      }]
    }
  },
  components: {
    CarouselCard,
    CarouselCardItem,
  }
}
</script>

<style>
.carousel {
  margin: auto;
  width: 90vw;
}
.thumbnail {
  width: 100%;
  height: 100%;
}
</style>