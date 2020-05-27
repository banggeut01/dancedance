<template>
    <div class="avatar">
        <div class="div1">
            <SelectedAvatar v-if="isSelected" :avatar="avatar" />
        </div>
        <div class="div2">
            <div class="btnLayer" style="margin-top: 5px">
                <v-btn @click="changeAcquired" x-large color="primary" dark>Change Category</v-btn>
            </div>
            <div class="wrapper rightside" style="margin-top: 10px">
                <div v-if="isAcquired">
                    <h1 class="avatarTitle">Available Dancers</h1>
                    <ul class="img-grid">
                        <li v-for="avatar in yAvatars" :key="avatar.id" @click="changeAvatar(avatar)">
                            <Avatar :avatar="avatar" :selected="avatar.selected" />
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
                        name: 'MR.Yeom',
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