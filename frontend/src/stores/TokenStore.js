import { defineStore } from "pinia";

export const useTokenStore = defineStore("tokenStore", {
  state: () => ({
    token: '',
  }),
  actions: {
    setToken(token) {
      if (token.includes("Bearer")) {
        localStorage.setItem("access_token", token);
        this.token = token;
      } else {
        console.error("Access token not exists");
      }
    },
    isTokenExists() {
        return this.token === '';
    }
  },
});
