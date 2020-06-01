<template>
  <div class="notFound">
    <h1 style="color: white">404 Error</h1>
    <p style="color: white">The resource could not be found.</p>
    <router-link to="/" exact>
      Go to home page
    </router-link>
  </div>
</template>

<style>
.notFound {
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  min-height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>