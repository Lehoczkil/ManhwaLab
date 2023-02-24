<template>
    <div class="comic" @click="handleClick">
        <button v-if="fromShortList" class="remove" @click.stop="handleRemove">-</button>
        <img :src="`${comic.coverPageSmall}`" alt="picture about the comic" class="pic">
        <h1>{{ comic.title }}</h1>
        <p>{{ comic.numberOfChapters }} chapters</p>
        <div class="rating">
            <div class="stars" v-if="tokenStore.isTokenExists()">
                <img class="star" src="../assets/star.png" alt="star">
                <img class="star" src="../assets/star.png" alt="star">
                <img class="star" src="../assets/star.png" alt="star">
                <img class="star" src="../assets/star.png" alt="star">
                <img class="star" src="../assets/star.png" alt="star">
            </div>
            <p v-if="!tokenStore.isTokenExists()">Rating:</p>
            <span>{{ comic.rating }}</span>
        </div>
    </div>
</template>


<style scoped>
.rating {
    display: flex;
    justify-content: center;
}

.comic {
    position: relative;
    color: white;
    flex-basis: 18%;
    height: clamp(430px, 26vh, 3200px);
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    text-align: center;
    background: var(--dark-gray);
    margin-bottom: 1vh;
    padding: 1vh;
    border-radius: var(--radius);
}

span {
    margin-left: 1vw;
}

.star {
    height: 2vh;
    filter: invert();
}

.pic {
    width: clamp(133px, 8vw, 1330px);
    height: clamp(200px, 12vw, 2000px);
    margin: 1vh auto;
    border-radius: var(--radius);
    border: 0.5px solid white;
}

.remove {
    position: absolute;
    right: 0;
    top: 0;
    width: 3rem;
    height: 2rem;
    color: white;
    background: transparent;
    border: none;
    font-size: 3rem;
    display: flex;
    align-items: center;
    justify-content: center;
}

.remove:hover,
.remove:focus {
    color: var(--blue);
}
</style>

<script>
import { useTokenStore } from '@/stores/TokenStore'
import { useUserStore } from '@/stores/UserStore'
import { storeToRefs } from 'pinia'
import { getCurrentInstance } from 'vue';

export default {
    name: "Comic",
    props: {
        comic: {
            type: Object,
            default() {
                return {}
            }
        },
        fromShortList: {
            type: Boolean,
            default() {
                return false
            }
        },
        category: {
            type: String,
            default() {
                return ''
            }
        }
    },
    methods: {
        handleClick() {
            if (this.fromShortList) {
                this.$router.push(`/comics/${this.comic.id}`)
            } else {
                this.$router.push(`/comics/${this.comic.comicId}`)
            }
        },
        handleRemove() {
            if (this.category !== '') {
                switch (this.category) {
                    case 'Reading':
                        this.userStore.removeFromReading(this.comic)
                        break
                    case 'Read Later':
                        this.userStore.removeFromReadLater(this.comic)
                        break
                    case 'Finished':
                        this.userStore.removeFromFinished(this.comic)
                        break
                    case 'Favourites':
                        this.userStore.removeFromFavourites(this.comic)
                        break
                }
                const instance = getCurrentInstance();
                instance.proxy.$forceUpdate();
            }
        }
    },
    setup() {
        const tokenStore = useTokenStore()
        const userStore = useUserStore()

        const { token } = storeToRefs(tokenStore)

        return { userStore, tokenStore, token }
    }
}
</script>