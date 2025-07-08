import { defineStore } from 'pinia'
import * as api from '@/services/index.js'

const useMainStore = defineStore('main', {
  state: () => ({
    user: [],
    token: "",
    areaList: [
      {
        "areaCode": 101,
        "areaName": "江岸区"
      },
      {
        "areaCode": 102,
        "areaName": "江汉区"
      },
      {
        "areaCode": 103,
        "areaName": "硚口区"
      },
      {
        "areaCode": 104,
        "areaName": "汉阳区"
      },
      {
        "areaCode": 105,
        "areaName": "武昌区"
      },
      {
        "areaCode": 106,
        "areaName": "青山区"
      },
      {
        "areaCode": 107,
        "areaName": "洪山区"
      },
      {
        "areaCode": 108,
        "areaName": "蔡甸区"
      },
      {
        "areaCode": 109,
        "areaName": "江夏区"
      },
      {
        "areaCode": 110,
        "areaName": "黄陂区"
      },
      {
        "areaCode": 111,
        "areaName": "新洲区"
      },
      {
        "areaCode": 112,
        "areaName": "东西湖区"
      },
      {
        "areaCode": 113,
        "areaName": "汉南区"
      }
    ],
    communityList: [
    {
      "areaCode": 101,
      "communityCode": 10101,
      "communityName": "大智街道"
    },
    {
      "areaCode": 101,
      "communityCode": 10102,
      "communityName": "一元街道"
    },
    {
      "areaCode": 101,
      "communityCode": 10103,
      "communityName": "车站街道"
    },
    {
      "areaCode": 101,
      "communityCode": 10104,
      "communityName": "四唯街道"
    },
    {
      "areaCode": 101,
      "communityCode": 10105,
      "communityName": "永清街道"
    },
    {
      "areaCode": 101,
      "communityCode": 10106,
      "communityName": "西马街道"
    },
    {
      "areaCode": 101,
      "communityCode": 10107,
      "communityName": "球场街道"
    },
    {
      "areaCode": 101,
      "communityCode": 10108,
      "communityName": "劳动街道"
    }
    ],

    isAuthenticated: false
  }),
  actions: {
    async fetchAreaList() {//获取区域代码名称对照表
      const res = await api.getAreaList()
      this.areaList = res.data.list
    },
    async fetchCommunityList() {//获取区域代码名称对照表
      const res = await api.getCommunityList()
      this.communityList = res.data
    },
    findAreaName(code) {//根据areaCode找areaName
      const item = areaList.value.find(item => item.areaCode === code)
      return item ? item.areaName : 0
    },
    findAreaCode(text) {//根据areaName找areaCode
      const item = areaList.value.find(item => item.areaName === text)
      return item ? item.areaCode : 0
    },
    findCommunityName(code) {//根据communityCode找communityName
      const item = communityList.value.find(item => item.communityCode === code)
      return item ? item.communityName : 0
    },
    userLogin(userData) {
      
      this.isAuthenticated = true
    },
    adminLogin(adminData, role) {
     
      this.isAuthenticated = true
    },
    logout() {
      this.user = null
      this.isAuthenticated = false
    }
  }
})

export default useMainStore