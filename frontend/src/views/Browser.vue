<template>
    <article>
        {{ types }}
        <section class="controls">
            <div class="row">
                <Select title="Genre" :data="genres" />
                <Select title="Theme" :data="themes" />
            </div>
            <div class="row">
                <Select title="Type" :data="types" />
                <Select title="Sort by" />
            </div>
            <div class="search">
                <input type="search" placeholder="Search..." id="search-phrase">
                <button type="submit" @click="handleClick">Go</button>
            </div>
        </section>
        <List />
    </article>
</template>

<style scoped>
.row {
    display: flex;
    width: 60%;
    margin-inline: auto;
    justify-content: space-between;
}

.controls {
    min-height: 35vh;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-around;
}

.search {
    width: 60vw;
    display: flex;
    align-items: center;
}

.search input {
    width: clamp(150px, 50vw, 1200px);
    height: clamp(30px, 6vh, 200px);
    background: var(--dark-gray);
    color: white;
    padding-inline: 1vw;
    padding-block: 0.5vh;
    border: none;
    border-radius: var(--radius) 0 0 var(--radius);
    transition: all 0.3s;
}

.search input:hover,
.search input:focus {
    border-right: none;
    background: white;
    color: #2d2f31;
}

.search input:focus {
    border-right: none;
    outline: none;
}

.search button {
    height: clamp(30px, 6vh, 200px);
    width: 10vw;
    border: none;
    border-radius: 0 var(--radius) var(--radius) 0;
    padding-inline: 1.5vw;
    padding-block: 0.5vh;
    transition: all 0.3s;
    background: var(--dark-gray);
    color: white
}

.search button:hover {
    background: var(--blue);
    color: white;
}

@media(max-width:1150px) {

    .search {
        flex-direction: column;
    }

    .row {
        display: block;
        width: 60vw;
        text-align: center;
    }

    .controls {
        margin-bottom: 5vh;
    }

    .search input,
    .search button {
        display: block;
        width: 60vw;
        border-radius: var(--radius);
        margin-bottom: 2vh;
    }

    .search button {
        font-size: 1.2rem;
    }
}
</style>

<script>
import Select from '../components/Select'
import { useGenreStore } from '@/stores/GenreStore'
import { useComicStore } from '@/stores/ComicStore'
import { useThemeStore } from '@/stores/ThemeStore'
import { useTypeStore } from '@/stores/TypeStore'
import List from '../components/List'
import { storeToRefs } from 'pinia'
export default {
    name: 'Browser',
    components: {
        Select,
        List
    },
    methods: {
        handleClick() {
            const comicStore = useComicStore();

            if (document.querySelector('#Genre') && document.querySelector('#Type') && document.querySelector('#Theme')) {
                const genre = document.querySelector('#Genre').value
                const theme = document.querySelector('#Theme').value
                const type = document.querySelector('#Type').value
                const sort = document.querySelector('#sort').value
                const search = document.querySelector('#search-phrase').value
                comicStore.filterComics(genre, theme, type, sort, search)
            }
        }
    },
    setup() {
        const genreStore = useGenreStore()
        genreStore.getGenres()
        const { genres } = storeToRefs(genreStore)

        const themeStore = useThemeStore()
        themeStore.getThemes()
        const { themes } = storeToRefs(themeStore)

        const typeStore = useTypeStore()
        typeStore.getTypes()
        const { types } = storeToRefs(typeStore)

        return { genreStore, genres, themeStore, themes, typeStore, types }
    }
}
</script>