<template>
  <div class="resultBackground">
    <video autoplay muted loop id="videoBG">
      <source :src="require('@/assets/resultBackground.mp4')" type="video/mp4">
    </video>
    <div class="resultDiv">
      <div class="resultUpper">
        <div class="profileDiv">
          <img :src="require('@/assets/profileImg/yeom.jpg')" alt="" class="profileImg">
        </div>
        <div class="userInfo">
          <span id="userName" class="glow">
            무무초이<br>
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
          <span style="font-size:4rem; margin-top:10px" id="point" class="glow">12400</span>pts
        </div>
        <div class="rankingRatings">
          <span style="color: white; font-size:2rem;">
            <span id="ranking" style="font-size:4rem; margin-top:10px" class="glow">35</span>th
          </span>
        </div>
      </div>
      <div class="resultBtn" style="text-align:center">
        <p class="buttonP" style="margin-right:100px;display:inline-block;">
          <a class="buttonCommon buttonA">다시하기</a>
        </p>
        <p class="buttonP" style="margin:0;display:inline;">
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
        chgNumSpeed: 0.1,
        today: ''
      }
    },
    methods: {
      increaseNum(id, unit) {
        var elt = document.getElementById(id);
        var endNbr = Number(document.getElementById(id).innerHTML);
        this.incNumRecur(0, endNbr, elt, unit);
      },
      /*A recursive function to increase the number.*/
      incNumRecur(i, endNbr, elt, unit) {
        if (i <= endNbr) {
          elt.innerHTML = i;
          var th = this
          setTimeout(function () { //Delay a bit before calling the function again.
            th.incNumRecur(i + unit, endNbr, elt, unit);
          }, th.chgNumSpeed);
        }
      },
      getCurrentTime() {
        var today = new Date();
        this.today = today.getFullYear() + '년 ' + (today.getMonth() + 1) + '월 ' + today.getDate() + '일 ' + today.getHours() +'시 ' + today.getMinutes() + '분';
      }
    },
    mounted() {
      this.increaseNum("ranking", 1);
      this.increaseNum("point", 100);
      this.getCurrentTime();
    }
  }
</script>

<style>
  .buttonP {
    text-align: center;
    font-size: 3rem;
    margin: 20px 0 20px 0;
    cursor: pointer;
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

  @-webkit-keyframes neon1 {
    from {
      text-shadow: 0 0 10px #fff, 0 0 20px #fff, 0 0 30px #fff, 0 0 40px #45b6fe, 0 0 70px #45b6fe, 0 0 80px #45b6fe, 0 0 100px #FF1177, 0 0 150px #FF1177;
    }

    to {
      text-shadow: 0 0 5px #fff, 0 0 10px #fff, 0 0 15px #fff, 0 0 20px #45b6fe, 0 0 35px #45b6fe, 0 0 40px #45b6fe, 0 0 50px #FF1177, 0 0 75px #FF1177;
    }
  }

  @-webkit-keyframes neon2 {
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
    height: 200px;
    width: 200px;
  }

  .userInfo {
    display: inline-block;
    margin-left: 30px;
  }

  .userInfo #userName {
    color: white;
    font-size: 4rem;
  }

  .userInfo #performedTime {
    color: white;
    font-size: 1rem;
  }

  .resultBottom {
    height: 200px;
    /* width: 600px; */
    margin-left: 50px;
  }

  .starRatings {
    unicode-bidi: bidi-override;
    color: white;
    font-size: 4rem;
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

  @keyframes rating {
    from {
      width: 0;
    }

    to {
      width: 70%;
    }
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