<template>
  <div>
    <n-flex
      ><n-card class="article"
        ><div class="markdown-body" v-html="htmlStr"></div> </n-card
      ><MyCard></MyCard
    ></n-flex>
  </div>
</template>

<script setup>
import MyCard from '@/components/AboutMyCard/AboutMyCard.vue'
import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router'
import { article } from '@/api/article.js'

import { marked } from 'marked'
import hljs from 'highlight.js'
import 'highlight.js/styles/atom-one-dark.css'
import { markedHighlight } from 'marked-highlight'

const renderer = new marked.Renderer()
renderer.image = function (href, title, text) {
  return `<img src="${href}" alt="${text}" title="${title || ''}" style="width:100%">`
}
// 自定义代码块渲染方法，确保添加 hljs 类
renderer.code = function (code, infostring, escaped) {
  const lang = (infostring || '').match(/^\S*/)?.[0]
  code = code.replace(/\n$/, '') + '\n'
  if (!lang) {
    return (
      '<pre><code class="hljs">' +
      (escaped ? code : escape(code, true)) +
      '</code></pre>\n'
    )
  }
  return (
    '<pre><code class="language-' +
    escape(lang) +
    ' hljs">' +
    (escaped ? code : escape(code, true)) +
    '</code></pre>\n'
  )
}

marked.use(
  markedHighlight({
    langPrefix: 'hljs language-',
    highlight(code, lang) {
      const language = hljs.getLanguage(lang) ? lang : 'plaintext'
      return hljs.highlight(code, { language }).value
    }
  })
)

// 再次配置 marked，确保使用自定义渲染器
marked.setOptions({
  renderer,
  pedantic: false,
  sanitize: false,
  breaks: true, // 支持换行
  smartLists: true,
  smartypants: true
})
//const htmlStr = marked.parse(hh)
//向客户端请求文章
const htmlStr = ref()
const route = useRoute()
const getArticleContent = async () => {
  const response = await article(route.params.id)
  htmlStr.value = response.data.data.article
}

onMounted(async () => {
  await getArticleContent()
})
</script>

<style scoped>
.article {
  width: var(--width);
  min-height: var(--height);
  border-radius: 10px;
  padding: 40px;
}
</style>
