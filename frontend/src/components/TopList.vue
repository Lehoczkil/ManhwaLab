<template>
    <section>
        <h1 class="title">{{ title }}</h1>
        <div class="shows">
            <TopComic v-for="comic in comics" :key="comic.id" :comic="comic" />
        </div>
    </section>
</template>

<style scoped>
@media (max-width:950px) {
    .title {
        text-align: center;
        font-size: 2rem;
        margin-block: 3vh;
    }
}
</style>

<script>
import TopComic from './TopComic'

export default {
    name: 'TopList',
    components: {
        TopComic
    },
    props: {
        comics: Array,
        title: String,
    }
}
</script>