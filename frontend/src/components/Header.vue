<template>
    <header>
        <div class="search-container">
            <input type="search" placeholder="Find manhwa...">
            <select class="menu">
                <option value="">Browse</option>
                <option value="">Recommendations</option>
            </select>
        </div>
        <img src="../assets/logo.png" alt="logo">
        <div class="auth">
            <button>Register</button>
            <button>Login</button>
        </div>
    </header>
</template>

<script>
export default {
    name: 'Header'
}
</script>