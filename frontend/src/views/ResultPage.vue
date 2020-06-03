<template>
  <div class="resultBackground">
    <video autoplay muted loop id="videoBG">
      <source :src="videoSrc" type="video/mp4">
    </video>
    <div class="resultDiv">
      <div class="resultUpper">
        <div class="profileDiv">
          <img :src="profileSrc" alt="" class="profileImg">
        </div>
        <div class="userInfo">
          <span id="userName" class="glow">
            {{userName}}<br>
          </span>
          <span id="performedTime">
            {{ today }}
          </span>
        </div>
      </div>
      <div style="height:20px"></div>
      <div class="resultBottom">
        <div class="starRatings">
          <div class="starRatingsTop"><span>★</span><span>★</span><span>★</span><span>★</span><span>★</span></div>
          <div class="starRatingsBottom"><span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
          </div>
        </div>
        <div class="scoreRatings">
          <span style="font-size:1rem; margin-top:10px">Score</span>
          <span id="point" class="glow scoreRank">{{ score }}</span>pts
        </div>

        <div class="rankingRatings">
          <span id="ranking" class="glow scoreRank">{{ rank }}</span>th
        </div>
      </div>
      <div class="resultBtn" style="text-align:center">
        <p class="buttonP" @click="replay()">
          <a class="buttonCommon buttonA">다시하기</a>
        </p>
        <p class="buttonP" style="margin:0;display:inline;" @click="goToMain()">
          <a class="buttonCommon buttonB">종료하기</a>
        </p>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'ResultPage',
    data() {
      return {
        chgNumSpeed: 3,
        today: '',
        userName: '',
        perfectScore: 0,
        score: 0,
        rank: 0,
        videoSrc: require('@/assets/resultBackground.mp4'),
        profileSrc: '',
        replayId: null,
      }
    },
    watch: {
      score: function () {
        this.increaseNum("point", 100, this.score);
      },
      rank: function () {
        this.increaseNum("ranking", 1, this.rank);
      }
    },
    methods: {
      getResult() {
        this.$axios.get('http://k02b1021.p.ssafy.io:8197/ssafy-dance/api/play/result')
          .then(res => {
            this.replayId = res.data.video_id
            this.userName = res.data.nickname
            this.today = res.data.datetime.substring(0, 4) + '년 ' + res.data.datetime.substring(5, 7) + '월 ' + res.data.datetime.substring(8, 10) + '일 '+
            res.data.datetime.substring(11, 13) + '시 ' + res.data.datetime.substring(14, 16) + '분 ' + res.data.datetime.substring(17, 19) + '초'
            this.rank = res.data.ranking
            this.score = res.data.point
            this.perfectScore = res.data.perfect
            this.profileSrc = require('@/components/avatar' + `${res.data.img.substring(1, res.data.img.length)}`)
            this.fillStar(this.score, this.perfectScore);
          })
      },
      increaseNum(id, unit, endNbr) {
        var elt = document.getElementById(id);
        this.incNumRecur(0, endNbr, elt, unit);
      },
      incNumRecur(i, endNbr, elt, unit) {
        if (i <= endNbr) {
          elt.innerHTML = i;
          var th = this
          setTimeout(function () {
            th.incNumRecur(i + unit, endNbr, elt, unit);
          }, th.chgNumSpeed);
        }
      },
      getCurrentTime() {
        var today = new Date();
        this.today = today.getFullYear() + '년 ' + (today.getMonth() + 1) + '월 ' + today.getDate() + '일 ' + today
          .getHours() + '시 ' + today.getMinutes() + '분';
      },
      fillStar(score, perfectScore) {
        const rate = parseInt((score / perfectScore) * 100);
        var cssAnimation = document.createElement('style');
        cssAnimation.type = 'text/css';

        var rules = document.createTextNode('@keyframes rating{' +
          'from { width: 0; }' +
          `to { width: ${rate}%; }` +
          '}');
        cssAnimation.appendChild(rules);
        document.getElementsByTagName("head")[0].appendChild(cssAnimation);
      },
      replay() {
        this.$router.push(`/play/${this.replayId}`)
      },
      goToMain() {
        this.$router.push('/main')
      }
    },
    mounted() {
      this.$store.dispatch('isLogin', this.$axios);
      this.getResult();
      this.getCurrentTime();
    }
  }
</script>

<style>
  .buttonP {
    text-align: center;
    font-size: 3.5vw;
    margin: 20px 0 20px 0;
    cursor: pointer;
    margin-right: 3.5vw;
    display: inline-block;
  }

  .buttonCommon {
    text-decoration: none;
    -webkit-transition: all 0.5s;
    -moz-transition: all 0.5s;
    transition: all 0.5s;
    font-family: Monoton;
  }

  .buttonA {
    color: #fff;
    -webkit-animation: neon1 1s ease-in-out infinite alternate;
    -moz-animation: neon1 1s ease-in-out infinite alternate;
    animation: neon1 1s ease-in-out infinite alternate;
  }

  .buttonB {
    color: #fff;
    -webkit-animation: neon2 1s ease-in-out infinite alternate;
    -moz-animation: neon2 1s ease-in-out infinite alternate;
    animation: neon2 1s ease-in-out infinite alternate;
  }

  .buttonP .buttonA:hover {
    color: #45b6fe;
    -webkit-animation: none;
    -moz-animation: none;
    animation: none;
  }

  .buttonP .buttonB:hover {
    color: #FF1177;
    -webkit-animation: none;
    -moz-animation: none;
    animation: none;
  }

  .scoreRank {
    font-size: 4vw;
    margin-top: 10px;
  }

  @keyframes neon1 {
    from {
      text-shadow: 0 0 10px #fff, 0 0 20px #fff, 0 0 30px #fff, 0 0 40px #45b6fe, 0 0 70px #45b6fe, 0 0 80px #45b6fe, 0 0 100px #FF1177, 0 0 150px #FF1177;
    }

    to {
      text-shadow: 0 0 5px #fff, 0 0 10px #fff, 0 0 15px #fff, 0 0 20px #45b6fe, 0 0 35px #45b6fe, 0 0 40px #45b6fe, 0 0 50px #FF1177, 0 0 75px #FF1177;
    }
  }

  @keyframes neon2 {
    from {
      text-shadow: 0 0 10px #fff, 0 0 20px #fff, 0 0 30px #fff, 0 0 40px #FF1177, 0 0 70px #FF1177, 0 0 80px #FF1177, 0 0 100px #FF1177, 0 0 150px #FF1177;
    }

    to {
      text-shadow: 0 0 5px #fff, 0 0 10px #fff, 0 0 15px #fff, 0 0 20px #FF1177, 0 0 35px #FF1177, 0 0 40px #FF1177, 0 0 50px #FF1177, 0 0 75px #FF1177;
    }
  }

  #videoBG {
    position: fixed;
    right: 0;
    bottom: 0;
    width: auto;
    height: 100%;
    min-width: 100%;
    min-height: 100%;
  }

  @media screen and (max-width: 1360px) {

    #videoBG {
      display: none;
    }

  }

  .resultBackground {
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
    min-height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
  }

  .resultDiv {
    position: absolute;
    height: 55%;
    width: 50%;
    left: 50%;
    top: 50%;
    border-radius: 10%;
    align-content: center;
    -webkit-transform: translate(-50%, -50%);
    transform: translate(-50%, -50%);
    background-color: black;
  }

  .resultUpper {
    margin-top: 50px;
    width: 100%;
  }

  .profileDiv {
    display: inline-block;
    width: 200px;
    margin-left: 100px;
  }

  .profileImg {
    max-width: 11vw;
    max-height: 100%;
    margin: auto;
  }

  .userInfo {
    display: inline-block;
    margin-left: 30px;
  }

  .userInfo #userName {
    color: white;
    font-size: 4vw;
  }

  .userInfo #performedTime {
    color: white;
    font-size: 1vw;
  }

  .resultBottom {
    height: 15vh;
    /* width: 600px; */
    margin-left: 4vw;
  }

  .starRatings {
    unicode-bidi: bidi-override;
    color: white;
    font-size: 3.7vw;
    display: inline-block;
    margin: 0 auto;
    position: relative;
    padding: 0;
    /* border: 1px solid white; */
  }

  .scoreRatings {
    unicode-bidi: bidi-override;
    color: white;
    /* font-size: 4rem; */
    display: inline-block;
    /* margin: 0 auto; */
    margin-left: 40px;
    position: relative;
    padding: 0;
    /* border: 1px solid white; */
  }

  .rankingRatings {
    unicode-bidi: bidi-override;
    color: white;
    /* font-size: 4rem; */
    display: inline-block;
    /* margin: 0 auto; */
    margin-left: 40px;
    position: relative;
    padding: 0;
    /* border: 1px solid white; */
  }

  .starRatingsTop {
    color: gold;
    padding: 0;
    position: absolute;
    z-index: 1;
    display: block;
    top: 0;
    left: 0;
    overflow: hidden;
    animation: rating 5s forwards;
  }

  .starRatingsBottom {
    padding: 0;
    display: block;
    z-index: 0;
  }

  .resultThird {
    margin-left: 100px;
    height: 100px;
  }

  @font-face {
    font-family: 'Open Sans';
    font-style: normal;
    font-weight: 400;
    src: local('Open Sans Regular'), local('OpenSans-Regular'), url(https://fonts.gstatic.com/s/opensans/v17/mem8YaGs126MiZpBA-UFVZ0e.ttf) format('truetype');
  }

  @font-face {
    font-family: 'Open Sans';
    font-style: normal;
    font-weight: 600;
    src: local('Open Sans SemiBold'), local('OpenSans-SemiBold'), url(https://fonts.gstatic.com/s/opensans/v17/mem5YaGs126MiZpBA-UNirkOUuhs.ttf) format('truetype');
  }

  @font-face {
    font-family: 'Open Sans';
    font-style: normal;
    font-weight: 700;
    src: local('Open Sans Bold'), local('OpenSans-Bold'), url(https://fonts.gstatic.com/s/opensans/v17/mem5YaGs126MiZpBA-UN7rgOUuhs.ttf) format('truetype');
  }
</style>