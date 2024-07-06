<template>
  <n-flex>
    <div class="talksBox">
      <n-card class="card">
        <n-flex>
          <n-avatar
            class="avatar"
            :size="45"
            src="src\assets\img.jpg"
            object-fit="cover"
          />
          <div>
            <div style="font-size: 17px">name</div>
            <div style="font-size: 13px">2323</div>
          </div>
        </n-flex>
        <div clsss="content" style="padding: 0 20px 0 57px"><p>dwad</p></div>
      </n-card>
    </div>
  </n-flex>
</template>

<script setup></script>

<style scoped>
.card {
  width: 700px;
  min-height: 150px;
  border-radius: 10px;
  box-shadow: 5px 5px 10px rgba(136, 136, 136, 0.411); /* 阴影样式 */
  left: 15px; /* 自定义位置 */
  z-index: 0; /* 确保这个组件在上层 */
}
.talksBox {
  margin-bottom: 20px;
}
</style>
