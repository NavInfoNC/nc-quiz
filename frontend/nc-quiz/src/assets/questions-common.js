export function questionTypeDesc (t) {
  if (t === 'singleChoice') {
    return '单项选择题'
  } else if (t === 'multipleChoice') {
    return '多项选择题'
  } else if (t === 'indefiniteChoice') {
    return '不定项选择题'
  } else if (t === 'completion') {
    return '填空题'
  } else if (t === 'judgement') {
    return '判断题'
  } else if (t === 'essay') {
    return '问答题'
  } else {
    console.log('Unknown question type: ' + t)
    return t
  }
}
