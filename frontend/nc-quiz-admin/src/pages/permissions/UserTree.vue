<template>
  <div>
    <q-input
      dense
      outlined
      clearable
      clear-icon="close"
      ref="filter"
      v-model="userFilter"
      placeholder="搜索用户或组"
    >
      <template v-slot:prepend>
        <q-icon name="search" />
      </template>
    </q-input>

    <q-tree
      :nodes="users"
      node-key="label"
      :filter="userFilter"
      :selected.sync="selected"
      accordion
      selected-color="primary"
    />
  </div>
</template>

<script>
export default {
  name: 'UserTree',
  data () {
    return {
      userFilter: '',
      selected: null,
      users: [
        {
          label: '所有用户',
          icon: 'home',
          children: [
            { label: 'Admin', icon: 'fa fa-user' },
            {
              label: '管理层',
              icon: 'folder',
              children: [
                {
                  label: '管理组',
                  icon: 'folder',
                  children: [
                    { label: 'Tecyle', icon: 'fa fa-user' },
                    { label: '小天才', icon: 'fa fa-user' }
                  ]
                }
              ]
            }
          ]
        }
      ]
    }
  }
}
</script>

<style lang="stylus" scoped>

</style>
