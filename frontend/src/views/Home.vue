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