// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import VueRouter from 'vue-router';
import iView from 'iview';
import 'iview/dist/styles/iview.css'    // 使用 CSS
import axios from 'axios';//引入文件
// 引入echarts
import echarts from 'echarts'
Vue.prototype.echarts = echarts
import Qs from 'qs'
Vue.prototype.qs = Qs;
Vue.prototype.axios = axios;
Vue.config.productionTip = false
Vue.use(VueRouter);
Vue.use(iView);
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
