<template>
    <div class="comic">
        <img :src="comic.coverPageLink" alt="picture about the comic" class="pic">
        <div class="content">
            <h1>{{ comic.title }}</h1>
            <div class="info">
                <p class="type">Type: {{ comic.type }}</p>
                <p class="chapters">{{ comic.numberOfChapters }} chapters</p>
            </div>
            <div class="stat">
                <p class="rating">Rating: {{ comic.rating }}</p>
                <p class="views">Views: {{ comic.views }}</p>
            </div>
            <div class="description">
                <p>{{ comic.description }}</p>
            </div>
        </div>
    </div>
</template>

<style scoped>
.pic {
    width: clamp(133px, 8vw, 1330px);
    height: clamp(200px, 12vw, 2000px);
    margin: 1vh auto;
    border-radius: clamp(20px, 1vw, 50px);
    border: 0.5px solid white;
}

h1 {
    text-align: center;
    font-size: clamp(20px, 1vw, 100px);
    margin-bottom: 2vh;
}

.description {
    margin-top: 3vh;
    height: 20vh;
    overflow-y: scroll;
    overflow-x: hidden;
    padding: 0.5vh;
}

.comic {
    margin-block: 1vh;
    padding: 1.5vh;
    height: clamp(330px, 21vh, 1000px);
    align-items: center;
}

.content {
    width: 31.5vw;
    padding-inline: 1vw;
    padding-block: 0.5vh;
}

.comic,
.title-container,
.info,
.stat {
    display: flex;
}

.info,
.stat {
    justify-content: space-between;
}

.show-pic {
    height: clamp(100px, 12vh, 700px);
    width: clamp(72px, 8.5vh, 350px);
    background: black;
}

::-webkit-scrollbar {
  width: 14px;
}
</style>

<script>
export default {
    name: 'TopComic',
    props: {
        comic: Object
    }
}
</script>