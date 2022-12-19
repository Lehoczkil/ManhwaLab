<template>
    <div class="comment">
        <div class="profile-pic"></div>
        <div class="content">
            <div class="name-container">
                <h1>Name</h1>
                <div class="date">
                    <p>6 months ago</p>
                </div>
            </div>
            <div class="bottom-part">
                <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla vehicula suscipit
                    mauris, sit amet
                    vehicula est porttitor eu. Donec vitae consequat sapien. Maecenas tempus ante sit amet magna
                    faucibus aliquam. Nullam congue, turpis ut maximus rhoncus, nisl leo placerat neque, nec vulputate
                    odio felis et orci. Vestibulum molestie, lorem et maximus dictum, nunc odio convallis metus, eu
                    molestie nulla libero in felis. Integer consectetur bibendum purus id tempus.
                </p>

                <div class="actions">
                    <div class="likes">
                        <div class="like">
                            <button>
                                <img class="star" src="../assets/star.png" alt="star">
                            </button>
                            <p>293</p>
                        </div>
                        <div class="like">
                            <button>
                                <img class="star" src="../assets/star.png" alt="star">
                            </button>
                            <p>293</p>
                        </div>
                    </div>
                    <div class="interactions">
                        <button class="action">Reply</button>
                        <button class="action">Share</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<style>
.name-container {
    display: flex;
    justify-content: space-between;
    margin-bottom: 1vh;
}

.description {
    text-align: justify;
    padding-bottom: 3vh;
}

.actions,
.interactions,
.likes,
.like {
    display: flex;
    justify-content: space-between;
}

.likes,
.interactions {
    width: clamp(200px, 12vw, 1000px);
}

.like {
    width: clamp(50px, 4vw, 250px);
}

.like button {
    background: transparent;
    border: none;
}

.star {
    height: 2vh;
}

.comment {
    background: blue;
    margin-bottom: 2vh;
    display: flex;
    padding: 1vw;
}

.profile-pic {
    height: clamp(200px, 15vw, 1400px);
    width: clamp(200px, 15vw, 1400px);
    background: black;
}

.content {
    width: 80vw;
    padding-left: 5vw;
    display: flex;
    flex-direction: column;
    min-height: 20vh;
}

.bottom-part {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    height:100%;
}

.action {
    background: red;
    width: clamp(90px, 2vw, 1000px);
    border: none;
    border-radius: clamp(2px, 0.5vw, 20px);
}
</style>

<script>
export default {
    name: "Comment"
}
</script>

