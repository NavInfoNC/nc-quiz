<template>
  <div>
    <q-input
      dense
      outlined
      clearable
      clear-icon="close"
      ref="filter"
      v-model="filter"
      :placeholder="filterHint"
    >
      <template v-slot:prepend>
        <q-icon name="search" />
      </template>
    </q-input>

    <q-tree
      :nodes="orgs"
      node-key="id"
      :filter="filter"
      selected-color="primary"
      :selected.sync="selected"
      :filter-method="myFilterMethod"
    >
      <template v-slot:default-header="prop">
        <div class="row items-center">
          <q-icon :name="getNodeIcon(prop.node.type)" color="purple" size="18px" class="q-mr-sm" />
          <div :class="getNodeStyle(prop.node.type)">{{prop.node.label}}</div>
        </div>
      </template>
    </q-tree>
  </div>
</template>

<script>
export default {
  name: 'OrganizationTree',
  props: {
    orgs: Array,
    listGroups: {
      type: Boolean,
      default: false
    }
  },
  data () {
    return {
      filter: '',
      selected: ''
    }
  },
  computed: {
    filterHint () {
      return this.listGroups ? '搜索组织架构或用户组' : '搜索组织架构'
    }
  },
  methods: {
    getNodeIcon (type) {
      switch (type) {
        case 0:
          return 'fa fa-home'
        case 1:
          return 'fa fa-warehouse'
        case 2:
          return 'fa fa-users'
        default:
          return 'fa fa-question'
      }
    },
    getNodeStyle (type) {
      if (type !== 2) {
        return 'text-weight-bold'
      }
      return ''
    },
    myFilterMethod (node, filter) {
      console.log('done')
      return true
    }
  }
}
</script>

<style lang="stylus" scoped>

</style>
