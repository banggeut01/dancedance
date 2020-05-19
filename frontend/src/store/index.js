import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
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
    
  },
  modules: {
  }
})
