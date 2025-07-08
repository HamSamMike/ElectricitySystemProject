<template>
  <div class="date-display">
    <el-card shadow="hover">
      <div>当前日期: {{ currentDate }}</div>
    </el-card>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'

const currentDate = ref('')

const updateDate = () => {
  const now = new Date()
  currentDate.value = now.toLocaleDateString('zh-CN', {
    year: 'numeric',
    month: '2-digit',
    day: '2-digit',
    weekday: 'long'
  })
}

onMounted(() => {
  updateDate()
})
</script>

<style scoped>
.date-display {
  margin-bottom: 20px;
}
</style>