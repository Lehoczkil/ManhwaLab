import { defineStore } from "pinia";

export const useGenreStore = defineStore("genreStore", {
  state: () => ({
    genres: [],
  }),
  actions: {
    async getGenres() {
      const res = await fetch("http://localhost:8080/api/manhwaLab/genres");
      const data = await res.json();

      this.genres = data;
    },
  },
});
