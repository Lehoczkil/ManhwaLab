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
                <button>Register</button>
                <button>Login</button>
            </div>
        </nav>
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
    padding-block: 0.5vh;
    border: none;
    border-radius: clamp(2px, 0.5vh, 15px) 0 0 clamp(2px, 0.5vh, 15px);
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
    background: #353434;
    color: white;
}

.search button {
    height: 3vh;
    border: none;
    border-radius: 0 clamp(2px, 0.5vh, 15px) clamp(2px, 0.5vh, 15px) 0;
    padding-inline: 1.5vw;
    padding-block: 0.5vh;
    transition: all 0.3s;
}

.search button:hover {
    background: darkmagenta;
    color: white;
}

.auth button,
#browse {
    background: transparent;
    border: none;
    border-radius: clamp(5px, 0.5vh, 30px);
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

@media (max-width:950px) {

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
export default {
    name: 'Header',
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
            const comicStore = useComicStore();
            text = document.querySelector('#search').value
            comicStore.filterComics(null, null, null, null, search)
            this.$router.push('/comics')
        }
    }
}
</script>