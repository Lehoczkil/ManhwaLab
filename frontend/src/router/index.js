import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home";
import ComicProfile from "../views/ComicProfile";
import UserProfile from "../views/UserProfile";
import Browser from "../views/Browser";
const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/comics/:id",
    props: true,
    component: ComicProfile,
  },
  {
    path: "/user-profile",
    name: "UserProfile",
    component: UserProfile,
  },
  {
    path: "/comics",
    name: "Browser",
    component: Browser,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
