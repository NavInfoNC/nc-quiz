<template>
  <q-list separator>
    <!-- 用户管理选项组 -->
    <q-expansion-item
      icon="fa fa-users"
      label="用户管理"
      header-class="header-nav-level1"
      group="left-nav"
    >
      <q-list separator class="q-ml-md">
        <q-item clickable v-ripple>
          <q-item-section avatar>
            <q-icon name="fa fa-window-close" color="primary" />
          </q-item-section>
          <q-item-section>权限管理</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section avatar>
            <q-icon name="fa fa-sitemap" color="primary" />
          </q-item-section>
          <q-item-section>组织架构管理</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section avatar>
            <q-icon name="fa fa-user-friends" color="primary" />
          </q-item-section>
          <q-item-section>用户组管理</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section avatar>
            <q-icon name="fa fa-user-circle" color="primary" />
          </q-item-section>
          <q-item-section>前台用户管理</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section avatar>
            <q-icon name="fa fa-user-secret" color="primary" />
          </q-item-section>
          <q-item-section>后台账号管理</q-item-section>
        </q-item>
      </q-list>
    </q-expansion-item>
    <!-- 文章管理选项组 -->
    <q-expansion-item
      icon="fa fa-newspaper"
      label="文章管理"
      header-class="header-nav-level1"
      group="left-nav"
    >
      <q-list separator class="q-ml-md">
        <q-item clickable v-ripple>
          <q-item-section avatar>
            <q-icon name="fa fa-copy" color="primary" />
          </q-item-section>
          <q-item-section>文章列表</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section avatar>
            <q-icon name="fa fa-bookmark" color="primary" />
          </q-item-section>
          <q-item-section>文章分类管理</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section avatar>
            <q-icon name="fa fa-grip-horizontal" color="primary" />
          </q-item-section>
          <q-item-section>首页轮播</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section avatar>
            <q-icon name="fa fa-star" color="primary" />
          </q-item-section>
          <q-item-section>首页推荐</q-item-section>
        </q-item>
      </q-list>
    </q-expansion-item>
    <!-- 测验管理选项组 -->
    <q-expansion-item
      icon="fa fa-spell-check"
      label="测验管理"
      header-class="header-nav-level1"
      group="left-nav"
    >
      <q-list separator class="q-ml-md">
        <q-item clickable v-ripple>
          <q-item-section avatar>
            <q-icon name="fa fa-list" color="primary" />
          </q-item-section>
          <q-item-section>测验列表</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section avatar>
            <q-icon name="fa fa-chart-pie" color="primary" />
          </q-item-section>
          <q-item-section>测验统计</q-item-section>
        </q-item>
      </q-list>
    </q-expansion-item>
    <!-- 题库管理选项组 -->
    <q-expansion-item
      icon="fa fa-database"
      label="题库管理"
      header-class="header-nav-level1"
      group="left-nav"
    >
      <q-list separator class="q-ml-md">
        <q-item clickable v-ripple>
          <q-item-section avatar>
            <q-icon name="fa fa-th" color="primary" />
          </q-item-section>
          <q-item-section>题库浏览</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section avatar>
            <q-icon name="fa fa-file-import" color="primary" />
          </q-item-section>
          <q-item-section>导入题库</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section avatar>
            <q-icon name="fa fa-file-export" color="primary" />
          </q-item-section>
          <q-item-section>导出题库</q-item-section>
        </q-item>
      </q-list>
    </q-expansion-item>
    <!-- 审核管理选项组 -->
    <q-expansion-item
      icon="fa fa-clipboard-check"
      label="审核管理"
      header-class="header-nav-level1"
      group="left-nav"
    >
      <q-list separator class="q-ml-md">
        <q-item clickable v-ripple>
          <q-item-section avatar>
            <q-icon name="fa fa-question-circle" color="primary" />
          </q-item-section>
          <q-item-section>题目审核</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section avatar>
            <q-icon name="fa fa-user-check" color="primary" />
          </q-item-section>
          <q-item-section>阅卷管理</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section avatar>
            <q-icon name="fa fa-check-double" color="primary" />
          </q-item-section>
          <q-item-section>得分修改</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section avatar>
            <q-icon name="fa fa-code-branch" color="primary" />
          </q-item-section>
          <q-item-section>阅卷分配</q-item-section>
        </q-item>
      </q-list>
    </q-expansion-item>
    <!-- 口令管理选项组 -->
    <q-expansion-item
      icon="fa fa-key"
      label="口令管理"
      header-class="header-nav-level1"
      group="left-nav"
    >
      <q-list separator class="q-ml-md">
        <q-item clickable v-ripple>
          <q-item-section avatar>
            <q-icon name="fa fa-unlock-alt" color="primary" />
          </q-item-section>
          <q-item-section>口令列表</q-item-section>
        </q-item>
      </q-list>
    </q-expansion-item>
    <!-- 类型管理选项组 -->
    <q-expansion-item
      icon="fa fa-cubes"
      label="类型管理"
      header-class="header-nav-level1"
      group="left-nav"
    >
      <q-list separator class="q-ml-md">
        <q-item clickable v-ripple>
          <q-item-section avatar>
            <q-icon name="fa fa-folder-open" color="primary" />
          </q-item-section>
          <q-item-section>测验分类</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section avatar>
            <q-icon name="fa fa-tags" color="primary" />
          </q-item-section>
          <q-item-section>题目标签</q-item-section>
        </q-item>
      </q-list>
    </q-expansion-item>
    <!-- 素材管理选项组 -->
    <q-expansion-item
      icon="fa fa-photo-video"
      label="素材管理"
      header-class="header-nav-level1"
      group="left-nav"
    >
      <q-list separator class="q-ml-md">
        <q-item clickable v-ripple>
          <q-item-section avatar>
            <q-icon name="fa fa-images" color="primary" />
          </q-item-section>
          <q-item-section>图库</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section avatar>
            <q-icon name="fa fa-music" color="primary" />
          </q-item-section>
          <q-item-section>乐库</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section avatar>
            <q-icon name="fa fa-video" color="primary" />
          </q-item-section>
          <q-item-section>媒体库</q-item-section>
        </q-item>
      </q-list>
    </q-expansion-item>
    <!-- 站内信选项组 -->
    <q-expansion-item
      icon="fa fa-envelope-open-text"
      label="站内信"
      header-class="header-nav-level1"
      group="left-nav"
    >
      <q-list separator class="q-ml-md">
        <q-item clickable v-ripple>
          <q-item-section avatar>
            <q-icon name="fa fa-inbox" color="primary" />
          </q-item-section>
          <q-item-section>收件箱</q-item-section>
        </q-item>
        <q-item clickable v-ripple>
          <q-item-section avatar>
            <q-icon name="fa fa-edit" color="primary" />
          </q-item-section>
          <q-item-section>写信</q-item-section>
        </q-item>
      </q-list>
    </q-expansion-item>
    <!-- 个人设置选项组 -->
    <q-expansion-item
      icon="fa fa-user-cog"
      label="个人设置"
      header-class="header-nav-level1"
      group="left-nav"
    >
      <q-list separator class="q-ml-md">
        <q-item clickable v-ripple>
          <q-item-section avatar>
            <q-icon name="fa fa-address-card" color="primary" />
          </q-item-section>
          <q-item-section>账户设置</q-item-section>
        </q-item>
      </q-list>
    </q-expansion-item>
  </q-list>
</template>

<script>
export default {
  name: 'LeftDrawerNavBar'
}
</script>

<style lang="stylus">
.header-nav-level1 i.fa
  color: $primary
.header-nav-level1 .q-item__label
  font-weight: 700
</style>

<style lang="stylus" scoped>
</style>
