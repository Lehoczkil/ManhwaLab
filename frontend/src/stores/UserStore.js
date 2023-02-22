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
      const response = await fetch("/api/manhwaLab/profile", {
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
      await fetch("/api/manhwaLab/updateUser", {
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
      if (!this.read.includes(comic)) {
        this.read.push(comic);
        await fetch("/api/manhwaLab/addToReading", {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
            Authorization: JSON.parse(localStorage.getItem("tokenStore")).token,
          },
          body: JSON.stringify({
            comic: comic,
          }),
        });
      }
    },
    async updateLater(comic) {
      if (!this.readLater.includes(comic)) {
        this.readLater.push(comic);
        await fetch("/api/manhwaLab/addToReadLater", {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
            Authorization: JSON.parse(localStorage.getItem("tokenStore")).token,
          },
          body: JSON.stringify({
            comic: comic,
          }),
        });
      }
    },
    async updateFinished(comic) {
      if (!this.finished.includes(comic)) {
        this.finished.push(comic);
        await fetch("/api/manhwaLab/addToFinished", {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
            Authorization: JSON.parse(localStorage.getItem("tokenStore")).token,
          },
          body: JSON.stringify({
            comic: comic,
          }),
        });
      }
    },
    async updateFavourites(comic) {
      if (!this.favourites.includes(comic)) {
        this.favourites.push(comic);
        await fetch("/api/manhwaLab/addToFavourites", {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
            Authorization: JSON.parse(localStorage.getItem("tokenStore")).token,
          },
          body: JSON.stringify({
            comic: comic,
          }),
        });
      }
    },
  },
});
