/*
 * @Author: Victorzl
 * @Date: 2025-02-23 14:51:43
 * @LastEditors: Victorzl
 * @LastEditTime: 2026-04-17 15:46:11
 * @Description: 请填写简介
 */
export const routers = [
  {
    path: "/",
    name: "Home",
    meta: { title: "首页", requiresAuth: true },
    component: () => import("@/views/HomePage.vue"),
  },
  {
    path: "/user/login",
    name: "userLogin",
    meta: { title: "登录" },
    component: () => import("@/views/user/UserLoginPage.vue"),
  },
  {
    path: "/user/register",
    name: "userRegister",
    meta: { title: "注册" },
    component: () => import("@/views/user/UserRegisterPage.vue"),
  },
  {
    path: "/admin/usermanager",
    name: "userManage",
    meta: { title: "用户管理", requiresAuth: true },
    component: () => import("@/views/admin/UserManagePage.vue"),
  },
];
