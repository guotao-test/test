"use strict";(self["webpackChunkvue_cli_days14"]=self["webpackChunkvue_cli_days14"]||[]).push([[682],{9682:function(t,e,n){n.r(e),n.d(e,{default:function(){return c}});var a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("el-row",{staticClass:"header"},[n("el-col",{attrs:{span:24}},[n("h1",[t._v("毕业设计选题系统")])])],1),n("el-row",{staticClass:"main"},[n("el-col",{staticClass:"aside",attrs:{span:6}},[n("el-menu",{attrs:{"default-active":"2","background-color":"#545c64","text-color":"#fff",router:!0}},t._l(t.menus,(function(e){return n("el-menu-item",{key:e.id,attrs:{index:e.href}},[n("template",{slot:"title"},[n("i",{staticClass:"el-icon-location"}),n("span",[t._v(t._s(e.comment))])])],2)})),1)],1),n("el-col",{staticClass:"section",attrs:{span:18}},[n("router-view")],1)],1)],1)},s=[],l={data:function(){return{menus:{}}},created:function(){this.queryMenuById()},methods:{handleOpen:function(t){console.log(t)},handleClose:function(t){console.log(t)},queryMenuById:function(){var t=this;this.$ajax.get("/main/initMenu?id="+JSON.parse(this.$route.query.id)).then((function(e){t.menus=e.data.data}))}}},i=l,u=n(1001),o=(0,u.Z)(i,a,s,!1,null,"1ba73b05",null),c=o.exports}}]);