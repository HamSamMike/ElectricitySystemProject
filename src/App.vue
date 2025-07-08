<template>
  <el-container>
    <el-header class="header">
      <div class="header-left">
        <span class="system-name">电力管理系统</span>
      </div>
      <div v-if="mainStore.isAuthenticated === true" class="header-right">
        <span class="user-info">欢迎, {{ user.userName }} ({{ userRoleText }})</span>
        <el-button type="danger" size="small" @click="handleLogout">退出登录</el-button>
      </div>
      <div v-else-if="mainStore.isAuthenticated === false" class="header-right">
        <span class="user-info">请登录</span>
      </div>
    </el-header>
    
    <el-main>
      <router-view />
    </el-main>
  </el-container>
</template>

<script setup>
import { useRouter } from 'vue-router'
import useMainStore from './stores/main'
import { storeToRefs } from 'pinia'

const router = useRouter()
const mainStore = useMainStore()
const { user } = storeToRefs(mainStore)

const handleLogout = () => {
  mainStore.logout()
  router.push('/login')
}

</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #409EFF;
  color: white;
  padding: 0 20px;
}

.system-name {
  font-size: 20px;
  font-weight: bold;
}

.user-info {
  margin-right: 15px;
}

.el-main {
  padding: 20px;
}
</style>