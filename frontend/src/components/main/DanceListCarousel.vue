<template>
  <div class="danceList">
    <CarouselCard 
      class="carousel"
      :interval="7000" 
      height="70vh" 
      type="card" 
      arrow="hover" 
      indicatorPosition="none"
    >
      <CarouselCardItem 
        v-for="dance in dances" 
        :key="dance.id"
        v-model="nowDance"
      >
        <div 
          class="thumbnail" 
          :style="'background: url(' + dance.thumbnail + ') no-repeat center; background-size: cover;'"
          v-on:click="openDetail" v-on:mouseover="nowDance=dance"
        >
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
  data() {
    return {
      nowDance: {},
    }
  },
  props: ['dances'],
  components: {
    CarouselCard,
    CarouselCardItem,
  },
  methods: {
    openDetail() {
      this.$router.push({ name: 'DanceDetailPage', params: {'dances': this.dances, 'nowDance': this.nowDance, 'id': this.nowDance.video_id}, addToHistory:false})
    }
  }
}
</script>

<style>
.danceList {
  position: fixed;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
}
.carousel {
  width: 90vw;
  top: 20vh;
  margin: auto;
}
.thumbnail {
  width: 100%;
  height: 100%;
}
</style>