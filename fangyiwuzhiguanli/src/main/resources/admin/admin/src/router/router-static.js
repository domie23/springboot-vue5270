import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import fangyiwuzi from '@/views/modules/fangyiwuzi/list'
    import fangyiwuziChuruInout from '@/views/modules/fangyiwuziChuruInout/list'
    import fangyiwuziChuruInoutList from '@/views/modules/fangyiwuziChuruInoutList/list'
    import fangyiwuziYuyue from '@/views/modules/fangyiwuziYuyue/list'
    import forum from '@/views/modules/forum/list'
    import liuyan from '@/views/modules/liuyan/list'
    import news from '@/views/modules/news/list'
    import yonghu from '@/views/modules/yonghu/list'
    import config from '@/views/modules/config/list'
    import dictionaryFangyiwuzi from '@/views/modules/dictionaryFangyiwuzi/list'
    import dictionaryFangyiwuziChuruInout from '@/views/modules/dictionaryFangyiwuziChuruInout/list'
    import dictionaryFangyiwuziYuyueYesno from '@/views/modules/dictionaryFangyiwuziYuyueYesno/list'
    import dictionaryForumState from '@/views/modules/dictionaryForumState/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryFangyiwuzi',
        name: '物资类型',
        component: dictionaryFangyiwuzi
    }
    ,{
        path: '/dictionaryFangyiwuziChuruInout',
        name: '出入库类型',
        component: dictionaryFangyiwuziChuruInout
    }
    ,{
        path: '/dictionaryFangyiwuziYuyueYesno',
        name: '申请状态',
        component: dictionaryFangyiwuziYuyueYesno
    }
    ,{
        path: '/dictionaryForumState',
        name: '帖子状态',
        component: dictionaryForumState
    }
    ,{
        path: '/dictionaryNews',
        name: '公告类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionarySex',
        name: '性别',
        component: dictionarySex
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/dictionary',
        name: '字典表',
        component: dictionary
      }
    ,{
        path: '/fangyiwuzi',
        name: '物资',
        component: fangyiwuzi
      }
    ,{
        path: '/fangyiwuziChuruInout',
        name: '出入库',
        component: fangyiwuziChuruInout
      }
    ,{
        path: '/fangyiwuziChuruInoutList',
        name: '出入库详情',
        component: fangyiwuziChuruInoutList
      }
    ,{
        path: '/fangyiwuziYuyue',
        name: '物资申请',
        component: fangyiwuziYuyue
      }
    ,{
        path: '/forum',
        name: '论坛',
        component: forum
      }
    ,{
        path: '/liuyan',
        name: '意见反馈',
        component: liuyan
      }
    ,{
        path: '/news',
        name: '通知公告',
        component: news
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
