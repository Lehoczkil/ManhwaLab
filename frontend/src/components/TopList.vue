<template>
    <section>
        <h1>Top</h1>
        <div class="shows">
            <TopShow v-for="comic in comics" :key="comic.id" :comic="comic" />
        </div>
    </section>
</template>

<script>
import TopShow from './TopShow'

export default {
    name: 'TopList',
    components: {
        TopShow
    },
    props: {
        comics: Array
    }
}
</script>