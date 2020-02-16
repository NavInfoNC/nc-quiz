<template>
  <titled-splitter
    left-title="用户组"
    left-icon="fa fa-users"
    right-title="详细信息"
    right-icon="fa fa-list"
    left-add-button
  >
    <template v-slot:leftContent>
      <organization-tree :orgs="organizations"></organization-tree>
    </template>
    <template v-slot:rightContent>
      <group-detail></group-detail>
    </template>
  </titled-splitter>
</template>

<script>
import TitledSplitter from '../../components/TitledSplitter'
import OrganizationTree from '../organizations/OrganizationTree'
import GroupDetail from './GroupDetail'
import axios from 'axios'

export default {
  name: 'UserGroups',
  components: {
    TitledSplitter,
    OrganizationTree,
    GroupDetail
  },
  data () {
    return {
      organizations: []
    }
  },
  methods: {
    getOrganizations () {
      axios.get('/statics/mock/groups.json')
        .then(this.getOrganizationsSucc)
    },
    getOrganizationsSucc (res) {
      if (res.status === 200) {
        console.log(res.data.organizations)
        this.organizations = res.data.organizations
      }
    }
  },
  mounted () {
    this.getOrganizations()
  }
}
</script>

<style lang="stylus" scoped>

</style>
