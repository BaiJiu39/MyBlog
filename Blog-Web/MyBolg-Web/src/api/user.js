import request from '@/utils/request'

export const userRegisterService = ({
  username,
  password,
  reenteredPassword
}) => {
  return request.post('/user/register', {
    username,
    password,
    reenteredPassword
  })
}
export const userLoginService = ({ username, password }) => {
  return request.post('/user/login', { username, password })
}
export const imgService = () => {
  return request.get('/user/myimg')
}
