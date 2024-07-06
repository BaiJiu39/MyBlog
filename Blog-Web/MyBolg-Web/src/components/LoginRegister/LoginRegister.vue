<template>
  <div>
    <span>
      <n-button :type="buttonType" size="medium" @click="showModal = true">
        {{ loginButton }}
      </n-button>
      <!-- 登录相关代码 -->
      <span v-if="isRegist">
        <n-modal
          v-model:show="showModal"
          class="custom-card"
          preset="card"
          :style="bodyStyle"
          title="卡片预设"
          size="huge"
          :bordered="false"
        >
          <template #header>
            <span>用户登录</span>
          </template>
          <div class="loginInputBox">
            <n-form
              ref="formRef"
              :label-width="80"
              :model="formValue"
              :rules="rules"
              :size="size"
            >
              <n-form-item label="账号" path="username">
                <n-input
                  v-model:value="formValue.username"
                  placeholder="账号必须是长度 4-16位 的字符 不允许纯数字"
                />
              </n-form-item>
              <n-form-item label="密码" path="password">
                <n-input
                  v-model:value="formValue.password"
                  type="password"
                  show-password-on="click"
                  :maxlength="16"
                  placeholder="密码必须包含数字 最少8个字符"
                />
              </n-form-item>
            </n-form>
          </div>
          <template #action>
            <div class="loginRegist">
              <n-button type="primary" @click="loginClick">登录</n-button>
              <n-button @click="onNegativeClick" style="margin-left: 15px"
                >注册</n-button
              >
            </div>
          </template>
        </n-modal>
      </span>
      <!-- 注册相关代码 -->
      <span v-else>
        <n-modal
          v-model:show="showModal"
          class="custom-card"
          preset="card"
          :style="bodyStyle"
          title="卡片预设"
          size="huge"
          :bordered="false"
        >
          <template #header>
            <span>用户注册</span>
          </template>
          <div class="loginInputBox">
            <n-form
              ref="formRef"
              :label-width="80"
              :model="formValue"
              :rules="rules"
              :size="size"
            >
              <n-form-item label="账号" path="username">
                <n-input
                  v-model:value="formValue.username"
                  placeholder="输入账号 长度4-16字 不允许纯数字"
                />
              </n-form-item>
              <n-form-item label="密码" path="password">
                <n-input
                  v-model:value="formValue.password"
                  type="password"
                  show-password-on="click"
                  :maxlength="16"
                  @input="handlePasswordInput"
                  @keydown.enter.prevent
                  placeholder="输入密码 包含数字 最少8个字符"
                />
              </n-form-item>
              <n-form-item
                ref="rPasswordFormItemRef"
                first
                path="reenteredPassword"
                label="重复密码"
              >
                <n-input
                  v-model:value="formValue.reenteredPassword"
                  :disabled="!formValue.password"
                  type="password"
                  @keydown.enter.prevent
                  placeholder="再次输入密码"
              /></n-form-item>
            </n-form>
          </div>
          <template #action>
            <div class="loginRegist">
              <n-button type="primary" @click="onPositiveClick">登录</n-button>
              <n-button @click="regesterClick" style="margin-left: 15px"
                >注册</n-button
              >
            </div>
          </template>
        </n-modal>
      </span>
    </span>
  </div>
</template>

<script setup>
import { userRegisterService, userLoginService } from '@/api/user.js'
import { ref, watch, onMounted } from 'vue'
import { useMessage } from 'naive-ui'
import { useUserStore } from '@/stores'
const isRegist = ref(true)
window.$message = useMessage()
const buttonType = ref('primary')
const loginButton = ref('登录')
//用户登录数据
const formRef = ref(null)
const size = ref('medium')
const rPasswordFormItemRef = ref(null)
const formValue = ref({
  username: '',
  password: '',
  reenteredPassword: ''
})
//数据验证
const rules = {
  username: [
    {
      required: true,
      message: '请输入账号',
      trigger: 'blur'
    },
    {
      validator: validateUsernameRegex,
      message: '账号格式不符合',
      trigger: 'input'
    }
  ],
  password: [
    {
      required: true,
      message: '请输入密码'
    },
    {
      validator: validatePasswordRegex,
      message: '密码格式不正确',
      trigger: 'input'
    }
  ],
  reenteredPassword: [
    {
      required: true,
      message: '请再次输入密码',
      trigger: ['input', 'blur']
    },
    {
      validator: validatePasswordStartWith,
      message: '两次密码输入不一致',
      trigger: 'input'
    },
    {
      validator: validatePasswordSame,
      message: '两次密码输入不一致',
      trigger: ['blur', 'password-input']
    }
  ]
}

function validatePasswordStartWith(rule, value) {
  return (
    !!formValue.value.password &&
    formValue.value.password.startsWith(value) &&
    formValue.value.password.length >= value.length
  )
}
function validatePasswordSame(rule, value) {
  return value === formValue.value.password
}

//验证账号正确性
function validateUsernameRegex() {
  return /^(?=.*[a-zA-Z])[\w]{4,16}$/.test(formValue.value.username)
}
function validatePasswordRegex() {
  return /^(?=.*[a-z])(?=.*\d).{8,}$/.test(formValue.value.password)
}
const handlePasswordInput = () => {
  if (formValue.value.reenteredPassword) {
    rPasswordFormItemRef.value?.validate({ trigger: 'password-input' })
  }
}
//登录弹窗组件样式
const bodyStyle = {
  width: '400px',
  height: '410px'
}

//用户登录事件
const ShowModalRef = ref(false)
const message = useMessage()
const showModal = ShowModalRef

function onNegativeClick() {
  message.success('注册')
  isRegist.value = false
  resetForm()
}
function onPositiveClick() {
  message.success('登录')
  isRegist.value = true
  resetForm()
}
function regesterClick() {
  register()
  isRegist.value = false
}
function loginClick() {
  login()
}
//清空输入框
const resetForm = () => {
  formValue.value.username = ''
  formValue.value.password = ''
  formValue.value.reenteredPassword = ''
}

//注册接口调用
const register = async () => {
  await formRef.value.validate()
  await userRegisterService(formValue.value)
  message.success('注册成功')
  resetForm()
  isRegist.value = true
}
//登录接口调用，获取token
const userStore = useUserStore()
const login = async () => {
  await formRef.value.validate()
  const res = await userLoginService(formValue.value)
  console.log()
  userStore.setToken(res.data.data)
  message.success('登录成功')
  ShowModalRef.value = false
}
//检测登录状态
watch(
  () => userStore.token,
  (newVal) => {
    if (newVal != '') {
      buttonType.value = ''
      loginButton.value = '已登录'
    }
  }
)
onMounted(() => {
  // 检查登录状态
  if (userStore.token != '') {
    buttonType.value = ''
    loginButton.value = '已登录'
  }
})
</script>

<style scoped>
.loginRegist {
  display: flex;
  justify-content: center; /* 水平居中 */
  align-items: center; /* 垂直居中 */
  height: 20px; /* 调整以适应按钮高度 */
}
.loginInput {
  margin-bottom: 20px;
}
.action {
  height: 100px;
}
.loginInputBox {
  margin-top: 10px;
}
</style>
