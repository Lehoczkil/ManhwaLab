<template>
    <header>
        <div class="search-container">
            <div class="search">
                <input type="search" placeholder="Find manhwa...">
                <button>Search</button>
            </div>
            <button id="browse" @click="handleBrowseBtn">Browse</button>
        </div>
        <img src="../assets/logo.png" alt="logo" @click="handleMainPageBtn">
        <div class="auth">
            <button>Register</button>
            <button>Login</button>
        </div>
    </header>
</template>

<style scoped>
header {
    background: black;
    display: flex;
    padding-inline: 1vw;
    padding-block: 1vh;
    justify-content: space-between;
    margin-bottom: 3vh;
}

img {
    width: clamp(100px, 10vw, 1000px)
}

.search-container {
    flex-basis: 28%;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.auth {
    flex-basis: 20%;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.search {
    display: flex;
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

.search input:hover,
.search input:focus,
.menu:hover,
.menu:focus {
    border: 1px solid white;
    border-right: none;
    background: black;
    color: white;
}

.search input:focus,
.menu:focus {
    border: 3px solid white;
    border-right: none;
    outline: none;
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
    background: black;
    color: white;
    border: 1px solid white;
    border-left: none;
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
</style>

<script>
export default {
    name: 'Header',
    methods: {
        handleBrowseBtn() {
            this.$router.push('/comics')
        },
        handleMainPageBtn() {
            this.$router.push('/')
        }
    }
}
</script>