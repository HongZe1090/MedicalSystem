<template>
  <el-dialog
  :title="formTitle"
  :visible.sync="Visible"
  width="35%"
  :before-close="closeForm">

  <el-form ref="form" label-width="120px" size="medium" style="margin-right:40px;">

      <el-form-item label="药品名称:">
          <template>{{ formBuInfo.dName }}</template>
      </el-form-item>

      <el-form-item label="药品编号:">
          <template>{{ formBuInfo.dCode }}</template>
      </el-form-item>

      <el-form-item label="单价:">
          <template>{{ formBuInfo.price }}</template>
      </el-form-item>

      <el-form-item label="库存:">
          <template>{{ formBuInfo.stockCount }}</template>
      </el-form-item>

      <el-form-item label="购买数量">
        <el-input v-model="number" />
      </el-form-item>


      <el-form-item>
        <el-button type="primary" @click="onSub" style="margin:10px 50px 0 45px;">提交</el-button>
        <el-button @click="closeForm">取消</el-button>
      </el-form-item>

    </el-form>

  </el-dialog>
</template>

<script>

import { addCate } from "@/api/saleTable"

export default {
  name: 'Buy',
  data() {
    return {
      number: '',
    }
  },
  props: ['Visible','formBuInfo'],
  computed: {
      formTitle(){
          return "购买药品"+' '+this.formBuInfo.dName
      }
  },
  methods: {

    //购买并回传父组件
    onSub() {
        let _that = this
        let form = {}
        var d = new Date()
        form.saleId =  d.getMinutes() + d.getSeconds()
        form.saleDate = d.getFullYear() + "-" + (d.getMonth()+1) + "-" + d.getDate();
        form.dcode = this.formBuInfo.dCode
        form.salePrice = this.formBuInfo.price
        form.saleCount = this.number
        form.managerId = this.$store.getters.avatar;

        console.log(this.$store.getters.avatar)

    this.$confirm("是否确认购买?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "info"
      }).then(() => { 
          addCate(form).then(()=>
          {
            _that.$emit('close',form.saleCount);
          })
      })
      
    },

    //关闭
    closeForm() {
      //this.Visible = false; 不能直接修改props中的值,同时要和父组件中的效果统一，故可以调用父组件改变重新传参
      this.$emit('closeForm');
    }
  }
}
</script>
