<template>
  <div class="admin">
    <el-tab-pane label="管理员管理" name="admins">
        <el-card shadow="hover">
          <el-button type="primary" @click="showAddAdmin" style="margin-bottom: 20px">新增管理员</el-button>
          <el-table stripe :data="adminList" border style="width: 100%">
            <el-table-column prop="adminCode" label="Code" width="80" />
            <el-table-column prop="adminName" label="姓名" width="120" />
            <el-table-column prop="adminType" label="类型" width="120">
              <template #default="{row}">
                {{ row.adminType === 1 ? '总局管理员' : '分局管理员' }}
              </template>
            </el-table-column>
            <el-table-column label="负责区域">
              <template #default="{row}">
                {{ row.areaCode }}
              </template>
            </el-table-column>
            <el-table-column label="操作">
              <template #default="{row}">
                <el-button type="success" @click="showPassword(row)">显示密码</el-button>
                <el-button type="primary" @click="showChangeAdmin(row)">修改信息</el-button>
                <el-button type="danger" @click="deleteAdmin(row)">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
        </el-card>
      </el-tab-pane>

      <el-dialog v-model="addAdminFlag" title="注册管理员信息" width="30%">
      <el-form :model="addAdminForm">
        <el-form-item label="管理员账号">
          <el-input v-model="addAdminForm.adminCode" type="string"></el-input>
        </el-form-item>
        <el-form-item label="管理员密码">
          <el-input v-model="addAdminForm.adminPasswd" type="string"></el-input>
        </el-form-item>
        <el-form-item label="管理员姓名">
          <el-input v-model="addAdminForm.adminName" type="string"></el-input>
        </el-form-item>
        <el-form-item label="管理员管理区域">
          <el-input v-model="addAdminForm.areaCode" type="string"></el-input>
        </el-form-item>
        <el-form-item label="管理员类型">
          <el-radio-group v-model="addAdminForm.adminType">
            <el-radio label="1">总局管理员</el-radio>
            <el-radio label="2">分局管理员</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="addAdminFlag = false">取消</el-button>
        <el-button type="primary" @click="handleAddAdmin">确认</el-button>
      </template>
    </el-dialog>

    <el-dialog v-model="changeAdminFlag" title="修改管理员信息" width="30%">
      <el-form :model="changeAdminForm">
        <el-form-item label="管理员姓名">
          <el-input v-model="changeAdminForm.adminName" type="string"></el-input>
        </el-form-item>
        <el-form-item label="管理员密码">
          <el-input v-model="changeAdminForm.adminPasswd" type="string"></el-input>
        </el-form-item>
        <el-form-item label="管理员类型">
          <el-radio-group v-model="changeAdminForm.adminType">
            <el-radio label="1">总局管理员</el-radio>
            <el-radio label="2">分局管理员</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="changeAdminFlag = false">取消</el-button>
        <el-button type="primary" @click="handleChangeAdmin">确认</el-button>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
  import useHeadAdminStore from '@/stores/headAdmin';
  import useMainStore from '@/stores/main'
  import { storeToRefs } from 'pinia'
  import { ref, onMounted } from 'vue'
  import axios from 'axios'
  const mainStore = useMainStore()
  const { areaList } = storeToRefs(mainStore)
  const headAdminStore = useHeadAdminStore()
  
  const { adminList } = storeToRefs(headAdminStore)

  const findAreaName = (code) => {//根据areaCode找areaName
    const item = areaList.value.find(item => item.areaCode === code)
    return item ? item.areaName : 0
  }
  const addAdminFlag = ref(false)
  const addAdminForm = ref({
    adminName: '小刘',
    adminPasswd: '111',
    adminType: 1, // 默认总局管理员
    areaCode: 101,
    adminCode: 2323
  })
  const showAddAdmin = () => {
    addAdminFlag.value = true
  }
  const handleAddAdmin = () => {
    axios.post("http://localhost:8080/api/admins/add", addAdminForm.value)
    console.log("已经成功添加管理员");
    
    addAdminFlag.value = false
    addAdminForm.value = null
    headAdminStore.fetchAdminsData()
    
  }
  const deleteAdmin = (admin) => {
    console.log(admin);
    
    axios.delete("http://localhost:8080/api/admins/delete", admin.adminCode)

  }
  const changeAdminFlag = ref(false)
  const changeAdminForm = ref({})
  const showChangeAdmin = (admin) => {
    changeAdminForm.value = admin
    changeAdminFlag.value = true
  }
  const handleChangeAdmin = () => {
    headAdminStore.changeAdminData(changeAdminForm.value)
    changeAdminFlag.value = false
    changeAdminForm.value.amount = 0
  }
  const showPassword = (admin) => {
    ElMessageBox.alert(`密码: ${admin.adminPasswd}`, '管理员密码', {
      confirmButtonText: '确定'
    })
  }

  
  onMounted(() => {
    console.log(adminList.value);
    
    headAdminStore.fetchAdminsData()
  })

</script>

<style scoped>

</style>