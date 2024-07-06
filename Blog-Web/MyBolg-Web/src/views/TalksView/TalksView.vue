<template>
  <n-flex>
    <n-card class="talks">
      <div v-for="item in 6" :key="item" class="talksBox">
        <TalksBox></TalksBox>
      </div>
    </n-card>
    <MyCard></MyCard>
  </n-flex>
</template>

<script setup>
import MyCard from '@/components/AboutMyCard/AboutMyCard.vue'
import TalksBox from '@/components/TalksBox/TalksBox.vue'
</script>

<style scoped>
.talks {
  width: var(--width);
  height: var(--height);
  border-radius: 10px;
  display: flex;
}
.talksBox {
  max-width: 800px;
  margin: 0 auto 0 auto;
}
</style>
