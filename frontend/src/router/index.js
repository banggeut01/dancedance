import Vue from 'vue'
import VueRouter from 'vue-router'
import AvatarPage from '@/views/AvatarPage.vue'
import IntroPage from '@/views/IntroPage.vue'
import LoginPage from '@/views/LoginPage.vue'
import MainPage from '@/views/MainPage.vue'
import DanceDetailPage from '@/views/DanceDetailPage.vue'
import PlayPage from '@/views/PlayPage.vue'
import RankPage from '@/views/RankPage.vue'
import ResultPage from '@/views/ResultPage.vue'
import TmpFaceMeshPage from '@/views/TmpFaceMeshPage.vue'

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
    path: '/danceDetail',
    name: 'DanceDetailPage',
    component: DanceDetailPage,
    props: (route) => ({
      ...route.params
    })
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
  },
  {
    path: '/faceMesh',
    name: 'TmpFaceMeshPage',
    component: TmpFaceMeshPage
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

  router.beforeResolve((to, from, next) => {
    if (sessionStorage.getItem('token')) {
      if (to.path === '/login') {
        return next('/main')
      }
      else {
        return next()
      }
    }
    else {
      if (to.path === '/login' || to.path === '/') {
        return next()
      }
      else {
        return next('/login')
      }
    }
  })

export default router
