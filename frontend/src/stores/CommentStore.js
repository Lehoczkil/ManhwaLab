import { defineStore } from "pinia";

export const useCommentStore = defineStore("commentStore", {
  state: () => ({
    comments: [],
  }),
  actions: {
    async getComments(comicId) {
      const comments = await fetch(`/api/manhwaLab/comments/${comicId}`);
      this.comments = await comments.json();
    },
    async addComment(text, comicId) {
      await fetch(`/api/manhwaLab/add-comment/${comicId}`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Authorization: JSON.parse(localStorage.getItem("tokenStore")).token,
        },
        body: JSON.stringify({
          title: text
        })
      });
      this.getComments(comicId)
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
      this.getComments(comicId)
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
      this.getComments(comicId)
    },
  },
});
