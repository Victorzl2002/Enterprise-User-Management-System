<!--
 * @Author: Victorzl
 * @Date: 2025-01-01 13:41:27
 * @LastEditors: Victorzl
 * @LastEditTime: 2025-01-01 15:08:09
 * @Description: 请填写简介
-->
<template>
  <div id="GlobalHeader">
    <a-row :wrap="false">
      <a-col flex="200px"
        ><div class="title-bar">
          <img class="logo" src="../assets/logo.png" alt="logo" />
          <div class="title">用户中心</div>
        </div>
      </a-col>
      <a-col flex="auto">
        <a-menu
          v-model:selectedKeys="current"
          mode="horizontal"
          :items="items"
          @click="MenueClick"
        />
      </a-col>
      <a-col flex="100px">
        <div class="user-login-status">
          <a-button type="primary">登录</a-button>
        </div>
      </a-col>
    </a-row>
  </div>
</template>
<script lang="ts" setup>
import { h, ref } from "vue";
import {
  MailOutlined,
  AppstoreOutlined,
  SettingOutlined,
} from "@ant-design/icons-vue";
import { MenuProps } from "ant-design-vue";
import { useRouter } from "vue-router";

const router = useRouter();

const MenueClick = ({ key }: { key: string }) => {
  router.push({ path: key });
};

const current = ref<string[]>(["/"]);
router.afterEach((to) => {
  current.value = [to.path];
});

const items = ref<MenuProps["items"]>([
  {
    key: "/",
    icon: () => h(MailOutlined),
    label: "主页",
    title: "主页",
  },
  {
    key: "/user/login",
    icon: () => h(AppstoreOutlined),
    label: "用户登录",
    title: "用户登录",
  },
  {
    key: "/user/register",
    icon: () => h(SettingOutlined),
    label: "用户注册",
    title: "用户注册",
  },
  {
    key: "alipay",
    label: h(
      "a",
      { href: "https://antdv.com", target: "_blank" },
      "Navigation Four - Link"
    ),
    title: "Navigation Four - Link",
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
</style>
