import { logout,queryManager } from '@/api/user'
import { getToken,getAvator,setAvator, setToken, removeToken } from '@/utils/auth'
import { resetRouter } from '@/router'

const getDefaultState = () => {
  return {
    token: getToken(),
    name: '',
    avatar: getAvator(),
  }
}

const state = getDefaultState()

const mutations = {
  RESET_STATE: (state) => {
    Object.assign(state, getDefaultState())
  },
  SET_TOKEN: (state, token) => {
    state.token = token
  },
  SET_NAME: (state, name) => {
    state.name = name
  },
  SET_AVATAR: (state, avatar) => {
    state.avatar = avatar
  }
}

const actions = {
  // user login
  //第一个参数即表示this.$mutations的引用，第二个参数是传进来的参数
  login({ commit }, userInfo) {
    console.log(userInfo)
    const { username, password } = userInfo
    return new Promise((resolve, reject) => {
      queryManager({ username: username.trim(), password: password }).then(response => {
        //解构语法
        const { data } = response
        commit('SET_NAME', data.username)
        commit('SET_AVATAR', data.id)
        commit('SET_TOKEN', data.token)
        //cookie中setToken,avatar
        setToken(data.token)
        setAvator(data.id)
        resolve()      
      }).catch(error => {
        reject(error)
      })
    })
  },


  // user logout
  logout({ commit, state }) {
    return new Promise((resolve, reject) => {
      logout(state.token).then(() => {
        removeToken() // must remove  token  first
        resetRouter()
        commit('RESET_STATE')
        resolve()
      }).catch(error => {
        reject(error)
      })
    })
  },

  // remove token
  resetToken({ commit }) {
    return new Promise(resolve => {
      removeToken() // must remove  token  first
      commit('RESET_STATE')
      resolve()
    })
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}

