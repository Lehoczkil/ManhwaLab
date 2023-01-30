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
    numberOfComics: 0,
  }),
  actions: {
    async getComics() {
      this.loading = true;
      const all = await fetch("https://backend-web-service-0qh4.onrender.com/api/manhwaLab/manhwaList");
      const allJson = await all.json();

      this.comics = allJson;
      this.originals = allJson;
      this.numberOfComics = allJson.length;

      this.loading = false;
    },
    async getTopComics() {
      const daily = await fetch(
        "https://backend-web-service-0qh4.onrender.com/api/manhwaLab/top/daily"
      );
      const dailyJson = await daily.json();

      const weekly = await fetch(
        "https://backend-web-service-0qh4.onrender.com/api/manhwaLab/top/weekly"
      );
      const weeklyJson = await weekly.json();

      const monthly = await fetch(
        "https://backend-web-service-0qh4.onrender.com/api/manhwaLab/top/monthly"
      );
      const monthlyJson = await monthly.json();

      this.dailyTop = dailyJson;
      this.weeklyTop = weeklyJson;
      this.monthlyTop = monthlyJson;
    },
    sortComics(sort) {
      let sortedComics = this.comics;
      if (sort === "view") {
        sortedComics.sort(function (a, b) {
          return b.views - a.views;
        });
      } else if (sort === "rating") {
        sortedComics.sort(function (a, b) {
          return b.rating - a.rating;
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
      this.numberOfComics = filteredComics.length;
    },
    searchInComics(title) {
      let searchedComics = this.comics;
      if (title) {
        title = title.toLowerCase();
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

        this.mostViewed = mostViewed
          .sort(function (a, b) {
            a.views - b.views;
          })
          .slice(0, 5);
      }
    },
    async getTopOngoing() {
      await this.getComics();
      let topOngoing = this.comics.filter(
        (comic) => comic.status === "ONGOING"
      );
      topOngoing = topOngoing.sort(function (a, b) {
        return b.rating - a.rating;
      });
      this.topOngoing = topOngoing.slice(0, 5);
    },
    async getComicById(id) {
      await this.getComics();
      let currentComic = this.comics.find((comic) => comic.id == id);
      this.currentComic = currentComic;
    },
    haveComics() {
      return (
        this.comics.length === this.numberOfComics && this.numberOfComics > 0
      );
    },
    increaseViewCount(id) {
      fetch(`https://backend-web-service-0qh4.onrender.com/manhwaLab/${id}/update-view`, {
        method: "POST",
        headers: {
          'Accept': "application/json",
          "Content-Type": "application/json",
        },
      });
    },
  },
});
