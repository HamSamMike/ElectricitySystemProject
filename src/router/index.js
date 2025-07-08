import { createRouter, createWebHashHistory } from 'vue-router'
import Login from '../views/common/Login.vue'
import UserHome from '../views/user/UserHome.vue'
import HeadAdmin from '@/views/admin/headadmin/HeadAdmin.vue'
import BureauAdmin from '@/views/admin/bureauadmin/BureauAdmin.vue'

const routes = [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/user',
    name: 'UserHome',
    component: UserHome,
    meta: { requiresAuth: true, role: 'user' }
  },
  {
    path: '/head-admin',
    name: 'HeadAdmin',
    component: HeadAdmin,
    meta: { requiresAuth: true, role: 'headAdmin' }
  },
  {
    path: '/bureau-admin',
    name: 'BureauAdmin',
    component: BureauAdmin,
    meta: { requiresAuth: true, role: 'bureauAdmin' }
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

// router.beforeEach((to, from, next) => {
//   const authStore = useAuthStore()
  
//   if (to.meta.requiresAuth && !authStore.isAuthenticated) {
//     next('/login')
//   } else if (to.meta.requiresAuth && to.meta.role !== authStore.user.role) {
//     next('/login')
//   } else {
//     next()
//   }
// })

export default router