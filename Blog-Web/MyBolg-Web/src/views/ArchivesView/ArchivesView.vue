<template>
  <div>
    <n-card>
      <n-flex justify="center">
        <Timeline
          :timeline-data="timelineData"
          mode="center"
          position="right"
          :width="500"
        >
          <template #icon="{ index }">
            <span class="big-dot" v-if="index === 2"></span>
          </template>
        </Timeline>
      </n-flex>
    </n-card>
  </div>
</template>

<script setup>
import Timeline from '@/components/TimeLine/timeLine.vue'
import { ref } from 'vue'

const timelineData = ref([
  {
    desc: 'Create a services site 2023-05-24',
    color: 'green'
  },
  {
    desc: 'Solve initial network problems 1 Solve initial network problems 2 2023-05-24',
    color: 'red'
  },
  {
    desc: 'Technical testing 2023-05-24',
    color: 'blue'
  },
  {
    desc: 'Network problems being solved 2023-05-24'
  },
  {
    desc: 'Technical testing 2023-05-24',
    color: 'blue'
  },
  {
    desc: 'Technical testing 2023-05-24',
    color: 'blue'
  },
  {
    desc: 'Technical testing 2023-05-24',
    color: 'blue'
  },
  {
    desc: 'Technical testing 2023-05-24',
    color: 'blue'
  },

  {
    desc: 'Network problems being solved 2',
    color: 'gray'
  }
])
</script>

<style scoped>
.n-card {
  border-radius: 10px;
}
.big-dot {
  display: inline-block;
  width: 18px;
  height: 18px;
  border: 4px solid #1677ff;
  border-radius: 50%;
  background: #fff;
}

.u-icon {
  fill: #1668dc;
  background: #fff;
  border-radius: 50%;
}

.desc {
  font-size: 16px;
  font-weight: 500;
}
</style>
