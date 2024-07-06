import { defineStore } from 'pinia'
import { ref } from 'vue'

export const useArticleStore = defineStore(
  'article',
  () => {
    const articles = ref([])
    const total = ref(0)
    const setArticles = (newArticle) => {
      articles.value = newArticle
    }

    const setTotal = (newTotal) => {
      total.value = newTotal
    }
    const addArticles = (newArticles) => {
      articles.value.push(...newArticles)
    }
    return {
      articles,
      total,
      setArticles,
      addArticles,
      setTotal
    }
  },
  {
    persist: false
  }
)
