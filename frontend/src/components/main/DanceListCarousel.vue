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
        <div class="danceTitleDiv">{{dance.title}}</div>
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
  position: fixed;
  text-align: center;
  top:50%; left:50%;
  transform: translate(-50%, -50%);
  font-family: 'Black Han Sans';
  width: 100%;
  color: rgba(0, 0, 0, 0.7);
  font-size: 7em;
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