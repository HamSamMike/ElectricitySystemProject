<template>
    <el-tab-pane label="供电申请" name="applications">
      <el-card shadow="hover">
        <el-button type="primary" @click="showApplicationDialog" style="margin-bottom: 20px">新增申请</el-button>
        <el-table :data="approveData" border style="width: 100%">
          <el-table-column prop="date" label="供电日期" />
          <el-table-column prop="areaCode" label="区域" />
          <el-table-column prop="communityCode" label="街道名" />
          <el-table-column prop="amount" label="供电量(度)" />
          <el-table-column prop="status" label="状态">
            <template #default="{row}">
              <el-tag :type="statusTagType(row.status)">
                {{ statusText(row.status) }}
              </el-tag>
            </template>
          </el-table-column>
        </el-table>
      </el-card>
    </el-tab-pane>

    <el-dialog v-model="applicationDialogVisible" title="新增供电申请" width="30%">
      <el-form :model="applicationForm" :rules="applicationRules" ref="applicationFormRef">
        <el-form-item label="街道" prop="street">
          <el-select v-model="applicationForm.street" placeholder="请选择街道">
            <el-option 
              v-for="street in streets" 
              :key="street.name" 
              :label="street.name" 
              :value="street.name"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="供电日期" prop="date">
          <el-date-picker
            v-model="applicationForm.date"
            type="date"
            placeholder="选择日期"
            value-format="YYYY-MM-DD"
          />
        </el-form-item>
        <el-form-item label="供电量(度)" prop="amount">
          <el-input v-model.number="applicationForm.amount" type="number"></el-input>
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="applicationDialogVisible = false">取消</el-button>
        <el-button type="primary" @click="submitApplication">提交</el-button>
      </template>
    </el-dialog>
</template>

<script setup>
  import useBureauAdminStore from '@/stores/bureauAdmin'
  import { storeToRefs } from 'pinia'
  import { ref } from 'vue'

  const bureauAdminStore = useBureauAdminStore()
  const { approveData } = storeToRefs(bureauAdminStore)

  const applicationDialogVisible = ref(false)
  const showApplicationDialog = () => {
    applicationDialogVisible.value = true

  }

  const applicationRules = {
    street: [{ required: true, message: '请选择街道', trigger: 'change' }],
    date: [{ required: true, message: '请选择日期', trigger: 'change' }],
    amount: [
      { required: true, message: '请输入供电量', trigger: 'blur' },
      { type: 'number', min: 1, message: '供电量必须大于0', trigger: 'blur' }
    ]
  }

  const statusText = (status) => {
    switch (status) {
      case 'pending': return '待审批'
      case 'approved': return '已批准'
      case 'rejected': return '已拒绝'
      default: return status
    }
  }
  const statusTagType = (status) => {
    switch (status) {
      case 'pending': return 'warning'
      case 'approved': return 'success'
      case 'rejected': return 'danger'
      default: return ''
    }
  }
</script>

<style scoped>

</style>