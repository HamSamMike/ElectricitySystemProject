<template>
  <div class="reports">
    <el-tab-pane label="月度报表" name="reports">
        <el-card shadow="hover">
          <div class="querybox">
            <span class="querymonthtext">选择报表月份范围：</span>
            <el-date-picker
              value-format="YYYY-MM"
              v-model="queryMonth"
              type="monthrange"
              range-separator="到"
              start-placeholder="开始月份"
              end-placeholder="结束月份"
            />
            <p></p>
            <div class="areabox">
              <div class="areatext">选择报表查询区域：</div>
              <el-select-v2
                v-model="selectedAreaCode"
                :options="areaOptions"
                placeholder="请选择区域"
                style="width: 140px"
                filterable
                clearable
              />
            </div>
              
            <el-button type="primary" @click="handleQuery()" class="btn">查询</el-button>
          </div>
          
          <div v-if="queryMonth[0] === queryMonth[1]" class="report-title">{{ queryMonth[0] }} 总局用电供电月报（{{ selectedAreaCode }}）</div>
          <div v-else-if="queryMonth[0] !== queryMonth[1]" class="report-title">{{ queryMonth[0] }}~{{ queryMonth[1] }} 总局用电供电月报（{{ selectedAreaCode }}）</div>
          <el-table stripe :data="monthsData" border style="width: 100%">
            <el-table-column prop="feeMonth" label="月份" />
            <el-table-column prop="areaName" label="区域" >
            </el-table-column>
            <el-table-column prop="totalConsume" label="用电量(度)" />
            <el-table-column prop="totalSupply" label="供电量(度)" />
          </el-table>
        </el-card>
      </el-tab-pane>
  </div>
</template>

<script setup>
  import useHeadAdminStore from '@/stores/headAdmin';
  import { storeToRefs } from 'pinia'
  import useMainStore from '@/stores/main'
  import { ref, onMounted, onUpdated, computed } from 'vue'

  const mainStore = useMainStore()
  const { areaList, user } = storeToRefs(mainStore)
  
  const headAdminStore = useHeadAdminStore()
  const { monthsData } = storeToRefs(headAdminStore)
  const findAreaName = (code) => {//根据areaCode找areaName
    const item = areaList.value.find(item => item.areaCode === code)
    return item ? item.areaName : 0
  }
  const queryMonth = ref(["2025-01","2025-02"])
  const selectedAreaCode = ref(102)
  onMounted(() => {
    handleQuery()
  })
  onUpdated(() => {
    handleQuery()
  })
  const monthList = ['2025-01','2025-02','2025-03','2025-04','2025-05','2025-06']
  const handleQuery = () => {
    for(let i = 0; i < monthList.length; i ++) {
      if(queryMonth.value[0] === monthList[i]) {
        headAdminStore.fetchMonthsData({
          month: monthList[i],
          areaCode: user.value.areaCode
        })
        console.log("上传数据：", monthList[i], user.value[0].areaCode);
      }
      console.log(queryMonth.value[0]);
    }
  }
  const areaOptions = computed(() => {
    return areaList.value.map(item => ({
      value: item.areaCode, // 实际绑定的值
      label: item.areaName  // 显示的文字
    }))
  })
  
</script>

<style scoped>
.report-title {
  font-size: 18px;
  font-weight: bold;
  margin-bottom: 20px;
  text-align: center;
}
  .querymonthtext {
    margin-right: 14px;
  }
  .areabox {
    display: flex;
    
  }

.areatext {
      margin-right: 14px;
    }

</style>