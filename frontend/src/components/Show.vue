<template>
    <div class="show">
        <div class="show-pic"></div>
        <h1>Title</h1>
        <p>Description</p>
        <div class="rating">
            <img class="star" src="../assets/left.png" alt="left-arrow">
            <img class="star" src="../assets/left.png" alt="left-arrow">
            <img class="star" src="../assets/left.png" alt="left-arrow">
            <img class="star" src="../assets/left.png" alt="left-arrow">
            <img class="star" src="../assets/left.png" alt="left-arrow">
        </div>
    </div>
</template>


<style scoped>
.star {
    height: 2vh;
}

.show-pic {
    height: clamp(100px, 12vh, 700px);
    width: clamp(72px, 8.5vh, 350px);
    background: black;
}
</style>

<script>
export default {
    name: 'Show'
}
</script>