<template>
  <div class="app-container">

    <el-row style="margin-bottom:10px">
    <el-input v-model="keyWord" placeholder="请输入内容" class="input-with-select">
    <el-select v-model="value" slot="prepend" placeholder="选择">
      <el-option
        v-for="item in options"
        :key="item.value"
        :label="item.label"
        :value="item.value">
      </el-option>
    </el-select>
    <el-button slot="append" icon="el-icon-search" @click="searchName" ></el-button>
    </el-input>
    </el-row>


  <div class="mainTable">

  <el-row style="margin-bottom:10px">
  <el-button type="primary" @click="Visible = true;formOpe.formType = 0;" >增加</el-button>
  <el-button type="danger" @click="deleteMuti" :disabled="deleteMutiOk">删除</el-button>
  <el-button type="success" @click="refresh">刷新</el-button>
  </el-row>

  <Form :Visible="Visible" :formOpe="formOpe"  v-on:closeAdd="closeAddForm" @closeEdit="closeEditForm" v-on:closeForm="Visible=false"></Form>  <!--引号中的closeTable是父组件定义，前面的是子组件定义-->
  <Buy :Visible="bVisible" :formBuInfo="formBuInfo"  v-on:close="closeBuy" v-on:closeForm="bVisible=false"></Buy>  <!--引号中的closeTable是父组件定义，前面的是子组件定义-->

    <!--将分页器和table绑定，-->
    <el-table
      stripe
      v-loading="listLoading"
      ref="checkTable"
      :data="pagelist"  
      element-loading-text="Loading"
      border
      fit
      :row-key="getRowKeys"
      @selection-change="handleSelectionChange"
      highlight-current-row
    >
      <el-table-column
      :reserve-selection="true"
      type="selection"
      width="55"
      :show-overflow-tooltip="true"
      align="center"
      >
      </el-table-column>

      
      <el-table-column align="center" label="ID" width="95">
        <template slot-scope="scope">
          {{ scope.row.id }}
        </template>
        <!-- //--- scope.row 直接取到该单元格对象，就是数组里的元素对象，即是tableData[scope.$index]
        //---.title 是对象里面的title属性的值 -->
      </el-table-column>

      <el-table-column label="名称" width="110" align="center">
        <template slot-scope="scope">
          {{ scope.row.dName }}
        </template>
      </el-table-column>

      <el-table-column label="编号" width="110" align="center">
        <template slot-scope="scope">
          {{ scope.row.dCode }}
        </template>
      </el-table-column>
      
      <el-table-column label="单价" width="110" align="center">
        <template slot-scope="scope">
          {{ scope.row.price }}
        </template>
      </el-table-column>

      <el-table-column label="库存数量" width="110" align="center">
        <template slot-scope="scope">
          {{ scope.row.stockCount }}
        </template>
      </el-table-column>

      <el-table-column align="center" prop="productionDate" label="创建时间" width="200">
        <template slot-scope="scope">
          <i class="el-icon-time" />
          <span>{{ scope.row.productionDate }}</span>
        </template>
      </el-table-column >

      <el-table-column label="厂商" width="110" align="center">
        <template slot-scope="scope">
          {{ scope.row.manufacturer }}
        </template> 
      </el-table-column>

      <el-table-column label="类别ID" width="110" align="center">
        <template slot-scope="scope">
          {{ scope.row.categoryId }}
        </template> 
      </el-table-column>

      <el-table-column width="150" align="center" label="操作" >
        <template slot-scope="scope">
        <!--单个编辑按钮,记录表格位置，编辑后仍然在同一个位置-->
        <el-button @click="editModify(scope.row , scope.$index)" type="primary" icon="el-icon-edit" size="small"
                   circle></el-button>
        <!--单个删除按钮-->           
        <el-button @click="deleteSingle(scope.$index, scope.row)" type="danger"
                   icon="el-icon-delete" size="small"
                   circle></el-button>
        <!--单个购买按钮-->           
        <el-button @click="formBuy( scope.row,scope.$index)" type="warning"
                   icon="el-icon-shopping-cart-2" size="small"
                   circle></el-button>
        </template>
      </el-table-column>

    </el-table>

    <el-pagination
    style="margin-top:10px;"
    align="center"
    layout="prev, pager, next"
    :total="list.length"
    :current-page.sync="currentPage"
    @current-change="handleCurrentChange"  
    background
    >
    </el-pagination>

  </div>

  </div>
</template>

<script>
import { getUserList,addCate,editCate,deleteCate } from '@/api/infoTable'
import Form from './form.vue'
import Buy from './buy.vue'

export default {
  components: {
    Form,
    Buy
  },
  data() {
    return {
      //渲染table控件
      list: [],
      listLoading: true,

      //添加与编辑子组件控件
      formOpe: {
      formType: '',    //控制form表单状态，0为增加，1为修改
      formVal: {},
      formIndex: ''
      },  
      Visible:false,

      //购买组件
      formBuInfo: {},
      bVisible:false,

      //批量删除控件  
      multipleSelection: [],
      deleteMutiOk:true,

      //分页控件
      currentPage:1,

      //前端模糊搜搜控件
       options: [{
          value: 'cname',
          label: '类别'
        }, {
          value: 'id',
          label: '编号'
        }],
        value: '',
      keyWord: '',
    }
  },

  created() {
    this.fetchData()
  },
  //监听多选框内容，不为0则批量删除可选
  watch: { 
    multipleSelection(val) {
      if(val.length == 0) this.deleteMutiOk = true;
      else this.deleteMutiOk = false;
    }
  },

  computed: {
    pagelist() {
    return this.list.slice((this.currentPage-1)*10,this.currentPage*10)
    }
  },

  methods: {
    //axios获取table数据
    fetchData() {
      var that = this
      this.listLoading = true
      getUserList().then(
        response => {
        that.list = response.data
        console.log(response.data)   
        that.listLoading = false
      })
    },
    //关闭add组件
    closeAddForm(newData) {
      this.Visible = false
      this.list.push(newData)
      addCate(newData).then(
        res =>{
          if(res == "sucess")
          this.$message("添加成功!")
          else
          this.$message("添加失败!")
        }
      )
    },
    //关闭edit组件
    closeEditForm(newData) {
      this.Visible = false;
      this.list.splice((this.currentPage-1)*10 + this.formOpe.formIndex,1,newData);
      editCate(newData).then(
        res=>{
          if(res == "sucess")
          this.$message("修改成功!")
          else
          this.$message("修改失败!")
        })  
    },
    //多选函数，记忆储存
    getRowKeys(row) {
      return row.id
    },
    handleSelectionChange(val){
      this.multipleSelection = val
    },
    //批量删除
    deleteMuti() {
    this.$confirm("是否确认删除数据，删除后不可恢复?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "info"
    }).then(() => {
      let orVal = this.multipleSelection;
      let obVal = this.list;
      if(orVal){
        orVal.forEach(function (item, index){
          obVal.forEach(function(oItem,oIndex){
            if(item.id == oItem.id)(
              obVal.splice(oIndex,1)
            )
          })
        })
        }

        orVal.forEach(function(item,index){
          deleteCate(item.id)
        })

        this.$refs.checkTable.clearSelection()
      }
      )
    },
    //单个删除
    deleteSingle(val,row) {
      var page= this.currentPage;
      // 模态框删除按钮
      this.$confirm("是否确认删除本条数据，删除后不可恢复?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "info"
      }).then(() => {
        // 此为假删除，只是删除了模态框中当前行的数据，并没有真正删除表格数据
        this.list.splice((page-1)*10+val, 1)
        deleteCate(row.id).then(
        res=>{
          if(res == "sucess")
          this.$message("删除成功!")
          else
          this.$message("删除失败!")
        })
       });
    },
    //编辑组件开启
    editModify(val,index) {
        this.formOpe.formType = 1
        this.formOpe.formVal = val
        this.formOpe.formIndex = index
        this.Visible = true
    },
    //购买组件
    formBuy(val){
      this.formBuInfo = val
      this.bVisible = true
    },
    //购买组件关闭
    closeBuy(val){
      this.bVisible = false
      let row = this.formBuInfo
      row.stockCount =parseInt(row.stockCount) - parseInt(val)
      editCate(row).then(
        res=>{
          if(res == "sucess")
          this.$message("购买成功!")
          else
          this.$message("购买失败!")
        })  
    },

    //分页组件，和watch共同控制分页
    handleCurrentChange(val) {
          // 改变默认的页数
      this.currentPage=val
//      this.handleSelectionOpen()
     },
     //搜索控件
  searchName() {
    var _that=this
    getUserList().then(
      res => {
      _that.list = res.data
      var col = _that.value
      //自动转换封装正则表达式
      let obList = []
      var reg = new RegExp(_that.keyWord);
      _that.list.forEach( function(item,index){
        if(item[col].match(reg)) obList.push(item);

        _that.list = obList;
      })
      }
    )

      
    },
    //刷新控件
    refresh() {
      this.fetchData();
    }
  }
}
</script>

<style>
.mainTable{
  width:1200px;
  padding: 10px;
  border: 1px rgb(245,247,250) solid;
  background: white;
}
.input-with-select{
  width:500px;
  float:left;
}
.el-input-group__prepend{
  width:80px;
  background:white;
  color: #8e9197;
}
</style>
