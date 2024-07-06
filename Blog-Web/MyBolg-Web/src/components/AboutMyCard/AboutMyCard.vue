<template>
  <div>
    <n-card class="card">
      <n-flex vertical align="center" justify="center" style="gap: 3px 12px">
        <n-avatar class="img" :size="100" :src="img" object-fit="cover" />
        <n-h1>Shiro</n-h1>
        <GB></GB>
        <n-h4 class="subtitle-1">迷子でもいい、迷子でも進め。</n-h4>
        <n-h4 class="subtitle-2">不畏迷茫，迷茫着也要砥砺前行</n-h4>
      </n-flex>

      <n-grid :cols="4" class="link">
        <n-gi :offset="1">
          <a
            href="https://space.bilibili.com/476136616?spm_id_from=333.1007.0.0"
            target="_blank"
            rel="noopener noreferrer"
          >
            <n-image width="40px" :src="github"></n-image>
          </a>
        </n-gi>
        <n-gi>
          <a
            href="https://github.com/BaiJiu39"
            target="_blank"
            rel="noopener noreferrer"
          >
            <n-image width="40px" :src="bilibili"></n-image>
          </a>
        </n-gi>
      </n-grid>
    </n-card>
  </div>
</template>

<script setup>
import img from '@/assets/img.jpg'
import bilibili from '@/assets/RiBilibiliFill.svg'
import github from '@/assets/RiGithubFill.svg'
import GB from '@/components/GradientBar/GB.vue'
</script>

<style scoped>
.card {
  width: 320px;
  height: 400px;
  border-radius: 10px;
  box-shadow: var(--box-shadow);
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.img {
  display: block;
  margin: 20px 0 auto;
}

.n-h1 {
  margin: 0;
  font-size: 40px;
}

.subtitle-1 {
  margin: 10px 0;
  font-size: 17px;
}

.subtitle-2 {
  margin: 0;
  font-size: 15px;
}

.link {
  margin-top: 30px;
}
</style>
