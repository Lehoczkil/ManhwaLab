<template>
    <div class="modal-backdrop">
        <form class="modal">
            <header class="modal-header">
                <h2>Login</h2>
                <button type="button" class="btn-close" @click="close">
                    x
                </button>
            </header>

            <section class="modal-body">
                <input type="text" placeholder="Username">
                <input type="password" placeholder="Password">
            </section>

            <footer class="modal-footer">
                <button type="submit" class="btn login">
                    Login
                </button>
            </footer>
        </form>
    </div>
</template>

<style>

input {
    width: 80%;
    height: 40px;
    text-align: center;
    background: transparent;
    border: none;
    color: black;
    border-radius: 5px;
    font-size: 20px;
}

input:focus {
    border-right: none;
    outline: none;
}

input:focus, input:hover {
    background: #353434;
    transition: 0.3s;
    color: white;
}

.modal-backdrop {
    position: fixed;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    background-color: rgba(0, 0, 0, 0.4);
    display: flex;
    justify-content: center;
    align-items: center;
}

.modal {
    background: #d1cdcd;
    height: clamp(500px, 50vh, 5000px);
    width: clamp(350px, 35vw, 3500px);
    box-shadow: 3px 3px 10px 2px rgb(136, 127, 127);
    overflow-x: auto;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    border-radius: 2%;
}

.modal-header {
    position: relative;
    justify-content: space-between;
    align-items: center;
    padding: 15px;
    display: flex;
}

.modal-body {
    position: relative;
    padding: 20px 10px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    align-items: center;
    height: 30%;
}

.btn-close {
    border: none;
    font-size: 20px;
    cursor: pointer;
    font-weight: bold;
    background: transparent;
}

.modal-footer {
    text-align: center;
    padding: 20px;
}

.login {
    width: 80%;
    min-width: 280px;
    height: 50px;
    border-radius: 12px;
    border: none;
    color: white;
    padding: 10px;
    font-weight: 600;
    background: #353434;
    cursor: pointer;
}

.login:hover {
    background: white;
    color: #353434;
    transition: 0.3s;
    border: 1px solid #353434;
}
</style>


<script>
export default {
    name: 'Login',
    methods: {
        close() {
            this.$emit('close');
        },
    },
};
</script>
