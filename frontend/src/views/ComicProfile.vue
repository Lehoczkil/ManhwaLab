<template>
    <article>
        <main>
            <div class="pic-container">
                <img :src="`https://backend-web-service-0qh4.onrender.com${currentComic.coverPage}`" alt="" class="pic">
                <div class="content">
                    <h1>{{ currentComic.title }}</h1>
                    <div class="description">
                        <p>
                            {{ currentComic.description }}
                        </p>
                    </div>
                </div>
            </div>

            <div class="data-container">
                <div class="info">
                    <div class="row">
                        <div class="box">
                            <p>Type</p>
                            <span>{{ currentComic.type }}</span>
                        </div>

                        <div class="box">
                            <p>Chapters</p>
                            <span>{{ currentComic.numberOfChapters }}</span>
                        </div>

                        <div class="box">
                            <p>Status</p>
                            <span>{{ currentComic.status }}</span>
                        </div>
                    </div>

                    <div class="row">
                        <div class="box">
                            <p>Author</p>
                            <span>{{ currentComic.author }}</span>
                        </div>

                        <div class="box">
                            <p>Released</p>
                            <span>{{ currentComic.released }}</span>
                        </div>

                        <div class="box">
                            <p>Updated</p>
                            <span>{{ currentComic.updated }}</span>
                        </div>
                    </div>

                    <div class="tag-container">
                        <p class="tag-title">Genres</p>
                        <div class="tags">
                            <button class="tag" v-for="genre in currentComic.genreList" :key="genre.id"
                                @click="handleFilterByGenre(genre.name)">{{
                                    genre.name
                                }}</button>
                        </div>
                    </div>

                    <div class="tag-container">
                        <p class="tag-title">Themes</p>
                        <div class="tags">
                            <button class="tag" v-for="theme in currentComic.themeList" :key="theme.id"
                                @click="handleFilterByTheme(theme.name)">{{
                                    theme.name
                                }}</button>
                        </div>
                    </div>
                </div>

                <div class="stat">
                    <div class="rating">
                        <div class="stat-row">
                            <p>Rating</p>
                            <p class="data">{{ currentComic.rating }}</p>
                        </div>
                        <div class="stars">
                            <img class="star inverse" src="../assets/star.png" alt="star">
                            <img class="star inverse" src="../assets/star.png" alt="star">
                            <img class="star inverse" src="../assets/star.png" alt="star">
                            <img class="star inverse" src="../assets/star.png" alt="star">
                            <img class="star inverse" src="../assets/star.png" alt="star">
                        </div>
                    </div>
                    <div class="stat-row">
                        <p>Ranked</p>
                        <p class="data">{{ currentComic.ratingRanking }}</p>
                    </div>
                    <div class="stat-row">
                        <p>Popularity</p>
                        <p class="data">{{ currentComic.popularityRanking }}</p>
                    </div>
                    <div class="stat-row">
                        <p>Views</p>
                        <p class="data">{{ currentComic.views }}</p>
                    </div>
                    <div class="stat-row">
                        <p>Favorites</p>
                        <p class="data">{{ currentComic.favourite }}</p>
                    </div>

                </div>
            </div>
        </main>
        <section class="comment-section">
            <div style=" width: 100%;">
                <textarea placeholder="Join the discussion..."
                    style="width: 100%; padding: 1vw; max-width: 100%; border-radius: clamp(5px, 0.7vw, 20px)"></textarea>
            </div>
            <div class="auth-container">
                <button class="auth">Sign in</button>
                <button class="auth">Login</button>
            </div>
            <div class="comment-container">
                <Comment />
                <Comment />
                <Comment />
                <Comment />
            </div>
        </section>
        <Recommended />
    </article>
</template>

<style scoped>
article,
.box span {
    color: white;
    font-size: 1vw;
}

.show-pic,
.stat {
    height: clamp(400px, 60vh, 2000px);
    width: clamp(288px, 34vh, 1440px);
}

.pic {
    width: clamp(180px, 18vw, 1800px);
    height: clamp(270px, 27vw, 2700px);
    margin: 1vh auto;
    border-radius: clamp(20px, 1vw, 50px);
    border: 0.5px solid white;
}

.content,
.info {
    flex-basis: 80%;
}

.content h1 {
    text-align: center;
    font-size: clamp(30px, 3vw, 300px);
}

.description {
    border-radius: clamp(5px, 1vw, 60px);
    padding: 2vw;
    height: 36vh;
    font-size: 1rem;
}

.pic-container,
.stat {
    display: flex;
    justify-content: space-between;
    padding: 1vh;
}

.stat {
    flex-direction: column;
}

.data-container,
.row,
.box {
    display: flex;
    justify-content: space-between;
    padding-block: 1vw;
    align-items: center;
}

.info {
    border-radius: clamp(5px, 1vw, 60px);
    padding: 2vw;
    height: 60vh;
}

.data-container {
    padding-inline: 0.5vw;
}

.box {
    width: clamp(200px, 19vw, 1000px);
    height: 12vh;
    font-size: clamp(15px, 1vw, 80px);
}

.box span {
    width: 12vw;
    min-height: 9vh;
    display: flex;
    justify-content: center;
    align-items: center;
    text-align: center;
    background: red;
    border: none;
    border-radius: clamp(3px, 1vh, 15px);
}

.tag-container {
    width: 70vw;
    margin-block: 3vh;
}

.tags {
    display: flex;
    flex-wrap: wrap;
    margin-top: 2vh;
}

.tag {
    width: clamp(140px, 12vw, 600px);
    height: 4vh;
    background: rgb(35, 35, 34);
    color: white;
    padding-inline: 0.5vw;
    padding-block: 0.5vh;
    border: grey 1px solid;
    border-radius: clamp(2px, 0.5vh, 15px);
    margin-right: 4vw;
    margin-bottom: 1vh;
}

.stat {
    color: white;
    padding: 2vw;
    background: rgb(35, 35, 34);
    border-radius: 1.5vh;
}

.stars {
    width: 8vw;
    display: flex;
    justify-content: space-between;
}

.star {
    height: 2vh;
}

.inverse {
    filter: invert(100%);
}

.stat-row {
    display: flex;
    justify-content: space-between;
}

.data {
    color: red;
    font-weight: 800;
}

.comment-section {
    background: black;
    padding: 2vw;
    color: white !important;
}

.auth-container{
    width: 30vw;
    display: flex;
    justify-content: space-between;
    margin-bottom: 2vh;
    align-items: center;
}

.auth {
    border: none;
    border-radius: clamp(2px, 0.5vh, 15px);
    width: 10vw;
    height: 3vh;
    background: red;
    color: white;
}

.log-in-actions {
    flex-basis: 30%;
    display: flex;
    justify-content: space-evenly;
}

@media (max-width: 950px) {
    article {
        overflow-x: hidden;
    }

    .pic-container,
    .data-container,
    .row {
        flex-direction: column;
        justify-content: center;
    }

    .description {
        max-height: 250px;
        margin-block: 1vh;
        overflow-y: scroll;
    }

    .row,
    .box {
        width: 80vw;
    }

    .box span {
        width: 40vw;
        font-size: 1rem;
    }

    .tag-container {
        font-size: 1rem;
    }

    .tags {
        justify-content: space-between;
        width: 84vw;
    }

    .tag {
        width: 33vw;
    }

    .stat {
        width: 80vw;
        padding: 5vw;
        font-size: 1.2rem;
        margin-bottom: 3vh;
    }

    .stars {
        width: 100%;
        margin-top: 3vh;
    }

    .star {
        width: 30px;
        height: auto;
    }

    .comment-section {
        width: 84vw;
        margin: auto;
    }

    .auth-container {
        width: 80vw;
        margin-top: 2vh;
        margin-bottom: 7vh;
    }

    .auth {
        font-size: 1rem;
        width: 30vw;
        height: 35px;
    }

}
</style>

<script>
import Comment from '../components/Comment'
import Recommended from '../components/Recommended'
import { useComicStore } from '@/stores/ComicStore'
import { storeToRefs } from 'pinia'

export default {
    name: 'ComicProfile',
    components: {
        Comment,
        Recommended
    },
    props: {
        id: String
    },
    methods: {
        handleFilterByGenre(genre) {
            this.comicStore.filterComics(genre, null, null, null, null)
            this.$router.push(`/comics`)
        },
        handleFilterByTheme(theme) {
            this.comicStore.filterComics(null, theme, null, null)
            this.$router.push(`/comics`)
        }
    },
    setup(props) {
        const comicStore = useComicStore()

        comicStore.getComicById(props.id)
        comicStore.increaseViewCount(props.id)

        const { currentComic } = storeToRefs(comicStore)

        return { comicStore, currentComic }
    }
}
</script>