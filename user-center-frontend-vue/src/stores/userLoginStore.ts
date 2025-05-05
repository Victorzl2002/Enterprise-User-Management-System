/*
 * @Author: Victorzl
 * @Date: 2025-04-04 21:14:06
 * @LastEditors: Victorzl
 * @LastEditTime: 2025-04-05 10:36:42
 * @Description: 请填写简介
 */
import { defineStore } from "pinia";

export const useUserLoginStore = defineStore("userLogin", {
  state: () => {
    return { username: "" };
  },
  actions: {
    fetchLogin() {
      this.username = "zl";
    },
  },
});
