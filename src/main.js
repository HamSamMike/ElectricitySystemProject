import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'
import router from './router'
import { createPinia } from "pinia";

const pinia = createPinia()
const app = createApp(App).use(pinia)

app.use(ElementPlus)
app.use(router)

app.mount('#app')