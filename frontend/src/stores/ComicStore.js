import { defineStore } from "pinia";

export const useComicStore = defineStore("comicStore", {
  state: () => ({
    originals: [],
    comics: [],
    loading: false,
  }),
  actions: {
    async getComics() {
      this.loading = true;
      const res = await fetch("http://localhost:8080/api/manhwaLab/manhwaList");
      const data = await res.json();

      this.comics = data;
      this.originals = data;
      this.loading = false;
    },
    async getComicByName(name) {
      const res = await fetch("http://localhost:8080/api/manhwaLab/" + name);
      const data = await res.json();
      this.currentComic = data;
    },
    filterComics(genre, theme, type) {
      this.comics = this.originals;
      let filteredComics = this.originals;
      if (genre) {
        filteredComics = filteredComics.filter((comic) =>
          comic.genreList.map((g) => g.name).includes(genre)
        );
      }
      if (theme) {
        filteredComics = filteredComics.filter(
          (comic) => comic.theme === theme
        );
      }
      if (type) {
        filteredComics = filteredComics.filter((comic) => comic.type === type);
      }
      this.comics = filteredComics;
    },
  },
});
