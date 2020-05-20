<template>
    <div>
        <img :src="require(`${avatar.url}`)" class="avatarImg">
        <h3 style="color:white; text-align:center">{{ avatar.name }}</h3>
    </div>
</template>

<script>
    export default {
        name: 'Avatar',
        props: {
            avatar: {
                type: Object
            }
        },
    }
</script>

<style>
    .avatarImg {
        max-width: 170px;
        max-height: 130px;
    }
</style>