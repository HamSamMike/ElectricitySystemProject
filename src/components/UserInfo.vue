<template>
  <el-card shadow="hover" class="user-info">
    <template #header>
      <div class="card-header">
        <span>个人信息</span>
      </div>
    </template>
    <el-descriptions :column="1" border>
      <el-descriptions-item label="用户编号">{{ user.userCode }}</el-descriptions-item>
      <el-descriptions-item label="姓名">{{ user.userName }}</el-descriptions-item>
      <el-descriptions-item label="街道号">{{ user.communityCode }}</el-descriptions-item>
      <el-descriptions-item label="区域号">{{ user.areaCode }}</el-descriptions-item>
      <el-descriptions-item label="账户余额">
        {{ user.balance }} 元
        <el-button type="primary" size="small" @click="showRechargeDialog">充值</el-button>
      </el-descriptions-item>
    </el-descriptions>

    <el-dialog v-model="rechargeDialogVisible" title="账户充值" width="30%">
      <el-form :model="rechargeForm">
        <el-form-item label="充值金额">
          <el-input v-model.number="rechargeForm.amount" type="number"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="rechargeDialogVisible = false">取消</el-button>
        <el-button type="primary" @click="handleRecharge">确认</el-button>
      </template>
    </el-dialog>
  </el-card>
</template>

<script setup>
import { ref } from 'vue'
import useMainStore from '@/stores/main'
import { storeToRefs } from 'pinia'

const mainStore = useMainStore()
const { user } = storeToRefs(mainStore)

const rechargeDialogVisible = ref(false)
const rechargeForm = ref({
  amount: 0
})

const showRechargeDialog = () => {
  rechargeDialogVisible.value = true
}

const handleRecharge = () => {
  // 实际项目中这里应该是API调用
  
  rechargeDialogVisible.value = false
  rechargeForm.value.amount = 0
}

</script>

<style scoped>
.user-info {
  margin-bottom: 20px;
}
</style>