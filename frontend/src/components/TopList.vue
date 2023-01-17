<template>
    <section>
        <h1>{{ title }}</h1>
        <div class="shows">
            <TopComic v-for="comic in comics" :key="comic.id" :comic="comic" />
        </div>
    </section>
</template>

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