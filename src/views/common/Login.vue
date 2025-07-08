<template>
  <div class="login-container">
    <el-card class="login-card">
      <template #header>
        <div class="card-header">
          <span>电力管理系统登录</span>
        </div>
      </template>
      
      <el-form :model="loginForm" :rules="rules" ref="loginFormRef">
        <el-form-item prop="username">
          <el-input v-model="loginForm.username" placeholder="请输入姓名"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input v-model="loginForm.password" placeholder="请输入密码" show-password></el-input>
        </el-form-item>
        <el-form-item prop="role">
          <el-radio-group v-model="loginForm.role">
            <el-radio label="user">普通用户</el-radio>
            <el-radio label="headAdmin">总局管理员</el-radio>
            <el-radio label="bureauAdmin">分局管理员</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="handleLogin" style="width: 100%">登录</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { ElMessage } from 'element-plus'
import axios from 'axios'
import useMainStore from '@/stores/main'
import { storeToRefs } from 'pinia'

const router = useRouter()
const mainStore = useMainStore()
const loginFormRef = ref(null)

const loginForm = ref({
  username: '',
  password: '',
  role: 'user',
})

const rules = {
  name: [{ required: true, message: '请输入姓名', trigger: 'blur' }],
  password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
  role: [{ required: true, message: '请选择身份', trigger: 'change' }]
}

const handleLogin = () => {
  loginFormRef.value.validate(async (valid) => {
    if (valid) {
      // const response = await axios.post('/api/auth/login', {
      //   userName: loginForm.value.username,
      //   userPasswd : loginForm.value.password
      // })
      // const { token, user } = response.data
      // mainStore.token = token
      // mainStore.user = user
      //暂时模拟一个数据
      const { user } = storeToRefs(mainStore)
      // user.value = {
      //   userName: '张三',
      //   userCode: '1000000001',
      //   userPasswd: '123',
      //   areaCode: "101",
      //   communityCode: "10101",
      //   balance: '234.8',
      //   type: '0',
      // }
      // user.value = {
      //   userName: '杨云',
      //   userCode: '1000000002',
      //   userPasswd: '111',
      //   areaCode: "101",
      //   communityCode: "10101",
      //   type: '1',
      // }
      user.value = {
        userName: '李四',
        userCode: '1000000003',
        userPasswd: '222',
        areaCode: "101",
        communityCode: "10101",
        type: '2',
      }
      mainStore.isAuthenticated = true
      switch (user.value.type) {
        case '0':
          router.push('/user')
          break
        case '1':
          router.push('/head-admin')
          break
        case '2':
          router.push('/bureau-admin')
          break
      }
    } else {
      ElMessage.error('用户名、密码或身份错误')
    }
  })
}

</script>

<style scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f5f7fa;
}

.login-card {
  position: fixed;
  top: 20%;
  width: 400px;
}
</style>