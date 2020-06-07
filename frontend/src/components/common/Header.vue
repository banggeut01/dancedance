<template>
  <v-app-bar flat color="rgba(0, 0, 0, 0)">
    <v-toolbar-title class="neon" @click="moveMain">DANCE_DANCE</v-toolbar-title>
    <v-spacer></v-spacer>
    <v-toolbar-items class="hidden-sm-and-down">
      <div v-if="islogin" class="my-auto mx-2">
        <v-btn large text to="/avatar" class="logInOutBtn">
          AVATAR
        </v-btn>
      </div>
      <div v-if="islogin" class="my-auto mx-2">
        <v-btn large text to="/rank" class="logInOutBtn">
          RANK
        </v-btn>
      </div>
      <div v-if="!islogin" class="my-auto mx-2">
        <v-btn large text @click="login" class="logInOutBtn">
          LOGIN
        </v-btn>
      </div>
      <div v-if="islogin" class="my-auto mx-2">
        <v-btn text @click="logout" class="logInOutBtn">
          LOGOUT
        </v-btn>
      </div>
    </v-toolbar-items>
  </v-app-bar>
</template>

<script>
  export default {
    name: 'Header',
    components: {

    },
    computed: {
      islogin() {
        return this.$store.state.token
      }
    },
    methods: {
      moveMain() {
        this.$router.push({ name: 'MainPage' })
      },
      login() {
        this.$router.push({ name: 'LoginPage' })
      },
      logout() {
        this.$router.push({ name: 'IntroPage' })
        sessionStorage.removeItem('token')
        this.$store.commit('deleteToken')
      }
    }
  }
</script>

<style>

.v-toolbar__content > .v-toolbar__title {
  overflow: visible;
}

.v-btn > .v-btn__content {
  overflow: visible;
}

@font-face {
  font-family: neon;
  src: url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/707108/neon.ttf);
}

.neon {
  font-family: neon;
  overflow: visible;
  color: #FB4264;
  font-size: 2rem !important;
  line-height: 2rem !important;
  text-shadow: 0 0 3vw #F40A35;
  cursor: pointer;
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

.logInOutBtn {
  height: 100% !important;
  color: #B6FF00 !important;
  font-family: "Press Start 2P" !important;
  font-size: 1.3rem !important;
  -webkit-transition: all 0.5s !important;
  -moz-transition: all 0.5s !important;
  transition: all 0.5s !important;
}
.logInOutBtn:hover {
  color: #ffffff !important;
  -webkit-animation: neon4 1.5s ease-in-out infinite alternate;
  -moz-animation: neon4 1.5s ease-in-out infinite alternate;
  animation: neon4 1.5s ease-in-out infinite alternate;
}
@-webkit-keyframes neon4 {
  from {
    text-shadow: 0 0 10px #fff, 0 0 20px #fff, 0 0 30px #fff, 0 0 40px #B6FF00, 0 0 70px #B6FF00, 0 0 80px #B6FF00, 0 0 100px #B6FF00, 0 0 150px #B6FF00;
  }
  to {
    text-shadow: 0 0 5px #fff, 0 0 10px #fff, 0 0 15px #fff, 0 0 20px #B6FF00, 0 0 35px #B6FF00, 0 0 40px #B6FF00, 0 0 50px #B6FF00, 0 0 75px #B6FF00;
  }
}
@-moz-keyframes neon4 {
  from {
    text-shadow: 0 0 10px #fff, 0 0 20px #fff, 0 0 30px #fff, 0 0 40px #B6FF00, 0 0 70px #B6FF00, 0 0 80px #B6FF00, 0 0 100px #B6FF00, 0 0 150px #B6FF00;
  }
  to {
    text-shadow: 0 0 5px #fff, 0 0 10px #fff, 0 0 15px #fff, 0 0 20px #B6FF00, 0 0 35px #B6FF00, 0 0 40px #B6FF00, 0 0 50px #B6FF00, 0 0 75px #B6FF00;
  }
}
@keyframes neon4 {
  from {
    text-shadow: 0 0 10px #fff, 0 0 20px #fff, 0 0 30px #fff, 0 0 40px #B6FF00, 0 0 70px #B6FF00, 0 0 80px #B6FF00, 0 0 100px #B6FF00, 0 0 150px #B6FF00;
  }
  to {
    text-shadow: 0 0 5px #fff, 0 0 10px #fff, 0 0 15px #fff, 0 0 20px #B6FF00, 0 0 35px #B6FF00, 0 0 40px #B6FF00, 0 0 50px #B6FF00, 0 0 75px #B6FF00;
  }
}
</style>