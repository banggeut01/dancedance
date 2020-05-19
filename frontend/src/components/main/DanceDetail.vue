<template>
  <div class="danceDetail">

  </div>
</template>

<script>
export default {
    name: 'DanceDetail',
    props: {
        id: Number,
        title: String,
        src: String,
        closeDetail: Function,
    }
}
</script>

<style>
.DanceDetail {
  position: fixed;
  top: 0;
  left: 0;
}
</style>