/*
 * @Author: Victorzl
 * @Date: 2024-12-30 09:25:56
 * @LastEditors: Victorzl
 * @LastEditTime: 2025-01-01 14:33:46
 * @Description: 请填写简介
 */
import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import HomeView from "../views/HomeView.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
