import { defineStore } from "pinia";

export const useComicStore = defineStore("comicStore", {
  state: () => ({
    originals: [],
    currentComic: {},
    comics: [],
    dailyTop: [],
    weeklyTop: [],
    monthlyTop: [],
    mostViewed: [],
    topOngoing: [],
    loading: false,
  }),
  actions: {
    async getComics() {
      this.loading = true;
      const all = await fetch("http://localhost:8080/api/manhwaLab/manhwaList");
      const allJson = await all.json();

      this.comics = allJson;
      this.originals = allJson;

      this.loading = false;
    },
    async getTopComics() {
      const daily = await fetch(
        "http://localhost:8080/api/manhwaLab/top/daily"
      );
      const dailyJson = await daily.json();

      const weekly = await fetch(
        "http://localhost:8080/api/manhwaLab/top/weekly"
      );
      const weeklyJson = await weekly.json();

      const monthly = await fetch(
        "http://localhost:8080/api/manhwaLab/top/monthly"
      );
      const monthlyJson = await monthly.json();

      this.dailyTop = dailyJson;
      this.weeklyTop = weeklyJson;
      this.monthlyTop = monthlyJson;
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
      }
      this.comics = sortedComics;
    },
    filterComics(genre, theme, type, sort, search) {
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
      this.searchInComics(search);
    },
    searchInComics(title) {
      let searchedComics = this.comics;
      title = title.toLowerCase();
      if (title) {
        searchedComics = searchedComics.filter((comic) =>
          comic.title.toLowerCase().includes(title)
        );
      }
      this.comics = searchedComics;
    },
    async getMostViewed() { 
      await this.getComics();
      if (this.comics.length > 0) { 
        let mostViewed = this.comics;
        
        this.mostViewed = mostViewed.sort(function(a, b) {
          a.views - b.views
        }).slice(0,5);
      }
    },
    async getTopOngoing() {
      await this.getComics();
      let topOngoing = this.comics.filter(
        (comic) => comic.status === "ONGOING"
      );
      topOngoing = topOngoing.sort(function (a, b) {
        return a.rating - b.rating;
      });
      this.topOngoing = topOngoing.slice(0, 5);
    },
  },
});
