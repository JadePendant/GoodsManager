<template>
 <div>
<Table :columns="columns" :data="data" height="700"></Table>
 </div>
</template>

<script>
export default {
 data() {
  return {
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
 mounted(){
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
   remove(params){
        let postData = this.qs.stringify({
          id: params.row.id,
        });
        this.axios({
            method: "post",
            url: "/api/deleterecord",
            data: postData
          })
          .then(response => {
            console.log(response.data);
            if (response.data.ok == 1) {
              this.$Message.success("删除成功");
            } else {
              this.$Message.warning("删除失败");
            }
            this.getRecord();
          })
          .catch(function (error) {
            console.log(error);
          });
   }
},
}
</script>

<style scoped>

</style>
