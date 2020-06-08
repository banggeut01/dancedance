<template>
  <div style="width:100%;">
    <div class="slider-box">
        <div class="slider-list clearfix"></div>  
        <button id="pree" @click="preSlide"><i class="fas fa-caret-left fa-5x"></i></button>
        <button id="nextt" @click="nextSlide"><i class="fas fa-caret-right fa-5x"></i></button>
    </div>
    <div style="width: 90%;margin-left: 30px;">
      <div style="margin-top: 10px;"></div>
      <v-row class="video-rank" v-if="myRanking !== null && myRanking.ranking > 3">
        <v-col class="pad-zero width-40">
          <i
          class="its-mine 
          animated infinite swing 
          fas fa-mitten fa-2x
          "></i>
        </v-col>
        <v-col class="pad-zero width-40">
          <p class="ranknum-neon2" style="vertical-align: middle; font-size: 2em;">{{ myRanking.ranking }}</p>
        </v-col>
        <v-col class="avatar-neon-div2 pad-zero width-40">
          <img :src="myRanking.img" style="height: 100%; width: 100%;">
        </v-col>
        <v-col class="rank-neon-border1-2 pad-zero">
          <span class="videorank-text" style="margin-left: 10px;">{{ myRanking.nickname }}</span>
        </v-col>
        <v-col class="rank-neon-border2-2 pad-zero" style="text-align: right;">
          <span class="videorank-text" style="margin-right: 10px;">{{ myRanking.point }} SCORES</span>
        </v-col>
      </v-row>
      <v-row class="video-rank" v-for="i in rank.length > 3 ? 3 : rank.length" :key="i">
        <v-col class="pad-zero width-40">
          <i v-if="myRanking !== null && rank[i - 1].ranking === myRanking.ranking" 
          class="its-mine 
          animated infinite swing 
          fas fa-mitten fa-2x
          "></i>
        </v-col>
        <v-col class="pad-zero width-40">
          <p class="ranknum-neon2" style="vertical-align: middle; font-size: 2em;">{{ rank[i -1].ranking }}</p>
        </v-col>
        <v-col class="avatar-neon-div2 pad-zero width-40">
          <img :src="rank[i - 1].img" style="height: 100%; width: 100%;">
        </v-col>
        <v-col class="rank-neon-border1-2 pad-zero">
          <span class="videorank-text" style="margin-left: 10px;">{{ rank[i - 1].nickname }}</span>
        </v-col>
        <v-col class="rank-neon-border2-2 pad-zero" style="text-align: right;">
          <span class="videorank-text" style="margin-right: 10px;">{{ rank[i - 1].point }} SCORES</span>
        </v-col>
      </v-row>
    </div>
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
        // path1: [require('@/assets/introImg/scene00001.jpg'), require('@/assets/introImg/scene00002.jpg'), require('@/assets/introImg/scene00003.jpg')],
        path: [],
        curidx: 0,
        video: {},
        rank: [],
        myRanking: {}
      }
    },
    methods: {
      createImgList() {
        const sliderList = document.querySelector('.slider-list')
        const sliderBox = document.querySelector('.slider-box')
        // const indexWidth = sliderBox.clientWidth
        sliderList.style.width = `${100 * this.videoRanking.length}%`
        // console.log(indexWidth)
        // for (let i=0; i<this.path.length; i ++) {
        for (let i=0; i<this.videoRanking.length; i ++) {
          let img = new Image(); 
          let div = document.createElement("div");
          let h1 = document.createElement("h1")
          let infodiv = document.createElement("div")
          let singer = document.createElement("h3")
          let difficulty = document.createElement("h3")
          let singerDetail = document.createElement("h3")
          let stardiv = document.createElement("div")
          let itag = document.createElement("i")
          let itag2 = document.createElement("i")
          h1.innerText = this.videoRanking[i].video.title
          singer.innerText = '가수'
          difficulty.innerText = '난이도'
          singerDetail.innerText = this.videoRanking[i].video.singer
          img.src = this.videoRanking[i].video.thumbnail
          itag.classList.add('fab')
          itag.classList.add('fa-itunes-note')
          itag.classList.add('fa-3x')
          itag.classList.add('itag')
          itag2.classList.add('fab')
          itag2.classList.add('fa-itunes-note')
          itag2.classList.add('fa-3x')
          itag2.classList.add('itag2')

          for (let j=0; j<this.videoRanking[i].video.difficulty; j++) {
            let star = document.createElement("i")
            star.classList.add('star-style')
            star.classList.add('fas')
            star.classList.add('fa-star')
            star.classList.add('fa-2x')
            stardiv.appendChild(star)
          }

          div.style.width = `${100 / this.videoRanking.length}%`
          img.style.width = '100%'
          infodiv.style.width = '100%'
          // div 
          div.style.cssFloat = 'left'
          div.style.position = 'relative'
          // video title
          h1.style.position = 'absolute'
          h1.style.top = '20%'
          h1.classList.add("rankvideo-title")
          h1.style.left = '50%'
          h1.style.transform = 'translateX(-50%)'
          // infodiv
          infodiv.style.position = 'absolute'
          infodiv.style.height = '40%'
          infodiv.style.bottom = '4px'
          infodiv.style.background = 'rgba(0, 0, 0, 0.8)'
          // singer
          singer.style.position = 'absolute'
          singer.style.top = '20%'
          singer.classList.add("rankvideo-info")
          singer.style.right = '70%'
          // difficulty
          difficulty.style.position = 'absolute'
          difficulty.style.bottom = '20%'
          difficulty.classList.add("rankvideo-info")
          difficulty.style.right = '70%'
          // singerDetail
          singerDetail.style.position = 'absolute'
          singerDetail.style.top = '20%'
          singerDetail.classList.add("singer-font")
          singerDetail.style.left = '35%'
          // stardiv
          stardiv.style.position = 'absolute'
          stardiv.style.display = "inline"
          stardiv.style.bottom = '20%'
          stardiv.style.left = '35%'
          // itag
          itag.style.position = 'absolute'
          itag.style.right = '10%'
          itag.style.top = '20%'
          itag2.style.position = 'absolute'
          itag2.style.right = '3%'
          itag2.style.top = '40%'

          infodiv.appendChild(stardiv)
          infodiv.appendChild(singer)
          infodiv.appendChild(difficulty)
          infodiv.appendChild(singerDetail)
          infodiv.appendChild(itag)
          infodiv.appendChild(itag2)
          div.appendChild(img)
          div.appendChild(h1)
          div.appendChild(infodiv)
          sliderList.appendChild(div)
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
      },
      setPath() {
        for (let i=0 ; i < this.videoRanking.length ; i ++) {
          this.path.push(this.videoRanking[i].video.thumbnail)
        }
      },
      setVideo() {
        this.video = this.videoRanking[this.curidx].video
      },
      setRank() {
        let tmp = []
        for (let i=0 ; i < Math.min(this.videoRanking[this.curidx].rank.length, 3); i ++){
          tmp.push(this.videoRanking[this.curidx].rank[i])
        }
        this.rank = tmp
      },
      setMyRanking() {
        this.myRanking = this.videoRanking[this.curidx].myRanking
      }
    },
    mounted () {
      // this.setPath()
      // this.createImgList();
    },
    watch: {
      videoRanking: function() {
        this.setPath()
        this.setVideo()
        this.setRank()
        this.setMyRanking()
        this.createImgList();
      },
      curidx: function() {
        this.setVideo()
        this.setRank()
        this.setMyRanking()
      }
    },
    computed: {
      spath() {
        return this.path
      },
      svideo() {
        return this.video
      },
      srank() {
        return this.rank
      },
      smyRanking() {
        return this.myRanking
      }
    }
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
.rankvideo-title {
  color: blue;
  font-weight: 100;
  font-size: 3em;
  text-shadow: -1px -1px 0 #ffffff,
    1px -1px 0 #ffffff,
    -1px 1px 0 #ffffff,
    1px 1px 0 #ffffff; 
  font-family: 'Black Han Sans', sans-serif;
}
.rankvideo-info {
  color: rgb(0, 255, 0);
  font-weight: 100;
  font-size: 2em;
  text-shadow: -1px -1px 0 #000,
    1px -1px 0 #000,
    -1px 1px 0 #000,
    1px 1px 0 #000; 
  font-family: 'Black Han Sans', sans-serif;
}
.singer-font {
  color: rgb(255, 255, 255);
  font-weight: 100;
  font-size: 2em;
  text-shadow: -1px -1px 0 #000,
    1px -1px 0 #000,
    -1px 1px 0 #000,
    1px 1px 0 #000; 
  font-family: 'Black Han Sans', sans-serif;
}
.star-style {
  color: yellow;
}
.itag {
  color: blue;
  text-shadow: 0 0 10px blue, 0 0 20px blue;
}
.itag2 {
  color: purple;
  text-shadow: 0 0 10px purple, 0 0 20px purple;
}
.video-rank {
  height: 40px;
  margin-bottom: 10px;
}
.pad-zero {
  padding: 0px !important;
  margin: 0px 2px 0px 2px;
}
.width-40 {
  width: 40px;
  max-width: 40px !important;
}
.ranknum-neon2 {
  color: #fff;
  text-shadow: 0 0 10px rgb(255, 34, 200), 0 0 20px rgb(255, 34, 200);
  font-family: Iceland;
  text-align: center;
  font-weight: bold;
}
.videorank-text {
  line-height: 40px; 
  font-family: 'Black Han Sans', sans-serif; 
  font-size: 20px;
  color: white;
}
.avatar-neon-div2 {
  border: 2px solid white;
  box-shadow: 0 0 30px rgb(255, 34, 200) inset;
}
.rank-neon-border1-2 {
  border-style: solid;
  border-image-width: 1px;
  border-image: linear-gradient(to right, #fff 0%, rgb(253, 142, 225) 100%);
  border-image-slice: 1;
  box-shadow: 0 0 30px rgb(255, 34, 200) inset;
}
.rank-neon-border2-2 {
  border-style: solid;
  border-image-width: 1px;
  border-image: linear-gradient(to right, rgb(253, 142, 225) 0%, rgb(255, 34, 200) 100%);
  border-image-slice: 1;
  box-shadow: 0 0 30px rgb(255, 34, 200) inset;
}
.its-mine {
  color: #fff;
  text-shadow: 0 0 10px rgb(255, 0, 98), 0 0 20px rgb(255, 0, 98);
}
</style>