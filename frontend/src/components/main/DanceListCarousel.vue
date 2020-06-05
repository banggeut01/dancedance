<template>
  <div class="danceList">
    <CarouselCard 
      class="carousel"
      :interval="7000" 
      height="60vh"
      type="card" 
      arrow="hover" 
      indicatorPosition="none"
    >
      <CarouselCardItem 
        v-for="dance in dances" 
        :key="dance.id"
        v-model="nowDance"
      >
        <div v-if="hasActive" class="danceTitleDiv">{{dance.title}}</div>
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
    },
    hasActive() {
      
    }
  }
}
</script>

<style>
.danceList {
  position: fixed;
  width: 100%;
  height: 90vh;
  top: 10vh;
  left: 0;
}
.danceTitleDiv{
  background-color: rgba(0, 0, 0, 0.3);
  text-align: center;
}
.carousel {
  width: 90vw;
  top: 20vh;
  margin: auto;
  z-index: 1;
}
.thumbnail {
  width: 100%;
  height: 100%;
}
</style>