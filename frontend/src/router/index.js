import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home";
import MangaProfile from "../views/MangaProfile";
import UserProfile from "../views/UserProfile";
import Comics from "../views/Comics";
import Recommendations from "../views/Recommendations";

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
  {
    path: "/comics",
    name: "Comics",
    component: Comics,
  },
  {
    path: "/recommendations",
    name: "Recommendations",
    component: Recommendations,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
