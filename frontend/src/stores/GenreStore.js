import { defineStore } from "pinia";

export const useGenreStore = defineStore("genreStore", {
  state: () => ({
    genres: [],
  }),
  actions: {
    async getGenres() {
      const res = await fetch(`${process.env.VUE_APP_API_BASE}/api/manhwaLab/genres`);
      const data = await res.json();

      this.genres = data;
    },
  },
});
