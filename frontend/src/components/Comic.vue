<template>
    <div class="comic">
        <img :src="comic.coverPageLink" alt="picture about the comic" class="pic">
        <h1 @click="handleClick">{{ comic.title }}</h1>
        <p>{{ comic.numberOfChapters }} chapters</p>
        <div class="rating">
            <img class="star" src="../assets/star.png" alt="star">
            <img class="star" src="../assets/star.png" alt="star">
            <img class="star" src="../assets/star.png" alt="star">
            <img class="star" src="../assets/star.png" alt="star">
            <img class="star" src="../assets/star.png" alt="star">
            <span>{{ comic.rating }}</span>
        </div>
    </div>
</template>


<style scoped>
.comic {
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
    }
}
</script>