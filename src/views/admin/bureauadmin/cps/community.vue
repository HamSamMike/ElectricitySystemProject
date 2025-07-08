<template>
  <el-tab-pane label="街道信息" name="community">
    <el-card shadow="hover">
      <el-table :data="adminCommunityInfo" border style="width: 100%">
        <el-table-column prop="communityCode" label="街道名" />
        <el-table-column prop="usersNum" label="用户数" />
      </el-table>
    </el-card>
  </el-tab-pane>
</template>

<script setup>
  import useBureauAdminStore from '@/stores/bureauAdmin'
  import { storeToRefs } from 'pinia'

  const bureauAdminStore = useBureauAdminStore()
  const { adminCommunityInfo} = storeToRefs(bureauAdminStore)
</script>

<style lang='less' scoped>

</style>