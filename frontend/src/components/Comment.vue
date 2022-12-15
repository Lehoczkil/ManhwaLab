<template>
    <div class="comment">
        <div class="profile-pic"></div>
        <div class="content">
            <div class="name-container">
                <h1>Name</h1>
                <img class="star" src="../assets/star.png" alt="star">
                <p>6 months ago</p>
            </div>

            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla vehicula suscipit mauris, sit amet
                vehicula est porttitor eu. Donec vitae consequat sapien. Maecenas tempus ante sit amet magna
                faucibus aliquam. Nullam congue, turpis ut maximus rhoncus, nisl leo placerat neque, nec vulputate
                odio felis et orci. Vestibulum molestie, lorem et maximus dictum, nunc odio convallis metus, eu
                molestie nulla libero in felis. Integer consectetur bibendum purus id tempus.
            </p>

            <div class="actions">
                <div class="like">
                    <img class="star" src="../assets/star.png" alt="star">
                    <p>293</p>
                </div>
                <div class="like">
                    <img class="star" src="../assets/star.png" alt="star">
                    <p>293</p>
                </div>
                <button class="action">Reply</button>
                <button class="action">Share</button>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "Comment"
}
</script>

