<template>
    <div class="comic" @click="handleClick">
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
    color: white;
    flex-basis: 18%;
    height: clamp(430px, 26vh, 3200px);
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    text-align: center;
    background: rgb(35, 35, 34);
    margin-bottom: 1vh;
    padding: 1vh;
    border-radius: clamp(20px, 1vw, 50px);
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
    border-radius: clamp(20px, 1vw, 50px);
    border: 0.5px solid white;
}
</style>

<script>
import { useTokenStore } from '@/stores/TokenStore'
import { storeToRefs } from 'pinia'

export default {
    name: "Comic",
    props: {
        comic: {
            type: Object,
            default() {
                return {}
            }
        }
    },
    methods: {
        handleClick() {
            this.$router.push(`/comics/${this.comic.comicId}`)
        }
    },
    setup() {
        const tokenStore = useTokenStore()
        const { token } = storeToRefs(tokenStore)
        return { tokenStore, token }
    }
}
</script>