/*
 * @Author: Victorzl
 * @Date: 2025-01-01 15:16:51
 * @LastEditors: Victorzl
 * @LastEditTime: 2025-04-03 09:20:52
 * @Description: 请填写简介
 */
import axios from "axios";
const myAxios = axios.create({
  baseURL: "http://localhost:8080",
  timeout: 5000,
});

myAxios.interceptors.request.use((config) => {
  return config;
});

myAxios.interceptors.response.use((response) => {
  return response.data;
});

export default myAxios;
