<template>
    <section>
        <h1>{{ title }}</h1>
        <div class="comic-container">
            <Comic v-for="comic in comics" :key="comic.comicId" :comic="comic" />
        </div>
    </section>
</template>

<style scoped>
.comic-container {
    min-height: 420px;
    display: grid;
    grid-template-columns: repeat(auto-fill, 200px);
    grid-gap: 1rem;
    justify-content: space-around;
    margin-top: 1vh;
}


</style>

<script>
import Comic from './Comic'

export default {
    name: 'Slider',
    components: {
        Comic
    },
    props: {
        comics: Array,
        title: String
    }
}
</script>



