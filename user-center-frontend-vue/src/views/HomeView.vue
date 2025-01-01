<!--
 * @Author: Victorzl
 * @Date: 2024-12-30 09:25:56
 * @LastEditors: Victorzl
 * @LastEditTime: 2025-01-01 14:02:40
 * @Description: 请填写简介
-->
<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png" />
    <HelloWorld msg="Welcome to Your Vue.js + TypeScript App" />
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import HelloWorld from "@/components/HelloWorld.vue"; // @ is an alias to /src

export default defineComponent({
  name: "HomeView",
  components: {
    HelloWorld,
  },
});
</script>
