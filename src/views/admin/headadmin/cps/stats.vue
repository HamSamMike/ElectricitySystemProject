<template>
  <div class="stats">
    <el-tab-pane label="街道统计" name="stats">
        <el-card shadow="hover">
          <el-button type="primary" @click="areaSearch" style="margin-bottom: 20px">查询</el-button>
          <el-table stripe :data="adminCommunityInfo" border style="width: 100%">
            <el-table-column label="区域">
              <template #header class="searchbox">
                
                <div class="search-container">
                  <div class="describe">区域</div>
                  <el-select-v2
                    v-model="selectedAreaCode"
                    :options="areaOptions"
                    placeholder="请选择区域"
                    style="width: 140px"
                    filterable
                    clearable
                  />
                </div>
              </template>
              <template #default="{ row }">
                {{ findAreaName(row.communityCode) }}
              </template>
            </el-table-column>
            <el-table-column prop="usersCount" label="用户数"/>
            <el-table-column prop="totalConsume" label="日用电量(度)" >
              <template #header>
                  <el-date-picker
                    v-model="usageDate"
                    type="date"
                    placeholder="选择查询日期"
                    size="default"
                    style="width: 140px"
                  />
                  <span class="text">日用电量(度)</span>
              </template>
            </el-table-column>
            <el-table-column prop="totalSupply">
              <template #header>
                  <el-date-picker
                    v-model="supplyDate"
                    type="date"
                    placeholder="选择查询日期"
                    size="default"
                    style="width: 140px"
                  />
                  <span class="text">日供电量(度)</span>
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
  import { ref, onMounted, onUpdated, computed } from 'vue'

  const headAdminStore = useHeadAdminStore()
  const mainStore = useMainStore()
  const { communityList, areaList } = storeToRefs(mainStore)

  onMounted(() => {
    headAdminStore.fetchAdminsCommunityData({
      areaCode: selectedAreaCode.value,
      startDate: usageDate.value,
      endDate: supplyDate.value
    })
  })
  // onUpdated(() => {
  //   headAdminStore.fetchAdminsCommunityData()
  // })
  
  const findAreaName = (code) => {//根据areaCode找areaName
    const item = areaList.value.find(item => item.areaCode === code)
    return item ? item.areaName : 0
  }
  const findCommunityName = (code) => {//根据communityCode找communityName
    const item = communityList.value.find(item => item.communityCode === code)
    return item ? item.communityName : 0
  }
  const selectedAreaCode = ref('')
  const usageDate = ref('2025-05-01')
  const supplyDate = ref('2025-05-02')
  
  const areaSearch = () => {
    headAdminStore.fetchAdminsCommunityData({
      areaCode: selectedAreaCode.value,
      startDate: usageDate.value,
      endDate: supplyDate.value
    })
  }

  const areaOptions = computed(() => {
    return areaList.value.map(item => ({
      value: item.areaCode, // 实际绑定的值
      label: item.areaName  // 显示的文字
    }))
  })
</script>

<style scoped>
.search-container {
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100%;
}
.describe {
  width: 40px;
  margin: 0 10px;
}
.text {
  margin: 10px;
}
.icon {
  width: 100%;
  height: 20px;
  cursor: pointer;
  img {
    width: 20px;
    height: 20px;
  }
  
}
</style>