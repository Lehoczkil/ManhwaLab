<template>
    <article>
        <main>
            <Slider :comics="dailyTop" title="Popular Today" />
            <Slider :comics="weeklyTop" title="Popular This Week" />
            <Slider :comics="monthlyTop" title="Popular This Month" />
        </main>
        <aside>
            <TopList :comics="topOngoing" title="Top Rated Ongoing" />
            <TopList :comics="mostViewed" title="Most Viewed" />
        </aside>
    </article>
</template>

<style scoped>
article {
    display: flex;
    color: white;
}

main,
aside {
    min-height: 85vh;
    padding: 2vh;
}

main {
    flex-basis: 65%;
}

aside {
    flex-basis: 35%;
    max-height: 165vh;
    overflow-y: scroll;
}

::-webkit-scrollbar {
  width: 18px;
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