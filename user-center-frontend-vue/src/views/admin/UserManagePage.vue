<!--
 * @Author: Victorzl
 * @Date: 2026-04-17 15:40:39
 * @LastEditors: Victorzl
 * @LastEditTime: 2026-04-19 20:33:41
 * @Description: 请填写简介
-->
<template>
  <div class="UserManagePage">
    <a-input-search
      v-model:value="username"
      placeholder="请输入用户名搜索"
      enter-button
      @search="onSearch"
    />
    <a-table :columns="columns" :data-source="data">
      <template #bodyCell="{ column, record }">
        <template v-if="column.key === 'userAccount'">
          <a>
            {{ record.userAccount }}
          </a>
        </template>
        <template v-else-if="column.key === 'username'">
          <a>
            {{ record.username }}
          </a>
        </template>
        <template v-else-if="column.key === 'avatar'">
          <a-image :width="32" :src="record.avatar" />
        </template>
        <template v-else-if="column.key === 'gender'">
          <a>
            {{ record.gender === 0 ? "男" : "女" }}
          </a>
        </template>
        <template v-else-if="column.key === 'userRole'">
          <div v-if="record.userRole == 0">
            <a-tag color="blue">普通用户</a-tag>
          </div>
          <div v-else-if="record.userRole == 1">
            <a-tag color="green">管理员</a-tag>
          </div>
          <div v-else>
            <a-tag color="red">未知角色</a-tag>
          </div>
        </template>
        <template v-else-if="column.key === 'userStatus'">
          <a>
            {{ record.userStatus === 0 ? "正常" : "封禁" }}
          </a>
        </template>
        <template v-else-if="column.key === 'createTime'">
          <a>
            {{ dayjs(record.createTime).format("YYYY-MM-DD HH:mm:ss") }}
          </a>
        </template>
        <template v-else-if="column.key === 'action'">
          <a-button type="primary" danger @click="deleteUser(record)">
            删除
          </a-button>
        </template>
      </template>
    </a-table>
  </div>
</template>
<script setup lang="ts" name="">
import { ref, onMounted } from "vue";
import { useUserLoginStore } from "@/stores/userLoginStore";
import dayjs from "dayjs";
const columns = [
  {
    title: "账号",
    dataIndex: "userAccount",
    key: "userAccount",
  },
  {
    title: "用户名",
    dataIndex: "username",
    key: "username",
  },
  {
    title: "头像",
    dataIndex: "avatar",
    key: "avatar",
  },
  {
    title: "性别",
    key: "gender",
    dataIndex: "gender",
  },
  {
    title: "角色",
    key: "userRole",
    dataIndex: "userRole",
  },
  {
    title: "状态",
    key: "userStatus",
    dataIndex: "userStatus",
  },
  {
    title: "创建时间",
    key: "createTime",
    dataIndex: "createTime",
  },
  {
    title: "Action",
    key: "action",
  },
];
const userLoginStore = useUserLoginStore();
const username = ref("");
const data = ref([]);

const loadUsers = async (username: string) => {
  try {
    const response = await userLoginStore.fetchUsers(username);
    data.value = response; // 假设后端返回的数据在 response.data 中
  } catch (error) {
    console.error("搜索用户失败:", error);
  }
};
onMounted(() => {
  loadUsers("");
});

const onSearch = () => {
  loadUsers(username.value);
};

const deleteUser = async (record) => {
  try {
    await userLoginStore.deleteUser(record.id);
    // 从数据源中移除被删除的用户
    data.value = data.value.filter((user) => user.id !== record.id);
  } catch (error) {
    console.error("删除用户失败:", error);
  }
};
</script>
<style lang="scss" scoped></style>
