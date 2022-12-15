<template>
    <article>
        <main>
            <Slider />
            <Slider />
            <Slider />
        </main>
        <aside></aside>
    </article>
</template>

<script>
import Slider from '../components/Slider'

export default {
    name: 'Home',
    components: {
        Slider
    }
}
</script>