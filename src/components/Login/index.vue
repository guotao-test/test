<template>
    <div class="login">
        <el-form ref="loginRef" :rules="loginRules" label-width="auto" :model="loginForm" status-icon hide-required-asterisk>
            <el-form-item label="账号" prop="account">
                <el-input placeholder="请输入账号" v-model.number="loginForm.account"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="pwd">
                <el-input type="password" v-model="loginForm.pwd" placeholder="请输入密码"></el-input>
            </el-form-item>
            <el-form-item label="身份" prop="role">
                <el-radio v-model="loginForm.role" label="1">管理员</el-radio>
                <el-radio v-model="loginForm.role" label="2">学生</el-radio>
                <el-radio v-model="loginForm.role" label="3">老师</el-radio>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="isUser">登录</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
export default {
    data() {
        return {
            //登录
            loginForm:{
                account:'',
                pwd:'',
                role:'1',
            },
            loginRules:{
                account:[
                    {required:true,message:'账号不能为空',trigger:'blur'},
                    {type:'number',message:'账号为数字',trigger:'blur'},
                ],
                pwd:[
                    {required:true,message:'密码不能为空',trigger:'blur'},
                    {min:6,max:32,message:'密码为6到32位',trigger:'blur'}
                ],
            },
        }
    },
    methods:{
        //验证登录
        isUser(){
            this.$refs.loginRef.validate((flag)=>{
                if(flag){
                    this.$ajax.post('http://localhost:8080/login',this.loginForm).then(res=>{
                        console.log(res)
                        if(res.data.code===200){
                            this.$router.push({
                                path:'/main',
                                query:{
                                    id:JSON.stringify(res.data.data)
                                },
                            })
                            this.$message.success('登陆成功')
                        }else{
                            this.$message.error("登陆失败")
                        }
                    })
                }
            })
        }
    }
}
</script>

<style scoped>
   
    .login{
        width: 400px;
        height: 250px;
        background-color: #ddd;
        position: relative;
        left: 50%;
        top: 200px;
        margin-left: -200px;
        padding: 20px;
        box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
        border-radius: 10px;
        
    }
    
    .el-button{
        margin-top: 10px;
        margin-left: 60px;
    }
</style>