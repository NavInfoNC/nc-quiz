<template>
  <div>
    <q-splitter
      v-model="splitterModel"
      class="fit col-grow"
    >
      <template v-slot:before>
        <div class="q-px-sm fit">
          <div ref="header">
            <div class="text-h6">
              <q-icon :name="leftIcon" class="q-mr-md" />
              <span>{{ leftTitle }}</span>
              <q-icon v-if="leftAddButton" name="fa fa-plus" class="float-right q-ma-sm" />
            </div>
            <q-separator spaced />
          </div>

          <div class="content">
            <slot name="leftContent"></slot>
          </div>
        </div>
      </template>

      <template v-slot:after>
        <div class="q-px-sm">
          <div class="text-h6">
            <q-icon :name="rightIcon" class="q-mr-md" />
            <span>{{ rightTitle }}</span></div>
          <q-separator spaced />

          <div class="content">
              <slot name="rightContent"></slot>
          </div>
        </div>
      </template>
    </q-splitter>
  </div>
</template>

<script>
export default {
  name: 'TitledSplitter',
  props: {
    leftTitle: String,
    leftIcon: String,
    rightTitle: String,
    rightIcon: String,
    leftAddButton: {
      type: Boolean,
      default: false
    }
  },
  data () {
    return {
      splitterModel: 50
    }
  }
}
</script>

<style lang="stylus" scoped>

</style>
