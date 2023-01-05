import { defineStore } from "pinia";

export const useComicStore = defineStore("comicStore", {
  state: () => ({
    currentComic: {},
    comics: [],
    loading: false,
  }),
  getters: {},
  actions: {
    async getComics() {
      this.loading = true;
      const res = await fetch("http://localhost:8080/api/manhwaLab/manhwaList");
      const data = await res.json();

      this.comics = data;
      this.loading = false;
    },
    async getComicByName(name) {
      const res = await fetch("http://localhost:8080/api/manhwaLab/" + name);
      const data = await res.json();
      this.currentComic = data;
    },
  },
});
