<template>
  <div>
    <div class="row header-buttons">
      <q-space />
      <q-btn-group unelevated rounded>
        <q-btn color="red" unelevated rounded icon="fa fa-times" label="移除所选成员" />
        <q-btn color="green" unelevated rounded icon-right="fa fa-plus" label="添加新成员" />
      </q-btn-group>
    </div>

    <q-list separator>
      <q-item clickable v-ripple>
        <q-item-section side top>
          <q-checkbox v-model="check1" />
        </q-item-section>

        <q-item-section>
          <q-item-label>管理员</q-item-label>
        </q-item-section>

        <q-item-section side>
          <q-icon name="fa fa-users" color="primary" />
        </q-item-section>
      </q-item>

      <q-item clickable v-ripple>
        <q-item-section side top>
          <q-checkbox v-model="check1" />
        </q-item-section>

        <q-item-section>
          <q-item-label>管理员</q-item-label>
        </q-item-section>

        <q-item-section side>
          <q-icon name="fa fa-users" color="primary" />
        </q-item-section>
      </q-item>
    </q-list>
  </div>
</template>

<script>
export default {
  name: 'OrganizationMembers'
}
</script>

<style lang="stylus" scoped>

</style>
