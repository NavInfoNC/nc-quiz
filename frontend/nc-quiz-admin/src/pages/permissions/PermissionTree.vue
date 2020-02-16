<template>
  <div>
    <q-input
      dense
      outlined
      clearable
      clear-icon="close"
      ref="filter"
      v-model="permissionFilter"
      placeholder="搜索权限或组"
    >
      <template v-slot:prepend>
        <q-icon name="search" />
      </template>
    </q-input>

    <q-tree
      :nodes="cpa"
      node-key="id"
      :filter="permissionFilter"
      :ticked.sync="ticked"
      tick-strategy="leaf"
      accordion
      selected-color="primary"
    >
      <template v-slot:default-header="prop">
        <div v-if="prop.node.type === 0" class="row items-center">
          <q-icon name="folder" color="orange" size="28px" class="q-mr-sm" />
          <div class="text-weight-bold text-primary">{{prop.node.label}}</div>
        </div>
        <div v-else class="row items-center">
          <q-icon name="lock" color="primary" size="28px" class="q-mr-sm" />
          <div class="">{{prop.node.label}}</div>
          <q-tooltip
            v-if="prop.node.desc !== ''"
            :delay="1000"
          >
            <div style="max-width: 250px; font-size: 1.2em">{{prop.node.desc}}</div>
          </q-tooltip>
        </div>
      </template>
    </q-tree>
  </div>
</template>

<script>
export default {
  name: 'PermissionTree',
  props: {
    cpa: []
  },
  data () {
    return {
      permissionFilter: '',
      ticked: []
    }
  }
}
</script>

<style lang="stylus" scoped>

</style>
