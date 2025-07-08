<template>
    <el-tab-pane label="月度报表" name="reports">
      <el-card shadow="hover">
        <el-form :model="queryForm" label-width="100px">
          <el-form-item label="日期">
            <el-date-picker
              v-model="queryForm.date"
              type="month"
              placeholder="选择月份"
              value-format="YYYY-MM"
            />
            <el-button type="primary" @click="handleQuery" class="btn">查询</el-button>
          </el-form-item>
        </el-form>
        <div class="report-title">{{ queryForm.month }} 月度供电报表({{ queryForm.communityCode }})</div>
        <el-table :data="monthlyData" border style="width: 100%">
          <el-table-column prop="feeMonth" label="月份" />
          <el-table-column prop="communityCode" label="街道名" />
          <el-table-column prop="totalConsume" label="用电量(度)" />
          <el-table-column prop="totalFee" label="总电费(元)" />
        </el-table>
      </el-card>
    </el-tab-pane>
</template>

<script setup>
  import useBureauAdminStore from '@/stores/bureauAdmin'
  import useMainStore from '@/stores/main'
  import { storeToRefs } from 'pinia'
  import { ref } from 'vue'

  const bureauAdminStore = useBureauAdminStore()
  const { monthlyData } = storeToRefs(bureauAdminStore)
  const mainStore = useMainStore
  const { user } = storeToRefs(mainStore)
  const queryForm = ref({
    month: '2025-01',
    // areaCode: user.value.areaCode
    areaCode: 101
  })
  const handleQuery = () => {
    bureauAdminStore.fetchMonthlyData(queryForm)
  }
</script>

<style scoped>
.report-title {
  font-size: 18px;
  font-weight: bold;
  margin-bottom: 20px;
  text-align: center;
}
</style>

git remote add origin https://github.com/HamSamMike/ElectricitySystemProject.git