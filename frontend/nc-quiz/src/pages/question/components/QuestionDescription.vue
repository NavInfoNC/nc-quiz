<template>
  <div class="question-area">
    <div v-html="description"></div>
    <div class="q-gutter-xs">
      <q-badge color="orange" v-for="item of labels" :key="item">{{item}}</q-badge>
    </div>
  </div>
</template>

<script>
export default {
  name: 'QuestionDescription',
  props: {
    description: String,
    labels: Array
  }
}
</script>

<style lang="stylus" scoped>
  .question-area
    margin-top: 15px
    background-color: $grey-3
    padding: 10px 28px
    position: relative
    font-size: 1.2em
    &:before
      content: "“"
      position: absolute
      top: -.2em
      left: .1em
      font-size: 4em
      color: $grey-5
    &:after
      content: "”"
      position: absolute
      bottom: -.7em
      right: .1em
      font-size: 4em
      color: $grey-5
</style>
