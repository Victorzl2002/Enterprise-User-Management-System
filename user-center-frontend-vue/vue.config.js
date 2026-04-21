/*
 * @Author: Victorzl
 * @Date: 2025-02-23 15:24:58
 * @LastEditors: Victorzl
 * @LastEditTime: 2026-04-16 22:31:36
 * @Description: 请填写简介
 */
module.exports = {
  devServer: {
    proxy: {
      "/api": {
        target: "http://localhost:8080",
        changeOrigin: true,
        pathRewrite: { "^/api": "" },
      },
    },
  },
  css: {
    loaderOptions: {
      sass: {
        additionalData: `@use "@/style/variables.scss" as *;`,
      },
    },
  },
};
