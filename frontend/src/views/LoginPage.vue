<template>
  <div>
    login
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

</style>