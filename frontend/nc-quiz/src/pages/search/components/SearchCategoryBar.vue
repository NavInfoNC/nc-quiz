<template>
  <q-breadcrumbs>
    <template v-slot:separator>
      <q-icon
        size="1.5em"
        name="chevron_right"
        color="primary"
      />
    </template>

    <q-breadcrumbs-el label="全部" icon="list"></q-breadcrumbs-el>
    <q-breadcrumbs-el>
      <q-select
        outlined
        v-model="category1"
        :options="category1Options"
        dense
        color="primary"
      >
        <template v-slot:prepend>
          <q-icon color="primary" name="widgets" />
        </template>
      </q-select>
    </q-breadcrumbs-el>
    <q-breadcrumbs-el>
      <q-select
        outlined
        v-model="category1"
        :options="category1Options"
        dense
        color="primary"
      >
        <template v-slot:prepend>
          <q-icon color="primary" name="widgets" />
        </template>
      </q-select>
    </q-breadcrumbs-el>
  </q-breadcrumbs>
</template>

<script>
export default {
  name: 'SearchCategoryBar',
  data () {
    return {
      category1: '全部分类',
      category1Options: [
        '全部分类', '能力测试', '招聘测试'
      ]
    }
  }
}
</script>

<style lang="stylus" scoped>
</style>
