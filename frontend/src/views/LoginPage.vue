<template>
  <div>
    <!-- / link button -->
    <div v-if="!islogin" class="logo-div">
      <v-btn 
      depressed 
      style="background-color: rgba(0,0,0,0);" 
      to="/">
        <p class="neon">DANCE_DANCE</p>
      </v-btn>
    </div>
    <!-- background img -->
    <video autoplay muted loop id="login-video">
      <source src="../assets/login_back_img.mp4" type="video/mp4">
    </video>
    <!-- background sound -->
    <audio class="login-audio" controls autoplay loop>
      <source src="../assets/login_bgsound.mp3" type="audio/mpeg">
    </audio>
    <!-- slide login/signup -->
    <div class="slidershow middle">

      <div class="slides">
        <input type="radio" name="r" id="r1" checked>
        <input type="radio" name="r" id="r2">

        <div class="slide s1 d-flex">
          <div class="account-form">
            <LoginForm></LoginForm>
          </div>
        </div>
        <div class="slide">
          <div style="width:50%; height:100%;">
            <div class="account-form">
              <SignUpForm></SignUpForm>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- slide button -->
    <div class="navigation">
      <label for="r1" style="margin-right:25px;"><p class="nav-p login-p">LOGIN</p></label>
      <label for="r2" style="margin-left:25px;"><p class="nav-p signup-p">SIGNUP</p></label>
    </div>
  </div>
</template>

<script>
  import LoginForm from '../components/login/LoginForm.vue'
  import SignUpForm from '../components/login/SignUpForm.vue'
  export default {
    name: 'LoginPage',
    data: () => ({
      length: 2,
      window: 0,
      componentTags: ['', '<LoginForm></LoginForm>', '<SignUpForm></SignUpForm>']
    }),
    components: {
      LoginForm,
      SignUpForm
    },
    computed: {
      islogin() {
        return false
      }
    },
    mounted() {
      document.getElementsByClassName('login-audio').volume = 0.1;
    },
  }
</script>

<style>
  /* DANCE DANCE LINK */
  .logo-div {
    position: absolute;
    left: 10px;
    top: 20px;
  }

  @font-face {
    font-family: neon;
    src: url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/707108/neon.ttf);
  }

  .neon {
    font-family: neon;
    color: #FB4264;
    font-size: 3rem;
    line-height: 3rem;
    text-shadow: 0 0 3vw #F40A35;
  }

  .neon {
    animation: neon 1s ease infinite;
    -moz-animation: neon 1s ease infinite;
    -webkit-animation: neon 1s ease infinite;
  }

  @keyframes neon {
    0%,
    100% {
      text-shadow: 0 0 1vw #FA1C16, 0 0 3vw #FA1C16, 0 0 10vw #FA1C16, 0 0 10vw #FA1C16, 0 0 .4vw #FED128, .5vw .5vw .1vw #806914;
      color: #FED128;
    }
    50% {
      text-shadow: 0 0 .5vw #800E0B, 0 0 1.5vw #800E0B, 0 0 5vw #800E0B, 0 0 5vw #800E0B, 0 0 .2vw #800E0B, .5vw .5vw .1vw #40340A;
      color: #806914;
    }
  }
  /* background-video */
  #login-video {
    position: fixed;
    right: 0;
    bottom: 0;
    min-width: 100%;
    min-height: 100%;
    z-index: -1;
  }
  /* slide login & signup form */
  .slidershow {
    width: 100%;
    height: 400px;
    overflow: hidden;
  }

  .middle {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
  }
  /* login, signup button */
  .navigation {
    position: absolute;
    top: 100px;
    left: 50%;
    transform: translateX(-50%);
    display: flex;
  }

  input[name="r"] {
    position: absolute;
    visibility: hidden;
  }

  .slides {
    width: 200%;
    height: 100%;
    display: flex;
  }

  .slide {
    width: 100%;
    transition: 0.6s;
  }

  .slide .account-form {
    width: 300px;
    height: 300px;
    min-height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    min-width: 30%;
    margin: 0 auto;
  }

  #r1:checked~.s1 {
    margin-left: 0;
  }

  #r2:checked~.s1 {
    margin-left: -100%;
  }

  .login-audio {
    position: absolute;
    bottom: 10px;
    left: 10px;
  }

  /* 네온사인 텍스트 */
  .nav-p {
    text-align: center;
    font-size: 3em;
    text-decoration: none;
    -webkit-transition: all 0.5s;
    -moz-transition: all 0.5s;
    transition: all 0.5s;
    font-family: Iceland;
    cursor: pointer;
  }
  .login-p {
    color: #228DFF;
  }
  .signup-p {
    color: #BA01FF;
  }
  .login-p:hover {
    -webkit-animation: neon2 1.5s ease-in-out infinite alternate;
    -moz-animation: neon2 1.5s ease-in-out infinite alternate;
    animation: neon2 1.5s ease-in-out infinite alternate;
  }
  .signup-p:hover {
    -webkit-animation: neon6 1.5s ease-in-out infinite alternate;
    -moz-animation: neon6 1.5s ease-in-out infinite alternate;
    animation: neon6 1.5s ease-in-out infinite alternate;
  }
  .nav-p:hover {
    color: #ffffff;
  }

  @-webkit-keyframes neon2 {
    from {
      text-shadow: 0 0 10px #fff, 0 0 20px #fff, 0 0 30px #fff, 0 0 40px #228DFF, 0 0 70px #228DFF, 0 0 80px #228DFF, 0 0 100px #228DFF, 0 0 150px #228DFF;
    }

    to {
      text-shadow: 0 0 5px #fff, 0 0 10px #fff, 0 0 15px #fff, 0 0 20px #228DFF, 0 0 35px #228DFF, 0 0 40px #228DFF, 0 0 50px #228DFF, 0 0 75px #228DFF;
    }
  }

  @-moz-keyframes neon2 {
    from {
      text-shadow: 0 0 10px #fff, 0 0 20px #fff, 0 0 30px #fff, 0 0 40px #228DFF, 0 0 70px #228DFF, 0 0 80px #228DFF, 0 0 100px #228DFF, 0 0 150px #228DFF;
    }

    to {
      text-shadow: 0 0 5px #fff, 0 0 10px #fff, 0 0 15px #fff, 0 0 20px #228DFF, 0 0 35px #228DFF, 0 0 40px #228DFF, 0 0 50px #228DFF, 0 0 75px #228DFF;
    }
  }

  @keyframes neon2 {
    from {
      text-shadow: 0 0 10px #fff, 0 0 20px #fff, 0 0 30px #fff, 0 0 40px #228DFF, 0 0 70px #228DFF, 0 0 80px #228DFF, 0 0 100px #228DFF, 0 0 150px #228DFF;
    }

    to {
      text-shadow: 0 0 5px #fff, 0 0 10px #fff, 0 0 15px #fff, 0 0 20px #228DFF, 0 0 35px #228DFF, 0 0 40px #228DFF, 0 0 50px #228DFF, 0 0 75px #228DFF;
    }
  }

  @-webkit-keyframes neon6 {
    from {
      text-shadow: 0 0 10px #fff, 0 0 20px #fff, 0 0 30px #fff, 0 0 40px #ff00de, 0 0 70px #ff00de, 0 0 80px #ff00de, 0 0 100px #ff00de, 0 0 150px #ff00de;
    }
    to {
      text-shadow: 0 0 5px #fff, 0 0 10px #fff, 0 0 15px #fff, 0 0 20px #ff00de, 0 0 35px #ff00de, 0 0 40px #ff00de, 0 0 50px #ff00de, 0 0 75px #ff00de;
    }
  }

  @-moz-keyframes neon6 {
    from {
      text-shadow: 0 0 10px #fff, 0 0 20px #fff, 0 0 30px #fff, 0 0 40px #ff00de, 0 0 70px #ff00de, 0 0 80px #ff00de, 0 0 100px #ff00de, 0 0 150px #ff00de;
    }
    to {
      text-shadow: 0 0 5px #fff, 0 0 10px #fff, 0 0 15px #fff, 0 0 20px #ff00de, 0 0 35px #ff00de, 0 0 40px #ff00de, 0 0 50px #ff00de, 0 0 75px #ff00de;
    }
  }
  
  @keyframes neon6 {
    from {
      text-shadow: 0 0 10px #fff, 0 0 20px #fff, 0 0 30px #fff, 0 0 40px #ff00de, 0 0 70px #ff00de, 0 0 80px #ff00de, 0 0 100px #ff00de, 0 0 150px #ff00de;
    }
    to {
      text-shadow: 0 0 5px #fff, 0 0 10px #fff, 0 0 15px #fff, 0 0 20px #ff00de, 0 0 35px #ff00de, 0 0 40px #ff00de, 0 0 50px #ff00de, 0 0 75px #ff00de;
    }
  }
</style>