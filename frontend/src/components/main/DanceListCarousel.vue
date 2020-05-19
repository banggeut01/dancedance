<template>
  <div class="carousel">
    <CarouselCard :interval="7000" height="70vh" type="card" arrow="hover" indicatorPosition="none">
      <CarouselCardItem v-for="dance in dances" :key="dance.id">
        <div class="thumbnail" :style="'background: url(' + require(`@/assets/${dance.src}`) + ') no-repeat center; background-size: cover;'">

        </div>
      </CarouselCardItem>
    </CarouselCard>
  </div>
</template>

<script>
import { CarouselCard, CarouselCardItem } from 'vue-carousel-card'
import 'vue-carousel-card/styles/index.css'

export default {
  name: 'Carousel',
  props: {
    dances: {
      type: Array,
      default: () => ([]),
    }
  },
  components: {
    CarouselCard,
    CarouselCardItem,
  },
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