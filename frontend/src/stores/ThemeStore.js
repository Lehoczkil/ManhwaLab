import { defineStore } from "pinia";

export const useThemeStore = defineStore("themeStore", {
  state: () => ({
    themes: [],
  }),
  actions: {
    async getThemes() {
      const res = await fetch("/api/manhwaLab/themes");
      const data = await res.json();

      this.themes = data;
    },
  },
});
