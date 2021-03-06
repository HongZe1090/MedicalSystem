import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'/'el-icon-x' the icon show in the sidebar
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [{
      path: 'dashboard',
      name: 'Dashboard',
      component: () => import('@/views/dashboard/index'),
      meta: { title: '', icon: '' }
    }],
    hidden: true
  },

  {
    path: '/cate',
    component: Layout,
    redirect: '/cate/table',
    name: 'Example',
    meta: { title: '类别管理', icon: 'el-icon-s-help' },
    children: [
      {
        path: 'cate-table',
        name: 'Table',
        component: () => import('@/views/cateTable/index'),
        meta: { title: '药品类别', icon: 'example' }
      },
    ]
  },

  
  {
    path: '/sale',
    component: Layout,
    redirect: '/sale/table',
    name: 'Example',
    meta: { title: '销售管理', icon: 'el-icon-s-help' },
    children: [
      {
        path: 'sale-table',
        name: 'Table',
        component: () => import('@/views/saleTable/index'),
        meta: { title: '销售信息', icon: 'el-icon-shopping-cart-2' }
      },
    ]
  },

  {
    path: '/info',
    component: Layout,
    redirect: '/info/table',
    name: 'Example',
    meta: { title: '药品管理', icon: 'el-icon-s-help' },
    children: [
      {
        path: 'info-table',
        name: 'Table',
        component: () => import('@/views/infoTable/index'),
        meta: { title: '药品信息', icon: 'table' }
      },
    ]
  },


  {
    path: '/system',
    component: Layout,
    redirect: '/system/table',
    name: 'Example',
    meta: { title: '系统管理', icon: 'el-icon-s-help' },
    children: [
      {
        path: 'info-table',
        name: 'Table',
        component: () => import('@/views/systemTable/index'),
        meta: { title: '管理人员', icon: 'user' }
      },
    ]
  },
  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
