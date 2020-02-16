<template>
  <q-list class="choices">
    <q-item tag="label" v-ripple v-for="c of choices" :key="c.val">
      <q-item-section avatar>
        <q-radio v-model="choice" :val="c.val" color="teal" />
      </q-item-section>
      <q-item-section>
        <q-item-label v-html="c.desc"></q-item-label>
      </q-item-section>
    </q-item>
  </q-list>
</template>

<script>
export default {
  name: 'SingleChoiceBoard',
  props: {
    choices: Array
  },
  data () {
    return {
      choice: ''
    }
  }
}
</script>

<style lang="stylus">
  .choices
    margin-top: 18px
    font-size: 1.2em
</style>
