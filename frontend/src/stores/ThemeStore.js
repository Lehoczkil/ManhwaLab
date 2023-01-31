import { defineStore } from "pinia";

export const useThemeStore = defineStore("themeStore", {
  state: () => ({
    themes: [],
  }),
  actions: {
    async getThemes() {
      const res = await fetch("https://second-backend-web-service-0qh4.onrender.com/api/manhwaLab/themes");
      const data = await res.json();

      this.themes = data;
    },
  },
});
