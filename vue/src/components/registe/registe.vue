<template>
  <div class="container">
    <div class="card-box">
      <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="120" label-position="right">
        <FormItem label="用户名" prop="username">
          <Input v-model="formValidate.username" placeholder="请输入登录名" style="width:400px;"></Input>
        </FormItem>
        <FormItem label="昵称" prop="nickname">
          <Input v-model="formValidate.nickname" placeholder="请输入昵称" style="width:400px"></Input>
        </FormItem>
        <FormItem label="密码" prop="password">
          <Input v-model="formValidate.password" type="password" placeholder="请输入密码" style="width:400px"></Input>
        </FormItem>
        <FormItem label="性别" prop="sex">
          <RadioGroup v-model="formValidate.sex" style="width:400px">
            <Radio label="男"></Radio>
            <Radio label="女"></Radio>
          </RadioGroup>
        </FormItem>
        <FormItem label="号码" prop="phone">
          <Input v-model="formValidate.phone" placeholder="请输入号码" style="width:400px"></Input>
        </FormItem>
        <FormItem label="邮箱" prop="email">
          <Input v-model="formValidate.email" placeholder="请输入邮箱" style="width:400px"></Input>
        </FormItem>
        <FormItem label="地址">
          <Input v-model="formValidate.address" placeholder="请输入地址" style="width:400px"></Input>
        </FormItem>
        <FormItem>
          <Button type="primary" @click="handleSubmit('formValidate')"  style="margin-left: -70px">提交</Button>
          <Button type="primary" @click="handleReset('formValidate')" style="margin-left: 100px">重置</Button>
        </FormItem>
      </Form>
      <a href="/login"><span class="tologin">已有账号,去登录</span></a>

    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        formValidate: {
          username: '',
          nickname: '',
          password: '',
          sex: '',
          phone: '',
          email: '',
          address: '',
        },
        ruleValidate: {
          username: [{
            required: true,
            message: '用户名不能为空',
            trigger: 'blur'
          }],
          nickname: [{
            required: true,
            message: '昵称不能为空',
            trigger: 'blur'
          }],
          password: [{
              required: true,
              message: '密码不能为空',
              trigger: 'blur'
            },
            {
              type: "string",
              min: 6,
              message: "密码长度不小于6位",
              trigger: "blur"
            },
            {
              type: "string",
              max: 12,
              message: "密码长度不大于12位",
              trigger: "blur"
            }
          ],
          sex: [{
            required: true,
            message: '请选择性别',
            trigger: 'blur'
          }],
          phone: [{
              type: "string",
              min: 11,
              message: "请输入正确手机号",
              trigger: "blur"
            },
            {
              type: "string",
              max: 11,
              message: "请输入正确手机号",
              trigger: "blur"
            }
          ],
          email: [{
            type: 'email',
            message: '请输入正确邮箱',
            trigger: 'blur'
          }]
        }
      }
    },
    components: {

    },
    mounted() {

    },
    methods: {
      handleSubmit(name) {
        this.$refs[name].validate((valid) => {
          if (valid) {
            let postData = this.qs.stringify({
              username: this.formValidate.username,
              nickname: this.formValidate.nickname,
              password: this.formValidate.password,
              sex: this.formValidate.sex,
              phone: this.formValidate.phone,
              email: this.formValidate.email,
              address: this.formValidate.address

            });
            this.axios({
                method: "post",
                url: "/api/registe",
                data: postData
              })
              .then(response => {
                console.log(response.data);
                if (response.data.ok == 1) {
                  //this.$Message.success("注册成功");
                    this.$Message.loading({
                    content: '注册成功,欢迎到登陆页面',
                    duration: 2
                  });
                   this.$router.push('/login');
                } else {
                  this.$Message.warning("用户名已存在");
                }
              })
              .catch(function (error) {
                console.log(error);
              });
          }
        });

      },
      handleReset(name) {
        this.$refs[name].resetFields();
      }
    },
  }

</script>

<style scoped>
  .container {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    min-width: 1000px;
    z-index: -10;
    zoom: 1;
    background-repeat: no-repeat;
    background-size: cover;
    -webkit-background-size: cover;
    -o-background-size: cover;
    background-position: center 0;
    display: flex;
    background-image: url(../../img/registe.png);
  }

  .card-box {
    width: 700px;
    height: 700px;
    text-align: center;
    align-self: center;
    margin-left: auto;
    margin-right: auto;
padding-top: 50px;
    background-image: url(../../img/registecard.png)
  }
.ivu-radio-wrapper {
    font-size: 24px;
    vertical-align: middle;
    display: inline-block;
    position: relative;
    white-space: nowrap;
    margin-right: 8px;
    cursor: pointer;
}
.ivu-btn-primary {
    color:floralwhite;
    font-size: 30px;
    width: 150px;
    height: 70px;
    background-color: rgba(4, 40, 247, 0.212);
    border-radius: 50px;
    border-color: rgba(4, 40, 247, 0.212);
}
.tologin{
color:black;
font-size: 20px;
}
</style>
