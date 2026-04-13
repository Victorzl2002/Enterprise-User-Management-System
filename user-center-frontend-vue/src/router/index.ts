/*
 * @Author: Victorzl
 * @Date: 2024-12-30 09:25:56
 * @LastEditors: Victorzl
 * @LastEditTime: 2026-04-10 17:05:57
 * @Description: 请填写简介
 */
import { createRouter, createWebHistory } from "vue-router";
import { routers } from "@/router/routes";
import { useUserLoginStore } from "@/stores/userLoginStore";
import { message } from "ant-design-vue";

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes: routers,
});

router.beforeEach(async (to) => {
  const userLoginStore = useUserLoginStore();
  // 白名单页面直接放行
  if (!to.meta.requiresAuth) return true;

  if (userLoginStore.userLoginInfo) {
    return true;
  }

  // 刷新后尝试向后端确认当前登录态（session）
  try {
    await userLoginStore.fetchCurrent();
    return true;
  } catch (error) {
    // 未登录则跳登录页，并带上回跳地址
    message.warning("已过期，请先登录");
    return {
      path: "/user/login",
      query: { redirect: to.fullPath },
    };
  }
});

export default router;
