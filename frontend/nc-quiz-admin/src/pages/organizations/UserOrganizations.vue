<template>
  <titled-splitter
    left-title="组织架构"
    left-icon="fa fa-sitemap"
    right-title="详细信息"
    right-icon="fa fa-list"
    left-add-button
  >
    <template v-slot:leftContent>
      <organization-tree :orgs="organizations"></organization-tree>
    </template>
    <template v-slot:rightContent>
      <organization-detail></organization-detail>
    </template>
  </titled-splitter>
</template>

<script>
import TitledSplitter from '../../components/TitledSplitter'
import OrganizationTree from './OrganizationTree'
import OrganizationDetail from './OrganizationDetail'
import axios from 'axios'

export default {
  name: 'UserOrganizations',
  components: {
    TitledSplitter,
    OrganizationTree,
    OrganizationDetail
  },
  data () {
    return {
      organizations: []
    }
  },
  methods: {
    getOrganizations () {
      axios.get('/statics/mock/organizations.json')
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
