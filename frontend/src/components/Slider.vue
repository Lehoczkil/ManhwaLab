<template>
    <section>
        <h1>Test</h1>
        <div class="show-container">
            <Show v-for="comic in comics" :key="comic.comicId" :comic="comic" />
        </div>
    </section>
</template>

<style scoped>
.show-container {
    display: flex;
    justify-content: space-between;
    background: red;
    height: clamp(200px, 15vh, 1200px);
    align-items: center;
}
</style>

<script>
import Show from './Show'

export default {
    name: 'Slider',
    components: {
        Show
    },
    props: {
        comics: Array
    }
}
</script>



