<template>
    <section class="short-list">
        <h1>{{ title }}</h1>
        <div class="comics">
            <Comic v-for="comic in comics" :key="comic.comicId" :comic="comic" :fromShortList="true" />
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
import { useUserStore } from '@/stores/UserStore';

export default {
    name: 'ShortList',
    components: {
        Comic
    },
    props: {
        title: String
    },
    setup(props) {
        const userStore = useUserStore()

        let comics = [];
        switch (props.title) {
            case 'Reading':
                comics = userStore.read
                break
            case 'Read Later':
                comics = userStore.readLater
                break
            case 'Finished':
                comics = userStore.finished
                break
            case 'Favourites':
                comics = userStore.favourites
                break
        }

        return { comics }
    }
}
</script>