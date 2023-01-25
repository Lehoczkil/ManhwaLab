import { defineStore } from "pinia";

export const useThemeStore = defineStore("themeStore", {
  state: () => ({
    themes: [],
  }),
  actions: {
    async getThemes() {
      const res = await fetch("http://10.44.7.208:8080/api/manhwaLab/themes");
      const data = await res.json();

      this.themes = data;
    },
  },
});
