<template>
  <div class="main">
    <Header></Header>
    <video autoplay muted loop width="100%" style="position: fixed">
      <source src="@/assets/mainBackground.mp4" type="video/mp4">
    </video>
    <DanceListCarousel :dances.sync="dances"></DanceListCarousel>
  </div>
</template>

<script>
import Header from '@/components/common/Header.vue'
import DanceListCarousel from '@/components/main/DanceListCarousel.vue'

export default {
  name: 'MainPage',
  data () {
    return {
      dances: []
    }
  },
  components: {
    Header,
    DanceListCarousel,
  },
  mounted() {
    this.$axios.get("http://k02b1021.p.ssafy.io:8197/ssafy-dance/api/main/", 
    {
      headers: {
        'Authorization' : 'eyJ0eXAiOiJKV1QiLCJyZWdEYXRlIjoxNTkwODEyMzE1OTMwLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1OTA4OTg3MTUsInN1YiI6IuuhnOq3uOyduO2GoO2BsCIsIkF1dGhvcml6YXRpb24iOnsibWVtYmVyX2lkIjoyLCJlbWFpbCI6ImRlbGlnaHRfam9vQG5hdmVyLmNvbSIsInBhc3N3b3JkIjpudWxsLCJuaWNrbmFtZSI6Iu2drOq1rCIsImF2YXRhcl9ub3ciOjJ9fQ.8J6OWidZ4k3amstIwK7eq_0Q6U_SnQJKyUWz_ULe_7c'
      }
      }).then(response => {
        console.log(response.data.video)
        this.dances = response.data.video
    })
  }
}
</script>

<style>
.main {
  height: 100vh;
  overflow: hidden;
}
</style>