<template>
  <div style="width:100%">
    <div class="slider-box">
        <div class="slider-list clearfix"></div>  
        <button id="pree" @click="preSlide"><i class="fas fa-caret-left fa-5x"></i></button>
        <button id="nextt" @click="nextSlide"><i class="fas fa-caret-right fa-5x"></i></button>
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
        path1: [],
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
      // for (let i=0 ; i < videoRanking.length ; i ++) {
      //   path.appendChild(videoRanking.video[i].thumbnail)
      // }
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
  transform: translateY(-50%);
  left: 10px;
  color: #fff;
  text-shadow: 0 0 10px #fff, 0 0 20px #228DFF, 0 0 30px #228DFF, 0 0 40px #228DFF, 0 0 70px #228DFF, 0 0 80px #228DFF, 0 0 100px #228DFF, 0 0 150px #228DFF;
  border: 0;
  outline: 0;
}
.slider-box #nextt {
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  right: 10px;
  color: #fff;
  text-shadow: 0 0 10px #fff, 0 0 20px #228DFF, 0 0 30px #228DFF, 0 0 40px #228DFF, 0 0 70px #228DFF, 0 0 80px #228DFF, 0 0 100px #228DFF, 0 0 150px #228DFF;
  border: 0;
  outline: 0;
}
.slider-list img {
  /* background: linear-gradient(
    to right,
  rgba(255,255,255,0) 0%,
  rgba(0,0,0,0.99) 66%,
  rgba(0,0,0,1) 67%); */
}
</style>