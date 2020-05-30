<template>
    <div class="centered">
        <h1 class="glow">Your Avatar</h1>
        <FaceMesh :name="avatar.name" />
        <h1 style="color:white">{{ avatar.name }}</h1>
    </div>
</template>

<script>
    import FaceMesh from '@/components/faceMesh/FaceMesh.vue'

    export default {
        name: 'SelectedAvatar',
        components: {
            FaceMesh
        },
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