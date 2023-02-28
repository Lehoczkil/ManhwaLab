<template>
    <header>
        <input type="checkbox" id="nav-check">
        <img src="../assets/logo.png" alt="logo with a purple potion and the text 'ManhwaLab'"
            @click="handleMainPageBtn">
        <div class="menu-icon">
            <label for="nav-check">
                <span></span>
                <span></span>
                <span></span>
            </label>
        </div>

        <nav class="menu-items">
            <div class="search">
                <input id="search" type="search" placeholder="Find manhwa...">
                <button @click="handleSearch">Search</button>
            </div>
            <div class="auth">
                <button id="browse" @click="handleBrowseBtn">Browse</button>
                <button v-if="!tokenStore.isTokenExists()" @click="showRegister">Register</button>
                <button v-if="!tokenStore.isTokenExists()" @click="showLogin">Login</button>
                <button v-if="tokenStore.isTokenExists()" @click="goToProfile">Profile</button>
                <button v-if="tokenStore.isTokenExists()" @click="handleLogout">Logout</button>
            </div>
        </nav>
        <Login v-show="isLoginVisible" @close="closeLogin" />
        <Register v-show="isRegisterVisible" @close="closeRegister" />
    </header>
</template>

<style scoped>
header,
.menu-items {
    background: black;
    display: flex;
    padding-inline: 1vw;
    padding-block: 1vh;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 3vh;
}

img {
    width: 152px;
    height: 72px;
    cursor: pointer;
}

.auth {
    width: 35vw;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.search {
    display: flex;
    align-items: center;
    width: 20vw;
}

.search input {
    width: clamp(150px, 13vw, 1200px);
    height: 3vh;
    padding-inline: 1vw;
    background: var(--dark-gray);
    padding-block: 0.5vh;
    border: none;
    border-radius: var(--radius) 0 0 var(--radius);
    transition: all 0.3s;
}

.menu:hover,
.menu:focus {
    border-right: none;
    background: black;
    color: white;
}

.search input:focus,
.menu:focus {
    border-right: none;
    outline: none;
}

.search input:focus,
.search input:hover {
    color: white;
}

.search button {
    height: 3vh;
    border: none;
    border-radius: 0 var(--radius) var(--radius) 0;
    padding-inline: 1.5vw;
    padding-block: 0.5vh;
    transition: all 0.3s;
}

.search button:hover {
    background: var(--blue);
    color: white;
}

.auth button,
#browse {
    background: transparent;
    border: none;
    border-radius: var(--radius);
    color: white;
    cursor: pointer;
    font-size: clamp(15px, 1vw, 100px);
    font-weight: 600;
    padding-block: 0.8vh;
    transition: all 0.4s;
    width: clamp(100px, 9vw, 500px);
}

.auth button:hover,
#browse:hover {
    background: white;
    color: black;
}

#browse {
    margin-left: 1vw;
}

.menu-icon {
    display: none;
}

#nav-check {
    display: none;
}

@media (max-width:1150px) {

    header {
        min-width: 350px;
    }

    .menu-icon {
        display: inline-block;
    }

    label {
        display: inline-block;
        width: 50px;
        height: 50px;
        padding: 13px;
    }

    label:hover,
    #nav-check:checked~label {
        background-color: rgba(0, 0, 0, 0.3);
    }

    span {
        display: block;
        width: 25px;
        height: 10px;
        border-top: 2px solid #eee;
    }

    .menu-items {
        position: absolute;
        display: block;
        width: 100%;
        height: 0px;
        transition: all 0.3s ease-in;
        overflow-y: hidden;
        top: 50px;
        left: 0px;
    }

    .menu-items {
        display: block;
        width: 100%;
    }

    #nav-check:not(:checked)~.menu-items {
        display: none;
    }

    #nav-check:not(:checked)~header {
        height: 3vh;
    }

    #nav-check:checked~.menu-items {
        display: flex;
        flex-direction: column;
        justify-content: center;
        text-align: center;
        align-items: center;
        margin-top: 1vh;
        height: auto;
        overflow-y: auto;
    }

    .auth,
    .auth button {
        display: block;
    }

    .search {
        justify-content: center;
    }

    .auth button,
    #browse,
    .search {
        width: clamp(120px, 30vw, 900px);
        margin: auto;
        text-align: center;
        margin-bottom: 1vh;
    }

    img {
        width: 76px;
        height: 36px;
    }
}
</style>

<script>
import { useComicStore } from '@/stores/ComicStore'
import { useTokenStore } from '@/stores/TokenStore'
import { storeToRefs } from 'pinia'
import Login from './Login.vue'
import Register from './Register.vue'

export default {
    name: 'Header',
    components: {
        Login,
        Register
    },
    data() {
        return {
            isLoginVisible: false,
            isRegisterVisible: false,
        };
    },
    methods: {
        handleBrowseBtn() {
            document.querySelector('#nav-check').checked = false;
            this.$router.push('/comics')
        },
        handleMainPageBtn() {
            document.querySelector('#nav-check').checked = false;
            this.$router.push('/')
        },
        handleSearch() {
            document.querySelector('#nav-check').checked = false;
            const comicStore = useComicStore();
            const search = document.querySelector('#search').value
            comicStore.filterComics(null, null, null, null, search);
            this.$router.push('/comics')
        },
        showLogin() {
            document.querySelector('#nav-check').checked = false;
            this.isLoginVisible = true;
        },
        closeLogin() {
            this.isLoginVisible = false;
        },
        showRegister() {
            document.querySelector('#nav-check').checked = false;
            this.isRegisterVisible = true;
        },
        closeRegister() {
            this.isRegisterVisible = false;
        },
        handleLogout() {
            this.tokenStore.clearToken();
        },
        goToProfile() {
            document.querySelector('#nav-check').checked = false;
            this.$router.push('/user-profile')
        }
    },
    setup() {
        const tokenStore = useTokenStore()
        const { token } = storeToRefs(tokenStore)
        return { tokenStore, token }
    }
}
</script>