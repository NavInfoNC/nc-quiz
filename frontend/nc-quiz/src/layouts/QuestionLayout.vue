<template>
  <q-layout view="hHh LpR fFf">

    <q-header elevated class="bg-primary text-white">
      <q-toolbar>
        <q-btn dense flat round icon="menu" @click="left = !left" />

        <q-toolbar-title class="row items-center no-wrap">
          <img class="global-logo" src="../assets/global-logo.png">
          <span>{{this.questionName}}</span>
        </q-toolbar-title>

        <div class="cursor-pointer">
          <div class="row items-center">
            <q-spinner-hourglass color="light-green" size="md" />
            <span class="text-light-green time-computing">120:00</span>
          </div>
          <q-tooltip content-style="font-size: 1.2em">距离考试结束还剩 120 分钟 0 秒</q-tooltip>
        </div>

        <q-btn-dropdown
          flat
          dense
        >
          <template v-slot:label>
            <q-avatar>
              <img src="https://cdn.quasar.dev/img/avatar.png">
            </q-avatar>
          </template>

          <q-list>
            <q-item clickable v-close-popup>
              <q-item-section avatar>
                <q-avatar icon="folder" size="sm" color="primary" text-color="white" />
              </q-item-section>
              <q-item-section>
                <q-item-label caption>注销</q-item-label>
              </q-item-section>
            </q-item>
          </q-list>
        </q-btn-dropdown>
      </q-toolbar>
      <q-linear-progress :value="questionProgress" color="green">
        <q-tooltip content-style="font-size: 1.2em">答题进度：50%</q-tooltip>
      </q-linear-progress>
    </q-header>

    <q-drawer
      show-if-above
      v-model="left"
      side="left"
      behavior="desktop"
      bordered
      :mini="!left || miniState"
      @click.capture="drawerClick"
    >
      <template v-slot:mini>
        <q-scroll-area class="fit mini-slot cursor-pointer">
          <div class="q-py-lg">
            <div class="column items-center">
              <q-avatar icon="inbox">
                  <q-badge color="red" floating>4</q-badge>
              </q-avatar>
              <q-avatar icon="bluetooth">
                  <q-badge color="red" floating>4</q-badge>
              </q-avatar>
            </div>
          </div>
        </q-scroll-area>
      </template>

      <q-scroll-area class="fit">
        <q-list padding>
          <q-expansion-item expand-separator default-expanded>
            <template v-slot:header>
              <q-item-section avatar>
                <q-avatar icon="inbox">
                  <q-badge color="red" floating>4</q-badge>
                </q-avatar>
              </q-item-section>
              <q-item-section>
                单项选择题
              </q-item-section>
              <q-item-section side>
                <q-circular-progress
                  show-value
                  class="text-black"
                  :value="72"
                  size="40px"
                  color="green"
                  track-color="grey-3"
                >
                  72%
                </q-circular-progress>
              </q-item-section>
            </template>

            <q-card>
              <q-card-section>
                <div style="" class="row items-center q-gutter-sm">
                  <div class="col-2 q-px-sm">
                    <div class="question-select-btn answered rounded-borders fit">1</div>
                  </div>
                  <div class="col-2 q-px-sm">
                    <div class="question-select-btn answered rounded-borders fit">2</div>
                  </div>
                  <div class="col-2 q-px-sm">
                    <div class="question-select-btn answered rounded-borders fit">3</div>
                  </div>
                  <div class="col-2 q-px-sm">
                    <div class="question-select-btn answered rounded-borders fit">4</div>
                  </div>
                  <div class="col-2 q-px-sm">
                    <div class="question-select-btn answered rounded-borders fit">5</div>
                  </div>
                  <div class="col-2 q-px-sm">
                    <div class="question-select-btn answered rounded-borders fit">6</div>
                  </div>
                  <div class="col-2 q-px-sm">
                    <div class="question-select-btn current-answering answered rounded-borders fit">7</div>
                  </div>
                  <div class="col-2 q-px-sm">
                    <div class="question-select-btn current-answering rounded-borders fit">8</div>
                  </div>
                  <div class="col-2 q-px-sm">
                    <div class="question-select-btn rounded-borders fit">9</div>
                  </div>
                </div>
              </q-card-section>
            </q-card>
          </q-expansion-item>
          <q-expansion-item
            expand-separator
            icon="bluetooth"
            label="多项选择题"
          >
            <q-card>
              <q-card-section>选择题列表</q-card-section>
            </q-card>
          </q-expansion-item>
        </q-list>
      </q-scroll-area>

      <div class="q-mini-drawer-hide absolute" style="top: 15px; right: -17px">
        <q-btn
          dense
          round
          unelevated
          color="primary"
          icon="chevron_left"
          @click="miniState = true"
        />
      </div>
    </q-drawer>

    <q-page-container>
      <router-view />

      <q-page-sticky position="bottom-right" :offset="[80, 18]">
        <q-btn round icon="keyboard_arrow_left" color="primary" />
      </q-page-sticky>
      <q-page-sticky position="bottom-right" :offset="[18, 18]">
        <q-btn fab icon="keyboard_arrow_right" color="green" />
      </q-page-sticky>
    </q-page-container>

  </q-layout>
</template>

<script>
export default {
  data () {
    return {
      left: false,
      questionName: '四维图新2010年第一季度 C++ 程序员在线笔试题',
      miniState: false
    }
  },
  computed: {
    questionProgress () {
      return 0.5
    }
  },
  methods: {
    drawerClick (e) {
      if (this.miniState) {
        this.miniState = false
        e.stopPropagation()
      }
    }
  }
}
</script>

<style lang="stylus" scoped>
  .global-logo
    height: 48px
  .time-computing
    margin: 0 5px
    font-size: 1.5em
  .question-select-btn
    border-color: $grey-6
    border-width: 1px
    border-style: solid
    text-align: center
    padding: 0 2px
    color: $grey-6
    cursor: pointer
  .current-answering
    border-color: green
    color: green
    border-width: 2px
  .answered
    border-color: $light-green
    background-color: $light-green
    color: white
  .current-answering.answered
    border-color: green
    background-color: green
    color: white
  .mini-slot
    transition: background-color .28s
    &:hover
      background-color: rgba(0, 0, 0, .04)
</style>
