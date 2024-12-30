/*
 * @Author: Victorzl
 * @Date: 2024-12-30 09:25:56
 * @LastEditors: Victorzl
 * @LastEditTime: 2024-12-30 09:49:06
 * @Description: 请填写简介
 */
import { createApp } from "../node_modules/vue";
import App from "./App.vue";
import router from "./router";
import Antd from "../node_modules/ant-design-vue";
import "ant-design-vue/dist/reset.css";

createApp(App).use(Antd).use(router).mount("#app");
