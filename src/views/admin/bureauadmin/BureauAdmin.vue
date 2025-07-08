<template>
  <div class="bureau-admin">
    <DateDisplay />
    
    <el-tabs v-model="activeTab">
      <community></community>
      <applications></applications>
      <reports></reports>
    </el-tabs>
  </div>
</template>

<script setup>
import { onMounted, ref } from 'vue'
import DateDisplay from '@/components/DateDisplay.vue'
import { storeToRefs } from 'pinia'
import useBureauAdminStore from '@/stores/bureauAdmin'
import community from './cps/community.vue'
import applications from './cps/applications.vue'
import reports from './cps/reports.vue'

const bureauAdminStore = useBureauAdminStore()
const { activeTab } = storeToRefs(bureauAdminStore) 
onMounted(() => {
  bureauAdminStore.fetchAdminsCommunityData()
  bureauAdminStore.fetchApproveData()
  bureauAdminStore.fetchMonthlyData()
})


</script>

<style scoped>
.bureau-admin {
  padding: 20px;
}

</style>