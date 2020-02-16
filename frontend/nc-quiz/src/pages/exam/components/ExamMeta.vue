<template>
  <q-markup-table separator="vertical" bordered>
    <thead>
      <tr>
        <th class="text-left">项目</th>
        <th class="text-left">值</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td class="caption">发布者</td>
        <td class="value">伊万诺夫</td>
      </tr>
      <tr>
        <td class="caption">测试时长</td>
        <td class="value">60分钟</td>
      </tr>
      <tr>
        <td class="caption">题量</td>
        <td class="value">20 题</td>
      </tr>
      <tr>
        <td class="caption">满分</td>
        <td class="value">100 分</td>
      </tr>
      <tr>
        <td class="caption">可重复参与</td>
        <td class="value">否</td>
      </tr>
      <tr>
        <td class="caption">参与次数</td>
        <td class="value">0</td>
      </tr>
      <tr>
        <td class="caption">试卷数量</td>
        <td class="value">无限</td>
      </tr>
      <tr>
        <td class="caption">公开测试</td>
        <td class="value">否</td>
      </tr>
      <tr>
        <td class="caption">题型</td>
        <td class="value" style="white-space: pre-wrap">单项选择题，多项选择题，判断题，填空题</td>
      </tr>
      <tr>
        <td class="caption">试卷形式</td>
        <td class="value">随机出题</td>
      </tr>
      <tr>
        <td class="caption">答题限制</td>
        <td class="value" style="white-space: pre-wrap">不可修改，不可切页面</td>
      </tr>
      <tr>
        <td class="caption">得分公开</td>
        <td class="value">是</td>
      </tr>
      <tr>
        <td class="caption">开始时间</td>
        <td class="value">2020年1月3日 12:00:00</td>
      </tr>
      <tr>
        <td class="caption">结束时间</td>
        <td class="value">2020年1月9日 12:00:00</td>
      </tr>
    </tbody>
  </q-markup-table>
</template>

<script>
export default {
  name: 'ExamMeta'
}
</script>

<style lang="stylus" scoped>
  .caption
    font-weight: 500
  .value
    color: $grey-7
</style>
