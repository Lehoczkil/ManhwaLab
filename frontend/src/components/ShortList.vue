<template>
    <section class="short-list">
        <h1>{{ title }}</h1>
        <div class="comics" v-if="this.title === 'Reading'">
            <Comic v-for="comic in read" :key="comic.comicId" :comic="comic" :fromShortList="true" :category="title" />
        </div>
        <div class="comics" v-if="this.title === 'Read Later'">
            <Comic v-for="comic in readLater" :key="comic.comicId" :comic="comic" :fromShortList="true" :category="title" />
        </div>
        <div class="comics" v-if="this.title === 'Finished'">
            <Comic v-for="comic in finished" :key="comic.comicId" :comic="comic" :fromShortList="true" :category="title" />
        </div>
        <div class="comics" v-if="this.title === 'Favourites'">
            <Comic v-for="comic in favourites" :key="comic.comicId" :comic="comic" :fromShortList="true"
                :category="title" />
        </div>
        <div class="comics" v-if="this.title === 'Recommended'">
            <Comic v-for="comic in recommendations" :key="comic.comicId" :comic="comic" :isRecommended="true" :fromShortList="false"
                :category="title" />
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

@media (min-width: 1921px) {
    .comic, .short-list {
        min-height: 600px;
    }
}
</style>

<script>
import Comic from './Comic'
import { storeToRefs } from 'pinia';
import { useUserStore } from '@/stores/UserStore';
import { useComicStore } from '@/stores/ComicStore';

export default {
    name: 'ShortList',
    components: {
        Comic
    },
    props: {
        title: String
    },
    setup() {
        const userStore = useUserStore()
        const comicStore = useComicStore()

        const { read, readLater, finished, favourites } = storeToRefs(userStore)
        const { recommendations } = storeToRefs(comicStore)

        return { read, readLater, finished, favourites, userStore, comicStore, recommendations }
    }
}
</script>