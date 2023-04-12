import { defineStore } from "pinia";
import { useUserStore } from "./UserStore";

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
          title: text,
        }),
      });
      this.getComments(comicId);
    },
    async deleteComment(commentId, comicId) {
      await fetch(`/api/manhwaLab/delete-comment/${comicId}`, {
        method: "DELETE",
        headers: {
          "Content-Type": "application/json",
          Authorization: JSON.parse(localStorage.getItem("tokenStore")).token,
        },
        body: JSON.stringify({
          title: commentId,
        }),
      });
      this.getComments(comicId);
    },
    async editComment(commentId, text, comicId) {
      await fetch(`/api/manhwaLab/edit-comment/${comicId}`, {
        method: "PATCH",
        headers: {
          "Content-Type": "application/json",
          Authorization: JSON.parse(localStorage.getItem("tokenStore")).token,
        },
        body: JSON.stringify({
          commentId: commentId,
          text: text,
        }),
      });
      this.getComments(comicId);
    },
    async increaseLike(comicId, commentId, isLike) {
      if (isLike) {
        await fetch(`/api/manhwaLab/like/${commentId}`, {
          method: "PATCH",
          headers: {
            "Content-Type": "application/json",
            Authorization: JSON.parse(localStorage.getItem("tokenStore")).token,
          },
          body: JSON.stringify({
            title: commentId,
          }),
        });
      } else {
        await fetch(`/api/manhwaLab/dislike/${commentId}`, {
          method: "PATCH",
          headers: {
            "Content-Type": "application/json",
            Authorization: JSON.parse(localStorage.getItem("tokenStore")).token,
          }
        });
      }
      this.getComments(comicId);
    },
    isUsersComment(comment) {
      const userStore = useUserStore();
      userStore.getUser();
      return comment.parentUserProfile.username === userStore.username;
    },
  },
});
