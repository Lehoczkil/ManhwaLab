import { defineStore } from "pinia";

export const useGenreStore = defineStore("genreStore", {
  state: () => ({
    genres: [],
  }),
  actions: {
    async getGenres() {
      const res = await fetch("/api/manhwaLab/genres");
      const data = await res.json();

      this.genres = data;
    },
  },
});
