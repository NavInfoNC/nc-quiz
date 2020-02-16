<template>
  <div>
    <search-bar-header></search-bar-header>
    <q-separator spaced />
    <search-category-bar></search-category-bar>
    <search-result></search-result>
  </div>
</template>

<script>
import SearchBarHeader from './components/SearchBarHeader'
import SearchCategoryBar from './components/SearchCategoryBar'
import SearchResult from './components/SearchResult'

export default {
  name: 'Search',
  components: {
    SearchBarHeader,
    SearchCategoryBar,
    SearchResult
  }
}
</script>

<style lang="stylus" scoped>
</style>
