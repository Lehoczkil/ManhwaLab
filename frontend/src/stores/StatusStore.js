import { defineStore } from "pinia";

export const useStatusStore = defineStore("statusStore", {
  state: () => ({
    statuses: [],
  }),
  actions: {
    async getStatuses() {
      const res = await fetch("http://localhost:8080/api/manhwaLab/statuses");
      const data = res.json();

      this.statuses = data;
    },
  },
});
