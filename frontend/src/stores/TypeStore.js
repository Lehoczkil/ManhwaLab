import { defineStore } from "pinia";

export const useTypeStore = defineStore("typeStore", {
  state: () => ({
    types: [],
  }),
  actions: {
    async getTypes() {
      const res = await fetch(`${process.env.VUE_APP_API_BASE}/api/manhwaLab/types`);
      const data = await res.json();

      this.types = data;
    }
  },
});
