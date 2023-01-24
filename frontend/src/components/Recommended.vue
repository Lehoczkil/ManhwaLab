<template>
    <section class="recommended">
        <h1>More like this</h1>
        <div class="comics">
            <comic />
            <comic />
            <comic />
            <comic />
            <comic />
        </div>
    </section>
</template>

<style scoped>
    .recommended {
        background: purple;
        margin-inline: 2vw;
        width: 50vw;
        margin:2vh auto;
    }
    .comics {
        display: flex;
        justify-content: space-around;
    }

    h1 {
        margin-left: 2.5vw;
    }
</style>

<script>
import Comic from './Comic'
export default {
    name: 'Recommended',
    components: {
        Comic
    }
}
</script>