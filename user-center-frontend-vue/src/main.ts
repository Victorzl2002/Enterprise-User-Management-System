/*
 * @Author: Victorzl
 * @Date: 2024-12-30 09:25:56
 * @LastEditors: Victorzl
 * @LastEditTime: 2026-04-09 22:57:14
 * @Description: 请填写简介
 */
import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import Antd from "ant-design-vue";
import pinia from "@/stores";
//引入全局样式
import "@/style/index.scss";
createApp(App).use(Antd).use(router).use(pinia).mount("#app");
