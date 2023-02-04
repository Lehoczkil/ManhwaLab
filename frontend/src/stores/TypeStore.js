import { defineStore } from "pinia";

export const useTypeStore = defineStore("typeStore", {
  state: () => ({
    types: [],
  }),
  actions: {
    async getTypes() {
      const res = await fetch("/api/manhwaLab/types");
      const data = await res.json();

      this.types = data;
    }
  },
});
