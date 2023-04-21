<template>
    <div class="replies">
        <div v-for="reply in replies" :key="reply.id" class="reply">
            <img src="../assets/default-pic.jpg" class="profile-pic">
            <div class="content">
                <div class="name-container">
                    <h1>{{ reply.parentUserProfile.username }}</h1>
                    <div class="top-bar">
                        <div class="date-container">
                            <p>{{ reply.commendtedAt }}</p>
                        </div>
                        <div class="crud-container">
                            <button>
                                <img src="../assets/delete.png" class="star" alt="delete icon">
                            </button>
                            <button>
                                <img src="../assets/edit.png" class="star" alt="edit icon">
                            </button>
                        </div>
                    </div>
                </div>
                <div class="bottom-part">
                    <p class="description">
                        {{ reply.text }}
                    </p>
                    <div class="actions">
                        <div class="likes">
                            <div class="like">
                                <button>
                                    <img class="star" src="../assets/like.png" alt="like">
                                </button>
                                <p>{{ reply.likes }}</p>
                            </div>
                            <div class="like">
                                <button>
                                    <img class="star" src="../assets/dislike.png" alt="dislike">
                                </button>
                                <p>{{ reply.dislikes }}</p>
                            </div>
                        </div>
                        <button class="action">Save</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "Replies",
    props: {
        replies: {
            type: Array,
            default() {
                return [];
            }
        }
    }
}
</script>

<style scoped>

.replies {
    padding-left: 5vw;
}

.reply {
    display: flex;
    padding: 1rem;
}

.profile-pic {
    min-width: 130px;
    width: 10vw;
}
.name-container {
    display: flex;
    justify-content: space-between;
    margin-bottom: 1vh;
}

.top-bar,
.crud-container {
    width: 20%;
    justify-content: space-between;
    display: flex;
}

.crud-container,
.date-container {
    width: 50%;
}

.description {
    text-align: justify;
    padding-bottom: 3vh;
}

.actions,
.likes,
.like {
    display: flex;
    justify-content: space-between;
}


.like {
    width: clamp(50px, 4vw, 250px);
    display: flex;
    justify-content: space-around;
    align-items: center;
}

.like button,
.crud-container button {
    background: transparent;
    border: none;
}

.star {
    height: 2vh;
    filter: invert();
}

.comment {
    margin-bottom: 2vh;
    display: flex;
    padding: 1vw;
}

.content {
    width: 50vw;
    padding-left: 5vw;
    display: flex;
    flex-direction: column;
}

.bottom-part {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    height: 100%;
}

.action {
    background: var(--blue);
    width: clamp(67.5px, 1.5vw, 675px);
    height: 1.5rem;
    border: none;
    color: white;
    border-radius: var(--radius);
}

.comment-text {
    width: clamp(100px, 10vw, 200px);
    background: var(--dark-gray);
    padding-left: 1rem;
    color: white;
    border: none;
    height: 2rem;
}

@media(max-width: 950px) {
    .comment {
        flex-direction: column;
        justify-content: center;
        width: 84vw;
        margin: 7vh auto;
        font-size: 1rem;
    }

    .profile-pic {
        margin-inline: auto;
        margin-bottom: 2vh;
        width: 100px;
    }

    .crud-container p {
        font-weight: 600;
    }

    .likes {
        width: 28vw;
        justify-content: space-between;
    }

    .action {
        width: 15vw;
        font-size: 1rem;
    }
}
</style>