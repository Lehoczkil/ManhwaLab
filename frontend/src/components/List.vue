<template>
    <article class="comic-list">
        <div class="loading" v-if="loading">Loading comics...</div>

        <div class="comics" v-for="comic in comics" :key="comic.id">
            <div class="comic" @click="handleClick(comic.id)">
                <img :src="`https://second-backend-web-service.onrender.com${comic.coverPage}`" alt="Cover page of the manhwa" class="pic">
                <h1>{{ comic.title }}</h1>
            </div>
        </div>
    </article>
</template>

<style scoped>
.comic-list {
    display: grid;
    grid-template-columns: repeat(auto-fill, 250px);
    grid-gap: 1rem;
    justify-content: space-around;
    padding: 2vw;
    margin-top: 1vh;
}

.comic {
    text-align: center;
    background: rgb(35, 35, 34);
    margin-bottom: 1vh;
    height: clamp(430px, 25vw, 3400px);
    padding: 0.5vh;
    color: white;
    border-radius: clamp(20px, 1vw, 50px);
}

.pic {
    width: clamp(210px, 12vw, 2100px);
    height: clamp(280px, 16vw, 2800px);
    margin: 1vh auto;
    border-radius: clamp(20px, 1vw, 50px);
    border: 0.5px solid white;
}
</style>

<script>
import { useComicStore } from '../stores/ComicStore';
import { storeToRefs } from 'pinia'

export default {
    name: 'List',
    methods: {
        handleClick(comicId) {
            this.$router.push(`/comics/${comicId}`)
        }
    },
    setup() {
        const comicStore = useComicStore()

        const { comics, loading } = storeToRefs(comicStore)
        if (!comicStore.haveComics()) {
            comicStore.getComics()
        }

        return { comicStore, comics, loading }
    }
}
</script>