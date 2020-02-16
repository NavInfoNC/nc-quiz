<template>
  <div>
    <q-tabs
      v-model="tab"
      dense
      class="text-grey"
      active-color="primary"
      indicator-color="primary"
      align="justify"
    >
      <q-tab name="basic" label="基本信息" />
      <q-tab name="members" label="成员信息" />
    </q-tabs>

    <q-separator />

    <q-tab-panels v-model="tab" animated>
      <q-tab-panel name="basic">
        <organization-basic></organization-basic>
      </q-tab-panel>

      <q-tab-panel name="members">
        <organization-members></organization-members>
      </q-tab-panel>
    </q-tab-panels>
  </div>
</template>

<script>
import OrganizationBasic from './OrganizationBasic'
import OrganizationMembers from './OrganizationMembers'

export default {
  name: 'OrgnizationDetail',
  components: {
    OrganizationBasic,
    OrganizationMembers
  },
  data () {
    return {
      tab: 'basic'
    }
  }
}
</script>

<style lang="stylus" scoped>

</style>
