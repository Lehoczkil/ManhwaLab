<template>
    <div class="modal-backdrop">
        <div class="modal">
            <header class="modal-header">
                <h2>Register</h2>
                <button type="button" class="btn-close" @click="close">
                    x
                </button>
            </header>

            <section class="modal-body">
                <input type="text" placeholder="Username" id="username-reg">
                <input type="password" placeholder="Password" id="password-reg">
                <input type="email" placeholder="Email" id="email">
            </section>

            <footer class="modal-footer">
                <button type="button" class="btn login" @click="handleRegister">
                    Register
                </button>
            </footer>
        </div>
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
        async handleRegister() {
            const username = document.querySelector('#username-reg').value
            const password = document.querySelector('#password-reg').value
            const email = document.querySelector('#email').value

            await fetch(`/api/manhwaLab/registration`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    username: username,
                    password: password,
                    email: email
                })
            })

            this.close()
        }
    },
};
</script>
