<!--
 * @Author: Victorzl
 * @Date: 2025-04-05 10:48:31
 * @LastEditors: Victorzl
 * @LastEditTime: 2025-04-05 10:50:31
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
        name="username"
        :rules="[{ required: true, message: '请输入账号' }]"
      >
        <a-input v-model:value="formState.username" />
      </a-form-item>

      <a-form-item
        label="密码"
        name="password"
        :rules="[{ required: true, message: '请输入密码' }]"
      >
        <a-input-password v-model:value="formState.password" />
      </a-form-item>

      <a-form-item
        label="确认"
        name="password"
        :rules="[{ required: true, message: '请输入确认密码' }]"
      >
        <a-input-password v-model:value="formState.password" />
      </a-form-item>

      <a-form-item>
        <a-button type="primary" html-type="submit">注册</a-button>
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
import { reactive, ref } from "vue";
import { useUserLoginStore } from "@/stores/userLoginStore";
import { useRouter } from "vue-router";

interface FormState {
  username: string;
  password: string;
  remember: boolean;
}

const userLoginStore = useUserLoginStore();
const router = useRouter();

const formState = reactive<FormState>({
  username: "",
  password: "",
  remember: true,
});

const handleSubmit = (values: unknown) => {
  userLoginStore.fetchLogin();
  router.push("/");
};

const onFinishFailed = (errorInfo: any) => {
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
