import axios from 'axios'
import { useUserStore } from '@/stores'
import router from '@/router'
const baseURL = '/api'
const instance = axios.create({
  baseURL,
  timeout: 100000
})

//请求拦截器
instance.interceptors.request.use(
  (config) => {
    const UserStore = useUserStore()
    if (UserStore.token) {
      config.headers.Authorization = UserStore.token
    }
    return config
  },
  (err) => Promise.reject(err)
)

//响应拦截器
instance.interceptors.response.use(
  (res) => {
    if (res.data.code === 1) {
      return res
    }
    console.log(res)
    window.$message.error(res.data.msg || '服务端异常')
    return Promise.reject(res.data)
  },
  (err) => {
    if (err.response?.status === 401) {
      router.push('/')
    }

    //错误的默认情况
    window.$message.error(err.response.data.msg || '服务端异常')
    return Promise.reject(err)
  }
)

export default instance
export { baseURL }
