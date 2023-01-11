import { defineStore } from "pinia";

export const useComicStore = defineStore("comicStore", {
  state: () => ({
    originals: [],
    currentComic: {},
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
    sortComics(sort) {
      let sortedComics = this.comics;
      if (sort === "view") {
        sortedComics.sort(function (a, b) {
          return b.views - a.views;
        });
      } else if (sort === "rating") {
        sortedComics.sort(function (a, b) {
          return a.rating - b.rating;
        });
      } else if (sort === "abc") {
        sortedComics.sort(function (a, b) {
          if (a.title < b.title) {
            return -1;
          }
          if (a.title > b.title) {
            return 1;
          }
          return 0;
        });

        this.comics = sortedComics;
      }
    },
    filterComics(genre, theme, type, sort) {
      this.comics = this.originals;
      let filteredComics = this.originals;
      if (genre) {
        filteredComics = filteredComics.filter((comic) =>
          comic.genreList.map((g) => g.name).includes(genre)
        );
      }
      if (theme) {
        filteredComics = filteredComics.filter((comic) =>
          comic.themeList.map((t) => t.name).includes(theme)
        );
      }
      if (type) {
        filteredComics = filteredComics.filter((comic) => comic.type === type);
      }

      this.comics = filteredComics;
      this.sortComics(sort);
    },
  },
});
