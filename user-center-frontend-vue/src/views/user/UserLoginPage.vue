<!--
 * @Author: Victorzl
 * @Date: 2025-02-23 15:09:59
 * @LastEditors: Victorzl
 * @LastEditTime: 2026-04-10 16:49:39
 * @Description: 请填写简介
-->
<template>
  <div class="LoginPage">
    <div class="titleHeader">
      <img src="../../assets/logo.png" alt="" />
      <span class="title">用户中心管理平台</span>
    </div>
    <a-form
      class="userLoginForm"
      :model="formState"
      name="basic"
      autocomplete="off"
      @finish="handleSubmit"
      @finishFailed="onFinishFailed"
    >
      <a-form-item
        label="账号"
        name="userAccount"
        :rules="[{ required: true, message: '请输入账号' }]"
      >
        <a-input v-model:value="formState.userAccount" />
      </a-form-item>

      <a-form-item
        label="密码"
        name="userPassword"
        :rules="[{ required: true, message: '请输入密码' }]"
      >
        <a-input-password v-model:value="formState.userPassword" />
      </a-form-item>

      <a-form-item>
        <a-button type="primary" html-type="submit">登录</a-button>
      </a-form-item>
    </a-form>
  </div>
</template>
<script lang="ts">
export default {
  name: "UserLoginPage",
};
</script>
<script setup lang="ts">
import { reactive } from "vue";
import { useUserLoginStore } from "@/stores/userLoginStore";
import { useRouter } from "vue-router";
import { message } from "ant-design-vue";

interface FormState {
  userAccount: string;
  userPassword: string;
}

const userLoginStore = useUserLoginStore();
const router = useRouter();

const formState = reactive<FormState>({
  userAccount: "",
  userPassword: "",
});

const handleSubmit = (values: unknown) => {
  userLoginStore
    .fetchLogin({
      userAccount: formState.userAccount,
      userPassword: formState.userPassword,
    })
    .then(() => {
      router.push({ path: "/" });
    })
    .catch((error) => {
      message.error(error.message);
    });
};

const onFinishFailed = (errorInfo: unknown) => {
  console.log("Failed:", errorInfo);
};
</script>

<style lang="scss" scoped>
.LoginPage {
  width: 1000px;
  display: flex;
  flex-direction: column;
  text-align: center;
  justify-content: center;
  .titleHeader {
    margin-bottom: 100px;
    display: flex;
    align-items: center;
    justify-content: center;
    img {
      width: 60px;
    }
    .title {
      font-size: 40px;
    }
  }
  .userLoginForm {
    width: 50%;
    margin: 0 auto;
  }
}
</style>
