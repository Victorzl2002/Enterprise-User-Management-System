/*
 * @Author: Victorzl
 * @Date: 2026-04-10 10:10:44
 * @LastEditors: Victorzl
 * @LastEditTime: 2026-04-10 11:35:12
 * @Description: 请填写简介
 */
export type UserLoginRequest = {
  userAccount: string;
  userPassword: string;
};

export type UserRegisterRequest = {
  userAccount: string;
  userPassword: string;
  checkPassword: string;
};

export type UserLoginResponse = {
  id: number;
  userAccount: string;
  username: string;
  userPassword: string | null;
  avatar: string | null;
  createTime: string; // ISO 时间字符串
  email: string | null;
  gender: number | null;
  isDelect: number | null;
  updateTime: string | null;
  userRole: number;
  userStatus: number;
};
