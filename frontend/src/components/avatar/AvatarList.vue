<template>
    <div class="avatar">
        <div class="leftDiv">
            <SelectedAvatar v-if="isSelected" :avatar="avatar" />
        </div>
        <div class="rightDiv">
            <div class="wrapper rightside" style="margin-top: 10px">
                <div>
                    <h1 class="glow">Available Avatars</h1>
                    <ul class="img-grid">
                        <li v-for="avatar in avatars" :key="avatar.avatar_id" @click="changeAvatar(avatar)">
                            <Avatar :avatar="avatar" :selected="avatar.selected" />
                        </li>
                    </ul>
                </div>
            </div>
            <div class="bottomBtnLayer btnDiv">
                <a href="#" class="btn changeBtn" @click="setAvatar" style="margin-right:5px">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    change avatar
                </a>
                <a href="#" class="btn returnBtn">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    return
                </a>
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
                avatar: {},
                selectedId: 0,
                avatars: '',
                initAvatarId: ''
            }
        },
        methods: {
            getAvatars() {
                this.$axios.get('http://k02b1021.p.ssafy.io:8197/ssafy-dance/api/avatar')
                    .then(res => {
                        this.avatars = res.data.myavatar
                        console.log(res.data)
                        this.getSelected()
                    })
            },
            setAvatar() {
                // this.$axios.post(this.$store.state.host + '/')
                if (this.initAvatarId !== this.selectedId) {
                    this.$axios.patch(`http://k02b1021.p.ssafy.io:8197/ssafy-dance/api/avatar/${this.selectedId}`)
                        .then(res => {
                            this.$store.commit("setToken", res.headers.authorization)
                            sessionStorage.setItem('token', res.headers.authorization)
                        })

                }
            },
            getSelected() {
                for (var i = 0; i < this.avatars.length; i++) {
                    if (this.avatars[i].selected === true) {
                        this.avatar = this.avatars[i]
                        this.isSelected = true
                        this.initAvatarId = i
                        this.selectedId = this.avatars[i].avatar_id
                    }
                }
            },
            changeAvatar(avatar) {
                if (this.avatars[avatar.avatar_id].selected === false) {
                    this.avatar = avatar
                    this.avatars[avatar.avatar_id].selected = !this.avatars[avatar.avatar_id].selected
                    this.avatars[this.selectedId].selected = false
                    this.selectedId = this.avatar.avatar_id
                }
            },
        },
        mounted() {
            this.$store.dispatch('isLogin', this.$axios)
            this.getAvatars();
        }
    }
</script>

<style>
    .avatar {
        height: 700px;
        width: 1400px;
        justify-content: center;
    }

    .leftDiv {
        width: 50%;
        height: 700px;
        background-image: url("../../assets/stage.gif");
        background-size: cover;
        background-position: center;
        float: left;
        transform: skewY(2deg);
    }

    .rightDiv {
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
    }

    .btnDiv {
        height: auto;
        margin: 40px auto;
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

    .img-grid {
        overflow: hidden;
        overflow-y: scroll;
        height: 500px;
        width: 100%;
    }

    .btn {
        position: relative;
        display: inline-block;
        padding: 15px 30px;
        text-transform: uppercase;
        letter-spacing: 4px;
        text-decoration: none;
        font-size: 24px;
        overflow: hidden;
        transition: 0.1s;
    }

    .glow {
        font-size: 40px;
        color: #fff;
        text-align: center;
        -webkit-animation: glow 1s ease-in-out infinite alternate;
        -moz-animation: glow 1s ease-in-out infinite alternate;
        animation: glow 1s ease-in-out infinite alternate;
    }

    @keyframes glow {
        from {
            text-shadow: 0 0 10px #fff, 0 0 20px #fff, 0 0 30px #e60073, 0 0 40px #e60073, 0 0 50px #e60073, 0 0 60px #e60073, 0 0 70px #e60073;
        }

        to {
            text-shadow: 0 0 20px #fff, 0 0 30px #ff4da6, 0 0 40px #ff4da6, 0 0 50px #ff4da6, 0 0 60px #ff4da6, 0 0 70px #ff4da6, 0 0 80px #ff4da6;
        }
    }

    .changeBtn {
        color: #2196f3;
    }

    .returnBtn {
        color: red;
    }

    .changeBtn:hover {
        color: #255784;
        background: skyblue;
        box-shadow: 0 0 10px #2196f3, 0 0 40px #2196f3, 0 0 80px #2196f3;
        transition-delay: 0.25s;
    }

    .returnBtn:hover {
        color: red;
        background: pink;
        box-shadow: 0 0 10px red, 0 0 40px red, 0 0 80px red;
        transition-delay: 0.25s;
    }

    .btn span {
        position: absolute;
        display: block;
    }

    .changeBtn span:nth-child(1) {
        top: 0;
        left: -100%;
        width: 100%;
        height: 2px;
        background: linear-gradient(90deg, transparent, #2196f3);
    }

    .returnBtn span:nth-child(1) {
        top: 0;
        left: -100%;
        width: 100%;
        height: 2px;
        background: linear-gradient(90deg, transparent, red);
    }

    .btn:hover span:nth-child(1) {
        left: 100%;
        transition: 1s;
    }

    .changeBtn span:nth-child(2) {
        bottom: 0;
        right: -100%;
        width: 100%;
        height: 2px;
        background: linear-gradient(270deg, transparent, #2196f3);
    }

    .returnBtn span:nth-child(2) {
        bottom: 0;
        right: -100%;
        width: 100%;
        height: 2px;
        background: linear-gradient(270deg, transparent, red);
    }

    .btn:hover span:nth-child(2) {
        right: 100%;
        transition: 1s;
        transition-delay: 0.5s;
    }

    .changeBtn span:nth-child(3) {
        top: -100℅;
        right: 0%;
        width: 2px;
        height: 100%;
        background: linear-gradient(180deg, transparent, #2196f3);
    }

    .returnBtn span:nth-child(3) {
        top: -100℅;
        right: 0%;
        width: 2px;
        height: 100%;
        background: linear-gradient(180deg, transparent, red);
    }

    .btn:hover span:nth-child(3) {
        top: 100%;
        transition: 1s;
        transition-delay: 0.25s;
    }

    .changeBtn span:nth-child(4) {
        bottom: -100℅;
        left: 0%;
        width: 2px;
        height: 100%;
        background: linear-gradient(360deg, transparent, #2196f3);
    }

    .returnBtn span:nth-child(4) {
        bottom: -100℅;
        left: 0%;
        width: 2px;
        height: 100%;
        background: linear-gradient(360deg, transparent, red);
    }

    .btn:hover span:nth-child(4) {
        bottom: 100%;
        transition: 1s;
        transition-delay: 0.75s;
    }
</style>