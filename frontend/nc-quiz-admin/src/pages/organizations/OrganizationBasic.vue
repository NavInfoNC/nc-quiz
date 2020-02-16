<template>
  <div class="q-gutter-md">
    <div class="row items-center">
      <div class="col-4 caption">
        组织名称：
      </div>
      <div class="col-8 value cursor-pointer text-primary">
        {{ orgName }}
        <q-icon name="fa fa-edit" />
        <q-popup-edit
          v-model="orgName"
          :validate="val => val.length > 0"
        >
          <template v-slot="{ initialValue, value, emitValue, validate, set, cancel }">
            <q-input
              autofocus
              dense
              :value="orgName"
              hint="输入新的组织架构名称"
              :rules="[ val => validate(value) || '组织架构名称不能为空' ]"
              @input="emitValue"
            >
              <template v-slot:after>
                <q-btn flat dense color="negative" icon="cancel" @click.stop="cancel" />
                <q-btn flat dense color="positive" icon="check_circle" @click.stop="set" :disable="validate(value) === false || initialValue === value" />
              </template>
            </q-input>
          </template>
        </q-popup-edit>
      </div>
    </div>

    <div class="row items-center">
      <div class="col-4 caption">
        创建人：
      </div>
      <div class="col-8 value">
        <q-chip>
          <q-avatar>
            <img src="/statics/defaults/male.png">
          </q-avatar>
          Administrator
        </q-chip>
      </div>
    </div>

    <div class="row items-center">
      <div class="col-4 caption">
        创建时间：
      </div>
      <div class="col-8 value">
        2019-12-31 12:23:11
      </div>
    </div>

    <div class="row items-center">
      <div class="col-4 caption">
        上次修改人：
      </div>
      <div class="col-8 value">
        <q-chip>
          <q-avatar>
            <img src="/statics/defaults/male.png">
          </q-avatar>
          Administrator
        </q-chip>
      </div>
    </div>

    <div class="row items-center">
      <div class="col-4 caption">
        上次修改时间：
      </div>
      <div class="col-8 value">
        2019-12-31 12:23:11
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'OrganizationBasic',
  data () {
    return {
      orgName: '最高管理层'
    }
  }
}
</script>

<style lang="stylus" scoped>

</style>
