<template>
    <div class="show">
        <img :src="comic.coverPageLink" alt="picture about the comic" class="pic">
        <div class="content">
            <div class="title-container">
                <h1>{{comic.title}}</h1>
                <button>Add</button>
            </div>
            <div class="info">
                <p class="type">{{comic.type}}</p>
                <p class="chapters">{{ comic.numberOfChapters }}</p>
            </div>
            <div class="stat">
                <p class="rating">{{ comic.rating }}</p>
                <p class="views">{{ comic.views }}</p>
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

.show {
    background: white;
    margin-block: 1vh;
    padding: 1vh;
}

.content {
    background: yellow;
    width: 31.5vw;
    padding-inline: 1vw;
    padding-block: 0.5vh;
}
.show, .title-container, .info, .stat {
    display: flex;
}

.title-container, .info, .stat {
    justify-content: space-between;
}

.show-pic {
    height: clamp(100px, 12vh, 700px);
    width: clamp(72px, 8.5vh, 350px);
    background: black;
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