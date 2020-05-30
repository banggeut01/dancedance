<template>
   <v-row style="height: 100%">
    <v-col cols="12">
      <v-form ref="form">
        <v-card-text color="white">
          <v-text-field ref="email" v-model="email" :rules="[
                () => !!email || '이메일을 입력해주세요',
                () => /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/.test(email) || '이메일 형식이 아닙니다!'
              ]" lazy-validation label="E-mail" color="success" dark background-color="success" required>
          </v-text-field>
          <v-text-field ref="password" v-model="password" :rules="[() => !!password || '패스워드를 입력해주세요']" label="Password"
            type="password" dark required></v-text-field>
        <v-divider class="mt-12"></v-divider>
        </v-card-text>
        <v-card-actions>
          <v-btn class="signup-neon-btn" text @click="submit">
            <span class="signup-neon-span">
              <v-icon>done_outline</v-icon>
            </span>
          </v-btn>
          <v-spacer></v-spacer>
          <v-btn class="reset-neon-btn" text @click="resetForm">
            <span class="reset-neon-span">
              <v-icon>refresh</v-icon>
            </span>
          </v-btn>
        </v-card-actions>
      </v-form>
    </v-col>
  </v-row>
</template>

<script>
export default {
  name : 'LoginForm',
   data() {
      return {
        email: null,
        password: null,
        formHasErrors: false
      }
    },
    computed: {
      form() {
        return {
          email: this.email,
          password: this.password,
        }
      },
    },
    methods: {
      resetForm() {
        this.formHasErrors = false
        Object.keys(this.form).forEach(f => {
          this.$refs[f].reset()
        })
      },
      submit() {
        this.formHasErrors = false
        Object.keys(this.form).forEach(f => {
          if (!this.form[f]) this.formHasErrors = true
          if (!this.$refs[f].validate(true)) this.formHasErrors = true
        })
        if (this.formHasErrors) {
          console.log('error')
        } else {
          console.log('no error')
          // 로그인 요청
          const payload = {email: this.email, password: this.password}
          this.$axios.post(this.$store.state.host + '/login', payload)
          .then(res => {
            console.log(res)
            this.$axios.defaults.headers.common['Authorization'] = res.headers.authorization
            console.log(this.$axios.defaults.headers.common)
            const token = res.headers.authorization
            this.$store.commit('setToken', token)
            sessionStorage.setItem('token', token)
            this.$router.push('/main')
          })
        }
      },
    },
}
</script>

<style>

</style>