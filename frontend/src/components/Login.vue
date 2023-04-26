<template>
    <div class="modal-backdrop">
        <div class="modal">
            <header class="modal-header">
                <button type="button" class="btn-close" @click="close">
                    esc
                </button>
                <h2>Login</h2>
            </header>

            <section class="modal-body">
                <input class="input" type="text" placeholder="Username" id="username">
                <input class="input" type="password" placeholder="Password" id="password">
            </section>

            <footer class="modal-footer">
                <h2 class="invalid" v-if="!isValid">Invalid username or password</h2>
                <button type="button" class="btn login" @click="handleLogin">
                    Login
                </button>
            </footer>
        </div>
    </div>
</template>

<style>
h2 {
    color: rgb(231, 230, 230);
}

.invalid {
    font-size: 0.75rem;
    margin-bottom: 0.75rem;
    text-align: center;
    color: var(--blue);
}

.input {
    height: 2.5rem;
    text-align: center;
    background: var(--almost-black);
    border: none;
    border-bottom: 0.200rem solid rgb(231, 230, 230);
    font-size: 20px;
    color: white;
}

input:focus,
input:hover {
    border-right: none;
    outline: none;
}

.modal-backdrop {
    position: fixed;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    background-color: rgba(0, 0, 0, 0.9);
    display: flex;
    justify-content: center;
    padding-top: 10vh;
}

.modal {
    background: var(--dark-gray);
    height: clamp(400px, 50vh, 4000px);
    width: clamp(320px, 30vw, 3200px);
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    border-radius: var(--radius);
    padding: 2rem;
}

.modal-body {
    position: relative;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    height: 30%;
}

.btn-close {
    background: transparent;
    border: 0.150rem solid var(--blue);
    border-radius: var(--radius);
    cursor: pointer;
    color: rgb(231, 230, 230);
    font-size: 0.80rem;
    padding: var(--radius);
    display: flex;
    margin-left: auto;
    margin-bottom: 1rem;
}

.btn-close:hover {
    background: var(--blue);
    color: white;
}

.login {
    width: 100%;
    height: 2.5rem;
    border-radius: var(--radius);
    border: none;
    color: rgb(42 46 53);
    padding: 10px;
    font-weight: 600;
}
</style>


<script>
import { useTokenStore } from '@/stores/TokenStore';

export default {
    name: 'Login',
    methods: {
        close() {
            this.$emit('close');
        },
        async handleLogin() {
            const username = document.querySelector('#username').value
            const password = document.querySelector('#password').value

            if (!(username === "" || password === "")) {
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
                    this.$emit('close');
                    const tokenStore = useTokenStore();
                    tokenStore.setToken(response.headers.get('Authorization'));
                    this.$router.push('/');
                }
                
                this.isValid = true
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
}
</script>
