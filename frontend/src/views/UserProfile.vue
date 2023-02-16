<template>
    <article>
        <section class="profile">
            <div class="img-container">
                <img src="../assets/default-pic.jpg" alt="Users profile picture" class="pic">
                <button class="edit">Edit</button>
            </div>
            <div class="content">
                <div class="row">
                    <div class="field">
                        <p>Name:</p>
                        <span>{{ username }}</span>
                    </div>

                    <div class="field">
                        <p>Age:</p>
                        <span>{{ age }}</span>
                    </div>

                    <div class="field">
                        <p>Gender:</p>
                        <span>{{ gender }}</span>
                    </div>
                </div>

                <div class="row">
                    <div class="field">
                        <p>Location:</p>
                        <span>{{ location }}</span>
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
                    <p>
                        {{ description }}
                    </p>
                </div>
            </div>
        </section>
        <section class="shows">
            <ShortList title="Favourites"/>
            <ShortList title="Read"/>
            <ShortList title="Read Later"/>
            <ShortList title="Finished"/>
        </section>
    </article>
</template>

<style scoped>
article {
    padding: 1vw;
}

.pic {
    width: clamp(240px, 24vw, 2400px);
    height: clamp(300px, 30vw, 3000px);
    margin: 1vh auto;
    border-radius: clamp(20px, 1vw, 50px);
    border: 0.5px solid white;
}

.edit {
    background: white;
    border: none;
    border-radius: clamp(5px, 0.5vh, 30px);
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

    .profile, .row {
        flex-direction: column;
    }    

    .content {
        margin: auto;
        margin-top: 1rem;
        padding: 0.5rem;
    }

    .row, .description {
        width: 80%;
        margin: auto;
    }

    .field {
        margin-bottom: 1rem;
    }

    .description {
        margin-top: 2rem;
        background: rgb(35, 35, 34);
        border-radius: clamp(20px, 1vw, 50px);
        width: 82%;
        padding: 1rem;
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
    setup() {
        const userStore = useUserStore()
        userStore.getUser()

        const { username, age, gender, location, lastOnline, joined, description, finished, read, favourites, readLater } = storeToRefs(userStore)
        return { userStore, username, age, gender, location, lastOnline, joined, description, finished, read, favourites, readLater }
    }
}
</script>