<template>
    <div class="comment">
        <div class="profile-pic"></div>
        <div class="content">
            <div class="name-container">
                <h1>{{ comment.parentUserProfile.username }}</h1>
                <div class="date">
                    <p>{{ comment.commendtedAt }}</p>
                </div>
            </div>
            <div class="bottom-part">
                <p class="description">
                    {{ comment.text }}
                </p>

                <div class="actions">
                    <div class="likes">
                        <div class="like">
                            <button>
                                <img class="star" src="../assets/like.png" alt="like">
                            </button>
                            <p>{{comment.likes}}</p>
                        </div>
                        <div class="like">
                            <button>
                                <img class="star" src="../assets/dislike.png" alt="dislike">
                            </button>
                            <p>{{comment.dislikes}}</p>
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

<style scoped>
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
    display: flex;
    justify-content: space-around;
    align-items: center;
}

.like button {
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

.profile-pic {
    height: clamp(200px, 15vw, 1400px);
    width: clamp(200px, 15vw, 1400px);
    background: white;
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
    background: var(--blue);
    width: clamp(90px, 2vw, 1000px);
    border: none;
    color: white;
    border-radius: var(--radius);
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
        height: 100px;
        width: 100px;
    }

    .date p {
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
    .interactions {
        width: 40vw;
    }
}
</style>

<script>
export default {
    name: "Comment",
    props: {
        comment: {
            type: Object,
            default() {
                return {}
            }
        }
    }
}
</script>

