<template>
  <div>
    rank
    <v-carousel hide-delimiters>
      <v-carousel-item
        v-for="(item,i) in items"
        :key="i"
        :src="item.src"
      ></v-carousel-item>
    </v-carousel>
  </div> 
</template>

<script>
export default {
  name: 'RankPage',
  data () {
      return {
        items: [
          {
            src: require('@/assets/stage.png'),
          },
          {
            src: require('@/assets/stage.png'),
          },
          {
            src: require('@/assets/stage.png'),
          },
          {
            src: require('@/assets/stage.png'),
          },
        ],
      }
    },
}
</script>

<style>

</style>