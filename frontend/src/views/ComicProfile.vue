<template>
    <article>
        <main>
            <div class="pic-container">
                <div class="img-container">
                    <img :src="`${currentComic.coverPageBig}`" alt="Cover for the comic" class="pic">
                    <div class="btn-row">
                        <button v-if="tokenStore.isTokenExists()" class="add" @click="handleAdd('Reading')">Add to
                            Reading</button>
                        <button v-if="tokenStore.isTokenExists()" class="add" @click="handleAdd('Later')">Add to Read
                            Later</button>
                    </div>
                    <div class="btn-row">
                        <button v-if="tokenStore.isTokenExists()" class="add" @click="handleAdd('Favourites')">Add to
                            Favourites</button>
                        <button v-if="tokenStore.isTokenExists()" class="add" @click="handleAdd('Finished')">Add to
                            Finished</button>
                    </div>
                </div>
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
                        <div class="stars" v-if="tokenStore.isTokenExists()">
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
            <div style=" width: 100%;" v-if="tokenStore.isTokenExists()">
                <textarea placeholder="Join the discussion..."
                    style="width: 100%; padding: 1vw; max-width: 100%; border-radius: clamp(5px, 0.7vw, 20px)"
                    id="commentText"></textarea>
            </div>
            <div class="auth-container">
                <button class="auth" v-if="tokenStore.isTokenExists()" @click="sendComment">Send</button>
            </div>
            <Suspense>
                <div class="comment-container">
                    <Comment v-for="comment in comments" :key="comment.id" :comment="comment" />
                </div>
            </Suspense>
        </section>
        <ShortList title="Recommended" />
    </article>
</template>

<style scoped>
article,
.box span {
    color: white;
    font-size: 1vw;
}

.add {
    background: white;
    border: none;
    border-radius: var(--radius);
    cursor: pointer;
    font-size: 0.75rem;
    font-weight: 600;
    padding-block: 0.8vh;
    transition: all 0.4s;
    width: clamp(150px, 10vw, 500px);
    margin: auto;
    margin-top: 0.5rem;
}

.btn-row {
    display: flex;
    justify-content: space-between;
    flex-wrap: wrap;
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
    border-radius: var(--radius);
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
    border-radius: var(--radius);
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
    border-radius: var(--radius);
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
    background: var(--blue);
    border: none;
    border-radius: var(--radius);
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
    background: var(--dark-gray);
    color: white;
    padding-inline: 0.5vw;
    padding-block: 0.5vh;
    border: grey 1px solid;
    border-radius: var(--radius);
    margin-right: 4vw;
    margin-bottom: 1vh;
}

.stat {
    color: white;
    padding: 2vw;
    background: var(--dark-gray);
    border-radius: var(--radius);
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
    color: var(--blue);
    font-weight: 800;
}

.comment-section {
    margin-top: 3vw;
    background: black;
    padding: 2vw;
    color: white !important;
}

.auth-container {
    width: 30vw;
    display: flex;
    justify-content: space-between;
    margin-bottom: 2vh;
    align-items: center;
}

.auth {
    border: none;
    border-radius: var(--radius);
    width: 10vw;
    height: 3vh;
    background: var(--blue);
    color: white;
}

.log-in-actions {
    flex-basis: 30%;
    display: flex;
    justify-content: space-evenly;
}

.img-container {
    margin: auto;
    width: 50%;
    text-align: center;
}

@media (max-width: 950px) {
    article {
        overflow-x: hidden;
    }

    .img-container {
        margin-bottom: 3rem;
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
import ShortList from '../components/ShortList'
import { useComicStore } from '@/stores/ComicStore'
import { useUserStore } from '@/stores/UserStore'
import { useTokenStore } from '@/stores/TokenStore'
import { useCommentStore } from '@/stores/CommentStore'
import { storeToRefs } from 'pinia'

export default {
    name: 'ComicProfile',
    components: {
        Comment,
        ShortList,
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
        },
        handleAdd(target) {
            const userStore = useUserStore()
            if (target == "Reading") {
                userStore.updateReading(this.currentComic)
            }

            if (target == "Later") {
                userStore.updateLater(this.currentComic)
            }

            if (target == "Finished") {
                userStore.updateFinished(this.currentComic)
            }

            if (target == "Favourites") {
                userStore.updateFavourites(this.currentComic)
            }
        },
        sendComment() {
            const commentText = document.querySelector("#commentText").value;
            if (commentText.length > 0) {
                this.commentStore.addComment(commentText, this.id);
            }
        }
    },
    setup(props) {
        const comicStore = useComicStore()
        const tokenStore = useTokenStore()
        const commentStore = useCommentStore()

        comicStore.getComicById(props.id)
        comicStore.increaseViewCount(props.id)
        comicStore.getRecommendations(props.id)
        commentStore.getComments(props.id)

        const { currentComic } = storeToRefs(comicStore)
        const { token } = storeToRefs(tokenStore)
        const { comments } = storeToRefs(commentStore)


        return { comicStore, currentComic, tokenStore, token, commentStore, comments }
    }
}
</script>