<template>
    <div class="modal-backdrop">
        <form class="modal">
            <header class="modal-header">
                <h2>Register</h2>
                <button type="button" class="btn-close" @click="close">
                    x
                </button>
            </header>

            <section class="modal-body">
                <input type="text" placeholder="Username">
                <input type="password" placeholder="Password">
                <input type="email" placeholder="Email">
            </section>

            <footer class="modal-footer">
                <button type="submit" class="btn login">
                    Register
                </button>
            </footer>
        </form>
    </div>
</template>

<style scoped>
    .modal-body {
        height: 45%;
    }
</style>


<script>
export default {
    name: 'Register',
    methods: {
        close() {
            this.$emit('close');
        },
    },
};
</script>
