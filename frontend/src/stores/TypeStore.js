import { defineStore } from "pinia";

export const useTypeStore = defineStore("typeStore", {
  state: () => ({
    types: [],
  }),
  actions: {
    async getTypes() {
      const res = await fetch("https://backend-web-service-0qh4.onrender.com/api/manhwaLab/types");
      const data = await res.json();

      this.types = data;
    }
  },
});
