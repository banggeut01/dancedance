<template>
    <div class="avatar">
        <div class="div1">
            <SelectedAvatar if="isSelected" :avatar="avatar" />
        </div>
        <div class="div2">
            <div class="btnLayer" style="margin-top: 5px">
                <v-btn @click="changeAcquired" x-large color="primary" dark>Change Category</v-btn>
                <!-- <v-btn v-else @click="changeAcquired" x-large color="error" dark>획득 아바타</v-btn> -->
            </div>
            <div class="wrapper rightside" style="margin-top: 10px">
                <div v-if="isAcquired">
                    <h1 class="avatarTitle">Available Dancers</h1>
                    <ul class="img-grid">
                        <li v-for="avatar in yAvatars" :key="avatar.id" @click="changeAvatar(avatar)">
                            <Avatar :avatar="avatar" />
                        </li>
                    </ul>
                </div>
                <div v-else id="style-1">
                    <h1 class="avatarTitle">Unvailable Dancers</h1>
                    <ul class="img-grid">
                        <li v-for="avatar in nAvatars" :key="avatar.id">
                            <Avatar :avatar="avatar" />
                        </li>
                    </ul>
                </div>
            </div>
            <div class="btnLayer btnDiv">
                <v-btn v-if="isAcquired" dark style="margin-right:2px">change dancer</v-btn>
                <v-btn dark>return</v-btn>
            </div>
        </div>
    </div>
</template>
S02P31B102-21

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
                yAvatars: [{
                        id: 1,
                        name: 'Ssafyin',
                        explanation: '',
                        url: './avatarImages/1.gif',
                        selected: false
                    },
                    {
                        id: 2,
                        name: 'Heotdool',
                        explanation: '',
                        url: './avatarImages/2.gif',
                        selected: false
                    },
                    {
                        id: 3,
                        name: 'Santa',
                        explanation: '',
                        url: './avatarImages/3.gif',
                        selected: true
                    },
                    {
                        id: 4,
                        name: 'Gaegool',
                        explanation: '',
                        url: './avatarImages/4.gif',
                        selected: false
                    },
                    {
                        id: 5,
                        name: 'Baeksoo',
                        explanation: '',
                        url: './avatarImages/5.gif',
                        selected: false
                    },
                    {
                        id: 6,
                        name: 'Wadadada',
                        explanation: '',
                        url: './avatarImages/6.gif',
                        selected: false
                    },
                ],
                nAvatars: [{
                        id: 7,
                        name: 'Chang',
                        explanation: '',
                        url: './avatarImages/7.gif',
                        selected: false
                    },
                    {
                        id: 8,
                        name: 'Pong',
                        explanation: '',
                        url: './avatarImages/8.gif',
                        selected: false
                    },
                    {
                        id: 9,
                        name: 'Seonbi',
                        explanation: '',
                        url: './avatarImages/9.gif',
                        selected: false
                    },
                    {
                        id: 10,
                        name: 'Mizal',
                        explanation: '',
                        url: './avatarImages/10.gif',
                        selected: false
                    },
                    {
                        id: 11,
                        name: 'Shrimp',
                        explanation: '',
                        url: './avatarImages/11.gif',
                        selected: false
                    },
                    {
                        id: 12,
                        name: 'Kyeong-Ho',
                        explanation: '',
                        url: './avatarImages/12.gif',
                        selected: false
                    },
                ]
            }
        },
        methods: {
            getSelected() {
                for (var i = 0; i < this.yAvatars.length; i++) {
                    if (this.yAvatars[i].selected === true) {
                        this.avatar = this.yAvatars[i]
                        this.isSelected = true
                    }
                }
            },
            changeAvatar(avatar) {
                this.avatar = avatar
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
</style>