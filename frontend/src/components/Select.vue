<template>
    <nav>
        <label for="touch"><span>titre</span></label>
        <input type="checkbox" id="touch">
        <ul class="slide">
            <li><a href="#">Lorem Ipsum</a></li>
            <li><a href="#">Lorem Ipsum</a></li>
            <li><a href="#">Lorem Ipsum</a></li>
            <li><a href="#">Lorem Ipsum</a></li>
            <li><a href="#">Lorem Ipsum</a></li>
            <li><a href="#">Lorem Ipsum</a></li>
            <li><a href="#">Lorem Ipsum</a></li>
            <li><a href="#">Lorem Ipsum</a></li>
            <li><a href="#">Lorem Ipsum</a></li>
            <li><a href="#">Lorem Ipsum</a></li>
        </ul>
    </nav>
</template>

<style scoped>
li a {
    text-decoration: none;
    color: #2d2f31;
}

nav {
    width: 23vw;
    background: #d9d9d9;
    border-radius:  3.8vh;
}

span {
    padding: 1.5vh 1.5vw;
    background: #2d2f31;
    color: white;
    font-size: clamp(17px, 1vw, 100px);
    cursor: pointer;
    display: block;
    border-radius: 50vw;
    min-height: 6vh;
    margin: auto;

}

li:hover {
    background: lightgreen;
    z-index: 0;
}

span::after {
    float: right;
    content: "+";
}

.slide {
    clear: both;
    width: 100%;
    border-radius:  3vh 3vh 0vh 0vh;
    max-height: 0;
    overflow: hidden;
    text-align: center;
    transition: max-height .3s ease-out;
}

.slide li {
    padding: 1.5vw;
    transition: all .3s;
}

#touch {
    position: absolute;
    opacity: 0;
    height: 0px;
}

#touch:checked+.slide {
    max-height: 250px;
    overflow-y: scroll;
    transition: max-height .7s ease-in;
}

#touch:checked+nav {
    z-index: 100000;
    margin-bottom: 3vh;
}
</style>

<script>
export default {
    name: 'Select'
}
</script>