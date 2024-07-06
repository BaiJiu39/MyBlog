<template>
  <n-flex class="header">
    <n-icon size="50px" style="margin: 10px 0px"
      ><svg
        xmlns="http://www.w3.org/2000/svg"
        width="200"
        height="200"
        viewBox="0 0 700 700"
      >
        <path
          fill="#ffffff"
          d="M699.966 411.706l-61.947-28.207c17.041-145.642-78.335-281.835-221.022-315.643L411.672 0l-28.208 61.912c-145.607-17.007-281.8 78.335-315.608 221.022L0 288.26l61.947 28.207C44.905 462.109 140.282 598.302 282.968 632.11l5.326 67.856 28.207-61.913c145.642 17.042 281.835-78.335 315.643-221.021L700 411.706h-.034zM336.36 594.385l58.202-127.776 69.299 46.039-19.55-80.877 139.973-10.995c-32.502 107.814-135.472 179.931-247.89 173.575l-.034.034zM105.615 336.394l127.776 58.202-46.039 69.299 80.877-19.549 10.995 139.972C171.41 551.816 99.294 448.847 105.649 336.429l-.034-.035zm257.991-230.779l-58.202 127.776-69.299-46.039 19.549 80.877-139.972 10.995c32.502-107.814 135.471-179.93 247.889-173.575l.035-.034zm230.779 257.991l-127.776-58.202 46.039-69.299-80.877 19.549-10.995-139.972c107.814 32.502 179.931 135.471 173.575 247.889l.034.035zm33.189 35.353l-36.487-6.424L350 350.034l46.657 66.654-95.616 210.921 6.424-36.488 42.501-241.087-66.654 46.658-175.876-79.71-35.08-15.907 36.489 6.425L349.931 350l-46.657-66.654 95.617-210.92-6.425 36.487L349.966 350l66.653-46.658 210.921 95.617h.034z"
        />
      </svg>
    </n-icon>

    <div class="navigation">
      <n-tabs size="medium" style="--n-tab-text-color: #d3e6dc">
        <n-tab name="首页">
          <RouterLink to="/">首页</RouterLink>
        </n-tab>
        <n-tab name="归档">
          <RouterLink to="/Archives">归档</RouterLink>
        </n-tab>
        <n-tab name="说说">
          <RouterLink to="/Talks">说说</RouterLink>
        </n-tab>
        <n-tab name="友链">
          <RouterLink to="/FriendLink">友链</RouterLink>
        </n-tab>
        <n-tab name="留言">
          <RouterLink to="/Message">留言板</RouterLink>
        </n-tab>
        <n-tab name="关于">
          <RouterLink to="/About">关于</RouterLink>
        </n-tab>
      </n-tabs>
    </div>
    <span class="login"><loginRegister></loginRegister></span>
  </n-flex>
</template>

<script setup>
import loginRegister from '@/components/LoginRegister/LoginRegister.vue'
</script>

<style scoped>
.header {
  min-width: var(--width);
  padding-top: 10px;
  .navigation {
    /* 在交叉轴方向上居中 */
    margin: 20px 0px;
    padding-left: 20px;
  }
}

.login {
  margin: 20px 0px 0px 680px;
  padding-left: 20px;
}

a {
  text-decoration: none;
  /* 取消下划线 */
  color: inherit;
  /* 继承父元素的颜色 */
}
</style>
