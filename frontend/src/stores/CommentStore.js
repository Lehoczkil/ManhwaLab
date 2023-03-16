import { defineStore, storeToRefs } from "pinia";
import { useComicStore } from "./ComicStore";

export const useCommentStore = defineStore("commentStore", {
  state: () => ({
    comments: [],
  }),
  actions: {
    async getComments(comicId) {
      const comicStore = useComicStore;
      const { currentComic } = storeToRefs(comicStore);
      const comicId = currentComic.comicId;

      const comments = await fetch(`api/manhwaLab/comments/${comicId}`);
      this.comments = comments.json();
    },
    async addComment(text, type, comicId) {
      await fetch(`/api/manhwaLab/add-comment/${comicId}`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Authorization: JSON.parse(localStorage.getItem("tokenStore")).token,
        },
        body: JSON.stringify({
          commentType: type,
          text: text,
        }),
      });
      this.getComments()
    },
    async editComment(text, comicId) {
      await fetch(`/api/manhwaLab/edit-comment/${comicId}`, {
        method: "PATCH",
        headers: {
          "Content-Type": "application/json",
          Authorization: JSON.parse(localStorage.getItem("tokenStore")).token,
        },
        body: JSON.stringify({
          text: text,
        }),
      });
      this.getComments()
    },
    async removeComment(commentId, comicId) {
      await fetch(`/api/manhwaLab/remove-comment/${comicId}`, {
        method: "DELETE",
        headers: {
          "Content-Type": "application/json",
          Authorization: JSON.parse(localStorage.getItem("tokenStore")).token,
        },
        body: JSON.stringify({
            commentId: commentId
        })
      });
      this.getComments()
    },
  },
});
