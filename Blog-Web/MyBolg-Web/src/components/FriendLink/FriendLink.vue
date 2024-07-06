<template>
  <n-card class="friendBox" hoverable>友好</n-card>
</template>

<script setup></script>

<style scoped>
.friendBox {
  height: 245px;
  width: 100%;
  border-radius: 10px;
  flex-grow: 1;
  transform: scale(1);
  overflow: hidden;
  transition: all 0.3s;
  cursor: pointer;
  box-shadow: var(--box-shadow);
}
.friendBox:hover {
  transform: scale(1.01);
}
</style>
