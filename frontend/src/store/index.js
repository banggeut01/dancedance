import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    host : 'http://localhost:8197/ssafy-dance/api',
    token : null,
    user : {}
  },
  mutations: {
    getUserInfo(state, payload) {
      state.token = payload.token
      state.user = payload.user
    },
    deleteUserInfo(state) {
      state.token = null
      state.user = {}
    }
  },
  actions: {
    //세션에 저장하기 및 로그인 상태인지 확인하기
  },
  getters : {
    // options(state) {
    //     return{
    //         headers: {
    //             Authorization : `JWT ${state.token}` // JWT 다음에 공백있음!
    //         }
    //     }        
    // },
    // user(state) {
    //     return jwtDecode(state.token).user_id
    // }
  },
  modules: {
  }
})
