/*
 * @Author: Victorzl
 * @Date: 2025-01-01 15:17:44
 * @LastEditors: Victorzl
 * @LastEditTime: 2025-01-01 15:20:34
 * @Description: 请填写简介
 */
import myAxios from "@/request";
export const userRequest = async (params: unknown) => {
  return myAxios({
    method: "POST",
    url: "/user",
    data: params,
  });
};
