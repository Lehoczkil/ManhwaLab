<template>
    <article>
        <section class="profile">
            <div class="profile-pic"></div>
            <div class="content">
                <div class="row">
                    <p>Name: My Name</p>
                    <p>Age: 27</p>
                    <p>Gender: Male</p>
                </div>
                <div class="row">
                    <p>Location: Hungary</p>
                    <p>Last Online: 2022. 12. 09.</p>
                    <p>Joined: 2018. 11. 07.</p>
                </div>
                <div class="description">
                    <p>Nam et convallis tortor, in finibus leo. Nulla ut elit eros. Suspendisse porttitor eu velit a
                        vestibulum. Integer iaculis ultrices neque ac vehicula. Fusce gravida, dui vitae egestas
                        rhoncus, arcu nunc iaculis augue, scelerisque vulputate sapien neque vitae enim. Phasellus quis
                        neque ultrices, commodo erat sed, finibus quam. In accumsan libero sed erat egestas, a convallis
                        sapien auctor. Vivamus quam elit, luctus ac pretium in, egestas sit amet felis. Ut tempus luctus
                        arcu sit amet molestie. Nunc ut metus quis felis porta tincidunt id at dolor. Nam molestie
                        tempus augue, a feugiat mauris consequat finibus.
                    </p>
                </div>
            </div>
        </section>
        <section class="shows">
            <Recommended/>
            <Recommended/>
        </section>
    </article>
</template>

<script>
import Recommended from '../components/Recommended'

export default {
    name: 'UserProfile',
    components: {
        Recommended
    }
}
</script>