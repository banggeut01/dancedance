<template>
  <div>
    <video autoplay muted loop id="login-video">
      <source src="../assets/login_back_img.mp4" type="video/mp4">
    </video>
    <!-- <embed src="" autostart=true loop="infinite"> -->
    <audio class="login-audio" controls autoplay loop>
      <!-- <source src="horse.ogg" type="audio/ogg"> -->
      <source src="../assets/login_bgsound.mp3" type="audio/mpeg">
      Your browser does not support the audio element.
    </audio>
    <div class="slidershow middle">

      <div class="slides">
        <input type="radio" name="r" id="r1" checked>
        <input type="radio" name="r" id="r2">

        <div class="slide s1 d-flex">
          <div class="account-form">
            <LoginForm></LoginForm>
          </div>
          <!-- <img src="../assets/logo.png"> -->
        </div>
        <div class="slide">
          <div style="width:50%; height:100%;">
            <div class="account-form">
              <SignUpForm></SignUpForm>
            </div>
          </div>
          <!-- <img class="signup-form" src="../assets/logo.png"> -->
        </div>
      </div>
    </div>

    <div class="navigation">
      <label for="r1" class="bar"><p class="nav-p login-p">LOGIN</p></label>
      <label for="r2" class="bar"><p class="nav-p signup-p">SINGUP</p></label>
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
    }
  }
</script>

<style>
  #login-video {
    position: fixed;
    right: 0;
    bottom: 0;
    min-width: 100%;
    min-height: 100%;
    z-index: -1;
  }

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

  .navigation {
    position: absolute;
    top: 100px;
    left: 50%;
    transform: translateX(-50%);
    display: flex;
  }

  .bar {
    width: 50px;
    height: 10px;
    border: 2px solid #fff;
    margin: 6px;
    cursor: pointer;
    transition: 0.4s;
  }

  .bar:hover {
    background: #fff;
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