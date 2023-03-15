<template>
    <article>
        <section class="profile">
            <div class="img-container">
                <img src="../assets/default-pic.jpg" alt="Users profile picture" class="pic">
                <button v-if="!isEditing" @click="handleEdit" class="edit">Edit</button>
                <button v-if="isEditing" @click="handleSave" class="edit">Save</button>
            </div>
            <div class="content">
                <div class="row">
                    <div class="field">
                        <p>Name:</p>
                        <span v-if="!isEditing">{{ username }}</span>
                        <input class="data" type="text" v-if="isEditing" id="name" :placeholder=username>
                    </div>

                    <div class="field">
                        <p>Age:</p>
                        <span v-if="!isEditing">{{ age }}</span>
                        <input class="data" type="number" v-if="isEditing" id="age" :placeholder=age>
                    </div>

                    <div class="field">
                        <p>Gender:</p>
                        <span v-if="!isEditing">{{ gender }}</span>
                        <select class="data" id="gender" v-if="isEditing" :placeholder=gender>
                            <option value="MALE">Male</option>
                            <option value="FEMALE">Female</option>
                            <option value="OTHER">Other</option>
                        </select>
                    </div>
                </div>

                <div class="row">
                    <div class="field">
                        <p>Location:</p>
                        <span v-if="!isEditing">{{ location }}</span>
                        <input class="data" type="text" v-if="isEditing" id="location" :placeholder=location>
                    </div>

                    <div class="field">
                        <p>Last Online:</p>
                        <span>{{ lastOnline }}</span>
                    </div>

                    <div class="field">
                        <p>Joined:</p>
                        <span>{{ joined }}</span>
                    </div>
                </div>

                <div class="description">
                    <p v-if="!isEditing">
                        {{ description }}
                    </p>
                    <textarea v-if="isEditing" id="description" cols="30" rows="10" :placeholder=description />
                </div>
            </div>
        </section>
        <section class="shows">
            <ShortList title="Favourites" />
            <ShortList title="Reading" />
            <ShortList title="Read Later" />
            <ShortList title="Finished" />
        </section>
    </article>
</template>

<style scoped>
article {
    padding: 1vw;
}

.data {
    width: clamp(100px, 10vw, 200px);
    background: var(--dark-gray);
    color: white;
    border: none;
    height: 2rem;
}

.pic {
    width: clamp(240px, 24vw, 2400px);
    height: clamp(300px, 30vw, 3000px);
    margin: 1vh auto;
    border-radius: var(--radius);
    border: 0.5px solid white;
}

.edit {
    background: white;
    border: none;
    border-radius: var(--radius);
    cursor: pointer;
    font-size: clamp(15px, 1vw, 100px);
    font-weight: 600;
    padding-block: 0.8vh;
    transition: all 0.4s;
    width: clamp(100px, 9vw, 500px);
}

.profile {
    display: flex;
    justify-content: space-between;
    margin-bottom: 5vh;
}

.content {
    width: 78vw;
    padding: 1rem 10rem;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
}

.row {
    display: flex;
    justify-content: space-between;
    color: white;
}

.field {
    flex-basis: 20%;
    display: flex;
    justify-content: space-between;
    font-size: 1.1rem;
    flex-wrap: wrap;
}

.field p {
    font-weight: 800;
}

.description {
    text-align: justify;
    color: white;
    height: 10vh;
    overflow-y: scroll;
    padding-block: 1rem;
}

@media (max-width: 950px) {
    article {
        overflow-x: hidden;
    }

    .profile,
    .row {
        flex-direction: column;
    }

    .content {
        margin: auto;
        margin-top: 1rem;
        padding: 0.5rem;
    }

    .row,
    .description {
        width: 80%;
        margin: auto;
    }

    .field {
        margin-bottom: 1rem;
    }

    .description {
        margin-top: 2rem;
        background: var(--dark-gray);
        border-radius: var(--radius);
        width: 82%;
        padding: 1rem;
    }

    .img-container {
        display: flex;
        margin: auto;
        flex-direction: column;
    }

}
</style>

<script>
import ShortList from '../components/ShortList'
import { useUserStore } from '@/stores/UserStore';
import { storeToRefs } from 'pinia';

export default {
    name: 'UserProfile',
    components: {
        ShortList
    },
    methods: {
        handleEdit() {
            this.isEditing = true;
        },
        handleSave() {
            this.isEditing = false;

            let username = this.username;
            let usernameToBeTested = document.querySelector("#name").value
            if (usernameToBeTested !== '' && !usernameToBeTested.includes('"') && !usernameToBeTested.includes("'") && usernameToBeTested.length > 3 && usernameToBeTested.length < 16 && !(/\d/.test(usernameToBeTested))) {
                username = usernameToBeTested
            }

            let age = this.age;
            let ageToBeTested = document.querySelector("#age").value
            if (ageToBeTested !== '' && ageToBeTested > 0 && ageToBeTested < 130) {
                age = ageToBeTested
            }

            let location = this.location;
            let locationToBeTested = document.querySelector("#location").value
            if (locationToBeTested !== '' && locationToBeTested.length < 3 && locationToBeTested.length > 30 && !(/\d/.test(usernameToBeTested))) {
                location = locationToBeTested
            }

            const gender = document.querySelector("#gender").value === "" ? this.gender : document.querySelector("#gender").value.toUpperCase();
            
            let description = this.description
            let descriptionToBeTested = document.querySelector("#description").value
            if (descriptionToBeTested !== '' && locationToBeTested < 0 && locationToBeTested > 150) {
                description = locationToBeTested
            }

            this.userStore.updateUser(username, age, gender, location, description)
        }
    },
    data() {
        return {
            isEditing: false
        }
    },
    setup() {
        const userStore = useUserStore()
        userStore.getUser()

        const { username, age, gender, location, lastOnline, joined, description, finished, read, favourites, readLater } = storeToRefs(userStore)
        return { userStore, username, age, gender, location, lastOnline, joined, description, finished, read, favourites, readLater }
    }
}
</script>