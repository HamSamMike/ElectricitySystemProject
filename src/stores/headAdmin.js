import { defineStore } from 'pinia'
import * as api from '@/services/index.js'

const useHeadAdminStore = defineStore('headAdmin', {
  
  state: () => ({
    adminList: [{"adminCode":1001,"adminName":"张总局1","adminPasswd":"pwd1001","adminType":1,"areaCode":101},{"adminCode":1002,"adminName":"李分局2","adminPasswd":"pwd1002","adminType":2,"areaCode":102},{"adminCode":1003,"adminName":"王总局3","adminPasswd":"pwd1003","adminType":1,"areaCode":103},{"adminCode":1004,"adminName":"赵分局4","adminPasswd":"pwd1004","adminType":2,"areaCode":104},{"adminCode":1005,"adminName":"钱总局5","adminPasswd":"pwd1005","adminType":1,"areaCode":105},{"adminCode":1006,"adminName":"孙分局1","adminPasswd":"pwd1006","adminType":2,"areaCode":106},{"adminCode":1007,"adminName":"周总局2","adminPasswd":"pwd1007","adminType":1,"areaCode":107},{"adminCode":1008,"adminName":"吴分局3","adminPasswd":"pwd1008","adminType":2,"areaCode":108},{"adminCode":1009,"adminName":"郑总局4","adminPasswd":"pwd1009","adminType":1,"areaCode":109},{"adminCode":1010,"adminName":"冯分局5","adminPasswd":"pwd1010","adminType":2,"areaCode":110},{"adminCode":1011,"adminName":"杨分局1","adminPasswd":"pwd1011","adminType":2,"areaCode":111},{"adminCode":1012,"adminName":"刘分局2","adminPasswd":"pwd1012","adminType":2,"areaCode":112},{"adminCode":1013,"adminName":"鲁分局3","adminPasswd":"pwd1013","adminType":2,"areaCode":113}],
    adminCommunityInfo: [],
    approveData: [{"areaCode":101,"communityCode":10101,"date":"2025-06-01","amount":234233,"adminCode":"1001"},{"areaCode":101,"communityCode":10101,"date":"2025-06-02","amount":456345,"adminCode":"1001"},{"areaCode":101,"communityCode":10101,"date":"2025-06-03","amount":678362,"adminCode":"1001"},],
    monthsData: [{"areaName":"江岸区", "feeMonth":"2025-01", "totalConsume":874234, "totalSupply":783423},{"areaName":"江岸区", "feeMonth":"2025-02", "totalConsume":34564564234, "totalSupply":456583423}],
    activeTab: 'admins',
  }),
  actions: {
    async fetchAdminsData() {//获取管理员列表
      const res = await api.getAdminsInfo()
      this.adminList = res.data.list
    },
    async addAdminData(data) {//添加管理员
      const res = await api.addAdminInfo(data)
      return res
    },
    async deleteAdminData(code) {//删除管理员
      const res = await api.deleteAdminInfo(code)
      return res
    },
    async changeAdminData(data) {//修改管理员信息
      const res = await api.changeAdminInfo(data)
      return res
    },
    async fetchAdminsCommunityData(data) {//获取街道用电供电信息
      const res = await api.getAdminCommunityInfo(data)
      this.adminCommunityInfo = res.data
    },
    
    async fetchApproveData() { //获取审批信息
      const res = await api.getApproveInfo()
      this.approveData = res.data
    },

    async fetchMonthsData(data) {//获取某月到某月的月度报表信息
      const res = await api.getMonthsInfo(data)
      this.monthsData = res.data
    },

    async approveApplication(code) {//总局批准请求
      const res = await api.headAdminApproveApplication(code)
      return res
    },

    async rejectApplication(code) {//总局批准请求
      const res = await api.headAdminRejectApplication(code)
      return res
    },
    
  }
})

export default useHeadAdminStore

  