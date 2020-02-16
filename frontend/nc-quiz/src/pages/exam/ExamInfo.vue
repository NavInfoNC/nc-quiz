<template>
  <div>
    <exam-header></exam-header>
    <div class="text-h5">测试详情</div>
    <q-separator spaced />
    <div class="row">
      <div class="col-8">
        <exam-desc></exam-desc>
      </div>
      <div class="col-4 q-mb-lg">
        <exam-meta></exam-meta>
      </div>
    </div>
  </div>
</template>

<script>
import ExamHeader from './components/ExamHeader'
import ExamDesc from './components/ExamDesc'
import ExamMeta from './components/ExamMeta'

export default {
  name: 'ExamInfo',
  components: {
    ExamHeader,
    ExamDesc,
    ExamMeta
  }
}
</script>

<style lang="stylus" scoped>
</style>
