import request from '@/utils/request'

export const articleList = ({ page, pageSize }) => {
  return request.get('/articles', {
    params: {
      page: page,
      pageSize: pageSize
    }
  })
}
export const article = (id) => {
  return request.get(`/articles/${id}`)
}
