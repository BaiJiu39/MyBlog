<template>
  <div class="ArticleList">
    <n-flex vertical>
      <div v-if="isLoading">
        <!-- 加载中的占位内容 -->
        <ArticleList
          v-for="index in pageSize"
          :key="index"
          class="list"
          :Loading="isLoading"
        ></ArticleList>
      </div>
      <div v-else>
        <ArticleList
          v-for="(item, index) in currentArticles"
          :key="index"
          class="list"
          @click="viewArticle(item.articleId)"
          :title="item.title"
          :summary="item.summary"
          :create-time="item.createTime"
          :like-count="item.likeCount"
          :view-count="item.viewCount"
          :Loading="isLoading"
        ></ArticleList>
      </div>
      <div class="page">
        <n-pagination
          size="large"
          v-model:page="page"
          :page-count="pageCount"
          @update:page="fetchArticleList"
        />
      </div>
    </n-flex>

    <n-flex class="my">
      <MyCard></MyCard>
    </n-flex>
  </div>
</template>

<script setup>
import ArticleList from '@/components/ArticleList/ArticleList.vue'
import MyCard from '@/components/AboutMyCard/AboutMyCard.vue'
import { useRouter } from 'vue-router'
import { ref, onMounted, computed } from 'vue'
import { articleList } from '@/api/article.js'
import { useArticleStore } from '@/stores/modules/article'

const router = useRouter()
const articleStore = useArticleStore()

const isLoading = ref(true) // 加载状态
const page = ref(1) // 当前页码
const pageSize = 10 // 每页显示的文章数量

const pageCount = computed(() => Math.ceil(articleStore.total / pageSize))

const currentArticles = computed(() => {
  const start = (page.value - 1) * pageSize
  const end = start + pageSize
  return articleStore.articles.slice(start, end)
})

const viewArticle = (id) => {
  router.push(`/Article/${id}`)
}

const fetchArticleList = async () => {
  isLoading.value = true
  try {
    const response = await articleList({ page: page.value, pageSize })
    articleStore.setTotal(response.data.data.total)
    if (page.value === 1) {
      articleStore.setArticles(response.data.data.records) // 初次加载时设置数据
    } else {
      articleStore.addArticles(response.data.data.records) // 其他页码时追加数据
    }
  } catch (error) {
    console.error('Error fetching articles:', error)
  } finally {
    isLoading.value = false
  }
}

onMounted(async () => {
  await fetchArticleList()
})
</script>

<style scoped>
.list {
  width: var(--width);
}
.ArticleList {
  display: flex;
  min-height: var(--height);
}
.my {
  margin-left: 10px;
}
.page {
  margin: 30px auto;
}
</style>
