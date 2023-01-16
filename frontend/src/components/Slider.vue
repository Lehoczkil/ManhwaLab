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
    display: flex;
    justify-content: space-between;
    height: clamp(420px, 26vh, 4200px);
    flex-wrap: wrap;
    align-items: center;
    margin-block: 3vh;
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



