import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import BookManager from '../views/BookManager'
import AddBook from '../views/AddBook'
import BookUpdate from '../views/BookUpdate'
import Index from '../views/Index'

Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    name: '图书管理',
    component: Index,
    show: true,
    redirect:'/BookManager',
    children:[
      {
        path: '/BookManager',
        name: '查询图书',
        component: BookManager
      },
      {
        path: '/AddBook',
        name: '添加图书',
        component: AddBook
      }
    ]
  },
  {
    path: '/',
    show: false,
    component: Index,
    children:[
      {
        path: '/update',
        component: BookUpdate
      }
    ]
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
