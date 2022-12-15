<template>
    <article>
        <main>
            <Slider />
            <Slider />
            <Slider />
        </main>
        <aside>
            <TopList />
            <TopList />
            <TopList />
        </aside>
    </article>
</template>

<style scoped>
article {
    display: flex;
}

main, aside {
    min-height: 85vh;
    padding-block: 2vh;
}

main {
    flex-basis: 65%;
    background: green;
}

aside {
    flex-basis: 35%;
    background: blue;
}
</style>

<script>
import Slider from '../components/Slider'
import TopList from '../components/TopList'

export default {
    name: 'Home',
    components: {
        Slider,
        TopList
    }
}
</script>