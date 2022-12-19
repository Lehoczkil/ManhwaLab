import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home";
import MangaProfile from "../views/MangaProfile";
import UserProfile from "../views/UserProfile";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/manga-profile",
    name: "MangaProfile",
    component: MangaProfile,
  },
  {
    path: "/user-profile",
    name: "UserProfile",
    component: UserProfile,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
