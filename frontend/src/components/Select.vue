<template>
    <div>
        <select v-if="title !== 'Type' && title !== 'Sort by'" :id="title">
            <option value="">{{ title }}</option>
            <option v-for="record in data" :key="record.id" :value=record.name>
                {{ record.name }}
            </option>
        </select>
    
        <select v-if="title === 'Type' && title !== 'Sort by'" :id="title">
            <option value="">{{ title }}</option>
            <option v-for="record in data" :key="record.id" :value=record.name>
                {{ record }}
            </option>
        </select>
    
        <select v-if="title === 'Sort by'" id="sort">
            <option value="">{{ title }}</option>
            <option value="abc">Abc</option>
            <option value="rating">Highest rating</option>
            <option value="view">Most Viewed</option>
        </select>
    </div>

</template>

<style scoped>
select {
    height: clamp(30px, 6vh, 200px);
    width: clamp(140px, 28vw, 1000px);
    background: var(--dark-gray);
    border-radius: var(--radius);
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
    background: var(--dark-gray);
    position: absolute;
    pointer-events: none;
}

@media(max-width:1150px) {
    select {
        margin-bottom: 2vh;
        width: 60vw;
    }
}

</style>

<script>
export default {
    name: 'Select',
    props: {
        title: String,
        data: Array
    }
}
</script>