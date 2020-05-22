<template>
    <div class="imgDiv" :class="{selectedGlow: selected, unselectedGlow: !selected}">
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
            },
            selected: {
                type: Boolean
            }
        },
    }
</script>

<style>
    .avatarImg {
        width: 210px;
        height: 200px;
        /* max-width: 170px;
        max-height: 130px; */
    }

    .imgDiv {
        margin-top: 10px;
        margin-left: 10px;
        border-radius: 10px;
    }

    .selectedGlow {
        color: #fff;
        box-shadow: 0 0 2px #fff, 0 0 10px #fff, 0 0 20px gold, 0 0 30px gold,
            0 0 40px gold, 0 0 50px gold;
        -webkit-animation: blink 0.5s infinite alternate;
        animation: blink 0.5s infinite alternate;
    }

    .unselectedGlow {
        color: #fff;
        box-shadow: 0 0 2px #fff, 0 0 10px #fff, 0 0 20px #9F00C5, 0 0 30px #9F00C5,
            0 0 40px #9F00C5, 0 0 50px #9F00C5;
        -webkit-animation: blink 0.5s infinite alternate;
        animation: blink 0.5s infinite alternate;
    }

    @-webkit-keyframes blink {
        100% {
            box-shadow: 0 0 3px #fff, 0 0 10px #fff, 0 0 20px #fff, 0 0 40px #0017A8,
                0 0 70px #0017A8, 0 0 80px #0017A8;
        }
    }

    @keyframes blink {
        100% {
            box-shadow: 0 0 3px #fff, 0 0 10px #fff, 0 0 20px #fff, 0 0 40px #0017A8,
                0 0 70px #0017A8, 0 0 80px #0017A8;
        }
    }
</style>