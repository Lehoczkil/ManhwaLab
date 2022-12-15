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
                            <p>10.0</p>
                        </div>
                        <div class="stars">
                            <img class="star" src="../assets/star.png" alt="star">
                            <img class="star" src="../assets/star.png" alt="star">
                            <img class="star" src="../assets/star.png" alt="star">
                            <img class="star" src="../assets/star.png" alt="star">
                            <img class="star" src="../assets/star.png" alt="star">
                        </div>
                        <div class="stat-row">
                            <p>Ranked</p>
                            <p>#1</p>
                        </div>
                        <div class="stat-row">
                            <p>Popularity</p>
                            <p>#1</p>
                        </div>
                        <div class="stat-row">
                            <p>Views</p>
                            <p>382,764</p>
                        </div>
                        <div class="stat-row">
                            <p>Favorites</p>
                            <p>3562</p>
                        </div>
                    </div>

                </div>
            </div>
        </main>
        <section class="comment-section">
            <textarea cols="30" rows="10"></textarea>
            <div class="buttons">
                <button class="auth">Sign in</button>
                <button class="auth">Login</button>
            </div>
            <div class="name-continer">
                <img class="star" src="../assets/star.png" alt="star">
                <img class="star" src="../assets/star.png" alt="star">
                <img class="star" src="../assets/star.png" alt="star">
                <input type="text" class="name">
            </div>
            <div class="comment-container">
                <Comment />
                <Comment />
                <Comment />
                <Comment />
            </div>
        </section>
        <section class="recommendations"></section>
    </article>
</template>

<script>
import Comment from '../components/Comment'
export default {
    name: 'MangaProfile',
    components: {
        Comment
    }
}
</script>