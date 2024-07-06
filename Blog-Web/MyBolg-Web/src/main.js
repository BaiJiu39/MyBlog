import { createApp } from 'vue'
import pinia from '@/stores/index'
import App from './App.vue'
import router from './router'
// 通用字体
import 'vfonts/Lato.css'
// 等宽字体
import 'vfonts/FiraCode.css'
import '@/styles/styles.css'

const app = createApp(App)

app.use(pinia)
app.use(router)

app.mount('#app')
