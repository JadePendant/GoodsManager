<template>
  <div>
    <div class="action-container">
      <div class="search"><Input v-model="goodsName" size="large" placeholder="请输入商品名" style="width:500px" />
        <Button type="primary" @click="search" style="margin-left:5px;">查找</Button><Button type="primary" @click="viewAll" style="margin-left:5px;">显示所有</Button></div>
      <div class="add"><Button type="primary" @click="addModal">增加</Button></div>
    </div>
    <Table :columns="columns" :data="data"></Table>
    <Modal v-model="updatemodal" @on-ok="handleSubmit()" @on-cancel="cancel">
      <div class="modal">
        <Form ref="updateform" :model="updateform" :rules="ruleValidate"  style="margin-top:20px;margin-bottom:20px;" :label-width="80">
          <FormItem label="商品名" prop="goodsName">
            <Input v-model="updateform.goodsName" placeholder="Enter your name"></Input>
          </FormItem>
          <FormItem label="简介">
            <Input v-model="updateform.context" placeholder="Enter your e-mail"></Input>
          </FormItem>
          <FormItem label="数量" prop="number">
            <Input v-model="updateform.number" placeholder="Enter your name"></Input>
          </FormItem>
          <FormItem label="最大库存" prop="max">
            <Input v-model="updateform.max"  placeholder="Enter your name"></Input>
          </FormItem>
          <FormItem label="最小库存" prop="min">
            <Input v-model="updateform.min" placeholder="Enter your name"></Input>
          </FormItem>
          <FormItem label="价格" prop="price">
            <Input v-model="updateform.price" placeholder="Enter your e-mail"></Input>
          </FormItem>
          <FormItem label="所属人">
            <Input v-model="updateform.username" placeholder="Enter your e-mail"></Input>
          </FormItem>
        </Form>
      </div>
    </Modal>
    <Modal  v-model="addmodal" @on-ok="add()" @on-cancel="cancel">
      <div class="modal">
         <Form ref="addform" :model="updateform"  :label-width="80" style="margin-top:20px;margin-bottom:20px;">
          <FormItem label="商品名">
            <Input v-model="addform.goodsName" placeholder="Enter your name"></Input>
          </FormItem>
          <FormItem label="简介">
            <Input v-model="addform.context" placeholder="Enter your e-mail"></Input>
          </FormItem>
          <FormItem label="数量">
            <Input v-model="addform.number" placeholder="Enter your name"></Input>
          </FormItem>
          <FormItem label="最大库存" >
            <Input v-model="addform.max"  placeholder="Enter your name"></Input>
          </FormItem>
          <FormItem label="最小库存">
            <Input v-model="addform.min" placeholder="Enter your name"></Input>
          </FormItem>
          <FormItem label="价格">
            <Input v-model="addform.price" placeholder="Enter your e-mail"></Input>
          </FormItem>
          <FormItem label="所属人">
            <Input v-model="addform.username" placeholder="Enter your e-mail"></Input>
          </FormItem>
        </Form>
      </div>
    </Modal>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        goodsName: '',
        addmodal:false,
        updatemodal: false,
        addform: {
          goodsName: '',
          context: '',
          number: 0,
          max: 0,
          min: 0,
          price: 0,
          username: '',
        },
        updateform: {
         goodsName: '',
          context: '',
          number: 0,
          max: 0,
          min: 0,
          price: 0,
          username: '',
        },
        ruleValidate: {
          goodsName: [{
            required: true,
            message: '商品名不能为空',
            trigger: 'blur'
          }],
          number: [{
              required: true,
              message: '商品不能为空',
              trigger: 'blur'
            }
          ],
          max: [{
            required: true,
            message: '库存量不能为空',
            trigger: 'blur'
          }],
         min: [{
            required: true,
            message: '库存量不能为空',
            trigger: 'blur'
          }],
          price: [{
            required:true,
            message: '价格不能为空',
            trigger: 'blur'
          }]
        },
        columns: [{
            type: 'selection',
            width: 100
          },
          {
            title: '序号',
            type: 'index',
            width: 100
          },
          {
            title: '商品名',
            key: 'goodsName',
            width: 200
          },
          {
            title: '介绍',
            key: 'context',
            width: 200
          },
          {
            title: '数量',
            key: 'number',
            width: 200
          },
          {
            title: '最大库存',
            key: 'max',
            width: 200
          },
          {
            title: '最小库存',
            key: 'min',
            width: 300
          },
          {
            title: '价格',
            key: 'price',
            width: 300
          },
          {
            title: '所属人',
            key: 'username',
            width: 200
          },
          {
            title: '操作',
            key: 'action',
            width: 150,
            align: 'center',
            render: (h, params) => {
              return h('div', [
                h('Button', {
                  props: {
                    type: 'primary',
                    size: 'small'
                  },
                  style: {
                    marginRight: '5px'
                  },
                  on: {
                    click: () => {
                      this.update(params)
                    }
                  }
                }, '修改'),
                h('Button', {
                  props: {
                    type: 'error',
                    size: 'small'
                  },
                  on: {
                    click: () => {
                      this.remove(params)
                    }
                  }
                }, '删除')
              ]);
            }
          }
        ],
        data: [],
      }
    },
    components: {

    },
    mounted() {
      this.getGoods();
    },
    methods: {
      getGoods() {
        this.axios({
            method: "post",
            url: "/api/goods",
          })
          .then(response => {
            this.data = response.data.data;
          })
          .catch(function (error) {
            console.log(error);
          });
      },
      viewAll(){
  this.getGoods();
      },
addModal(){
this.addmodal=true;
},
      add() {
          let postData = this.qs.stringify({
          goodsName: this.addform.goodsName,
          context: this.addform.context,
          number: this.addform.number,
          min: this.addform.min,
          max: this.addform.max,
          price: this.addform.price,
          username: this.addform.username
        });
        this.axios({
            method: "post",
            url: "/api/addgoods",
            data: postData
          })
          .then(response => {
            console.log(response.data);
            if (response.data.ok == 1) {
              this.$Message.success("添加成功");
              this.getGoods();
            } else {
              this.$Message.warning("添加失败");
            }
          })
          .catch(function (error) {
            console.log(error);
          });
      },
      search() {
        let postData = this.qs.stringify({
          goodsName: this.goodsName,
        });
        this.axios({
            method: "post",
            url: "/api/searchgoods",
            data: postData
          })
          .then(response => {
            console.log(response.data);
            if (response.data.ok == 1) {
              this.$Message.success("查找成功");
              this.data = response.data.data;
            } else {
              this.$Message.warning("查找失败");
            }
          })
          .catch(function (error) {
            console.log(error);
          });
      },
      update(params) {
        this.updateform = params.row;
        this.updatemodal = true;
      },
      handleSubmit() {
        console.log(this.updateform.context)
        let postData = this.qs.stringify({
          goodsName: this.updateform.goodsName,
          context: this.updateform.context,
          number: this.updateform.number,
          min: this.updateform.min,
          max: this.updateform.max,
          price: this.updateform.price,
          username: this.updateform.username,
          id:this.updateform.id
        });
        this.axios({
            method: "post",
            url: "/api/updategoods",
            data: postData
          })
          .then(response => {
            console.log(response.data);
            if (response.data.ok == 1) {
              this.$Message.success("更改成功");
              this.getGoods();
            } else {
              this.$Message.warning("更改失败");
            }
          })
          .catch(function (error) {
            console.log(error);
          });
      },
      remove(params) {
        console.log(params.row.goodsName);
        let postData = this.qs.stringify({
          id: params.row.id,
        });
        this.axios({
            method: "post",
            url: "/api/deletegoods",
            data: postData
          })
          .then(response => {
            console.log(response.data);
            if (response.data.ok == 1) {
              this.$Message.success("删除成功");
            } else {
              this.$Message.warning("删除失败");
            }
            this.getGoods();
          })
          .catch(function (error) {
            console.log(error);
          });
      },
      cancel() {}
    },
  }

</script>

<style scoped>
  .action-container {
    margin-top: 20px;
    margin-bottom: 20px;
  }

  .search {
    float: left;
    margin-left: 20px;
    margin-right: 1200px;
  }
.modal {
    padding: 20px;
    font-size: 12px;
    line-height: 2;
    background-image: url(../../img/modal.png)
}

</style>
