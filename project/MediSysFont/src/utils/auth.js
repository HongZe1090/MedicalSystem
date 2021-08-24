import Cookies from 'js-cookie'

const TokenKey = 'vue_admin_template_token'
//将用户id存cookie作为唯一标识
const Avator = 'admin_id'

export function getToken() {
  return Cookies.get(TokenKey)
}

export function setToken(token) {
  return Cookies.set(TokenKey, token)
}

export function getAvator() {
  return Cookies.get(Avator)
}

export function setAvator(avator) {
  return Cookies.set(Avator, avator)
}


export function removeToken() {
  return Cookies.remove(TokenKey)
}
