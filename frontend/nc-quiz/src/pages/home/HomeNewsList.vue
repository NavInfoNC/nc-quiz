<template>
  <div class="fit rounded-borders news-box">
    <div class="news-header row items-end">
      <div class="col text-h6">新闻公告</div>
      <div class="col-auto">更多></div>
    </div>
    <q-separator spaced />
    <q-scroll-area class="fit">
      <q-list separator dense class="new-list">
        <q-item clickable v-ripple>
          <q-item-section class="ellipsis"><div class="ellipsis">新闻标题新闻标题新闻标题新闻标题新闻标题</div></q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section class="ellipsis"><div class="ellipsis">新闻标题新闻标题新闻标题新闻标题新闻标题</div></q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section>新闻标题</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section>新闻标题</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section>新闻标题</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section>新闻标题</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section>新闻标题</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section>新闻标题</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section>新闻标题</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section>新闻标题</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section>新闻标题</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section>新闻标题</q-item-section>
        </q-item>
      </q-list>
    </q-scroll-area>
  </div>
</template>

<script>
export default {
  name: 'HomeNewsList'
}
</script>

<style lang="stylus" scoped>
  .news-box
    border-style: solid
    border-color: $grey-3
    border-width: 1px
    overflow: hidden
    .news-header
      padding: 8px 8px 0 8px
      color: $primary
    .news-list
      overflow: hidden
</style>
