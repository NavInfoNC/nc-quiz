<template>
  <div class="row items-center q-gutter-sm">
    <div class="col-auto">
      <img src="../../../assets/global-logo.png" class="fit" >
    </div>
    <div class="col">
      <q-input
        outlined
        clearable
        clear-icon="close"
        v-model="searchText"
        placeholder="搜索考试信息"
      >
        <template v-slot:prepend>
          <q-icon name="search" />
        </template>
      </q-input>
    </div>
    <div class="col-auto">
      <q-btn
        glossy
        color="primary"
        label="搜 索"
        style="height: 54px; width: 120px"
      >
      </q-btn>
    </div>
  </div>
</template>

<script>
export default {
  name: 'SearchBarHeader',
  data () {
    return {
      searchText: ''
    }
  }
}
</script>

<style lang="stylus" scoped>
</style>
