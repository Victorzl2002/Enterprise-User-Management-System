/*
 * @Author: Victorzl
 * @Date: 2024-12-30 09:25:56
 * @LastEditors: Victorzl
 * @LastEditTime: 2025-02-23 15:12:26
 * @Description: 请填写简介
 */
import { createRouter, createWebHistory } from "vue-router";
import { routers } from "@/router/routes";

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes: routers,
});

export default router;
