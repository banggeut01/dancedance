<template>
  <div id="app">
    <router-view :key="$route.fullPath"/>
  </div>
</template>

<style lang="scss">
#app {
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: black;
  // position: fixed;
}
</style>
