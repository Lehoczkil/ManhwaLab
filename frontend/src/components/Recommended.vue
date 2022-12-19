<template>
    <section class="recommended">
        <h1>More like this</h1>
        <div class="shows">
            <Show />
            <Show />
            <Show />
            <Show />
            <Show />
        </div>
    </section>
</template>

<style scoped>
    .recommended {
        background: purple;
        margin-inline: 2vw;
        width: 50vw;
        margin: auto;
    }
    .shows {
        display: flex;
        justify-content: space-around;
    }

    h1 {
        margin-left: 2.5vw;
    }
</style>

<script>
import Show from './Show'
export default {
    name: 'Recommended',
    components: {
        Show
    }
}
</script>