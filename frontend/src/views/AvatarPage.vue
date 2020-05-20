<template>
  <div class="avatarBackground">
    <AvatarList />
  </div>
</template>

<script>
import AvatarList from '../components/avatar/AvatarList.vue'

export default {
  name: 'AvatarPage',
  components: {
    AvatarList
  }
}
</script>

<style>
.avatarBackground {
  background-image: url("../assets/avatarBackground.jpg");
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  min-height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>