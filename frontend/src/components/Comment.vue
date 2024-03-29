<template>
    <div class="comment">
        <img src="../assets/default-pic.jpg" class="profile-pic">
        <div class="content">
            <div class="name-container">
                <h1>{{ comment.parentUserProfile.username }}</h1>
                <div class="top-bar">
                    <div class="date-container">
                        <p>{{ comment.commendtedAt }}</p>
                    </div>
                    <div v-if="isUsersComment" class="crud-container">
                        <button @click="deleteComment">
                            <img src="../assets/delete.png" class="star" alt="delete icon">
                        </button>
                        <button @click="editComment">
                            <img src="../assets/edit.png" class="star" alt="edit icon">
                        </button>
                    </div>
                </div>
            </div>
            <div class="bottom-part">
                <p v-if="!isEditing" class="description">
                    {{ comment.text }}
                </p>
                <input v-if="isEditing" class="comment-text" id="comment-text" type="text" :placeholder="comment.text">

                <div class="actions">
                    <div class="likes">
                        <div v-if="!isUsersComment && isLoggedIn()" class="like">
                            <button @click="increaseLike(true)">
                                <img class="star" src="../assets/like.png" alt="like">
                            </button>
                            <p>{{ comment.likes }}</p>
                        </div>
                        <div v-if="!isUsersComment && isLoggedIn()" class="like">
                            <button @click="increaseLike(false)">
                                <img class="star" src="../assets/dislike.png" alt="dislike">
                            </button>
                            <p>{{ comment.dislikes }}</p>
                        </div>
                    </div>
                    <button v-if="!isEditing && isLoggedIn()" @click="reply" class="action">Reply</button>
                    <button v-if="isEditing" @click="sendEditedComment" class="action">Save</button>
                </div>
            </div>
        </div>
    </div>
    <div v-if="isReplying" class="reply">
        <textarea type="text" class="reply-input" placeholder="Reply..." cols="30" rows="10"></textarea>
        <div class="reply-btns">
            <button @click="sendReply" class="action">Send</button>
            <button @click="cancel" class="action">Cancel</button>
        </div>
    </div>
    <Replies v-model:replies="replies" />
</template>

<style scoped>
.reply {
    display: flex;
    flex-direction: column;
    width: 60%;
    min-width: 290px;
    margin-left: 5rem;
}

.reply-input {
    border-radius: 0.375rem;
    margin-bottom: 1rem;
    padding: 1rem;
}

.reply-btns {
    width: 18%;
    min-width: 190px;
    display: flex;
    justify-content: space-between;
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

.profile-pic {
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
    height: 100%;
}

.action {
    background: var(--blue);
    width: clamp(90px, 2vw, 1000px);
    height: 2rem;
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

<script>
import { useCommentStore } from '@/stores/CommentStore'
import { useUserStore } from '@/stores/UserStore'
import Replies from './Replies'
import { ref } from 'vue'

export default {
    name: "Comment",
    components: {
        Replies,
    },
    props: {
        comment: {
            type: Object,
            default() {
                return {}
            }
        }
    },
    methods: {
        deleteComment() {
            this.commentStore.deleteComment(this.comment.id, this.comment.parentComic.id);
        },
        editComment() {
            this.isEditing = true;
        },
        sendEditedComment() {
            const text = document.querySelector('#comment-text').value;
            if (text.length > 0) {
                this.commentStore.editComment(this.comment.id, text, this.comment.parentComic.id);
            }
            this.isEditing = false;
        },
        increaseLike(isLike) {
            this.commentStore.increaseLike(this.comment.parentComic.id, this.comment.id, isLike);
        },
        reply() {
            this.isReplying = true;
        },
        async sendReply() {
            this.isReplying = false;
            const message = document.querySelector('.reply-input').value;
            await this.commentStore.addReply(message, this.comment.parentComic.id, this.comment.id);
            this.replies = await this.commentStore.getReplies(this.comment.id);
        },
        cancel() {
            this.isReplying = false;
        },
        isLoggedIn() {
            return this.userStore.isLoggedIn();
        }
    },
    async setup(props) {
        const commentStore = useCommentStore()
        const userStore = useUserStore();
        const isUsersComment = ref(commentStore.isUsersComment(props.comment));
        const isEditing = ref(false);
        const isReplying =  ref(false);
        const replies = ref(await commentStore.getReplies(props.comment.id));

        return { userStore, commentStore, isUsersComment, isEditing, isReplying, replies }
    }
}
</script>

