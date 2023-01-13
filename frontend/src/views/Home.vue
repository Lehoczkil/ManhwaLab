<template>
    <article>
        <main>
            <Slider :comics="dailyTop" />
            <Slider :comics="weeklyTop" />
            <Slider :comics="monthlyTop" />
        </main>
        <aside>
            <TopList :comics="topOngoing" />
            <TopList :comics="mostViewed" />
        </aside>
    </article>
</template>

<style scoped>
article {
    display: flex;
}

main,
aside {
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
import { useComicStore } from '@/stores/ComicStore'
import { storeToRefs } from 'pinia'

export default {
    name: 'Home',
    components: {
        Slider,
        TopList
    },
    setup() {
        const comicStore = useComicStore()
        
        comicStore.getTopComics()
        comicStore.getMostViewed()
        comicStore.getTopOngoing()

        const { dailyTop, weeklyTop, monthlyTop, topOngoing, mostViewed } = storeToRefs(comicStore)
        return { comicStore, dailyTop, weeklyTop, monthlyTop, topOngoing, mostViewed }
    }
}
</script>