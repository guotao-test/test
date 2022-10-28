<template>
    <div>
        <div class="main">
            <div class="login" id="login">
                <el-link id="toRegister" @click="toRegister" :underline="false">
                    注册<i class="el-icon-d-arrow-right"></i>
                </el-link>
                <el-form ref="loginRef" label-position="right" :model="loginUser" :rules="loginUserRule">
                    <el-form-item label="账号" prop="account" label-width="90px">
                        <el-input type="text" placeholder="请输入账号"  v-model="loginUser.account"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="password" label-width="90px">
                        <el-input type="password" placeholder="请输入密码"  v-model="loginUser.password"></el-input>
                    </el-form-item>
                    <el-form-item label-width="70px">
                        <el-button type="primary" style="margin-left:70px;" @click="login">登录</el-button>
                    </el-form-item>
                </el-form>
            </div>
            <div class="register" id="register">
                <el-link id="toLogin" @click="toLogin" :underline="false">
                    登录<i class="el-icon-d-arrow-right"></i>
                </el-link>
                <el-form ref="registerRef" label-position="right" :model="registerUser" :rules="registerUserRule">
                    <el-form-item label="账号" prop="account" label-width="90px" :error="checkAccountMsg">
                        <el-input type="text" placeholder="请输入账号" v-model="registerUser.account" @blur="checkAccount"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="password" label-width="90px">
                        <el-input type="password" placeholder="请输入密码" v-model="registerUser.password"></el-input>
                    </el-form-item>
                    <el-form-item label="确认密码" prop="isPassword" label-width="90px">
                        <el-input type="password" placeholder="请确认密码" v-model="registerUser.isPassword"></el-input>
                    </el-form-item>
                    <el-form-item label="邮箱" prop="email" label-width="90px">
                        <el-input type="email" placeholder="请输入邮箱" v-model="registerUser.email"></el-input>
                    </el-form-item>
                    <el-form-item label="电话号" prop="phone" label-width="90px">
                        <el-input type="phone" placeholder="请输入电话号" v-model="registerUser.phone"></el-input>
                    </el-form-item>
                    <el-form-item label="性别" prop="gender" label-width="90px">
                        <el-radio  v-model="registerUser.sex" label="0">女</el-radio>
                        <el-radio  v-model="registerUser.sex" label="1">男</el-radio>
                    </el-form-item>
                    <el-form-item label-width="70px">
                        <el-button type="primary" style="margin-left:70px;" @click="register">注册</el-button>
                    </el-form-item>
                </el-form>
            </div>
        </div>
    </div>
    
</template>

<script>

export default {
    data() {
        // 校验密码
        let check = (rule, value, callback) => {
            if(this.registerUser.password===value){
                    return callback()
            }else{
                    return callback(new Error("密码不一样"))
            }
        }   
        return {
            //登录
            loginUser:{
                account:'',
                password:''
            },
            registerUser:{
                account:'',
                password:'',
                isPassword:'',
                email:'',
                phone:'',
                sex:'0',
            },
            loginUserRule:{
                account:[{required:true,message:'账户不能为空',trigger:'blur'},
                         {min:5,max:10,message:'账号应在5-10位之间',trigger:'blur'}],
                password:[
                    {required:true,message:'密码不能为空',trigger:'blur'},
                    {min:6,max:32,message:'密码应在6-32位之间',trigger:'blur'}
                ]  
            },
            registerUserRule:{
                account:[
                    {required:true,message:'账号不能为空',trigger:'blur'},
                    {min:5,max:10,message:'账号应在5-10位之间',trigger:'blur'},
                ],
                password:[
                    {required:true,message:'密码不能为空',trigger:'blur'},
                    {min:6,max:32,message:'密码应在6-32位之间',trigger:'blur'}
                ],
                isPassword:[
                    {required:true,message:'密码不能为空',trigger:'blur'},
                    {min:6,max:32,message:'密码应在6-32位之间',trigger:'blur'},
                    {trigger:'blur',validator:check}
                ],
                email:[
                    {required:true,message:'邮箱不能为空',trigger:'blur'},
                    {type:'email',message:'格式有误',trigger:'blur'}
                ],
                phone:[
                    {required:true,message:'电话不能为空',trigger:'blur'},
                    {pattern:/^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/,message:'格式有误',trigger:'blur'}
                ]
            },
            checkAccountMsg:''
        }
    },
    methods:{
        //验证登录
        login(){
            this.$refs.loginRef.validate((flag)=>{
                if(flag){
                    this.$ajax.post('/login',this.loginUser).then(res=>{
                        console.log(res)
                        if(res.data.code==='200'){
                            this.$router.push({
                                path:'/main',
                                query:{
                                    
                                },
                            })
                            this.$message.success('登陆成功')
                        }else{
                            this.$message.error("登陆失败")
                        }
                    })
                }
            })
        },
        register(){
            this.$refs.registerRef.validate((flag)=>{
                let data={
                    user:{
                        account:this.registerUser.account,
                        password:this.registerUser.password,
                    },
                    email:this.registerUser.email,
                    phone:this.registerUser.phone,
                    sex:this.registerUser.sex,
                }
                if(flag){
                    this.$ajax.post('/register',data).then(res=>{
                        if(res.data.code==='200'){
                            this.$refs.registerRef.resetFields()
                            location.reload()
                            this.$message.success('注册成功')
                        }
                    })
                }
            })
        },
        toRegister(){
            let login=document.getElementById("login")
            let register=document.getElementById("register")
            login.style.cssText="transform: rotateY(180deg);"
            register.style.cssText="transform: rotateY(0deg);"
            this.$refs.registerRef.resetFields()
        },
        toLogin(){
            let login=document.getElementById("login")
            let register=document.getElementById("register")
            login.style.cssText="transform: rotateY(0deg);"
            register.style.cssText="transform: rotateY(180deg);"
            this.$refs.loginRef.resetFields()
        },
        checkAccount(){
            if(this.registerUser.account.length>=5 && this.registerUser.account.length <=10){
                this.$ajax.get("/checkAccount?account="+this.registerUser.account).then(res=>{
                    console.log(res)
                    if(res.data.code==500){
                        this.checkAccountMsg=res.data.msg
                    }
                })
            }
            
        }
    }
}
</script>

<style>
    body{
        display: flex;
        justify-content: center;
        align-items: center;
        width: 100vw;
        height: 100vh;
    }
   .main{
        width: 440px;
        height: 480px;
        position:relative;
        /* overflow: hidden; */
   }
   .login{
        position:absolute;
        width: 100%;
        height: 50%;
        transition: all 1.5s ease-in-out;
        border-radius: 10px;
        background-color: #ddd;
   }
   .register{
        position:absolute;
        width: 100%;
        height: 100%;
        backface-visibility: hidden;
        transition: all 1.5s ease-in-out;
        border-radius: 10px;
        background-color: #ddd;
   }
   .login{
        transform: rotateY(0deg);
   }
   .register{
        transform: rotateY(180deg);
   }
    .el-form{
        padding-top: 50px;
        padding-left: 10px;
        width: auto;
   }
   .el-input{
        width: 250px;
   }
   .el-button{
        width: 100px;
   }
   .el-link{
        font-size:larger;
        font-weight: bolder;
        float: right;
   }
</style>