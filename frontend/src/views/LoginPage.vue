<template>
  <div>
    <video autoplay loop id="login-video">
        <source src="../assets/login_back_img.mp4" type="video/mp4">
    </video>
    <LoginForm></LoginForm>
    <SignUpForm></SignUpForm>
  </div>
</template>

<script>
import LoginForm from '../components/login/LoginForm.vue'
import SignUpForm from '../components/login/SignUpForm.vue'
export default {
  name: 'LoginPage',
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
</style>