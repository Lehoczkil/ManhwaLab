import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home";
import MangaProfile from "../views/MangaProfile";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },{
    path: "/manga-profile",
    name: "MangaProfile",
    component: MangaProfile,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
