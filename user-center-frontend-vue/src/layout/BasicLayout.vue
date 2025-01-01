<!--
 * @Author: Victorzl
 * @Date: 2024-12-30 10:08:02
 * @LastEditors: Victorzl
 * @LastEditTime: 2025-01-01 13:54:08
 * @Description: 请填写简介
-->
<template>
  <div id="basic-layout">
    <a-layout>
      <a-layout-header class="header">
        <GlobalHeader />
      </a-layout-header>
      <a-layout-content class="content">
        <router-view />
      </a-layout-content>
      <a-layout-footer class="footer">
        <a href="https://blog.victorzl.top/github" target="_blank"
          >作者github</a
        >
      </a-layout-footer>
    </a-layout>
  </div>
</template>
<script setup lang="ts">
import GlobalHeader from "@/components/GlobalHeader.vue";
</script>
<style scoped>
#basic-layout .footer {
  text-align: center;
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
}

#basic-layout .content {
  padding: 20px;
  margin-bottom: 20px;
  background: linear-gradient(to right, #fff, #fff);
}

#basic-layout .header {
  background-color: #fff;
  color: unset;
  padding-inline: 20px;
  margin-bottom: 16px;
}
</style>
