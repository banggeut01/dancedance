<template>
  <div>
      {{ videoRanking }}
  </div>
</template>

<script>
  export default {
    name: 'SongRank',
    props: {
      videoRanking: {
        type: Array,
        default: () => ([])
      }
    }
  }
</script>

<style>

</style>