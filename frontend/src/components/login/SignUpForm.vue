<template>
  <v-row justify="center">
    <v-col cols="12">
      <v-form ref="form">
        <v-card-text color="white">
          <v-text-field
            ref="email"
            v-model="email"
            :rules="[
                () => !!email || '이메일을 입력해주세요',
                () => /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/.test(email) || '이메일 형식이 아닙니다!'
              ]"
            lazy-validation
            label="E-mail"
            color="success"
            dark
            background-color="success"
            required
          ></v-text-field>
          <v-text-field
            ref="nickname"
            v-model="nickname"
            :rules="[
              () => !!nickname || '닉네임을 입력해주세요',
              () => !!nickname && nickname.length <= 10 || '10글자 이하로 닉네임을 만드세요'
            ]"
            label="NickName"
            counter="10"
            maxlength="10"
            dark
            required
          ></v-text-field>
          <v-text-field
            ref="password"
            v-model="password"
            :rules="[() => !!password || '패스워드를 입력해주세요']"
            label="Password"
            type="password"
            dark
            required
          ></v-text-field>
          <v-text-field
            ref="passwordcheck"
            v-model="passwordcheck"
            :rules="[
              () => !!passwordcheck || '패스워드를 입력해주세요',
              () => password === passwordcheck || '동일한 패스워드를 입력해주세요'
            ]"
            label="Passwordcheck"
            type="password"
            dark
            required
          ></v-text-field>
        </v-card-text>
        <v-divider class="mt-12"></v-divider>
        <v-card-actions>
          <v-btn
            icon
            class="my-0 white--text"
            @click="resetForm"
            >
              
              <!-- <v-icon>mdi-refresh</v-icon> -->
              <p>reset</p>
            </v-btn>
          <v-spacer></v-spacer>
          <v-btn class="white--text" text @click="submit">Submit</v-btn>
        </v-card-actions>
      </v-form>
    </v-col>
  </v-row>
</template>

<script>
  export default {
    data() {
      return {
          email: null,
          nickname: null,
          password: null,
          passwordcheck: null,
          emailRules: [],
          formHasErrors : false
        }
      },
    computed: {
      form () {
        return {
          email: this.email,
          nickname: this.nickname,
          password: this.password,
          passwordcheck: this.passwordcheck,
        }
      },
    },
    methods: {
      resetForm () {
        this.formHasErrors = false
        Object.keys(this.form).forEach(f => {
          this.$refs[f].reset()
        })
      },
      submit () {
        this.formHasErrors = false
        Object.keys(this.form).forEach(f => {
          if (!this.form[f]) this.formHasErrors = true
          if (!this.$refs[f].validate(true)) this.formHasErrors=true
        })
        if (this.formHasErrors) {
          console.log('error')
        }
        else {
          console.log('no error')
          // 회원가입 요청쓰
        }
      },
    },
  }
</script>

<style>

</style>