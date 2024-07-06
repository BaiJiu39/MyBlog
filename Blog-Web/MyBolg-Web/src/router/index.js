import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      redirect: '/Home',
      children: [
        {
          path: 'Article/:id',
          component: () =>
            import('@/views/ArticleView/ArticleContent/ArticleContent.vue')
        },
        {
          path: '/Home',
          component: () => import('@/views/ArticleView/ArticleListView.vue')
        },
        {
          path: '/Archives',
          component: () => import('@/views/ArchivesView/ArchivesView.vue')
        },
        {
          path: '/Talks',
          component: () => import('@/views/TalksView/TalksView.vue')
        },
        {
          path: '/FriendLink',
          component: () => import('@/views/FriendLinkView/FriendLinkView.vue')
        },
        {
          path: '/Message',
          component: () => import('@/views/MessageView/MessageView.vue')
        },
        {
          path: '/About',
          component: () => import('@/views/AboutView/AboutView.vue')
        }
      ]
    }
  ]
})

export default router
