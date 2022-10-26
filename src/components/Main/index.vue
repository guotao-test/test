<template>
    <div>    
        <el-row class="header">
            <el-col :span="24">
                <h1>毕业设计选题系统</h1>
            </el-col>
        </el-row>
        <el-row class="main">
            <el-col :span="6" class="aside">
                <el-menu
                default-active="2"
                background-color="#545c64"
                text-color="#fff"
                :router="true">
                    <el-menu-item v-for="menu in menus" :key="menu.id" :index="menu.href">
                        <template slot="title">
                            <i class="el-icon-location"></i>
                            <span>{{menu.comment}}</span>
                        </template>
                    </el-menu-item>
                </el-menu>
            </el-col>
            <el-col :span="18" class="section">
                <router-view></router-view>
            </el-col>
        </el-row>
    </div>
</template>

<script>
export default {
    data() {
        return {
            menus:{}
        }
    },
    created(){
       this.queryMenuById()
    },
    methods:{
        handleOpen(e){
            console.log(e)
        },
        handleClose(e){
            console.log(e)
        },
        queryMenuById(){
            this.$ajax.get('/main/initMenu?id='+JSON.parse(this.$route.query.id)
            ).then(res=>{
                this.menus=res.data.data
            })
        }
    }
}
</script>

<style scoped>
    .header{
        width: 100vw;
        height: 13vh;
        background-color: azure;
    }
    .main{
        width: 100vw;
        height: 87vh;
    }
    .aside{
        width: 15vw;
        height: 87vh;
    }
    .section{
        width: 85vw;
        height: 87vh;
    }
</style>