<template>
  <n-flex>
    <n-card class="message">
      <n-card class="inputMsg">
        <n-input
          type="textarea"
          maxlength="300"
          placeholder="欢迎留言"
          size="large"
          :autosize="{
            minRows: 6
          }"
          show-count
        />
        <div class="button">
          <n-button @click="send()" type="primary">发布</n-button>
        </div>
      </n-card>
      <MsgBox v-for="item in 6" :key="item"></MsgBox>
    </n-card>
    <MyCard></MyCard>
  </n-flex>
</template>

<script setup>
import MyCard from '@/components/AboutMyCard/AboutMyCard.vue'
import MsgBox from '@/components/MsgBox/MsgBox.vue'
import { useMessage } from 'naive-ui'
import { useUserStore } from '@/stores'
const userStore = useUserStore()
window.$message = useMessage()
const message = useMessage()
function send() {
  //检查登录状态
  if (userStore.token != '') {
    //发送请求，把内容发送到后端判断是否发布成功
    message.success('发布成功')
  } else {
    message.error('未登录')
  }
}
</script>

<style scoped>
.message {
  width: var(--width);
  min-height: var(--height);
  border-radius: 10px;
  .inputMsg {
    background-color: #f9f9fc;
    box-shadow: var(--box-shadow);
    border-radius: 10px;
    .n-input {
      border-radius: 10px;
    }
    .n-button {
      border-radius: 5px;
    }
  }
  .button {
    margin-top: 10px;
    display: flex;
    justify-content: flex-end;
  }
}
</style>
