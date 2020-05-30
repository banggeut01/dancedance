import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    host : 'http://k02b1021.p.ssafy.io:8197/ssafy-dance/api',
    token: null
  },
  mutations: {
    setToken(state, payload) {
      state.token = payload
    },
    deleteToken(state) {
      state.token = null
    }
  },
  actions: {
    //세션에 저장하기 및 로그인 상태인지 확인하기
    isLogin(context, payload) {
      if (sessionStorage.getItem('token')) {
        payload.defaults.headers.common['Autherization'] = sessionStorage.getItem('token')
        context.state.token = sessionStorage.getItem('token')
        return true
      }
      else {
        payload.defaults.headers.common['Autherization'] = null
        context.state.token = null
        return false
      }
    }
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
