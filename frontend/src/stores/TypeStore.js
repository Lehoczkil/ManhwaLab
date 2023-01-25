import { defineStore } from "pinia";

export const useTypeStore = defineStore("typeStore", {
  state: () => ({
    types: [],
  }),
  actions: {
    async getTypes() {
      const res = await fetch("http://10.44.7.208:8080/api/manhwaLab/types");
      const data = await res.json();

      this.types = data;
    }
  },
});
