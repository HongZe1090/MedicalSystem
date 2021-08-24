<template>
  <div class="app-container">

    <el-row style="margin-bottom:10px">
    <el-input v-model="keyWord" placeholder="请输入内容" class="input-with-select">
    <el-select v-model="value" slot="prepend" placeholder="请选择">
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

  <!--？？？奇怪的bug，为什么这里的input不好用，明明和上面的一摸一样 
    <el-row style="margin-bottom:10px">
    <el-input placeholder="请输入内容" :v-model="search.keyWord" class="input-with-select">
    <template slot="prepend" >
      昵称
    </template>
    <el-button slot="append" icon="el-icon-search" @click="searchName" ></el-button>
    </el-input>
  </el-row>  -->

  <div class="mainTable">

  <el-row style="margin-bottom:10px">
  <el-button type="success" @click="refresh">刷新</el-button>
  </el-row>

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

      
      <el-table-column align="center" label="销售编号" width="95">
        <template slot-scope="scope">
          {{ scope.row.saleId }}
        </template>
        <!-- //--- scope.row 直接取到该单元格对象，就是数组里的元素对象，即是tableData[scope.$index]
        //---.title 是对象里面的title属性的值 -->
      </el-table-column>

      <el-table-column align="center" prop="saleDate" label="销售日期" width="200">
        <template slot-scope="scope">
          <i class="el-icon-time" />
          <span>{{ scope.row.saleDate }}</span>
        </template>
      </el-table-column >

      <el-table-column label="药品编号" width="110" align="center">
        <template slot-scope="scope">
          {{ scope.row.dcode }}
        </template>
      </el-table-column>
      
      <el-table-column label="销售数量" width="110" align="center">
        <template slot-scope="scope">
          {{ scope.row.saleCount }}
        </template>
      </el-table-column>

      <el-table-column label="销售价格" width="110" align="center">
        <template slot-scope="scope">
          {{ scope.row.salePrice }}
        </template>
      </el-table-column>

      <el-table-column label="购买人ID" width="110" align="center">
        <template slot-scope="scope">
          {{ scope.row.managerId }}
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
import { getUserList} from '@/api/saleTable'

export default {
  data() {
    return {
      //渲染table控件
      list: [],
      listLoading: true,
  

      //分页控件
      currentPage:1,

      //前端模糊搜搜控件
       options: [{
          value: 'saleId',
          label: '销售编号'
        }, {
          value: 'managerId',
          label: '购买人ID'
        }],
        value: '',
      keyWord: '',
    }
  },

  created() {
    this.fetchData()
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
        that.listLoading = false
      })
    },
    //多选函数，记忆储存
    getRowKeys(row) {
      return row.id
    },
    handleSelectionChange(val){
      this.multipleSelection = val
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
  width:950px;
  padding: 10px;
  border: 1px rgb(245,247,250) solid;
  background: white;
}
.input-with-select{
  width:500px;
  float:left;
}
.el-input-group__prepend{
  width:100px;
  background:white;
  color: #8e9197;
}
</style>
