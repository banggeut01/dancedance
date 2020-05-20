<template>
    <div class="centered">
        <h1 style="color:white">Your Dancer</h1>
        <img :src="require(`${avatar.url}`)" height="300px">
        <h1 style="color:white">{{ avatar.name }}</h1>
    </div>
</template>

<script>
    export default {
        name: 'SelectedAvatar',
        props: {
            avatar: {
                type: Object,
            }
        },
    }
</script>

<style>
    .centered {
        position: absolute;
        left: 50%;
        top: 50%;
        -webkit-transform: translate(-50%, -50%);
        transform: translate(-50%, -50%);
        text-align: center;
    }
</style>