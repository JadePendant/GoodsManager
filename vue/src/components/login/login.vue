<template>
  <div class="main">
    <div class="card-box">
      <p slot="title">
        <span class="title">商品库存管理系统</span>
      </p>
      <div class="login-box">
        <Form ref="formInline" :model="formInline" :rules="ruleInline">
          <FormItem prop="username">
            <Input
              type="text"
              v-model="formInline.username"
              placeholder="请输入用户名"
              style="width:400px;margin-left:100px;margin-top:100px"
            >
              <Icon type="ios-person-outline" slot="prepend"></Icon>
            </Input>
          </FormItem>
          <FormItem prop="password">
            <Input
              type="password"
              v-model="formInline.password"
              placeholder="请输入密码"
              style="width:400px;margin-left:100px;margin-bottom:50px"
            >
              <Icon type="ios-person-outline" slot="prepend"></Icon>
            </Input>
          </FormItem>
          <FormItem>
            <Button type="primary" @click="registe" style="margin-right:50px;">注册</Button>
            <Button type="primary" @click="login('formInline')">登录</Button>
          </FormItem>
        </Form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      ok: 0,
      type: 0,
      formInline: {
        username: "",
        password: ""
      },
      ruleInline: {
        username: [
          {
            required: true,
            message: "用户名不能为空",
            trigger: "blur"
          }
        ],
        password: [
          {
            required: true,
            message: "密码不能为空",
            trigger: "blur"
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
        ]
      }
    };
  },
  mounted() {},
  methods: {
    //获取用户类别
    getType() {
      let postData = this.qs.stringify({
        username: this.formInline.username
      });
      this.axios({
        method: "post",
        url: "/api/searchuser",
        data: postData
      })
        .then(response => {
          this.type = response.data.user.type;
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    //比对用户名和密码
    comparePassword() {
      let postData = this.qs.stringify({
        username: this.formInline.username,
        password: this.formInline.password
      });
      this.axios({
        method: "post",
        url: "/api/login",
        data: postData
      })
        .then(response => {
          console.log(response);
          this.ok = response.data.ok;
          console.log(this.ok);
        })
        .catch(function(error) {
          console.log(error);
        });
    },
    login(name) {
      this.axios.all([this.getType(), this.comparePassword()]).then(
        this.axios.spread(function(acct, perms) {
          // 两个请求现在都执行完成
        })
      );
      const msg = this.$Message.loading({
        content: "正在登录中...",
        duration: 0
      });
      var t;
      clearTimeout(t);
      t = setTimeout(() => {
        this.$refs[name].validate(valid => {
          if (valid) {
            if (this.ok == 1) {
              this.$Message.success("登陆成功");
              if (this.type == 1) this.$router.push("/admin");
              else
                this.$router.push({
                  path: "/user",
                  query: {
                    username: this.formInline.username
                  }
                });
            } else if (this.ok == 0) this.$Message.error("密码错误");
            else this.$Message.error("用户名不存在");
          }
        });
      }, 1000);
      setTimeout(msg, 1000);
    },
    registe() {
      this.$router.push("/registe");
    }
  }
};
</script>

<style scoped>
.main {
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
  background-image: url(../../img/login.jpg);
}

.card-box {
  width: 600px;
  height: 600px;
  text-align: center;
  align-self: center;
  margin-left: auto;
  margin-right: auto;
  background-image: url(../../img/card.png);
}

.title {
  background: none;
  border: 0;
  box-sizing: border-box;
  box-shadow: inset 0 0 0 2px #00f3df;
  color: 00f3df;
  font-size: 50px;
  font-weight: 700;
  margin-top: 50px;
  text-align: center;
  position: relative;
  vertical-align: middle;
  border-radius: 10px;
}
.ivu-btn-primary {
  color: floralwhite;
  font-size: 30px;
  width: 150px;
  height: 70px;
  background-color: rgba(4, 40, 247, 0.212);
  border-radius: 50px;
  border-color: rgba(0, 89, 255, 0.452);
}
</style>
