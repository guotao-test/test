import Vue from 'vue';
import App from './App.vue';
import router from "./router";
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from 'axios'
Vue.use(ElementUI);
Vue.config.productionTip = false
axios.defaults.baseURL = 'http://43.143.129.162:8080/'
Vue.prototype.$ajax=axios
new Vue({
  router,
  render: (h) => h(App),
}).$mount("#app");
