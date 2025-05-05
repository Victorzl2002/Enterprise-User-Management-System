/*
 * @Author: Victorzl
 * @Date: 2025-01-01 15:17:44
 * @LastEditors: Victorzl
 * @LastEditTime: 2025-02-23 14:51:12
 * @Description: 请填写简介
 */
import myAxios from "@/utils/request";
export const userRequest = async (params: unknown) => {
  return myAxios({
    method: "POST",
    url: "/api/user/login",
    data: params,
  });
};
