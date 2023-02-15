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

      this.username = user.username !== null ? user.username : "Not known" ;
      this.age = user.age !== null ? user.age : "Not known" ;
      this.gender = user.gender !== null ? user.gender : "Not known" ;
      this.location = user.location !== null ? user.location : "Not known" ;
      this.lastOnline = user.lastOnline !== null ? user.lastOnline : "Not known" ;
      this.joined = user.joined !== null ? user.joined : "Not known" ;
      this.description = user.description !== null ? user.description : "There is no description" ;
      this.finished = user.finished !== null ? user.finished: "Nothing here" ;
      this.read = user.read !== null ? user.read: "Nothing here" ;
      this.favourites = user.favourites !== null ? user.favourites: "Nothing here" ;
      this.readLater = user.readLater !== null ? user.readLater: "Nothing here" ;
    },
  },
});
