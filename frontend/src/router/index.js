import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home";
import MangaProfile from "../views/MangaProfile";
import UserProfile from "../views/UserProfile";
import Comics from "../views/Comics";
import Recommendations from "../views/Recommendations";
import { nextTick } from "vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/comics/:id",
    props: true,
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

router.afterEach((to) => {
  console.log("Navigated to: ", to.path);
  nextTick().then(() => {
    console.log('actual navigated to')
  })
});

export default router;
