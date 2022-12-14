<template>
    <header>
        <div class="search-container">
            <div class="search">
                <input type="search" placeholder="Find manhwa...">
                <button>Search</button>
            </div>
            <div class="select">
                <select>
                    <option value="">Browse</option>
                    <option value="">Recommendations</option>
                </select>
            </div>
        </div>
        <img src="../assets/logo.png" alt="logo">
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
}

img {
    width: clamp(100px, 13vw, 1000px)
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

select {
    -webkit-appearance: none;
    -moz-appearance: none;
    -ms-appearance: none;
    appearance: none;
    outline: 0;
    box-shadow: none;
    border: 0 !important;
    background: white;
    flex: 1;
    color: black;
    text-align: center;
    cursor: pointer;
}

select::-ms-expand {
    display: none;
}

.select {
    position: relative;
    display: flex;
    width: clamp(160px, 7vw, 1000px);
    height: 3vh;
    overflow: hidden;
    border-radius: .25em;
}

.select::after {
    content: '\25BC';
    position: absolute;
    height: 3vh;
    top: 0;
    right: 0;
    padding: 0 0.5vw;
    background: buttonface;
    cursor: pointer;
    pointer-events: none;
    transition: .25s all ease;
}

.select:hover::after {
    color: white;
    background: black;
    border: 2px solid white;
}

.auth button {
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

.auth button:hover {
    background: white;
    color: black;
}

</style>

<script>
export default {
    name: 'Header'
}
</script>