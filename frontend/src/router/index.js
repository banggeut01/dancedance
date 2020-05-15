import Vue from 'vue'
import VueRouter from 'vue-router'
import AvatarPage from '@/views/AvatarPage.vue'
import IntroPage from '@/views/IntroPage.vue'
import LoginPage from '@/views/LoginPage.vue'
import MainPage from '@/views/MainPage.vue'
import PlayPage from '@/views/PlayPage.vue'
import RankPage from '@/views/RankPage.vue'
import ResultPage from '@/views/ResultPage.vue'

Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    name: 'IntroPage',
    component: IntroPage
  },
  {
    path: '/avatar',
    name: 'AvatarPage',
    component: AvatarPage
  },
  {
    path: '/login',
    name: 'LoginPage',
    component: LoginPage
  },
  {
    path: '/main',
    name: 'MainPage',
    component: MainPage
  },
  {
    path: '/play',
    name: 'PlayPage',
    component: PlayPage
  },
  {
    path: '/rank',
    name: 'RankPage',
    component: RankPage
  },
  {
    path: '/result',
    name: 'ResultPage',
    component: ResultPage
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
