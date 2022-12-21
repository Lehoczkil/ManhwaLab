<template>
    <article>
        <section class="controls">
            <div class="row">
                <Select />
                <Select />
            </div>
            <div class="row">
                <Select />
                <Select />
            </div>
            <div class="search">
                <input type="search" placeholder="Search...">
                <button type="submit">Go</button>  
            </div>
        </section>
    </article>
</template>

<style scoped>
.row {
    display: flex;
    width: 60%;
    background: red;
    margin-inline: auto;
    justify-content: space-between;
}

.controls {
    min-height: 30vh;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-around;
    background: green;
}

.search {
    width: 60vw;
}

.search input {
    width: clamp(150px, 50vw, 1200px);
    height: 6vh;
    background: #2d2f31;
    color: white;
    padding-inline: 1vw;
    padding-block: 0.5vh;
    border: none;
    border-radius: clamp(2px, 0.5vh, 15px) 0 0 clamp(2px, 0.5vh, 15px);
    transition: all 0.3s;
}

.search input:hover,
.search input:focus {
    border-right: none;
    background: white;
    color: #2d2f31;
}

.search input:focus {
    border-right: none;
    outline: none;
}

.search button {
    height: 6vh;
    width: 10vw;
    border: none;
    border-radius: 0 clamp(2px, 0.5vh, 15px) clamp(2px, 0.5vh, 15px) 0;
    padding-inline: 1.5vw;
    padding-block: 0.5vh;
    transition: all 0.3s;
    background: #2d2f31;
    color: white
}

.search button:hover {
    background: darkslateblue;
    color: white;
}
</style>

<script>
import Select from '../components/Select'

export default {
    name: 'Comics',
    components: {
        Select
    }
}
</script>