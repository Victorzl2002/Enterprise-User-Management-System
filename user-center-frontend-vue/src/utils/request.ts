/*
 * @Author: Victorzl
 * @Date: 2025-01-01 15:16:51
 * @LastEditors: Victorzl
 * @LastEditTime: 2026-04-10 10:51:43
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
  return response.data;
});

export default myAxios;
