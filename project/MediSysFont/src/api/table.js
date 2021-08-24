import axios from 'axios'
 
export function getUserList(params) {
  return axios
       .get('http://localhost:8085/queryAllCate')
       .then(function(res){
        return new Promise((resolve,reject) =>{
          if(res.status == 200)
            resolve(res)
          else{
            reject("获取失败");
             }
          }
       )
      })
      .catch(function (error) { // 请求失败处理
        console.log(error);
    }); 
}

export function addCate(cate) {
  console.log(cate)
  return axios
       .get('http://localhost:8085/addCate',{params:cate})
       .then(function(res){
        return new Promise((resolve,reject) =>{
          if(res.status == 200)
            resolve("sucess")
          else
            reject("fail")
          }
       )
      })
      .catch(function (error) { // 请求失败处理
        console.log(error);
    }); 
}

export function editCate(cate) {
  return axios
       .get('http://localhost:8085/updateCate',{params:cate})
       .then(function(res){
        return new Promise((resolve,reject) =>{
          if(res.status == 200)
            resolve("sucess")
          else
            reject("fail")
          }
       )
      })
      .catch(function (error) { // 请求失败处理
        console.log(error);
    }); 
}

export function deleteCate(id) {
  return axios
       .get('http://localhost:8085/deleteCate/'+id)
       .then(function(res){
        return new Promise((resolve,reject) =>{
          if(res.status == 200)
            resolve("sucess")
          else
            reject("fail")
          }
       )
      })
      .catch(function (error) { // 请求失败处理
        console.log(error);
    }); 
}


export function queryCate(ob,value) {
  return axios
       .get('http://localhost:8085/querySingleCate/'+ob+'/'+value)
       .then(function(res){
        return new Promise((resolve,reject) =>{
          if(res!=null)
            resolve(res)
          else{
            reject("获取失败");
             }
          }
       )
      })
      .catch(function (error) { // 请求失败处理
        console.log(error);
    }); 
}
