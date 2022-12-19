<template>
    <div class="show">
        <div class="show-pic"></div>
        <h1>Title</h1>
        <p>112 ch</p>
        <div class="rating">
            <img class="star" src="../assets/star.png" alt="star">
            <img class="star" src="../assets/star.png" alt="star">
            <img class="star" src="../assets/star.png" alt="star">
            <img class="star" src="../assets/star.png" alt="star">
            <img class="star" src="../assets/star.png" alt="star">
        </div>
    </div>
</template>


<style scoped>
.star {
    height: 2vh;
}

.show-pic {
    height: clamp(100px, 12.5vh, 700px);
    width: clamp(72px, 9vh, 350px);
    background: black;
}
</style>

<script>
export default {
    name: 'Show'
}
</script>