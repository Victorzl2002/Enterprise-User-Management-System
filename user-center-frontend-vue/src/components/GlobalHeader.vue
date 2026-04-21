<!--
 * @Author: Victorzl
 * @Date: 2025-01-01 13:41:27
 * @LastEditors: Victorzl
 * @LastEditTime: 2026-04-17 15:47:09
 * @Description: 请填写简介
-->
<template>
  <div id="GlobalHeader">
    <a-row :wrap="false" align="middle">
      <!--left-logo-title -->
      <a-col flex="200px">
        <div class="title-bar">
          <img class="logo" src="../assets/logo.png" alt="logo" />
          <div class="title">用户中心</div>
        </div>
      </a-col>

      <!-- middle-menu -->
      <a-col flex="auto">
        <a-menu
          v-model:selectedKeys="current"
          mode="horizontal"
          :items="items"
          @click="MenueClick"
        />
      </a-col>

      <!-- right-button -->
      <a-col flex="180px">
        <div class="user-login-status">
          <div v-if="userLoginStore.userLoginInfo?.userAccount">
            {{ userLoginStore.userLoginInfo.userAccount }}
          </div>
          <div v-else class="login-register-buttons">
            <a-button type="primary" @click="handleLogin">登录</a-button>
            <a-button type="primary" @click="handleRegister">注册</a-button>
          </div>
        </div>
      </a-col>
    </a-row>
  </div>
</template>
<script lang="ts" setup>
import { h, ref } from "vue";
import { MailOutlined, AppstoreOutlined } from "@ant-design/icons-vue";
import { MenuProps } from "ant-design-vue";
import { useRouter } from "vue-router";
import { useUserLoginStore } from "@/stores/userLoginStore";

const router = useRouter();
const userLoginStore = useUserLoginStore();

//菜单项跳转
const MenueClick = ({ key }: { key: string }) => {
  router.push({ path: key });
};

const current = ref<string[]>(["/"]);

router.afterEach((to) => {
  current.value = [to.path];
});

const handleLogin = () => {
  router.push({ path: "/user/login" });
};

const handleRegister = () => {
  router.push({ path: "/user/register" });
};

const items = ref<MenuProps["items"]>([
  {
    key: "/",
    icon: () => h(MailOutlined),
    label: "主页",
    title: "主页",
  },
  {
    key: "/admin/usermanager",
    icon: () => h(AppstoreOutlined),
    label: "用户管理",
    title: "用户管理",
  },
]);
</script>

<style scoped>
.title-bar {
  display: flex;
  align-items: center;
}

.title {
  font-size: 18px;
  color: black;
}

.logo {
  margin-right: 16px;
  height: 48px;
}
.user-login-status {
  display: flex;
  justify-content: flex-end;
  align-items: center;
  height: 100%;
}

.login-register-buttons {
  display: flex;
  flex-direction: row;
  gap: 8px;
  align-items: center;
  justify-content: center;
}
</style>
