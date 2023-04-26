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
                        <div v-if="isUsersComment(reply)" class="crud-container">
                            <button @click="deleteReply(reply)">
                                <img src="../assets/delete.png" class="star" alt="delete icon">
                            </button>
                            <button @click="editReply(reply)">
                                <img src="../assets/edit.png" class="star" alt="edit icon">
                            </button>
                        </div>
                    </div>
                </div>
                <div class="bottom-part">
                    <p v-if="!isEditing" class="description">
                        {{ reply.text }}
                    </p>
                    <input v-if="isEditing && editedComment === reply.id" class="reply-text" id="reply-text" type="text"
                        :placeholder="reply.text">
                    <div class="actions">
                        <div class="likes">
                            <div v-if="!isUsersComment(reply) && isLoggedIn()" class="like">
                                <button @click="increaseLike(reply, true)">
                                    <img class="star" src="../assets/like.png" alt="like">
                                </button>
                                <p>{{ reply.likes }}</p>
                            </div>
                            <div v-if="!isUsersComment(reply) && isLoggedIn()" class="like">
                                <button @click="increaseLike(reply, false)">
                                    <img class="star" src="../assets/dislike.png" alt="dislike">
                                </button>
                                <p>{{ reply.dislikes }}</p>
                            </div>
                        </div>
                        <button @click="sendEditedReply(reply)" v-if="isEditing && editedComment === reply.id"
                            class="action">Save</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import { useCommentStore } from '@/stores/CommentStore';
import { useUserStore } from '@/stores/UserStore';
import { ref } from 'vue';

export default {
    name: "Replies",
    props: {
        replies: {
            type: Array,
            default() {
                return [];
            }
        }
    },
    emits: [
        'update:replies',
    ],
    methods: {
        async deleteReply(reply) {
            await this.commentStore.deleteComment(reply.id, reply.parentComic.id);
            const newReplies = await this.commentStore.getReplies(reply.parentCommentId);
            this.$emit('update:replies', newReplies);
        },
        editReply(reply) {
            this.isEditing = true;
            this.editedComment = reply.id;
        },
        async sendEditedReply(reply) {
            const text = document.querySelector('#reply-text').value;
            if (text.length > 0) {
                await this.commentStore.editComment(reply.id, text, reply.parentComic.id);
                const newReplies = await this.commentStore.getReplies(reply.parentCommentId);
                this.$emit('update:replies', newReplies);
            }
            this.isEditing = false;
            this.editComments = NaN;
        },
        async increaseLike(reply, isLike) {
            await this.commentStore.increaseLike(reply.parentComic.id, reply.id, isLike);
            const newReplies = await this.commentStore.getReplies(reply.parentCommentId);
            this.$emit('update:replies', newReplies);
        },
        isLoggedIn() {
            return this.userStore.isLoggedIn();
        },
        isUsersComment(reply) {
            
            return this.commentStore.isUsersComment(reply);
        }
    },
    setup() {
        const commentStore = useCommentStore();
        const userStore = useUserStore();
        const isEditing = ref(false);
        const editedComment = ref(NaN);
        return { commentStore, userStore, isEditing, editedComment }
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