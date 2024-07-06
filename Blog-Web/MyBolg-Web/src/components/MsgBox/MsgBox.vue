<template>
  <n-card class="msgbox">
    <n-flex class="avatar" size="large">
      <n-avatar :size="45" src="" />
      <span class="name">名字</span>
      <n-time :time="time" type="date" />
    </n-flex>
    <div>
      <p class="content">内容内容dadadad</p>
    </div>
    <!-- 回复内容 -->
    <div class="remsgbox">
      <n-card class="reply" v-for="index in reply" :key="index">
        <n-flex class="avatar" size="large">
          <n-avatar :size="45" src="" />
          <span class="name">名字</span>
          <n-time :time="time" type="date" />
        </n-flex>
        <div>
          <p class="content">内容内容dadadad</p>
        </div>
      </n-card>
    </div>
  </n-card>
</template>

<script setup>
import { ref } from 'vue'

const time = ref(new Date())
const reply = ref(2)
</script>

<style scoped>
.msgbox {
  margin-top: 15px;
  border-radius: 10px;
  background-color: #f9f9fc;
  box-shadow: var(--box-shadow);
}
.avatar {
  align-items: center;
}
.content {
  margin-left: 65px;
  font-size: 15px;
}
.name {
  margin: 0px;
  font-size: 25px;
}
.remsgbox {
  margin-top: 50px;
  margin-left: 50px;
  border-radius: 10px;
  background-color: #f9f9fc;
}
.reply {
  margin-top: 15px;
  border-radius: 10px;
  background-color: #f9f9fc;
  box-shadow: 10px 10px 10px rgba(0, 0, 0, 0.1);
}
</style>
