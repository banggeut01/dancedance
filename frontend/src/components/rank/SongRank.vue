<template>
  <div style="width:100%">
    <div class="slider-box">
        <div class="slider-list clearfix"></div>  
        <button id="pree" @click="preSlide">preeee</button>
        <button id="nextt" @click="nextSlide">nexxxxx</button>
    </div>
      <!-- {{ videoRanking }} -->
  </div>
</template>

<script>
  export default {
    name: 'SongRank',
    props: {
      videoRanking: {
        type: Array,
        default: () => ([])
      }
    },
    data() {
      return {
        path: [require('@/assets/introImg/scene00001.jpg'), require('@/assets/introImg/scene00002.jpg'), require('@/assets/introImg/scene00003.jpg')],
        curidx: 0,
      }
    },
    methods: {
      createImgList() {
        const sliderList = document.querySelector('.slider-list')
        const sliderBox = document.querySelector('.slider-box')
        // const indexWidth = sliderBox.clientWidth
        sliderList.style.width = `${100 * this.path.length}%`
        // console.log(indexWidth)
        for (let i=0; i<this.path.length; i ++) {
          let img = new Image();
          img.src = this.path[i]
          img.style.width = `${100 / this.path.length}%`
          img.style.cssFloat = 'left'
          sliderList.appendChild(img)
        }
      },
      preSlide() {
        const sliderList = document.querySelector('.slider-list')
        const sliderBox = document.querySelector('.slider-box')
        const indexWidth = sliderBox.clientWidth
        if(this.curidx <= 0) return
        this.curidx --
        
        sliderList.style.transition = "transform 0.4s ease-in-out";
        sliderList.style.transform = `translateX(${-(this.curidx) * 100/this.path.length}%)`;
      },
      nextSlide() {
        const sliderList = document.querySelector('.slider-list')
        const sliderBox = document.querySelector('.slider-box')
        const indexWidth = sliderBox.clientWidth
        if (this.curidx >= this.path.length-1) return
        this.curidx ++;
        
        
        sliderList.style.transition = "transform 0.4s ease-in-out";
        sliderList.style.transform = `translateX(${-(this.curidx) * 100/this.path.length}%)`;
      }
    },
    mounted () {
      this.createImgList();
    },

  }
</script>

<style>
  .slider-box {
      position: relative;
      overflow-x: hidden;
      width: 80%;
      padding-top: 40px;
      margin: auto;
    }
    .clearfix:after {
      content: ''; display: block; clear: both; float: none; 
    }
    .slider-box #pree { 
      position: absolute;
      top: 50%;
      left: 0;
    }
    .slider-box #nextt {
      position: absolute;
      top: 50%;
      right: 0;
    }
</style>