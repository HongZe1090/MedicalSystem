<template>
  <el-dialog
  :title="formTitle"
  :visible.sync="Visible"
  width="35%"
  :before-close="closeForm">

  <el-form ref="form" :rules="Rules" :model="form" label-width="120px" size="medium" style="margin-right:40px;">

      <el-form-item label="ID" prop="id">
        <el-input v-model="form.id" :value="form.id" />
      </el-form-item>

      <el-form-item label="名称" prop="dName">
        <el-input v-model="form.dName" />
      </el-form-item>

      <el-form-item label="编号" prop="dCode">
        <el-input v-model="form.dCode" />
      </el-form-item>

      <el-form-item label="单价" prop="price">
        <el-input v-model="form.price" />
      </el-form-item>

      <el-form-item label="库存数量" prop="stockCount">
        <el-input v-model="form.stockCount" />
      </el-form-item>

      <el-form-item label="生产日期">
          <el-date-picker v-model="form.productionDate" type="date" placeholder="自动填充" style="width: 100%;" :disabled="false" />
      </el-form-item>

      <el-form-item label="厂商">
        <el-input v-model="form.manufacturer" :value="form.manufacturer" />
      </el-form-item>

      <el-form-item label="类别ID">
        <el-input v-model="form.categoryId" />
      </el-form-item>


      <el-form-item>
        <el-button v-if="formOpe.formType == 0" type="primary" @click="onAddSub" style="margin:10px 50px 0 45px;">提交</el-button>
        <el-button v-else type="primary" @click="onEditSub" style="margin:10px 50px 0 45px;">提交</el-button>
        <el-button @click="closeForm">取消</el-button>
      </el-form-item>

    </el-form>

  </el-dialog>
</template>

<script>

export default {
  name: 'Form',
  data() {
    return {
      formTitle: '',
      form: {
         id: '',
         dCode: '',
         dName: '',
         price: '',
         stockCount: '',
         productionDate: '',
         manufacturer: '',
         categoryId: ''
      },
      Rules: {
        id: [{ required: true,message: '请输入ID', trigger: 'blur'}],
        dName: [{ required: true, message: '请输入名称',trigger: 'blur'}],
        dCode: [{ required: true, message: '请输入编号',trigger: 'blur'}],
        price: [{ required: true, message: '请输入价格',trigger: 'blur'}],
        stockCount: [{ required: true, message: '请输入库存',trigger: 'blur'}]
      },

    }
  },
  props: ['Visible','formOpe'],
  watch: {
    Visible(val) {
    if(val == true)
    this.setForm();
    }
  },
  methods: {

    //设置form状态，一组件俩用
    setForm() {
    console.log(this.formOpe);
    var state = this.formOpe.formType;
    var info = this.formOpe.formVal;
    //为防止上次留下的 form 值影响，需要清空
    if ( state == 0){
      this.formTitle = "添加类别";
      for(let key in this.form)
      this.form[key] = '';
    }
    else{
      this.formTitle = "编辑类别";
      //实现深拷贝，依次（递归）复制非对象
      for(let key in info)
      this.form[key] = info[key];
    }

    },
    //添加回传父组件
    onAddSub() {
      let newData = this.form

this.$refs.form.validate(valid => {
        if (valid) {
      this.$confirm("是否确认添加本条数据?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "info"
      }).then(() => {  
        console.log(newData.productionDate);
        let d = new Date(newData.productionDate)
        newData.productionDate = `${d.getFullYear()}-${d.getMonth()}-${d.getDate()-1}` 
        this.$emit('closeAdd',newData);
      })
        }
    })
    },

    //编辑回传父组件
    onEditSub() {
      //用瑕疵，如果没有改也会提示，缺少表单校验
      let newData = this.form;

      this.$confirm("是否确认修改本条数据?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "info"
      }).then(() => { 
        this.$emit('closeEdit',newData);
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
