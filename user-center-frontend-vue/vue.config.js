/*
 * @Author: Victorzl
 * @Date: 2025-02-23 15:24:58
 * @LastEditors: Victorzl
 * @LastEditTime: 2025-04-01 13:41:26
 * @Description: 请填写简介
 */
module.exports = {
  css: {
    loaderOptions: {
      sass: {
        additionalData: `@import "@/style/variables.scss";`,
      },
    },
  },
};
