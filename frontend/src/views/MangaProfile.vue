<template>
    <article>
        <main>
            <div class="pic-container">
                <div class="show-pic"></div>
                <div class="content">
                    <h1>Title</h1>
                    <div class="description">
                        <p>
                            Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has
                            been the industry's standard dummy text ever since the 1500s, when an unknown printer took a
                            galley of type and scrambled it to make a type specimen book. It has survived not only five
                            centuries, but also the leap into electronic typesetting, remaining essentially unchanged.
                            It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum
                            passages, and more recently with desktop publishing software like Aldus PageMaker including
                            versions of Lorem Ipsum.
                        </p>
                    </div>
                </div>
            </div>

            <div class="data-container">
                <div class="info">
                    <div class="row">
                        <div class="box">
                            <p>Type</p>
                            <button>Manga</button>
                        </div>

                        <div class="box">
                            <p>Chapters</p>
                            <button>124</button>
                        </div>

                        <div class="box">
                            <p>Status</p>
                            <button>Ongoing</button>
                        </div>
                    </div>

                    <div class="row">
                        <div class="box">
                            <p>Author</p>
                            <button>Me</button>
                        </div>

                        <div class="box">
                            <p>Released</p>
                            <button>2020.10.27.</button>
                        </div>

                        <div class="box">
                            <p>Updated</p>
                            <button>2022.12.15.</button>
                        </div>
                    </div>

                    <div class="tag-container">
                        <p>Genres</p>
                        <div class="tags">
                            <button class="tag">Genre</button>
                            <button class="tag">Genre</button>
                            <button class="tag">Genre</button>
                            <button class="tag">Genre</button>
                            <button class="tag">Genre</button>
                        </div>
                    </div>

                    <div class="tag-container">
                        <p>Genres</p>
                        <div class="tags">
                            <button class="tag">Genre</button>
                            <button class="tag">Genre</button>
                            <button class="tag">Genre</button>
                            <button class="tag">Genre</button>
                            <button class="tag">Genre</button>
                        </div>
                    </div>
                </div>

                <div class="stat">
                    <div class="rating">
                        <div class="stat-row">
                            <p>Rating</p>
                            <p class="data">10.0</p>
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
                        <p class="data">#1</p>
                    </div>
                    <div class="stat-row">
                        <p>Popularity</p>
                        <p class="data">#1</p>
                    </div>
                    <div class="stat-row">
                        <p>Views</p>
                        <p class="data">382,764</p>
                    </div>
                    <div class="stat-row">
                        <p>Favorites</p>
                        <p class="data">3562</p>
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
            <div class="name-container">
                <div class="log-in-actions">
                    <img class="star inverse" src="../assets/star.png" alt="star">
                    <img class="star inverse" src="../assets/star.png" alt="star">
                    <img class="star inverse" src="../assets/star.png" alt="star">
                </div>
                <input type="text" class="name" placeholder="Name...">
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
.show-pic,
.stat {
    height: clamp(400px, 48vh, 2000px);
    width: clamp(288px, 34vh, 1440px);
    background: black;
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
    background: red;
    border-radius: clamp(5px, 1vw, 60px);
    padding: 2vw;
    height: 36vh
}

.pic-container,
.stat {
    display: flex;
    justify-content: space-between;
    background: green;
    padding: 1vh;
}

.stat {
    flex-direction: column;
    background: black;
}

.data-container,
.row,
.box {
    display: flex;
    justify-content: space-between;
    padding-block: 1vw;
}

.info {
    background: lightblue;
    border-radius: clamp(5px, 1vw, 60px);
    padding: 2vw;
    height: 48vh;
}

.data-container {
    background: purple;
    padding-inline: 0.5vw;
}

.box {
    width: clamp(200px, 15vw, 700px);
    font-size: clamp(15px, 1vw, 80px);
}

.box button {
    width: 8vw;
    background: red;
    border: none;
    border-radius: clamp(2px, 0.5vh, 15px);
}

.tag-container {
    width: 70vw;
}

.tags {
    display: flex;
    flex-wrap: wrap;
}

.tag {
    width: clamp(140px, 10vw, 600px);
    background: white;
    padding-inline: 0.5vw;
    padding-block: 0.5vh;
    border: none;
    border-radius: clamp(2px, 0.5vh, 15px);
    margin-right: 2vw;
    margin-bottom: 1vh;
}

.stat {
    color: white;
    padding: 1vw;
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
}

.comment-section {
    background: black;
    padding: 2vw;
    color: white !important;
}

.auth-container,
.name-container {
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

.name {
    flex-basis: 70%;
    padding: 0.5vw 1vw;
    max-width: 100%;
    border-radius: clamp(5px, 0.7vw, 20px);
}

.log-in-actions {
    flex-basis: 30%;
    display: flex;
    justify-content: space-evenly;
}

.comment-container {
    background: green;
}
</style>

<script>
import Comment from '../components/Comment'
import Recommended from '../components/Recommended'
export default {
    name: 'MangaProfile',
    components: {
        Comment,
        Recommended
    }
}
</script>