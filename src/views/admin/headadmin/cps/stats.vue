<template>
  <div class="stats">
    <el-tab-pane label="街道统计" name="stats">
        <el-card shadow="hover">
          <el-table stripe :data="adminCommunityInfo" border style="width: 100%">
            <el-table-column label="区域">
              <template #header class="searchbox">
                
                <div class="search-container">
                  <div class="describe">区域</div>
                  <el-input
                    v-model="areaSearchText"
                    placeholder="搜索区域"
                    @keyup.enter="areaSearch(areaSearchText)"
                    style="width: 180px"
                  >
                    <template #append>
                      <div class="icon" @click="areaSearch(areaSearchText)">
                        <img src="../../../../assets/imgs/aigei_com.png" alt="">
                      </div>
                    </template>
                  </el-input>
                </div>
              </template>
              <template #default="{ row }">
                {{ findAreaName(row.areaCode) }}
              </template>
            </el-table-column>
            <el-table-column label="街道" >
              <template #default="{ row }">
                {{ findCommunityName(row.communityCode) }}
              </template>
            </el-table-column>
            <el-table-column prop="usersNum" label="用户数"/>
            <el-table-column prop="yesterdayUsage" label="日用电量(度)" >
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
            <el-table-column prop="todaySupply">
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
  import { ref, onMounted, onUpdated } from 'vue'

  const headAdminStore = useHeadAdminStore()
  const mainStore = useMainStore()
  const { communityList, areaList } = storeToRefs(mainStore)

  onMounted(() => {
    headAdminStore.fetchAdminsCommunityData()
  })
  onUpdated(() => {
    headAdminStore.fetchAdminsCommunityData()
  })
  
  const findAreaName = (code) => {//根据areaCode找areaName
    const item = areaList.value.find(item => item.areaCode === code)
    return item ? item.areaName : 0
  }
  const findCommunityName = (code) => {//根据communityCode找communityName
    const item = communityList.value.find(item => item.communityCode === code)
    return item ? item.communityName : 0
  }
  const areaSearchText = ref("")
  const usageDate = ref('2025-05-01')
  const supplyDate = ref('2025-05-02')
  
  const areaSearch = (text) => {
    headAdminStore.fetchAdminsCommunityData(findAreaCode(text))
  }
  
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