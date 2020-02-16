<template>
  <div class="fit">
    <div class="wrapper">
      <div class="header">
        <img src="../../assets/global-logo.png" class="logo">
        <span class="add-fav">
          <span class="fav-nav"><q-icon name="home" size="sm" /> <span>设为首页</span></span>
          <span class="fav-nav"><q-icon name="folder_special" size="sm" /> <span>加入收藏</span></span>
        </span>
      </div>
      <div class="login-board-container">
        <img src="../../assets/splash.jpg" class="fit splash">
        <q-card class="login-form">
          <q-card-section>
            <div class="login-title">用户登录</div>
            <q-separator />
            <q-input
              outlined
              clearable
              clear-icon="close"
              class="login-input"
              style="margin-top: 30px"
              color="primary"
              v-model="username"
              label="用户名"
            >
              <template v-slot:prepend>
                <q-icon name="person" />
              </template>
            </q-input>
            <q-input
              outlined
              clearable
              clear-icon="close"
              class="login-input"
              color="primary"
              type="password"
              v-model="password"
              label="登录密码"
            >
              <template v-slot:prepend>
                <q-icon name="lock" />
              </template>
            </q-input>
            <div class="login-input row items-center">
              <div class="col">
                <q-checkbox v-model="saveLoginState" label="下次自动登录" />
              </div>
              <div class="col-auto">
                <q-btn flat dense color="primary">忘记密码？</q-btn>
              </div>
            </div>
            <div class="login-input">
              <q-btn push class="full-width login-btn" size="lg" color="primary" label="登录" />
            </div>
            <q-separator style="margin-top: 40px" />
            <div class="row items-center other-login">
              <div class="col-auto">
                <q-btn flat dense color="light-blue" size="md" label="QQ登录" icon="fab fa-qq" />
              </div>
              <q-separator vertical />
              <div class="col-auto">
                <q-btn flat dense color="green" size="md" label="微信登录" icon="fab fa-weixin" />
              </div>
            </div>
          </q-card-section>
        </q-card>
      </div>
      <div class="footer column items-center">
        <div class="col q-gutter-md contact-methods">
          <q-icon name="fab fa-weixin" />
          <q-icon name="fab fa-weibo" />
          <q-icon name="fab fa-github" />
          <q-icon name="mail" />
        </div>
        <div class="col-auto">
          本项目 (AKI) 遵循 MIT 开源协议
        </div>
        <div class="col-auto copyright">
          Copyright © 2014-2020 NavInfo
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      slide: 1,
      username: '',
      password: '',
      saveLoginState: false
    }
  }
}
</script>

<style lang="stylus" scoped>
  .wrapper
    margin: 0 auto
    width: 1024px
    .header
      margin: 0
      background-color: white
      height: 64px
      line-height: 64px
      overflow: hidden
      .logo
        height: 100%
        margin: 0 10px
      .add-fav
        float: right
        margin: 10px
        .fav-nav
          margin: 0 5px
    .login-board-container
      margin: 0
      padding: 0
      height: 480px
      line-height: 480px
      position: relative
      .splash
        vertical-align: middle
      .login-form
        position: absolute
        top: 32px
        right: 32px
        width: 380px
        height: 416px
        line-height: 1em
        .login-title
          font-size: 1.6em
          line-height: 1.6em
          padding-bottom: 5px
          color: $primary
        .login-input
          margin: 10px 0
          .login-btn
            letter-spacing: 2em
            text-indent: 2em
        .other-login
          padding-top: 10px
          .col-auto
            padding: 0 10px
    .footer
      background-color: white
      height: 100px
      .contact-methods
        color: black
        font-size: 1.8em
        padding-top: 15px
      .copyright
        margin-bottom: 10px
</style>
