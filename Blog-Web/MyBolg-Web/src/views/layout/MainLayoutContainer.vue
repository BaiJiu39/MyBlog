<!-- 主页面布局 -->
<template>
  <n-message-provider>
    <n-flex vertical size="large">
      <n-layout>
        <n-modal-provider>
          <n-layout-header
            ><HeaderMenu class="menu"></HeaderMenu
          ></n-layout-header>
        </n-modal-provider>
        <n-layout-content
          ><RouterView class="View"></RouterView
        ></n-layout-content>

        <n-layout-footer>
          <div class="lien"></div>
          <p>底部信息</p>
        </n-layout-footer>
      </n-layout>
    </n-flex>
  </n-message-provider>
</template>

<script setup>
import HeaderMenu from '@/components/HeaderMenu/HeaderMenu.vue'
</script>

<style scoped>
.n-layout-header {
  background: #3388bb;
  position: fixed; /* 将导航栏固定在页面顶部 */
  top: 10; /* 距离页面顶部的距离为 0 */
  left: 0; /* 距离页面左侧的距离为 0 */
  z-index: 1000; /* 设置 z-index 避免被其他元素覆盖 */
  .menu {
    max-width: 1470px;
    margin: 0 auto;
  }
}

.n-layout-footer {
  background: #bbbbbb;
  height: 100px;
}

.n-layout-content {
  background: #ebebeb;

  padding: 20px 210px;
  .View {
    max-width: 1550px;
    margin: 85px auto 10px;
  }
}
.lien {
  background: linear-gradient(45deg, #3388bb 20%, #77dd77);
  width: 100%;
  height: 5px;
}
</style>
