<template>
 <div class="container">
<card class="card-box">
      <Form  :model="info" :label-width="80">
        <FormItem label="用户名" >
          <Input v-model="info.username" disabled></Input>
        </FormItem>
        <FormItem label="昵称">
          <Input v-model="info.nickname"></Input>
        </FormItem>
        <FormItem label="密码">
          <Input v-model="info.password"></Input>
        </FormItem>
        <FormItem label="性别">
          <RadioGroup v-model="info.sex">
            <Radio label="男"></Radio>
            <Radio label="女"></Radio>
          </RadioGroup>
        </FormItem>
        <FormItem label="号码">
          <Input v-model="info.phone" placeholder="Enter your name"></Input>
        </FormItem>
        <FormItem label="邮箱">
          <Input v-model="info.email" placeholder="Enter your e-mail"></Input>
        </FormItem>
        <FormItem label="地址">
          <Input v-model="info.address" placeholder="Enter your e-mail"></Input>
        </FormItem>
        <FormItem>
          <Button type="primary" @click="save">保存</Button>
          <Button @click="cancel" style="margin-left: 8px">取消</Button>
        </FormItem>
      </Form>
    </card>
 </div>
</template>

<script>
export default {
 data() {
  return {
    info:{
          username: '',
          nickname: '',
          password:'',
          sex: '',
          phone: '',
          email: '',
          address: '',
        },
  }
 },
 components: {

 },
 mounted(){
console.log(this.$route.query.username)
let postData = this.qs.stringify({
          username: this.$route.query.username,
        });
        this.axios({
            method: "post",
            url: "/api/searchuser",
            data: postData
          })
          .then(response => {
            console.log(response.data);
            if (response.data.ok == 1) {
            this.info=response.data.user;
            } else {
              this.$Message.warning("查找失败");
            }
          })
          .catch(function (error) {
            console.log(error);
          });
},
 methods: {
save(){
let postData = this.qs.stringify({
          username: this.info.username,
          nickname: this.info.nickname,
          password: this.info.password,
          sex: this.info.sex,
          phone: this.info.phone,
          email: this.info.email,
          address: this.info.address
        });
        this.axios({
            method: "post",
            url: "/api/updateuser",
            data: postData
          })
          .then(response => {
            console.log(response.data);
            if (response.data.ok == 1) {
              this.$Message.success("保存成功");
            } else {
              this.$Message.warning("保存失败");
            }
          })
          .catch(function (error) {
            console.log(error);
          });
},
cancel(){}
},
}
</script>

<style scoped>
.container {
    position: fixed;
    width: 100%;
    height: 100%;
  }
.card-box {
    width: 700px;
    height: 700px;
    opacity: 0.9;
    text-align: center;
    align-self: center;
    margin-left: auto;
    margin-right: auto;
    background-image: url(../../img/registecard.png)
  }
</style>
