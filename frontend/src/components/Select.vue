<template>
    <select>
        <option value="">{{ title }}</option>
        <option value="Item1">Item1</option>
        <option value="Item1">Item2</option>
        <option value="Item1">Item3</option>
        <option value="Item1">Item4</option>
        <option value="Item1">Item5</option>
        <option value="Item1">Item6</option>
    </select>
</template>

<style scoped>
select {
    height: 6vh;
    width: clamp(70px, 20vw, 450px);
    background: #353434;
    border-radius: clamp(2px, 1.5vh, 40px);
    padding-inline: 1.5vw;
    transition: all 0.3s;
    border: none;
    font-weight: 400;
    font-size: 16px;
    color: #9ba7bf;
    outline: none;
    -webkit-appearance: none !important;
    -moz-appearance: none !important;
    appearance: none !important;
}

select::after {
    content: url(data:image/svg+xml;base64,PHN2ZyB3aWR0aD0nMTInIGhlaWdodD0nOScgdmlld0JveD0nMCAwIDEyIDknIGZpbGw9J25vbmUnIHhtbG5zPSdodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2Zyc+PHBhdGggZD0nTTEuNDEgMC42MTQyNThMNiA1LjE5NDI2TDEwLjU5IDAuNjE0MjU4TDEyIDIuMDI0MjZMNiA4LjAyNDI2TDAgMi4wMjQyNkwxLjQxIDAuNjE0MjU4WicgZmlsbD0nIzlCQTdCRicvPjwvc3ZnPg==);
    font: 17px Consolas, monospace;
    right: 20px;
    color: white;
    top: 26px;
    transform: translateY(-50%);
    padding: 0 0 0 20px;
    background: #353434;
    position: absolute;
    pointer-events: none;
}
</style>

<script>
export default {
    name: 'Select',
    props: {
        title: String
    }
}
</script>