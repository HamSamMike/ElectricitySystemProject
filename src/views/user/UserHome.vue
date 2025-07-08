<template>
  <div class="user-home">
    <DateDisplay />
    
    <UserInfo />
    
    <el-card shadow="hover" class="electric-query">
      <template #header>
        <div class="card-header">
          <span>用电查询</span>
        </div>
      </template>
      
      <el-form :model="queryForm" label-width="100px">
        <el-form-item label="日期">
          <el-date-picker
            v-model="queryForm.Date"
            type="month"
            placeholder="选择月份"
            value-format="YYYY-MM"
          />
          <el-button type="primary" @click="handleQuery" class="btn">查询</el-button>
        </el-form-item>
      </el-form>
      
      <el-table :data="electricData" border style="width: 100%; margin-top: 20px">
        <el-table-column prop="date" label="日期" width="180" />
        <el-table-column prop="usage" label="用电量(度)" width="180" />
        <el-table-column prop="cost" label="电费(元)" />
      </el-table>
    </el-card>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import useMainStore from '../../stores/main'
import DateDisplay from '../../components/DateDisplay.vue'
import UserInfo from '../../components/UserInfo.vue'
import { storeToRefs } from 'pinia'

const mainStore = useMainStore()
const { user } = storeToRefs(mainStore)

const queryForm = ref({
  Date: ''
})

const handleQuery = () => {
  // 实际项目中这里应该是API调用
  
}
</script>

<style scoped>
.user-home {
  padding: 20px;
}

.electric-query {
  margin-top: 20px;
}
.btn {
  margin-left: 20px;
}
</style>