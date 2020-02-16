<template>
  <div>
    <div class="row items-top">
      <div class="col-3">
        <exam-guide></exam-guide>
      </div>
      <div class="col-6">
        <q-carousel
          animated
          v-model="slide"
          arrows
          navigation
          infinite
          autoplay
          class="fit"
        >
          <q-carousel-slide :name="1" img-src="https://cdn.quasar.dev/img/mountains.jpg" />
          <q-carousel-slide :name="2" img-src="https://cdn.quasar.dev/img/parallax1.jpg" />
          <q-carousel-slide :name="3" img-src="https://cdn.quasar.dev/img/parallax2.jpg" />
          <q-carousel-slide :name="4" img-src="https://cdn.quasar.dev/img/quasar.jpg" />
        </q-carousel>
      </div>
      <div class="col-3">
        <home-news-list></home-news-list>
      </div>
    </div>

    <exam-list></exam-list>
  </div>
</template>

<script>
import ExamGuide from './home/ExamGuide'
import HomeNewsList from './home/HomeNewsList'
import ExamList from './home/ExamList'

export default {
  name: 'PageIndex',
  components: {
    ExamGuide,
    HomeNewsList,
    ExamList
  },
  data () {
    return {
      slide: 1
    }
  }
}
</script>

<style lang="stylus" scoped>
</style>
