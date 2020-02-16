<template>
  <titled-splitter
    left-title="用户列表"
    left-icon="fa fa-users"
    right-title="权限列表"
    right-icon="fa fa-clipboard-list"
  >
    <template v-slot:leftContent>
      <user-tree></user-tree>
    </template>

    <template v-slot:rightContent>
      <permission-tree :cpa="cPermissions"></permission-tree>
    </template>
  </titled-splitter>
</template>

<script>
import UserTree from './UserTree'
import PermissionTree from './PermissionTree'
import TitledSplitter from '../../components/TitledSplitter'
import axios from 'axios'

export default {
  name: 'UserPermission',
  components: {
    UserTree,
    PermissionTree,
    TitledSplitter
  },
  data () {
    return {
      splitterModel: 50,
      cPermissions: []
    }
  },
  methods: {
    getPermissions () {
      axios.get('/statics/mock/c-permissions.json')
        .then(this.getPermissionsSucc)
    },
    getPermissionsSucc (res) {
      console.log(res)
      if (res.status === 200) {
        this.cPermissions = res.data.permissions
      }
    }
  },
  mounted () {
    this.getPermissions()
  }
}
</script>

<style lang="stylus" scoped>
</style>
