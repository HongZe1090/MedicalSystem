<template>
  <div class="login-container">

    <img src="@/assets/1.png" class="back">
    <el-form ref="loginForm" :model="loginForm" :rules="loginRules" class="login-form" auto-complete="on" label-position="left">

      
      <div class="title-container">
        <h3 class="title">欢迎来到医疗管理系统</h3>
      </div>

      <el-form-item prop="username">
        <span class="svg-container">
          <svg-icon icon-class="user" />
        </span>
        <el-input
          ref="username"
          v-model="loginForm.username"
          placeholder="Username"
          name="username"
          type="text"
          tabindex="1"
          auto-complete="on"
        />
      </el-form-item>

      <el-form-item prop="password">
        <span class="svg-container">
          <svg-icon icon-class="password" />
        </span>
        <el-input
          :key="passwordType"
          ref="password"
          v-model="loginForm.password"
          :type="passwordType"
          placeholder="Password"
          name="password"
          tabindex="2"
          auto-complete="on"
          @keyup.enter.native="handleLogin"
        />
        <span class="show-pwd" @click="showPwd">
          <svg-icon :icon-class="passwordType === 'password' ? 'eye' : 'eye-open'" />
        </span>
      </el-form-item>

      <el-button :loading="loading" type="primary" style="width:100%;margin-bottom:30px;" @click.native.prevent="handleLogin">登 录</el-button>

    </el-form>
     
  </div>
</template>

<script>

export default {
  name: 'Login',
  data() {
    const validatePassword = (rule, value, callback) => {
      if (value.length < 6) {
        callback(new Error('密码不少于六位'))
      } else {
        callback()
      }
    }
    return {
      loginForm: {
        username: '',
        password: ''
      },
      loginRules: {
        username: [{ required: true, trigger: 'blur'}],
        password: [{ required: true, trigger: 'blur', validator: validatePassword }]
      },
      loading: false,
      passwordType: 'password',
    }
  },
  watch: {
    $route: {
      immediate: true
    }
  },
  methods: {
    showPwd() {
      if (this.passwordType === 'password') {
        this.passwordType = ''
      } else {
        this.passwordType = 'password'
      }
      this.$nextTick(() => {
        this.$refs.password.focus()
      })
    },
    handleLogin() {
      //表单验证 valid为真表示验证通过
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          this.loading = true
          //提交数据到后台确认，调用vuex中的Action
          this.$store.dispatch('user/login', this.loginForm).then(() => {
            this.$router.push({ path: '/sale/sale-table' })
            this.loading = false
          }).catch(() => {
            this.loading = false
            this.$message({
            message: '登陆失败，用户名或密码错误',
            type: 'error'
            })
          })
        } else {
          console.log('error submit!!')
          return false
        }
      })
    }
  }
}
</script>

<style lang="scss">
/* 修复input 背景不协调 和光标变色 */

$bg:
#f0faff;
$light_gray:#1e2325;
$cursor: #1e2325;

@supports (-webkit-mask: none) and (not (cater-color: $cursor)) {
  .login-container .el-input input {
    color: $cursor;
  }
}

/* reset element-ui css */
.login-container {
  .el-input {
    display: inline-block;
    height: 47px;
    width: 85%;

    input {
      background: transparent;
      border: 0px;
      -webkit-appearance: none;
      border-radius: 0px;
      padding: 12px 5px 12px 15px;
      color: $light_gray;
      height: 47px;
      caret-color: $cursor;

      &:-webkit-autofill {
        box-shadow: 0 0 0px 1000px $bg inset !important;
        -webkit-text-fill-color: $cursor !important;
      }
    }
  }

  .el-form-item {
    border: 1px solid rgba(255, 255, 255, 0.1);
    background: rgba(0, 0, 0, 0.1);
    border-radius: 5px;
    color: #454545;
  }
}
</style>

<style lang="scss" scoped>
$bg:
#e4f5f9
;
$dark_gray:#1e2325;
$light_gray:#1e2325;

.login-container {
  min-height: 100%;
  width: 100%;
  background: #e4f5f9;
  overflow: hidden;
  .back{
      position: absolute;
      left:0; 
      right:0; 
      top:0;
      bottom:0;
      margin:auto;
      width:1100px;
      opacity: 0.8;
      z-index: 10;
  }
  
  .login-form {
    position: absolute;
    z-index: 100;
    opacity: 0.8;
border-radius: 20px;
background: #7fd7d0;
box-shadow:  20px 20px 60px #6cb7b1,
             -20px -20px 60px #92f7ef;
    width: 420px;
    padding: 50px 35px 20px;
    overflow: hidden;
    margin: 50px 550px;
  }
  .login-form:hover{
    opacity: 1;
  }

  .tips {
    font-size: 14px;
    margin-bottom: 10px;

    span {
      &:first-of-type {
        margin-right: 16px;
      }
    }
  }

  .svg-container {
    padding: 6px 5px 6px 15px;
    color: $dark_gray;
    vertical-align: middle;
    width: 30px;
    display: inline-block;
  }

  .title-container {
    position: relative;

    .title {
      font-size: 26px;
      color: $light_gray;
      margin: 0px auto 40px auto;
      text-align: center;
      font-weight: bold;
    }
  }

  .show-pwd {
    position: absolute;
    right: 10px;
    top: 7px;
    font-size: 16px;
    color: #1e2325;
    cursor: pointer;
    user-select: none;
  }
}
</style>
