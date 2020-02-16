<template>
  <titled-splitter
    left-title="用户列表"
    left-icon="fa fa-users"
    right-title="详细信息"
    right-icon="fa fa-list"
    left-add-button
  >
    <template v-slot:leftContent>
      <front-users-list></front-users-list>
    </template>
    <template v-slot:rightContent>
    </template>
  </titled-splitter>
</template>

<script>
import TitledSplitter from '../../components/TitledSplitter'
import FrontUsersList from './FrontUsersList'

export default {
  name: 'FrontUsers',
  components: {
    TitledSplitter,
    FrontUsersList
  }
}
</script>

<style lang="stylus" scoped>

</style>
