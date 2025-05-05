/*
 * @Author: Victorzl
 * @Date: 2025-02-23 14:51:43
 * @LastEditors: Victorzl
 * @LastEditTime: 2025-04-05 10:49:42
 * @Description: 请填写简介
 */
export const routers = [
  {
    path: "/",
    name: "Home",
    component: () => import("@/views/HomePage.vue"),
  },
  {
    path: "/user/login",
    name: "userLogin",
    component: () => import("@/views/user/UserLoginPage.vue"),
  },
  {
    path: "/user/register",
    name: "userRegister",
    component: () => import("@/views/user/UserRegisterPage.vue"),
  },
];
