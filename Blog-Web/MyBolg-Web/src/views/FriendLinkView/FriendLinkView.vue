<template>
  <div class="friend">
    <n-grid :x-gap="20" :y-gap="20" :cols="4" style="width: 100%">
      <n-grid-item class="item" v-for="item in 10" :key="item">
        <FriendLink></FriendLink>
      </n-grid-item>
    </n-grid>
  </div>
</template>

<script setup>
import FriendLink from '@/components/FriendLink/FriendLink.vue'
</script>

<style scoped>
.friend {
  height: var(--height);
}
</style>
