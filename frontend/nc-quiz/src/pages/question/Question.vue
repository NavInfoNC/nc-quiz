<template>
  <q-page padding class="bg-grey-3">
    <q-card>
      <q-card-section>
        <single-choice-question></single-choice-question>
      </q-card-section>
    </q-card>
  </q-page>
</template>

<script>
import SingleChoiceQuestion from './components/SingleChoiceQuestion'

export default {
  name: 'Question',
  components: {
    SingleChoiceQuestion
  }
}
</script>

<style lang="stylus" scoped>

</style>
