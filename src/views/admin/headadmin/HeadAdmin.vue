<template>
  <div class="head-admin">
    <DateDisplay />
    <el-tabs v-model="activeTab" class="tabs">
      <admins></admins>
      <stats></stats>
      <approvals></approvals>
      <reports></reports>
    </el-tabs>
  </div>
</template>

<script setup>
import DateDisplay from '@/components/DateDisplay.vue'
import admins from './cps/admins.vue'
import approvals from './cps/approvals.vue'
import reports from './cps/reports.vue'
import stats from './cps/stats.vue'
import useHeadAdminStore from '@/stores/headAdmin'
import useMainStore from '@/stores/main'
import { storeToRefs } from 'pinia'
import { onMounted } from 'vue'

const headAdminStore = useHeadAdminStore()
const { activeTab } = storeToRefs(headAdminStore)
const mainStore = useMainStore()
onMounted(() => {
  mainStore.fetchAreaList()
  mainStore.fetchCommunityList()
})
</script>

<style scoped>

.head-admin {
  padding: 20px;
  display: flex;
  flex-direction: column;
  overflow-y: auto;
}
</style>