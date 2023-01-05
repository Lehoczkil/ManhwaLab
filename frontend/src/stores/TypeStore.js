import { defineStore } from "pinia";

export const useTypeStore = defineStore("typeStore", {
  state: () => ({
    types: [],
  }),
  actions: {
    async getTypes() {
      const res = await fetch("http://localhost:8080/api/manhwaLab/types");
      const data = res.json();

      this.types = data;
    }
  },
});
