import { defineStore } from "pinia";

export const useTokenStore = defineStore("tokenStore", {
  state: () => ({
    token: '',
  }),
  actions: {
    setToken(token) {
      if (token.includes("Bearer")) {
        this.token = token;
      } else {
        console.error("Access token not exists");
      }
    },
    isTokenExists() {
        return this.token !== '';
    },
    clearToken() {
      localStorage.removeItem("token");
      this.token = '';
    }
  },
});
