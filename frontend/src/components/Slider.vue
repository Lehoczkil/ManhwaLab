<template>
    <section>
        <h1 class="title">{{ title }}</h1>
        <div class="comic-container">
            <Comic v-for="comic in comics" :key="comic.comicId" :comic="comic" />
        </div>
    </section>
</template>

<style scoped>
.comic-container {
    min-height: 420px;
    display: grid;
    grid-template-columns: repeat(auto-fill, 200px);
    grid-gap: 1rem;
    justify-content: space-between;
    margin-top: 1vh;
}

@media (max-width:950px) {
    .title {
        text-align: center;
        font-size: 2rem;
        margin-block: 3vh;
    }
}

@media (min-width: 1921px) {
    .comic-container {
        grid-template-columns: repeat(auto-fill, 300px);
        min-height: 500px;
    }
}

</style>

<script>
import Comic from './Comic'

export default {
    name: 'Slider',
    components: {
        Comic
    },
    props: {
        comics: Array,
        title: String
    }
}
</script>



