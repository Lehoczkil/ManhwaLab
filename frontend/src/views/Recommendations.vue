<template>
    <article>
        <h1>Recommendations</h1>
        <List />
    </article>
</template>

<style scoped>
    h1 {
        margin-block: 3vh;
        text-align: center;
        font-size: 3vw;
    }
</style>

<script>
import List from '../components/List'

export default {
    name: 'Recommendations',
    components: {
        List
    }
}
</script>