<template>
    <section>
        <h1>Top</h1>
        <div class="shows">
            <TopShow/>
            <TopShow/>
            <TopShow/>
            <TopShow/>
            <TopShow/>
        </div>
    </section>
</template>

<script>
import TopShow from './TopShow'

export default {
    name: 'TopList',
    components: {
        TopShow
    }
}
</script>