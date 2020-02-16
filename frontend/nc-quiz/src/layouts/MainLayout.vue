<template>
  <q-layout view="hHh lpR fFf">

    <q-header elevated class="bg-primary text-white">
      <q-toolbar>
        <q-toolbar-title>
          <div class="row items-center">
            <img class="global-logo" src="../assets/global-logo.png">
            <span>在线答题系统 <q-badge align="middle" color="orange">beta</q-badge></span>
          </div>
        </q-toolbar-title>

        <q-input
          dark
          dense
          standout
          v-model="searchText"
          input-class="text-right"
          class="q-ml-md"
          placeholder="搜索考试场次信息"
          style="width: 250px"
        >
          <template v-slot:append>
            <q-icon v-if="searchText === ''" name="search" />
            <q-icon v-else name="clear" class="cursor-pointer" @click="searchText = ''" />
          </template>
        </q-input>
        <q-btn-dropdown
          flat
          dense
        >
          <template v-slot:label>
            <q-avatar icon="notifications">
              <q-badge floating color="red">4</q-badge>
            </q-avatar>
          </template>

          <q-list style="max-width: 350px">
            <q-item clickable v-ripple>
              <q-item-section>
                <q-item-label>Single line item</q-item-label>
                <q-item-label caption lines="2">Secondary line text. Lorem ipsum dolor sit amet, consectetur adipiscit elit.</q-item-label>
              </q-item-section>

              <q-item-section side top>
                <q-item-label caption>5 min ago</q-item-label>
                <q-icon name="star" color="yellow" />
              </q-item-section>
            </q-item>

            <q-separator />

            <q-item clickable v-ripple>
              <q-item-section>
                <q-item-label>Single line item</q-item-label>
                <q-item-label caption>Secondary line text. Lorem ipsum dolor sit amet, consectetur adipiscit elit.</q-item-label>
              </q-item-section>

              <q-item-section side top>
                <q-item-label caption>Voted!</q-item-label>
              </q-item-section>
            </q-item>
          </q-list>
        </q-btn-dropdown>
        <q-btn-dropdown
          flat
          dense
        >
          <template v-slot:label>
            <q-avatar>
              <img src="https://cdn.quasar.dev/img/avatar.png">
            </q-avatar>
          </template>

          <div class="row no-wrap q-pa-md">
            <div class="column">
              <div class="text-h6 q-mb-md">考试信息</div>
              <q-list>
                <q-separator />

                <q-item clickable dense v-ripple>
                  <q-item-section>
                    <div class="row">
                    <q-avatar color="primary" size="sm" text-color="white" icon="bluetooth" />
                    <div class="col user-menu-title">我的成绩</div>
                  </div>
                  </q-item-section>
                </q-item>

                <q-separator />

                <q-item clickable dense v-ripple>
                  <q-item-section>
                    <div class="row">
                    <q-avatar color="primary" size="sm" text-color="white" icon="bluetooth" />
                    <div class="col user-menu-title">我的考试</div>
                  </div>
                  </q-item-section>
                </q-item>

                <q-separator />

                <q-item clickable dense v-ripple>
                  <q-item-section>
                    <div class="row">
                    <q-avatar color="primary" size="sm" text-color="white" icon="bluetooth" />
                    <div class="col user-menu-title">我的信息</div>
                  </div>
                  </q-item-section>
                </q-item>
              </q-list>
            </div>

            <q-separator vertical inset class="q-mx-lg" />

            <div class="column items-center">
              <q-avatar size="72px">
                <img src="https://cdn.quasar.dev/img/boy-avatar.png">
              </q-avatar>

              <div class="text-subtitle1 q-mt-md q-mb-xs ellipsis">Tecyle Genius</div>

              <q-btn
                color="primary"
                label="退出登录"
                push
                size="sm"
                v-close-popup
              />
            </div>
          </div>
        </q-btn-dropdown>
      </q-toolbar>
    </q-header>

    <q-page-container>
      <q-page>
        <div class="container">
          <router-view />
        </div>
      </q-page>
    </q-page-container>

  </q-layout>
</template>

<script>
export default {
  data () {
    return {
      searchText: ''
    }
  }
}
</script>

<style lang="stylus" scoped>
  .global-logo
    height: 48px
  .user-menu-title
    white-space: nowrap
    margin-left: 7px
    margin-top: 2px
  .container
    margin: 0 auto
    width: 1024px
</style>
