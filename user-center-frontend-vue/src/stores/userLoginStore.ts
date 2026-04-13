/*
 * @Author: Victorzl
 * @Date: 2025-04-04 21:14:06
 * @LastEditors: Victorzl
 * @LastEditTime: 2026-04-10 17:09:02
 * @Description: 请填写简介
 */
import {
  UserLoginRequest,
  UserLoginResponse,
  UserRegisterRequest,
} from "@/api/user/types";
import {
  userCurrent,
  userLogin,
  userLogout,
  userRegister,
} from "@/api/user/user";
import { message } from "ant-design-vue";
import { defineStore } from "pinia";

export const useUserLoginStore = defineStore("userLogin", {
  state: () => {
    return { userLoginInfo: null as UserLoginResponse | null };
  },
  actions: {
    fetchLogin(params: UserLoginRequest) {
      return userLogin(params).then((res) => {
        if (!res) {
          throw new Error("登录失败，请检查账号密码");
        }
        this.userLoginInfo = res;
        message.success("登录成功");
        return res;
      });
    },
    fetchRegister(params: UserRegisterRequest) {
      return userRegister(params).then((res) => {
        message.success("注册成功");
        return res;
      });
    },
    fetchCurrent() {
      return userCurrent().then((res) => {
        this.userLoginInfo = res;
        return res;
      });
    },
    async logout() {
      try {
        await userLogout(); // 先让后端销毁 session
      } finally {
        this.userLoginInfo = null; // 无论成功失败都清本地，保证前端退出
      }
    },
  },
});
