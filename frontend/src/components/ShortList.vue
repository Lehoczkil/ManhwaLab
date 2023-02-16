<template>
    <section class="short-list">
        <h1>{{ title }}</h1>
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
.short-list {
    margin-inline: 2vw;
    margin: 5vh auto;
    color: white;
}

.comics {
    display: grid;
    grid-template-columns: repeat(auto-fill, 300px);
    grid-gap: 2rem;
    justify-content: space-around;
    width: 100%;
}

h1 {
    padding-left: 2rem;
    padding-block: 1rem;
    font-size: 1.5rem;
}

@media (max-width: 950px) {
    .short-list {
        text-align: center;
        margin-inline: auto;
        margin-top: 8rem;
    }

    h1 {
        padding-left: 0;
        margin-bottom: 1rem;
    }
}

</style>

<script>
import Comic from './Comic'
export default {
    name: 'ShortList',
    components: {
        Comic
    },
    props: {
        title: String
    }
}
</script>