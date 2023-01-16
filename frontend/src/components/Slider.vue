<template>
    <section>
        <h1>Test</h1>
        <div class="comic-container">
            <Comic v-for="comic in comics" :key="comic.comicId" :comic="comic" />
        </div>
    </section>
</template>

<style scoped>
.comic-container {
    display: flex;
    justify-content: space-between;
    background: red;
    height: clamp(200px, 15vh, 1200px);
    align-items: center;
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
        comics: Array
    }
}
</script>



