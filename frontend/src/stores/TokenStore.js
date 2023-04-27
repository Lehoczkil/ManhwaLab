import { defineStore } from "pinia";
import { useUserStore } from "./UserStore";

export const useTokenStore = defineStore("tokenStore", {
  state: () => ({
    token: "",
  }),
  actions: {
    setToken(token) {
      if (token.includes("Bearer")) {
        this.token = token;
        const userStore = useUserStore();
        userStore.getUser(token);
      } else {
        console.error("Access token not exists");
      }
    },
    isTokenExists() {
      return this.token !== "";
    },
    clearToken() {
      localStorage.removeItem("token");
      this.token = "";
      const UserStore = useUserStore();
      UserStore.clearUser();
    },
  },
});
