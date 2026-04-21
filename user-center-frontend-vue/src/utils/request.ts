/*
 * @Author: Victorzl
 * @Date: 2025-01-01 15:16:51
 * @LastEditors: Victorzl
 * @LastEditTime: 2026-04-20 14:03:52
 * @Description: 请填写简介
 */
import axios from "axios";
const myAxios = axios.create({
  baseURL: "/api",
  timeout: 5000,
});

myAxios.interceptors.request.use((config) => {
  return config;
});

myAxios.interceptors.response.use((response) => {
  const { code, data, message } = response.data;
  if (code == 0) {
    return data;
  }
  throw new Error(message || "请求失败");
});

export default myAxios;
