<template>
    <div class="show">
        <div>
            <img :src="comic.coverPageLink" alt="picture about the comic" class="pic">
        </div>
        <h1>{{ comic.title }}</h1>
        <p></p>
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
.star {
    height: 2vh;
}

.pic {
    width: clamp(133px, 8vw, 1330px);
    height: clamp(200px, 12vw, 2000px);
    margin: 1vh auto;
    border-radius: clamp(20px, 1vw, 50px);
    border: 0.5px solid white;
}

.show-pic {
    height: clamp(100px, 12.5vh, 700px);
    width: clamp(72px, 9vh, 350px);
    background: black;
}
</style>

<script>

export default {
    name: "Show",
    props: {
        comic: Object,
    },
}
</script>