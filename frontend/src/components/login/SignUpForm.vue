<template>
  <v-row justify="center">
    <v-col cols="12">
      <v-form ref="form">
        <v-card-text color="white">
          <div>
            <v-text-field autocomplete="off" style="width: 80%; display: inline-block; padding-right: 8px;" ref="email" v-model="email" :rules="[
                  () => !!email || '이메일을 입력해주세요',
                  () => /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/.test(email) || '이메일 형식이 아닙니다!',
                  () => emailcheck || '이메일 중복을 확인해주세요!'
                ]" lazy-validation label="E-mail" color="success" dark background-color="success" required>
            </v-text-field>
            <div style="width: 20%; display: inline-block;">
              <v-btn :class="{'reset-neon-btn': !emailcheck, 'signup-neon-btn': emailcheck}" text @click="getEmailCheck">
                <span :class="{'reset-neon-span': !emailcheck, 'signup-neon-span': emailcheck}">
                  <v-icon>done_outline</v-icon>
                </span>
              </v-btn>
            </div>
          </div>
          <div>
            <v-text-field style="width: 80%; display: inline-block; padding-right: 8px;" autocomplete="off" ref="nickname" v-model="nickname" :rules="[
                () => !!nickname || '닉네임을 입력해주세요',
                () => !!nickname && nickname.length <= 10 || '10글자 이하로 닉네임을 만드세요',
                () => !!nicknamecheck || '닉네임 중복을 확인해주세요!'
              ]" label="NickName" counter="10" maxlength="10" dark required></v-text-field>
              <div style="width: 20%; display: inline-block;">
                <v-btn :class="{'reset-neon-btn': !nicknamecheck, 'signup-neon-btn': nicknamecheck}" text @click="getNicknameCheck">
                  <span :class="{'reset-neon-span': !nicknamecheck, 'signup-neon-span': nicknamecheck}">
                    <v-icon>done_outline</v-icon>
                  </span>
                </v-btn>
              </div>
          </div>
          <v-text-field autocomplete="new-password" ref="password" v-model="password" :rules="[() => !!password || '패스워드를 입력해주세요']" label="Password"
            type="password" dark required></v-text-field>
          <v-text-field autocomplete="new-password" ref="passwordcheck" v-model="passwordcheck" :rules="[
              () => !!passwordcheck || '패스워드를 입력해주세요',
              () => password === passwordcheck || '동일한 패스워드를 입력해주세요'
            ]" label="Passwordcheck" type="password" dark required></v-text-field>
        </v-card-text>
        <v-divider class="mt-12"></v-divider>
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
    name: 'SignUpForm',
    data() {
      return {
        email: null,
        nickname: null,
        password: null,
        passwordcheck: null,
        emailRules: [],
        formHasErrors: false,
        emailcheck: false,
        nicknamecheck: false
      }
    },
    computed: {
      form() {
        return {
          email: this.email,
          nickname: this.nickname,
          password: this.password,
          passwordcheck: this.passwordcheck,
        }
      },
    },
    methods: {
      resetForm() {
        this.formHasErrors = false
        console.log(this.$refs['email'])
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
          console.log('둘다 오케이')
          const payload = {email: this.email, nickname: this.nickname, password: this.password}
          this.$axios.post(this.$store.state.host + '/signup/', payload)
          .then(res => {
            console.log(res)
            const token = res.headers.authorization
            sessionStorage.setItem('token', token)
            this.$store.commit('setToken', token)
            this.eamil = null
            this.password = null
            this.passwordcheck = null
            this.nicknamecheck = null
            this.$router.push('/main')
            return
          })
        }
      },
      getEmailCheck() {
        this.$axios.get(this.$store.state.host + '/emailcheck', {params: {email : this.email}})
        .then(res => {
          this.emailcheck = res.data.emailcheck
          this.$refs['email'].validate()
          return
        })
      },
      getNicknameCheck() {
        this.$axios.get(this.$store.state.host + '/nicknamecheck', {params:{nickname: this.nickname}})
        .then(res => {
          this.nicknamecheck = res.data.nicknamecheck
          this.$refs['nickname'].validate()
          return
        })
      }
    },
    watch: {
      email() {
        this.emailcheck = false
      },
      nickname() {
        this.nicknamecheck= false
      },
    },
  }
</script>

<style>
  /* submit / reset neon button */
  .signup-neon-btn {
    border-radius: 8px;
    border: 3px solid #228DFF;
    /* cursor: pointer; */
  }

  .reset-neon-btn {
    border-radius: 8px;
    border: 3px solid #FF1177;
  }

  .signup-neon-btn:hover {
    animation: border-flicker 2s linear forwards;
  }

  .reset-neon-btn:hover {
    animation: reset-border-flicker 2s linear forwards;
  }
  
  .signup-neon-span {
    color: #228DFF;
  }

  .reset-neon-span {
    color: #FF1177;
  }
  .signup-neon-btn:hover .signup-neon-span {
    animation: text-flicker 2s linear forwards;
  }
  .reset-neon-btn:hover .reset-neon-span {
    animation: reset-text-flicker 2s linear forwards;
  }

  @keyframes text-flicker {
    2% {
      color: rgb(0, 180, 230);
      text-shadow: 0 0 15px rgb(0, 180, 230);
    }

    3% {
      color: rgb(0, 40, 70);
      text-shadow: none;
    }

    6% {
      color: rgb(0, 180, 230);
      text-shadow: 0 0 15px rgb(0, 180, 230);
    }

    9% {
      color: rgb(0, 40, 70);
      text-shadow: none;
    }

    11% {
      color: rgb(0, 180, 230);
      text-shadow: 0 0 15px rgb(0, 180, 230);
    }

    14% {
      color: rgb(0, 40, 70);
      text-shadow: none;
    }

    18% {
      color: rgb(0, 180, 230);
      text-shadow: 0 0 15px rgb(0, 180, 230);
    }

    32% {
      color: rgb(0, 180, 230);
      text-shadow: 0 0 15px rgb(0, 180, 230);
    }

    33% {
      color: rgb(0, 40, 70);
      text-shadow: none;
    }

    37% {
      color: rgb(0, 180, 230);
      text-shadow: 0 0 15px rgb(0, 180, 230);
    }

    39% {
      color: rgb(0, 40, 70);
      text-shadow: none;
    }

    43% {
      color: rgb(0, 180, 230);
      text-shadow: 0 0 15px rgb(0, 180, 230);
    }

    46% {
      color: rgb(0, 40, 70);
      text-shadow: none;
    }

    47% {
      color: rgb(0, 180, 230);
      text-shadow: 0 0 15px rgb(0, 180, 230);
    }

    100% {
      color: rgb(0, 180, 230);
      text-shadow: 0 0 15px rgb(0, 180, 230);
    }
  }

  @keyframes border-flicker {
    2% {
      border: 3px solid rgb(0, 180, 230);
      box-shadow: 0 0 15px -1px rgb(0, 180, 230),
        0 0 12px -1px rgb(0, 180, 230) inset;
    }

    3% {
      border: 3px solid rgb(0, 40, 70);
      box-shadow: none;
    }

    5% {
      border: 3px solid rgb(0, 180, 230);
      box-shadow: 0 0 15px -1px rgb(0, 180, 230),
        0 0 12px -1px rgb(0, 180, 230) inset;
    }

    6% {
      border: 3px solid rgb(0, 40, 70);
      box-shadow: none;
    }

    7% {
      border: 3px solid rgb(0, 180, 230);
      box-shadow: 0 0 15px -1px rgb(0, 180, 230),
        0 0 12px -1px rgb(0, 180, 230) inset;
    }

    9% {
      border: 3px solid rgb(0, 40, 70);
      box-shadow: none;
    }

    13% {
      border: 3px solid rgb(0, 180, 230);
      box-shadow: 0 0 15px -1px rgb(0, 180, 230),
        0 0 12px -1px rgb(0, 180, 230) inset;
    }

    16% {
      border: 3px solid rgb(0, 40, 70);
      box-shadow: none;
    }

    18% {
      border: 3px solid rgb(0, 180, 230);
      box-shadow: 0 0 15px -1px rgb(0, 180, 230),
        0 0 12px -1px rgb(0, 180, 230) inset;
    }

    22% {
      border: 3px solid rgb(0, 40, 70);
      box-shadow: none;
    }

    34% {
      border: 3px solid rgb(0, 180, 230);
      box-shadow: 0 0 15px -1px rgb(0, 180, 230),
        0 0 12px -1px rgb(0, 180, 230) inset;
    }

    36% {
      border: 3px solid rgb(0, 40, 70);
      box-shadow: none;
    }

    54% {
      border: 3px solid rgb(0, 180, 230);
      box-shadow: 0 0 15px -1px rgb(0, 180, 230),
        0 0 12px -1px rgb(0, 180, 230) inset;
    }

    100% {
      border: 3px solid rgb(0, 180, 230);
      box-shadow: 0 0 15px -1px rgb(0, 180, 230),
        0 0 12px -1px rgb(0, 180, 230) inset;
    }
  }
  
  @keyframes reset-text-flicker {
    2% { 
      color: rgb(230, 0, 120);
      text-shadow: 0 0 15px rgb(230, 0, 120);
    }
    3% {
      color: rgba(120, 0, 50, .5);
      text-shadow: none;
    }
    6% {
      color: rgb(230, 0, 120);
      text-shadow: 0 0 15px rgb(230, 0, 120);
    }
    9% {
      color: rgba(120, 0, 50, .5);
      text-shadow: none;
    }
    11% {
      color: rgb(230, 0, 120);
      text-shadow: 0 0 15px rgb(230, 0, 120);
    }
    14% {
      color: rgba(120, 0, 50, .5);
      text-shadow: none;
    }
    18% {
      color: rgb(230, 0, 120);
      text-shadow: 0 0 15px rgb(230, 0, 120);
    }
    32% {
      color: rgb(230, 0, 120);
      text-shadow: 0 0 15px rgb(230, 0, 120);
    }
    33% {
      color: rgba(120, 0, 50, .5);
      text-shadow: none;
    }
    37% {
      color: rgb(230, 0, 120);
      text-shadow: 0 0 15px rgb(230, 0, 120);
    }
    39% {
      color: rgba(120, 0, 50, .5);
      text-shadow: none;
    }
    43% {
      color: rgb(230, 0, 120);
      text-shadow: 0 0 15px rgb(230, 0, 120);
    }
    46% {
      color: rgba(120, 0, 50, .5);
      text-shadow: none;
    }
    47% {
      color: rgb(230, 0, 120);
      text-shadow: 0 0 15px rgb(230, 0, 120);
    }
    100% {
      color: rgb(230, 0, 120);
      text-shadow: 0 0 15px rgb(230, 0, 120);
    }
  }

  @keyframes reset-border-flicker {
    2% {
      border: 3px solid rgb(230, 0, 120);
      box-shadow: 0 0 15px -1px rgb(230, 0, 120), 
      0 0 12px -1px rgb(230, 0, 120) inset;
    }
    3% {
      border: 3px solid rgba(120, 0, 50, .5);
      box-shadow: none;
    }
    5% {
      border: 3px solid rgb(230, 0, 120);
      box-shadow: 0 0 15px -1px rgb(230, 0, 120), 
      0 0 12px -1px rgb(230, 0, 120) inset;
    }
    6% {
      border: 3px solid rgba(120, 0, 50, .5);
      box-shadow: none;
    }
    7% {
      border: 3px solid rgb(230, 0, 120);
      box-shadow: 0 0 15px -1px rgb(230, 0, 120), 
      0 0 12px -1px rgb(230, 0, 120) inset;
    }
    9% {
      border: 3px solid rgba(120, 0, 50, .5);
      box-shadow: none;
    }
    13% {
      border: 3px solid rgb(230, 0, 120);
      box-shadow: 0 0 15px -1px rgb(230, 0, 120), 
      0 0 12px -1px rgb(230, 0, 120) inset;
    }
    16% {
      border: 3px solid rgba(120, 0, 50, .5);
      box-shadow: none;
    }
    18% {
      border: 3px solid rgb(230, 0, 120);
      box-shadow: 0 0 15px -1px rgb(230, 0, 120), 
      0 0 12px -1px rgb(230, 0, 120) inset;
    }
    22% {
      border: 3px solid rgba(120, 0, 50, .5);
      box-shadow: none;
    }
    34% {
      border: 3px solid rgb(230, 0, 120);
      box-shadow: 0 0 15px -1px rgb(230, 0, 120), 
      0 0 12px -1px rgb(230, 0, 120) inset;
    }
    36% {
      border: 3px solid rgba(120, 0, 50, .5);
      box-shadow: none;
    }
    54% {
      border: 3px solid rgb(230, 0, 120);
      box-shadow: 0 0 15px -1px rgb(230, 0, 120), 
      0 0 12px -1px rgb(230, 0, 120) inset;
    }
    100% {
      border: 3px solid rgb(230, 0, 120);
      box-shadow: 0 0 15px -1px rgb(230, 0, 120), 
      0 0 12px -1px rgb(230, 0, 120) inset;
    }
  }
</style>