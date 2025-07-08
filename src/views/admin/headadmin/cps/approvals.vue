<template>
  <div class="approvals">
    <el-tab-pane label="供电审批" name="approvals">
        <el-card shadow="hover">
          <el-table stripe :data="approveData" border style="width: 100%">
            <el-table-column prop="areaCode" label="区域" />
            <el-table-column prop="communityCode" label="街道" />
            <el-table-column prop="date" label="供电日期" />
            <el-table-column prop="amount" label="供电量(度)" />
            <el-table-column label="操作" width="180">
              <template #default="{row}">
                <el-button type="success" size="small" @click="approveApplication(row.adminCode)">批准</el-button>
                <el-button type="danger" size="small" @click="rejectApplication(row.adminCode)">拒绝</el-button>
              </template>
            </el-table-column>
          </el-table>
        </el-card>
      </el-tab-pane>
  </div>
</template>

<script setup>
  import useHeadAdminStore from '@/stores/headAdmin';
  import useMainStore from '@/stores/main'
  import { storeToRefs } from 'pinia'
  import { ref, onMounted, onUpdated } from 'vue'
  import { ElMessage } from 'element-plus'

  const headAdminStore = useHeadAdminStore()
  const { approveData } = storeToRefs(headAdminStore)
  onMounted(() => {
    headAdminStore.fetchApproveData()
  })
  onUpdated(() => {
    
  })
  const findAreaName = (code) => {
  const item = areaList.value.find(item => item.areaCode === code)
  return item ? item.areaName : 0
  }
  const findCommunity = (code) => {
    const item = communityList.value.find(item => item.communityCode === code)
    return item ? item.communityName : 0
  }
  const approveApplication = (code) => {
    // 实际项目中这里应该是API调用
    const res = headAdminStore.approveApplication(code)
    if(true) {
      ElMessage.success('已批准申请')
    }
  }

  const rejectApplication = (code) => {
    // 实际项目中这里应该是API调用
    const res = headAdminStore.rejectApplication(code)
    if(true) {
      ElMessage.success('已拒绝申请')
    }
  }

</script>

<style scoped>

</style>