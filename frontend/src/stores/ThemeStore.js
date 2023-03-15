import { defineStore } from "pinia";

export const useThemeStore = defineStore("themeStore", {
  state: () => ({
    themes: [],
  }),
  actions: {
    async getThemes() {
      const res = await fetch(`${process.env.VUE_APP_API_BASE}/api/manhwaLab/themes`);
      const data = await res.json();

      this.themes = data;
    },
  },
});
