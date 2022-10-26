import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
    {
      path:'/',
      component:()=>import('@/components/Login/index')
    },
    {
      path:'/main',
      component:()=>import('@/components/Main')
    },
];

const router = new VueRouter({
  routes,
});

export default router;
