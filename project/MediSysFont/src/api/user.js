import request from '@/utils/request'
import axios from 'axios'

//request用于拦截token验证是否已经登陆
export function queryManager(value) {
  return axios
       .get('http://localhost:8085/querySingleManager/'+value.username+'/'+value.password)
       .then(function(res){
        return new Promise((resolve,reject) =>{
          if(res.data.username != 'error')
            resolve(res)
          else{
            reject('error')
             }
          }
       )
      })
      .catch(function (error) { // 请求失败处理
        reject(error)
    }); 
}


export function getInfo(token) {
  return request({
    url: '/vue-admin-template/user/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/vue-admin-template/user/logout',
    method: 'post'
  })
}
