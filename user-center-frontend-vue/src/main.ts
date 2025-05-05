/*
 * @Author: Victorzl
 * @Date: 2024-12-30 09:25:56
 * @LastEditors: Victorzl
 * @LastEditTime: 2025-04-03 09:49:41
 * @Description: 请填写简介
 */
import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import Antd from "ant-design-vue";
import pinia from "@/stores";
import "ant-design-vue/dist/reset.css";
//引入全局样式
import "@/style/index.scss";
createApp(App).use(Antd).use(router).use(pinia).mount("#app");
