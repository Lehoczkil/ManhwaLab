<template>
    <section>
        <h1>Test</h1>
        <div class="show-container">
            <img class="arrow" src="../assets/left.png" alt="left-arrow">
            <div class="shows">
                <Show />
                <Show />
                <Show />
                <Show />
                <Show />
                <Show />
                <Show />
            </div>
            <img class="arrow" src="../assets/right.png" alt="right-arrow">
        </div>
    </section>
</template>

<style scoped>
.show-container, .shows {
    display: flex;
    justify-content: space-between;
    background: red;
    height: clamp(200px, 15vh, 1200px);
    align-items: center;
}

.shows {
    background: purple;
    width: 50vw;
}

.arrow {
    height: 8vh;
}
</style>

<script>
import Show from './Show'

export default {
    name: 'Slider',
    components: {
        Show
    }
}
</script>



