<template>
  <div class="article">
    <n-card class="card" hoverable>
      <n-flex style="gap: 0px">
        <div class="article-text">
          <n-skeleton v-if="Loading" height="40px" width="33%" />
          <n-h1 v-else style="font-size: 30px">{{ title }}</n-h1>
          <div v-if="Loading" style="margin: 25px 0px">
            <n-skeleton text :repeat="4" />
            <n-skeleton text style="width: 60%" />
          </div>
          <div v-else style="min-height: 135px">
            <p style="font-size: 15px">{{ summary }}</p>
          </div>

          <n-flex justify="space-between">
            <div style="font-size: 15px">
              <n-skeleton v-if="Loading" height="30px" width="140px" />
              <b v-else> 发布于：</b>{{ createTime }}
            </div>
            <div class="num">
              <n-icon size="30"><Eye /></n-icon>

              <n-skeleton
                v-if="Loading"
                height="20px"
                width="40px"
                style="margin: 0px 35px 0px 10px"
              />
              <span v-else style="margin: 0px 35px 0px 10px">{{
                likeCount
              }}</span>

              <n-icon size="30">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="128"
                  height="128"
                  viewBox="0 0 256 256"
                >
                  <path
                    fill="currentColor"
                    d="M234 80.12A24 24 0 0 0 216 72h-56V56a40 40 0 0 0-40-40a8 8 0 0 0-7.16 4.42L75.06 96H32a16 16 0 0 0-16 16v88a16 16 0 0 0 16 16h172a24 24 0 0 0 23.82-21l12-96A24 24 0 0 0 234 80.12M32 112h40v88H32Z"
                  />
                </svg>
              </n-icon>

              <n-skeleton
                v-if="Loading"
                height="20px"
                width="40px"
                style="margin-left: 10px"
              />
              <span v-else style="margin-left: 10px">{{ viewCount }}</span>
            </div>
          </n-flex>
        </div>
        <div class="img">
          <n-image width="350" src="src\assets\R.jpg"></n-image>
        </div>
      </n-flex>
    </n-card>
  </div>
</template>

<script setup>
import { defineProps } from 'vue'
import { Eye } from '@vicons/ionicons5'
// eslint-disable-next-line no-unused-vars
const props = defineProps({
  title: String,
  summary: String,
  createTime: String,
  likeCount: Number,
  viewCount: Number,
  Loading: Boolean
})
</script>

<style scoped>
.card {
  width: 99%;
  height: 300px;
  padding: 10px;
  margin-bottom: 10px;
  margin-left: 10px;
  border-radius: 10px;
  flex-grow: 1;
  transform: scale(1);
  overflow: hidden;
  transition: all 0.3s;
  cursor: pointer;
  box-shadow: var(--box-shadow);
}

.card:hover {
  transform: scale(1.01);
}
.img {
  margin-left: 45px;
}
.article-text {
  max-width: 60%;
  min-width: 60%;
}
.num {
  display: flex;
  align-items: center;
}
</style>
