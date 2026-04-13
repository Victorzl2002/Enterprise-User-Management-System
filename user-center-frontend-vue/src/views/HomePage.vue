<!--
 * @Author: Victorzl
 * @Date: 2025-04-04 16:03:01
 * @LastEditors: Victorzl
 * @LastEditTime: 2026-04-10 16:15:00
 * @Description: 请填写简介
-->
<template>
  <div class="home-page">
    <a-card class="welcome-card" :bordered="false">
      <template #title>
        <div class="welcome-title">欢迎回来，{{ currentAccount }}</div>
      </template>

      <p class="welcome-subtitle">你已成功登录用户中心管理平台。</p>

      <a-row :gutter="[16, 16]" class="stat-grid">
        <a-col :xs="24" :sm="12" :md="8">
          <a-card size="small">
            <a-statistic title="当前账号" :value="currentAccount" />
          </a-card>
        </a-col>
        <a-col :xs="24" :sm="12" :md="8">
          <a-card size="small">
            <a-statistic title="账号状态" :value="currentStatusText" />
          </a-card>
        </a-col>
        <a-col :xs="24" :sm="12" :md="8">
          <a-card size="small">
            <a-statistic title="角色" :value="currentRoleText" />
          </a-card>
        </a-col>
      </a-row>

      <div class="actions">
        <a-space>
          <a-button type="primary" @click="goRegister">注册新用户</a-button>
          <a-button danger @click="handleLogout">退出登录</a-button>
        </a-space>
      </div>
    </a-card>
  </div>
</template>
<script setup lang="ts">
import { computed } from "vue";
import { useRouter } from "vue-router";
import { message } from "ant-design-vue";
import { useUserLoginStore } from "@/stores/userLoginStore";

const router = useRouter();
const userLoginStore = useUserLoginStore();
const currentUser = computed(() => userLoginStore.userLoginInfo);
const currentAccount = computed(() => currentUser.value?.userAccount ?? "-");
const currentStatusText = computed(() =>
  currentUser.value
    ? currentUser.value.userStatus === 0
      ? "正常"
      : "异常"
    : "-"
);
const currentRoleText = computed(() =>
  currentUser.value
    ? currentUser.value.userRole === 0
      ? "普通用户"
      : "管理员"
    : "-"
);

const goRegister = () => {
  router.push("/user/register");
};

const handleLogout = () => {
  userLoginStore.logout();
  message.success("已退出登录");
  router.push("/user/login");
};
</script>

<style lang="scss" scoped>
.home-page {
  width: min(1000px, 100%);
}

.welcome-card {
  border-radius: 12px;
}

.welcome-title {
  font-size: 24px;
  font-weight: 600;
}

.welcome-subtitle {
  color: #595959;
  margin-bottom: 20px;
}

.stat-grid {
  margin-bottom: 24px;
}

.actions {
  display: flex;
  justify-content: flex-end;
}
</style>
