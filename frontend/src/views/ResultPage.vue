<template>
  <div class="resultBackground">
    <div class="resultDiv">
      <div class="resultUpper">
        <div class="profileImg">
          <img :src="require('@/assets/profileImg/owl.jpg')" alt="" class="profileImg">
        </div>
        <div class="userInfo">
          <span>
            moomoo
          </span>
        </div>
      </div>
      <div class="resultBottom">
        <div class="starRatings">
          <div class="starRatingsTop"><span>★</span><span>★</span><span>★</span><span>★</span><span>★</span></div>
          <div class="starRatingsBottom"><span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
          </div>
        </div>
        <div class="scoreRatings">
          <span>Score</span>
          <span>12500pt</span>
        </div>
      </div>
      <div class="resultBtn">
        <div style="display:inline-block">
          <button style="color:white;">다시하기</button>
        </div>
        <div style="display:inline-block">
          <button style="color:white; display:inline-block">종료하기</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'ResultPage'
  }
</script>

<style>
  .resultBackground {
    background-image: url("../assets/avatarBackground.jpg");
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
    left: 50%;
    top: 50%;
    -webkit-transform: translate(-50%, -50%);
    transform: translate(-50%, -50%);
    background-color: black;
  }

  .profileImg {
    height: 200px;
    width: 200px;
    display: inline-block;
  }

  .userInfo {
    display: inline-block;
  }

  .userInfo span {
    color: white;
    font-size: 4rem;
  }

  .resultBottom {
    height: 300px;
    width: 600px;
  }

  .starRatings {
    unicode-bidi: bidi-override;
    color: white;
    font-size: 4rem;
    display: inline-block;
    margin: 0 auto;
    position: relative;
    padding: 0;
    border: 1px solid white;
  }

  .scoreRatings {
    unicode-bidi: bidi-override;
    color: white;
    font-size: 4rem;
    display: inline-block;
    margin: 0 auto;
    position: relative;
    padding: 0;
    border: 1px solid white;
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
    animation: rating 3s forwards;
  }

  .starRatingsBottom {
    padding: 0;
    display: block;
    z-index: 0;
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

  em {
    font-style: italic;
  }

  h2 {
    font-size: 16px;
    margin-bottom: 15px;
  }
</style>