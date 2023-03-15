import { defineStore } from "pinia";

export const useUserStore = defineStore("userStore", {
  state: () => ({
    username: "",
    age: "",
    gender: "",
    location: "",
    lastOnline: "",
    joined: "",
    description: "",
    finished: [],
    read: [],
    favourites: [],
    readLater: [],
  }),
  actions: {
    async getUser() {
      const response = await fetch(`${process.env.VUE_APP_API_BASE}/api/manhwaLab/profile`, {
        headers: {
          Authorization: JSON.parse(localStorage.getItem("tokenStore")).token,
        },
      });

      const user = await response.json();

      this.username = user.username !== null ? user.username : "Not known";
      this.age = user.age !== null ? user.age : "Not known";
      this.gender = user.gender !== null ? user.gender : "Not known";
      this.location = user.location !== null ? user.location : "Not known";
      this.lastOnline =
        user.lastOnline !== null ? user.lastOnline : "Not known";
      this.joined = user.joined !== null ? user.joined : "Not known";
      this.description =
        user.description !== null
          ? user.description
          : "There is no description";
      this.finished = user.finished !== null ? user.finished : "Nothing here";
      this.read = user.read !== null ? user.read : "Nothing here";
      this.favourites =
        user.favourites !== null ? user.favourites : "Nothing here";
      this.readLater =
        user.readLater !== null ? user.readLater : "Nothing here";
    },
    async updateUser(username, age, gender, location, description) {
      await fetch(`${process.env.VUE_APP_API_BASE}/api/manhwaLab/updateUser`, {
        method: "PATCH",
        headers: {
          "Content-Type": "application/json",
          Authorization: JSON.parse(localStorage.getItem("tokenStore")).token,
        },
        body: JSON.stringify({
          username: username,
          age: age,
          gender: gender,
          location: location,
          description: description,
        }),
      });

      this.username = username !== null ? username : "Not known";
      this.age = age !== null ? age : "Not known";
      this.gender = gender !== null ? gender : "Not known";
      this.location = location !== null ? location : "Not known";
      this.description =
        description !== null ? description : "There is no description";
    },
    async updateReading(comic) {
      if (!this.read.map((comic) => comic.id).includes(comic.id)) {
        this.read.push(comic);
        await fetch(`${process.env.VUE_APP_API_BASE}/api/manhwaLab/addToReading`, {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
            Authorization: JSON.parse(localStorage.getItem("tokenStore")).token,
          },
          body: JSON.stringify({
            title: comic.title,
          }),
        });
      }
    },
    async updateLater(comic) {
      if (!this.readLater.map((comic) => comic.id).includes(comic.id)) {
        this.readLater.push(comic);
        await fetch(`${process.env.VUE_APP_API_BASE}/api/manhwaLab/addToReadLater`, {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
            Authorization: JSON.parse(localStorage.getItem("tokenStore")).token,
          },
          body: JSON.stringify({
            title: comic.title,
          }),
        });
      }
    },
    async updateFinished(comic) {
      if (!this.finished.map((comic) => comic.id).includes(comic.id)) {
        this.finished.push(comic);
        await fetch(`${process.env.VUE_APP_API_BASE}/api/manhwaLab/addToFinished`, {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
            Authorization: JSON.parse(localStorage.getItem("tokenStore")).token,
          },
          body: JSON.stringify({
            title: comic.title,
          }),
        });
      }
    },
    async updateFavourites(comic) {
      if (!this.favourites.map((comic) => comic.id).includes(comic.id)) {
        this.favourites.push(comic);
        await fetch(`${process.env.VUE_APP_API_BASE}/api/manhwaLab/addToFavourites`, {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
            Authorization: JSON.parse(localStorage.getItem("tokenStore")).token,
          },
          body: JSON.stringify({
            title: comic.title,
          }),
        });
      }
    },
    async removeFromReading(comic) {
      let comicIds = this.read.map((comic) => comic.id);

      if (comicIds.includes(comic.id)) {
        this.read.splice(comicIds.indexOf(comic.id), 1);

        await fetch(`${process.env.VUE_APP_API_BASE}/api/manhwaLab/removeFromReading`, {
          method: "DELETE",
          headers: {
            "Content-type": "application/json",
            Authorization: JSON.parse(localStorage.getItem("tokenStore")).token,
          },
          body: JSON.stringify({
            title: comic.title,
          }),
        });
      }
    },
    async removeFromReadLater(comic) {
      let comicIds = this.readLater.map((comic) => comic.id);

      if (comicIds.includes(comic.id)) {
        this.readLater.splice(comicIds.indexOf(comic.id), 1);

        await fetch(`${process.env.VUE_APP_API_BASE}/api/manhwaLab/removeFromReadLater`, {
          method: "DELETE",
          headers: {
            "Content-type": "application/json",
            Authorization: JSON.parse(localStorage.getItem("tokenStore")).token,
          },
          body: JSON.stringify({
            title: comic.title,
          }),
        });
      }
    },
    async removeFromFinished(comic) {
      let comicIds = this.finished.map((comic) => comic.id);

      if (comicIds.includes(comic.id)) {
        this.finished.splice(comicIds.indexOf(comic.id), 1);

        await fetch(`${process.env.VUE_APP_API_BASE}/api/manhwaLab/removeFromFinished`, {
          method: "DELETE",
          headers: {
            "Content-type": "application/json",
            Authorization: JSON.parse(localStorage.getItem("tokenStore")).token,
          },
          body: JSON.stringify({
            title: comic.title,
          }),
        });
      }
    },
    async removeFromFavourites(comic) {
      let comicIds = this.favourites.map((comic) => comic.id);

      if (comicIds.includes(comic.id)) {
        this.favourites.splice(comicIds.indexOf(comic.id), 1);
        await fetch(`${process.env.VUE_APP_API_BASE}/api/manhwaLab/removeFromFavourites`, {
          method: "DELETE",
          headers: {
            "Content-type": "application/json",
            Authorization: JSON.parse(localStorage.getItem("tokenStore")).token,
          },
          body: JSON.stringify({
            title: comic.title,
          }),
        });
      }
    },
    clearUser() {
      this.username = '';
      this.age = '';
      this.gender ='';
      this.location = '';
      this.lastOnline = '';
      this.joined = '';
      this.description = '';
      this.finished = '';
      this.read = '';
      this.favourites = '';
      this.readLater = '';
    }
  },
});
