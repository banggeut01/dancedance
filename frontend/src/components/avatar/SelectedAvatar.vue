<template>
    <div class="centered">
        <h1 class="glow">Your Avatar</h1>
        <img :src="require(`${avatar.url}`)" class="selectedImg">
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
    .selectedImg {
        height: 100%;
        width: 30vw;
    }
    .centered {
        position: absolute;
        left: 50%;
        top: 50%;
        -webkit-transform: translate(-50%, -50%);
        transform: translate(-50%, -50%);
        text-align: center;
    }
</style>