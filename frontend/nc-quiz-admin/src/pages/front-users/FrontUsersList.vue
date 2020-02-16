<template>
  <div>
    <q-input
      outlined
      dense
      clearable
      clear-icon="close"
      placeholder="查找用户组或用户"
      v-model="filter"
    >
      <template v-slot:prepend>
        <q-icon name="search" />
      </template>
    </q-input>

    <q-tree
      :nodes="frontUsers"
      node-key="id"
      :filter="filter"
    >
      <template v-slot:default-header="prop">
        <div class="row items-center q-gutter-sm" v-if="prop.node.type === 1">
          <q-icon name="fa fa-folder" color="orange" />
          <div class="text-weight-bold text-primary">{{ prop.node.label }}</div>
        </div>
        <div class="row items-center q-gutter-sm" v-else>
          <q-avatar>
            <img :src="prop.node.avatar">
          </q-avatar>
          <div>{{ prop.node.label }}</div>
        </div>
      </template>
    </q-tree>
  </div>
</template>

<script>
export default {
  name: 'FrontUsersList',
  data () {
    return {
      filter: '',
      frontUsers: [
        {
          id: 1,
          label: '未分组用户',
          type: 1,
          children: [
            {
              id: 2,
              label: '测试用户1',
              type: 2,
              avatar: '/statics/defaults/male.png'
            }, {
              id: 3,
              label: '测试女账户',
              type: 2,
              avatar: '/statics/defaults/female.png'
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
