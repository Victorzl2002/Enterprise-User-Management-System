/*
 * @Author: Victorzl
 * @Date: 2025-01-01 15:16:51
 * @LastEditors: Victorzl
 * @LastEditTime: 2025-01-01 16:17:05
 * @Description: 请填写简介
 */
import axios from "axios";
const myAxios = axios.create({
  baseURL: "http://localhost:8080",
  timeout: 5000,
});
