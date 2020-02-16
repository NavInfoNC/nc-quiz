<template>
  <q-layout view="hHh LpR fFf">

    <q-header elevated class="bg-primary text-white">
      <q-toolbar>
        <q-btn dense flat round icon="menu" @click="left = !left" />

        <q-toolbar-title>
          <div class="row items-center">
            <img class="global-logo" src="../assets/global-logo.png">
            <span>在线答题系统很硬的后台 <q-badge align="middle" color="orange">beta</q-badge></span>
          </div>
        </q-toolbar-title>

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

    <q-drawer elevated show-if-above v-model="left" side="left" behavior="desktop" bordered>
      <q-scroll-area class="fit">
        <left-drawer-nav-bar></left-drawer-nav-bar>
      </q-scroll-area>
    </q-drawer>

    <q-page-container>
      <q-page class="column">

        <div class="page-container col-grow column">
          <router-view />
        </div>

        <q-page-sticky expand position="top" style="z-index: 2">
          <q-toolbar class="q-pa-md q-gutter-sm bg-white">
            <q-breadcrumbs>
              <q-breadcrumbs-el icon="home" to="/" />
              <q-breadcrumbs-el label="Docs" icon="widgets" to="/start/pick-quasar-flavour" />
              <q-breadcrumbs-el label="Breadcrumbs" icon="navigation" to="/vue-components/breadcrumbs" />
              <q-breadcrumbs-el label="Build" icon="build" />
            </q-breadcrumbs>
          </q-toolbar>
          <div class="q-px-md bg-white fit">
            <q-separator />
          </div>
        </q-page-sticky>

        <q-page-scroller
          position="bottom-right"
          :scroll-offset="150"
          :offset="[18, 18]"
        >
          <q-btn fab icon="keyboard_arrow_up" color="primary" />
        </q-page-scroller>
      </q-page>
    </q-page-container>

  </q-layout>
</template>

<script>
import LeftDrawerNavBar from './LeftDrawerNavBar'

export default {
  components: {
    LeftDrawerNavBar
  },
  data () {
    return {
      left: false
    }
  }
}
</script>

<style lang="stylus" scoped>
  .page-container
    margin: 10px 16px
    padding-top: 66px
</style>
