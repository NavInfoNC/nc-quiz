<template>
  <div>
    <div v-if="showHeader">
      <div class="header row items-end">
        <div class="col list-name">热门测试</div>
        <div class="col-auto more cursor-pointer">更多></div>
      </div>
      <q-separator />
    </div>

    <q-intersection
      transition="jump-up"
      once
    >
      <div class="row items-begin">
        <q-card class="q-ma-sm col-4">
          <img class="exam-avatar" src="https://cdn.quasar.dev/img/mountains.jpg">

          <q-card-section>
            <div class="text-exam-title ellipsis-2-lines">第二套全国中学生高中物理知识竞赛2020年春季赛季第一次尖子生测试</div>
            <div class="text-subtitle row">
              <div class="col"></div>
              <div class="col-auto">John Doe</div>
            </div>
            <div class="text-desc row">
              <div class="col">
                <q-badge color="orange">能力测试</q-badge>
                <q-badge color="orange">物理</q-badge>
              </div>
              <div class="col-auto">
                <q-icon name="alarm" /> 60'
                <q-icon name="whatshot" /> 10086
              </div>
            </div>
          </q-card-section>
        </q-card>
      </div>
    </q-intersection>
  </div>
</template>

<script>
export default {
  name: 'ExamList',
  props: {
    showHeader: {
      type: Boolean,
      default: true
    }
  }
}
</script>

<style lang="stylus" scoped>
  .header
    padding-top: 10px
    .list-name
      color: $primary
      font-size: 2.2em
    .more
      color: $primary
  .exam-avatar
    width: 100%
    height: 150px
  .text-exam-title
    font-size: 1.5em
  .text-subtitle
    color: $grey-8
</style>
