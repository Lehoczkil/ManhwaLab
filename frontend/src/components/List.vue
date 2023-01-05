<template>
    <article class="comic-list">
        <div class="comic">
            <div class="pic"></div>
            <h1>Title</h1>
        </div>
        <div class="comic">
            <div class="pic"></div>
            <h1>Title</h1>
        </div>
        <div class="comic">
            <div class="pic"></div>
            <h1>Title</h1>
        </div>
        <div class="comic">
            <div class="pic"></div>
            <h1>Title</h1>
        </div>
        <div class="comic">
            <div class="pic"></div>
            <h1>Title</h1>
        </div>
        <div class="comic">
            <div class="pic"></div>
            <h1>Title</h1>
        </div>
        <div class="comic">
            <div class="pic"></div>
            <h1>Title</h1>
        </div>
        <div class="comic">
            <div class="pic"></div>
            <h1>Title</h1>
        </div>
        <div class="comic">
            <div class="pic"></div>
            <h1>Title</h1>
        </div>
        <div class="comic">
            <div class="pic"></div>
            <h1>Title</h1>
        </div>
        <div class="comic">
            <div class="pic"></div>
            <h1>Title</h1>
        </div>
        <div class="comic">
            <div class="pic"></div>
            <h1>Title</h1>
        </div>
        <div class="comic">
            <div class="pic"></div>
            <h1>Title</h1>
        </div>
        <div class="comic">
            <div class="pic"></div>
            <h1>Title</h1>
        </div>
        <div class="comic">
            <div class="pic"></div>
            <h1>Title</h1>
        </div>
        <div class="comic">
            <div class="pic"></div>
            <h1>Title</h1>
        </div>
        <div class="comic">
            <div class="pic"></div>
            <h1>Title</h1>
        </div>
        <div class="comic">
            <div class="pic"></div>
            <h1>Title</h1>
        </div>
        <div class="comic">
            <div class="pic"></div>
            <h1>Title</h1>
        </div>
        <div class="comic">
            <div class="pic"></div>
            <h1>Title</h1>
        </div>
    </article>
</template>

<style scoped>
.comic-list {
    display: grid;
    grid-template-columns: repeat(auto-fill, 250px);
    grid-gap: 1rem;
    justify-content: space-around;
    padding: 2vw;
    background: blue;
    margin-top: 1vh;
}

.comic {
    text-align: center;
    background: wheat;
    margin-bottom: 1vh;
}

.pic {
    width: clamp(210px, 12vw, 2100px);
    height: clamp(280px, 18vw, 2800px);
    background: black;
    margin: 1vh auto;
    border-radius: clamp(20px, 1vw, 50px);
}
</style>

<script>
export default {
    name: 'List'
}
</script>