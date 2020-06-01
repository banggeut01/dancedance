<template>
  <v-app-bar flat class="header" color="rgba(0, 0, 0, 0)" bottom="true">
    <v-toolbar-title class="neon">DANCE_DANCE</v-toolbar-title>
    <v-spacer></v-spacer>
    <v-toolbar-items class="hidden-sm-and-down">
      <div class="my-auto mx-2" @click="moveMain">
        <div>
          GO
        </div>
      </div>
      <div v-if="islogin" class="my-auto mx-2">
        <v-btn v-if="user.name !='test'" key="MY PAGE" to="/userinfo" large text color="white">
          MY PAGE
        </v-btn>
      </div>
      <div v-if="!islogin" class="my-auto mx-2">
        <v-btn large color="#FF7033" key="LOG IN" to="/login" style="color: white;">
          LOG IN
        </v-btn>
      </div>
      <div v-if="islogin" class="my-auto mx-2">
        <v-btn large color="#FF7033" key="LOG OUT" @click="logout" style="color: white;">
          LOG OUT
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
        return false
      }
    },
  }
</script>

<style>
.v-toolbar__content > .v-toolbar__title {
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
  font-size: 2rem;
  line-height: 2rem;
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
</style>