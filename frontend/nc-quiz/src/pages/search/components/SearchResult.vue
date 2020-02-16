<template>
  <div>
    <exam-list :showHeader="false"></exam-list>
    <div class="q-pa-lg flex flex-center">
      <q-pagination
        v-model="currentPage"
        color="primary"
        :max="10"
        :max-pages="6"
        :boundary-numbers="true"
      >
      </q-pagination>
    </div>
  </div>
</template>

<script>
import ExamList from '../../home/ExamList'

export default {
  name: 'SearchResult',
  components: {
    ExamList
  },
  data () {
    return {
      currentPage: 6
    }
  }
}
</script>

<style lang="stylus" scoped>
</style>
