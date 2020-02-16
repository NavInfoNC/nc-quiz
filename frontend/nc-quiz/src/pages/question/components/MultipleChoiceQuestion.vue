<template>
  <div>
    <question-header :index="1" type="singleChoice"></question-header>
    <question-description description="<p>一个艰难的决定是谁做出来的？</p>" :labels="['没有节操类', '互联网类']"></question-description>
    <judgement-board></judgement-board>
    <single-choice-board :choices="choices"></single-choice-board>
    <multiple-choice-board :choices="choices"></multiple-choice-board>
  </div>
</template>

<script>
import QuestionHeader from './QuestionHeader'
import QuestionDescription from './QuestionDescription'
import SingleChoiceBoard from './SingleChoiceBoard'
import MultipleChoiceBoard from './MultipleChoiceBoard'
import JudgementBoard from './JudgementBoard'

export default {
  name: 'SingleChoiceQuestion',
  components: {
    QuestionHeader,
    QuestionDescription,
    SingleChoiceBoard,
    MultipleChoiceBoard,
    JudgementBoard
  },
  data () {
    return {
      choices: [{
        val: 'A',
        desc: '360'
      }, {
        val: 'B',
        desc: '可口可乐'
      }, {
        val: 'C',
        desc: '快播'
      }, {
        val: 'D',
        desc: '腾讯'
      }]
    }
  }
}
</script>
