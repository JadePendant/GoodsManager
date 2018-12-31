import Vue from 'vue'
import Router from 'vue-router'
import login from '../components/login/login.vue'
import registe from '../components/registe/registe.vue'
import admin from '../components/admin/admin.vue'
import adminuser from '../components/admin/user.vue'
import admingoods from '../components/admin/goods.vue'
import adminrecord from '../components/admin/record.vue'
import echarts from '../components/admin/echarts.vue'
import user from '../components/user/user.vue'
import userinfo from '../components/user/info.vue'
import usergoods from '../components/user/goods.vue'
import userrecord from '../components/user/record.vue'
Vue.use(Router)
export default new Router({
  mode: 'history',
  routes: [{
      path: '/',
      name: 'index',
      redirect: 'login'
    },
    {
      name: 'login',
      path: '/login',
      meta: {
        title: '登录'
      },
      component: login
    },
    {
      name: 'registe',
      path: '/registe',
      meta: {
        title: '注册'
      },
      component: registe
    },
    {
      name: 'admin',
      path: '/admin',
      meta: {
        title: '管理员'
      },
      redirect: '/admin/echarts',
      children: [{
        path: '/admin/user',
        component: adminuser
      },
      {
        path: '/admin/goods',
        component: admingoods
      },
      {
        path: '/admin/record',
        component: adminrecord
      },
      {
        path: '/admin/echarts',
        component: echarts
      }
    ],
      component: admin
    },
    {
      name: 'user',
      path: '/user',
      meta: {
        title: '用户中心'
      },
      redirect: '/user/info',
      children: [
        {
          path: '/user/info',
          component: userinfo
        },
        {
          path: '/user/goods',
          component: usergoods
        },
        {
          path: '/user/record',
          component: userrecord
        }
    ],
      component: user
    }
  ]
})
