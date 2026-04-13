/*
 * @Author: Victorzl
 * @Date: 2025-01-01 15:17:44
 * @LastEditors: Victorzl
 * @LastEditTime: 2026-04-10 16:31:48
 * @Description: 请填写简介
 */
import myAxios from "@/utils/request";
import {
  UserLoginRequest,
  UserLoginResponse,
  UserRegisterRequest,
} from "./types";

export const userLogin = async (data: UserLoginRequest) => {
  return myAxios.request<unknown, UserLoginResponse>({
    method: "POST",
    url: "/login",
    data: data,
  });
};

export const userRegister = async (data: UserRegisterRequest) => {
  return myAxios({
    method: "POST",
    url: "/register",
    data: data,
  });
};

export const userCurrent = () => {
  return myAxios.get<unknown, UserLoginResponse>("/current");
};

export const userLogout = () => {
  return myAxios.post("/logout");
};
