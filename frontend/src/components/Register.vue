<template>
    <div class="modal-backdrop">
        <div class="modal">
            <header class="modal-header">
                <button type="button" class="btn-close" @click="close">
                    esc
                </button>
                <h2>Register</h2>
            </header>

            <section class="modal-body">
                <input class="input" type="text" placeholder="Username" id="username-reg">
                <input class="input" type="password" placeholder="Password" id="password-reg">
                <input class="input" type="email" placeholder="Email" id="email">
            </section>

            <footer class="modal-footer">
                <h2 class="invalid" v-if="!isValid">Invalid username, password or email</h2>
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

.invalid {
    font-size: 0.75rem;
    margin-bottom: 0.75rem;
    text-align: center;
    color: var(--blue);
}
</style>


<script>
import { useTokenStore } from '@/stores/TokenStore';

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

            if (!(username === '' || password === '' || email === '')) {
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

                this.isValid = true

                const response = await fetch(`/login`, {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify({
                        username: username,
                        password: password
                    })
                })

                if (response.headers.get('Authorization')) {
                    this.$emit('close')
                    const tokenStore = useTokenStore()
                    tokenStore.setToken(response.headers.get('Authorization'))
                }
            } else {
                this.isValid = false
            }
        }
    },
    data() {
        return {
            isValid: true
        }
    }
};
</script>
