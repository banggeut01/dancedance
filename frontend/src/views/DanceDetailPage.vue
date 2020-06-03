<template>
  <div class="danceDetail">
    <Header></Header>
    <DanceDetail :dances.sync="dances" :nowDance.sync="nowDance"></DanceDetail>
  </div>
</template>

<script>
import Header from '@/components/common/Header.vue'
import DanceDetail from '@/components/main/DanceDetail.vue'

export default {
  name: 'MainPage',
  props: ['dances', 'nowDance'],
  components: {
    Header,
    DanceDetail,
  },
  created() {
    window.addEventListener('beforeunload', function() {
        this.$router.replace({ name: 'MainPage' })
    })
  },
}
</script>

<style>
.danceDetail {
  height: 100%;
}
</style>