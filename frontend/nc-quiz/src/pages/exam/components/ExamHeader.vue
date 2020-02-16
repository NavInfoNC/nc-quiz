<template>
  <div class="row q-my-lg" style="overflow: hidden">
    <div class="col-auto">
      <q-img
        src="https://placeimg.com/500/300/nature"
        :ratio="4/3"
        style="width: 320px"
        class="rounded-borders"
      />
    </div>
    <div class="col q-ml-md">
      <div class="column items-left">
        <div class="exam-name col-auto">哈尔滨佛学院2020年第一季度佛学阶梯测试第一阶段</div>
        <div class="col-auto q-my-sm">
          <q-breadcrumbs class="text-primary" style="font-size: 1.3em">
            <template v-slot:separator>
              <q-icon size="1.5em" name="chevron_right" color="primary" />
            </template>

            <q-breadcrumbs-el label="所有测试" icon="list" />
            <q-breadcrumbs-el label="能力测试" icon="widgets" />
            <q-breadcrumbs-el label="修仙系列" icon="navigation" />
          </q-breadcrumbs>
        </div>

        <div class="col q-mt-md">
          <span class="text-primary">10086</span> 人次参与
        </div>

        <div class="col-auto q-mt-xs">
          <q-btn push color="green" size="lg" style="width: 220px" @click="confirm = true">参与测试</q-btn>
        </div>
      </div>
    </div>

    <q-dialog v-model="confirm" persistent>
      <q-card>
        <q-card-section class="row items-center">
          <div class="col-auto">
            <q-icon name="help" color="primary" style="font-size: 6em" />
          </div>
          <div class="col">
            <div class="q-ml-sm">您即将开始<span class="text-primary">C++ 高级程序员算法训练营结业笔试</span>的测试。请保证测试过程中的网络通畅。</div>
            <div class="q-ml-sm">本次测试共 <span class="text-red">20</span> 题，时间限制为 <span class="text-red">60分钟</span> 。</div>
            <div class="q-ml-sm">您确定现在就要开始吗？</div>
          </div>
        </q-card-section>

        <q-card-section class="column">
          <div class="col-auto">本次测试需要验证答题口令之后才能开始：</div>
          <div class="col">
            <q-input clearable outlined clear-icon="close" v-model="accessKey" placeholder="请输入答题口令">
              <template v-slot:prepend>
                <q-icon name="lock" />
              </template>
            </q-input>
          </div>
        </q-card-section>

        <q-card-actions align="right">
          <q-btn flat label="我再想想" color="grey-9" v-close-popup />
          <q-btn flat label="马上开始" color="primary" v-close-popup />
        </q-card-actions>
      </q-card>
    </q-dialog>
  </div>
</template>

<script>
export default {
  name: 'ExamHeader',
  data () {
    return {
      confirm: false,
      accessKey: ''
    }
  }
}
</script>

<style lang="stylus" scoped>
  .exam-name
    font-size: 2.3em
</style>
