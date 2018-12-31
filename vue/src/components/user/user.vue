<template>
  <div class="container">
    <div class="menu-container">
      <Menu theme="dark" active-name="1" width="300px">
        <MenuGroup title="个人">
          <MenuItem name="1" :to="{ path:'/user/info', query: {username: this.username}}">
          <Icon type="md-person" />
          个人信息
          </MenuItem>
        </MenuGroup>
        <MenuGroup title="商品">
          <MenuItem name="2" :to="{ path:'/user/goods', query: {username: this.username}}">
          <Icon type="md-document" />
          我的商品
          </MenuItem>
        </MenuGroup>
        <MenuGroup title="出入库">
          <MenuItem name="3" to='/user/record'>
          <Icon type="md-reorder" />
          记录
          </MenuItem>
        </MenuGroup>
        <MenuGroup title="操作">
          <MenuItem name="4" to='/login'>
          <Icon type="ios-power" />
          退出
          </MenuItem>
        </MenuGroup>
      </Menu>
    </div>
    <div class="view-container">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        username: '',
      }
    },
    components: {

    },
    mounted() {
      console.log(this.$route.query.username);
      this.username = this.$route.query.username;
    },
    methods: {

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
  }

  .menu-container {
    float: left;
    height: 100%;
    width: 15%;
    position: relative;
    background-color: #515a6e;
  }

  .view_container {
    height: 100%;
    width: 85%;
    float: left;
  }

</style>
