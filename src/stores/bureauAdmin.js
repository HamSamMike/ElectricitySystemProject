import { defineStore } from 'pinia'
import * as api from '@/services/index.js'

const useBureauAdminStore = defineStore('bureauAdmin', {
  
  state: () => ({
    adminCommunityInfo: [],
    approveData: [],
    monthlyData: [],
    activeTab: 'community',
  }),
  actions: {
    // async fetchAdminsCommunityData() {
    //   const res = await getAdminCommunityInfo()
    //   this.adminCommunityInfo = res.data
    // },
    //暂时用模拟数据
    fetchAdminsCommunityData() {
      this.adminCommunityInfo = [
        {
          areaCode: '101',
          communityCode: '10101',
          usersNum: '632',
          yesterdayUsage: '5348',
          todaySupply: '6877',
        },
        {
          areaCode: '101',
          communityCode: '10101',
          usersNum: '632',
          yesterdayUsage: '5348',
          todaySupply: '6877',
        },
        {
          areaCode: '101',
          communityCode: '10101',
          usersNum: '632',
          yesterdayUsage: '5348',
          todaySupply: '6877',
        }
      ]
    },
    //暂时用模拟数据

    
    // async fetchApproveData() {
    //   const res = await getApproveInfo()
    //   this.approveData = res.data
    // },
    //暂时用模拟数据
    fetchApproveData() {
      this.approveData = [
        {
          areaCode: '101',
          communityCode: '10101',
          date: '2025-07-01',
          amount: '2233'
        },
        {
          areaCode: '101',
          communityCode: '10101',
          date: '2025-07-01',
          amount: '2233'
        },
        {
          areaCode: '101',
          communityCode: '10101',
          date: '2025-07-01',
          amount: '2233'
        },
      ]
    },

    // async fetchMonthlyData(data) {
    //   const res = await getMonthlyInfo(data)
    //   this.monthlyData = res.data
    // },
    //暂时用模拟数据
    fetchMonthlyData() {
      this.monthlyData = [
        {
          data: '2025-07',
          areaCode: "101",
          usage: '444543',
          supply: '452442',
        },
        {
          data: '2025-07',
          areaCode: "101",
          usage: '444543',
          supply: '452442',
        },
        {
          data: '2025-07',
          areaCode: "101",
          usage: '444543',
          supply: '452442',
        },
      ]
    }
    //暂时用模拟数据
  }
})

export default useBureauAdminStore