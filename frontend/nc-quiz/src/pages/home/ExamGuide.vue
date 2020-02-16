<template>
  <q-list bordered class="rounded-borders">
    <q-item-label header>测试分类</q-item-label>
    <q-separator />
    <q-item clickable v-ripple>
      <q-item-section avatar top>
        <q-avatar icon="folder" color="primary" text-color="white" />
      </q-item-section>

      <q-item-section>
        <q-item-label lines="1">能力测试</q-item-label>
      </q-item-section>

      <q-item-section side>
        <q-icon name="chevron_right" color="primary" />
      </q-item-section>
    </q-item>
    <q-separator />
    <q-item clickable v-ripple>
      <q-item-section avatar top>
        <q-avatar icon="folder" color="primary" text-color="white" />
      </q-item-section>

      <q-item-section>
        <q-item-label lines="1">招聘测试</q-item-label>
      </q-item-section>

      <q-item-section side>
        <q-icon name="chevron_right" color="primary" />
      </q-item-section>
    </q-item>
    <q-separator />
    <q-item clickable v-ripple>
      <q-item-section avatar top>
        <q-avatar icon="folder" color="primary" text-color="white" />
      </q-item-section>

      <q-item-section>
        <q-item-label lines="1">心理测试</q-item-label>
      </q-item-section>

      <q-item-section side>
        <q-icon name="chevron_right" color="primary" />
      </q-item-section>
    </q-item>
    <q-separator />
    <q-item clickable v-ripple>
      <q-item-section avatar top>
        <q-avatar icon="folder" color="primary" text-color="white" />
      </q-item-section>

      <q-item-section>
        <q-item-label lines="1">娱乐测试</q-item-label>
      </q-item-section>

      <q-item-section side>
        <q-icon name="chevron_right" color="primary" />
      </q-item-section>
    </q-item>
    <q-separator />
    <q-item clickable v-ripple>
      <q-item-section avatar top>
        <q-avatar icon="folder" color="primary" text-color="white" />
      </q-item-section>

      <q-item-section>
        <q-item-label lines="1">调查问卷</q-item-label>
      </q-item-section>

      <q-item-section side>
        <q-icon name="chevron_right" color="primary" />
      </q-item-section>
    </q-item>
  </q-list>
</template>

<script>
export default {
  name: 'ExamGuide'
}
</script>

<style lang="stylus" scoped>
</style>
