<template>
  <div>
    <Table :columns="columns" :data="data" height="700"></Table>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        updateform: {
          goodsName: '',
          context: '',
          number: 0,
          max: 0,
          min: 0,
          price: 0,
          username: '',
        },
        columns: [{
            type: 'selection',
          },
          {
            title: '序号',
            type: 'index',
          },
          {
            title: '商品名',
            key: 'goodsName',
          },
          {
            title: '所属人',
            key: 'username',
          },
          {
            title: '数量',
            key: 'number',
          },
          {
            title: '类型',
            key: 'type',
          },
          {
            title: '状态',
            key: 'state',
          },
          {
            title: '操作',
            key: 'action',
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
                      this.commit(params)
                    }
                  }
                }, '同意'),
                h('Button', {
                  props: {
                    type: 'error',
                    size: 'small'
                  },
                  on: {
                    click: () => {
                      this.refuse(params)
                    }
                  }
                }, '拒绝')
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
      this.getRecord();
    },
    methods: {
      getRecord() {
        this.axios({
            method: "post",
            url: "/api/record",
          })
          .then(response => {
            this.data = response.data.data;
          })
          .catch(function (error) {
            console.log(error);
          });
      },
      commit(params) {
          if (params.row.state == "暂未处理") {
          let postData = this.qs.stringify({
            goodsName: params.row.goodsName,
            username: params.row.username
          });
          this.axios({
              method: "post",
              url: "/api/searchgoodsbyusergoods",
              data: postData
            })
            .then(response => {
              console.log(response.data);
              if (response.data.ok == 1) {
                if (response.data.data.length != 0) {

                  this.updateform = response.data.data[0]
                  if (params.row.type == "出库")
                    this.updateform.number = this.updateform.number - params.row.number;
                  else
                    this.updateform.number = this.updateform.number + params.row.number;
                  this.update();
                  let postData = this.qs.stringify({
                    id: params.row.id,
                    goodsName: params.row.goodsName,
                    username: params.row.username,
                    number: params.row.number,
                    type: params.row.type,
                    state: "已批准",
                  });
                  this.axios({
                      method: "post",
                      url: "/api/updaterecord",
                      data: postData
                    })
                    .then(response => {})
                    .catch(function (error) {
                      console.log(error);
                    });
                }
              } else {
                this.$Message.warning("查找失败");
              }
            })
            .catch(function (error) {
              console.log(error);
            });
          }
        this.getRecord();
      },
      refuse(params) {
        if (params.row.state == "暂未处理") {
          let postData = this.qs.stringify({
            id: params.row.id,
            goodsName: params.row.goodsName,
            username: params.row.username,
            number: params.row.number,
            type: params.row.type,
            state: '不予批准',
          });
          this.axios({
              method: "post",
              url: "/api/updaterecord",
              data: postData
            })
            .then(response => {
              console.log(response.data);
              if (response.data.ok == 1) {
                this.$Message.success("拒绝成功");
                this.getGoods();
              } else {
                this.$Message.warning("拒绝失败");
              }
            })
            .catch(function (error) {
              console.log(error);
            });
          this.getRecord();
        }

      },
      update() {
        let postData = this.qs.stringify({
          goodsName: this.updateform.goodsName,
          context: this.updateform.context,
          number: this.updateform.number,
          min: this.updateform.min,
          max: this.updateform.max,
          price: this.updateform.price,
          username: this.updateform.username,
          id: this.updateform.id
        });
        this.axios({
            method: "post",
            url: "/api/updategoods",
            data: postData
          })
          .then(response => {})
          .catch(function (error) {
            console.log(error);
          });
      }
    },
  }

</script>

<style scoped>

</style>
