<template>
    <div class="show">
        <div class="show-pic"></div>
        <div class="content">
            <div class="title-container">
                <h1>Title</h1>
                <button>Add</button>
            </div>
            <div class="info">
                <p class="type">Manhwa</p>
                <p class="chapters">112 ch</p>
            </div>
            <div class="stat">
                <p class="rating">9.5</p>
                <p class="views">342,896</p>
            </div>
        </div>
    </div>
</template>

<style scoped>

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
    name: 'TopComic'
}
</script>