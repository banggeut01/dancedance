<template>
  <div class="danceList">
    <CarouselCard 
      class="carousel"
      v-if="!isDetail"
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
          :style="'background: url(' + require(`@/assets/${dance.thumbnail}`) + ') no-repeat center; background-size: cover;'"
          v-on:click="openDetail" @click="nowDance=dance"
        >
          
        </div>
      </CarouselCardItem>
    </CarouselCard>
    <DanceDetail v-if="isDetail" :nowDance="nowDance" :closeDetail="closeDetail"></DanceDetail>
  </div>
</template>

<script>
import DanceDetail from '@/components/main/DanceDetail.vue'

import { CarouselCard, CarouselCardItem } from 'vue-carousel-card'
import 'vue-carousel-card/styles/index.css'

export default {
  name: 'Carousel',
  data() {
    return {
      isDetail: false,
      nowDance: {},
    }
  },
  props: {
    dances: {
      type: Array,
      default: () => ([]),
    }
  },
  components: {
    DanceDetail,
    CarouselCard,
    CarouselCardItem,
  },
  methods: {
    openDetail() {
      this.isDetail = true
    },
    closeDetail() {
      this.isDetail = false
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