<template>
    <div class="avatar">
        <div class="div1">
            <SelectedAvatar v-if="isSelected" :avatar="avatar" />
        </div>
        <div class="div2">
            <div class="btnLayer glow" style="margin-top: 5px">
                <h3 style="color:white; text-align:center" @click="changeAcquired">change category</h3>
            </div>
            <div class="wrapper rightside" style="margin-top: 10px">
                <div v-if="isAcquired">
                    <h1 class="avatarTitle">Available Avatars</h1>
                    <ul class="img-grid">
                        <li v-for="avatar in yAvatars" :key="avatar.id" @click="changeAvatar(avatar)">
                            <Avatar :avatar="avatar" :selected="avatar.selected" />
                        </li>
                    </ul>
                </div>
                <div v-else id="style-1">
                    <h1 class="avatarTitle">Unavailable Avatars</h1>
                    <ul class="img-grid">
                        <li v-for="avatar in nAvatars" :key="avatar.id">
                            <Avatar :avatar="avatar" />
                        </li>
                    </ul>
                </div>
            </div>
            <div class="bottomBtnLayer btnDiv">
                <a href="#" class="button changeButton" v-if="isAcquired">change avatar</a>
                <a href="#" class="button returnButton">return</a>
            </div>
        </div>
    </div>
</template>


<script>
    import SelectedAvatar from './SelectedAvatar.vue'
    import Avatar from './Avatar.vue'

    export default {
        name: 'AvatarList',
        components: {
            SelectedAvatar,
            Avatar
        },
        data() {
            return {
                isSelected: false,
                isAcquired: true,
                avatar: {},
                selectedId: 0,
                yAvatars: [{
                        id: 0,
                        name: 'Yeom',
                        explanation: '',
                        url: './avatarImages/yeom.svg',
                        selected: false
                    },
                    {
                        id: 1,
                        name: 'Owl',
                        explanation: '',
                        url: './avatarImages/owl.svg',
                        selected: false
                    },
                    {
                        id: 2,
                        name: 'Boy',
                        explanation: '',
                        url: './avatarImages/boy.svg',
                        selected: true
                    },
                    {
                        id: 3,
                        name: 'Girl',
                        explanation: '',
                        url: './avatarImages/girl.svg',
                        selected: false
                    },
                ],
                nAvatars: [{
                    id: 0,
                    name: 'Raccoon',
                    explanation: '',
                    url: './avatarImages/raccoon.svg',
                    selected: false
                }, ]
            }
        },
        methods: {
            getSelected() {
                for (var i = 0; i < this.yAvatars.length; i++) {
                    if (this.yAvatars[i].selected === true) {
                        this.avatar = this.yAvatars[i]
                        this.isSelected = true
                        this.selectedId = this.yAvatars[i].id
                    }
                }
            },
            changeAvatar(avatar) {
                if (this.yAvatars[avatar.id].selected === false) {
                    this.avatar = avatar
                    this.yAvatars[avatar.id].selected = !this.yAvatars[avatar.id].selected
                    this.yAvatars[this.selectedId].selected = false
                    this.selectedId = this.avatar.id
                }
            },
            changeAcquired() {
                this.isAcquired = !this.isAcquired
            }
        },
        mounted() {
            this.getSelected(this.avatars)
        }
    }
</script>

<style>
    .avatar {
        height: 700px;
        width: 1400px;
        justify-content: center;
    }

    .div1 {
        width: 50%;
        height: 700px;
        background-image: url("../../assets/stage.png");
        background-size: cover;
        float: left;
        transform: skewY(2deg);
    }

    .div2 {
        width: 50%;
        height: 700px;
        float: left;
        background-color: #232b2b;
        transform: skewY(-2deg);
    }

    .btnLayer {
        display: flex;
        justify-content: center;
        font-family: 'Montserrat', Helvetica, sans-serif;
        flex-direction: row;
        align-items: center;
        cursor: pointer;
        height: 5vh;
    }

    .bottomBtnLayer {
        display: flex;
        justify-content: center;
        font-family: 'Montserrat', Helvetica, sans-serif;
        flex-direction: row;
        align-items: center;
        cursor: pointer;
    }

    .btnDiv {
        height: auto;
        margin: 20px auto;
        position: relative;
    }

    .wrapper {
        max-width: 80em;
        margin: 0 auto;
        background-color: #0e1111;
    }

    li {
        display: inline-block;
        max-height: 200px;
    }

    .avatarTitle {
        color: white;
        text-align: center;
    }

    .img-grid {
        overflow: hidden;
        overflow-y: scroll;
        height: 500px;
        width: 100%;
    }

    .button {
        border-radius: 100px;
        padding: 10px 30px;
        color: #fff;
        text-decoration: none;
        font-size: 1.45em;
        margin: 0 15px;
    }

    .btnLayer:hover {
        background-color: #CA3433;
    }

    .changeButton {
        background: gray;
    }

    .returnButton {
        background: #D2D2D2;
    }

    /* Hover state animation applied here */
    .button:hover {
        -webkit-animation: hover 1200ms linear 2 alternate;
        animation: hover 1200ms linear 2 alternate;
    }

    /* Active state animation applied here */
    .button:active {
        -webkit-animation: active 1200ms ease 1 alternate;
        animation: active 1200ms ease 1 alternate;
    }

    .glow {
        color: #fff;
        box-shadow: 0 0 2px #fff, 0 0 10px #fff, 0 0 20px #C21807, 0 0 30px #C21807,
            0 0 40px #C21807, 0 0 50px #C21807;
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