<template>
  <single-choice-board :choices="judgeChoices"></single-choice-board>
</template>

<script>
import SingleChoiceBoard from './SingleChoiceBoard'

export default {
  name: 'JudgementBoard',
  components: {
    SingleChoiceBoard
  },
  data () {
    return {
      judgeChoices: [{
        val: 'true',
        desc: '正确'
      }, {
        val: 'false',
        desc: '错误'
      }]
    }
  }
}
</script>
