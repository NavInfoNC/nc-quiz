<template>
  <h1>第 {{index}} 题 <small>{{questionTypeDescription}}</small></h1>
</template>

<script>
import { questionTypeDesc } from '../../../assets/questions-common.js'

export default {
  name: 'QuestionHeader',
  props: {
    index: Number,
    type: String
  },
  computed: {
    questionTypeDescription () {
      return questionTypeDesc(this.type)
    }
  }
}
</script>

<style lang="stylus" scoped>
  h1
    margin: 0
    padding: 0
    font-size: 2em
    line-height: 1.6em
    border-bottom-style: solid
    border-bottom-width: 1px
    border-bottom-color: $grey-5
    font-weight: 700
    small
      font-weight: 100
      color: $grey-7
</style>
