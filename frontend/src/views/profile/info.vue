<template>
  <div class="app-container">
    <el-form ref="form" :model="form" label-width="120px">
        <el-input v-model="form.id" v-if="false"/>
      <el-form-item label="头像">
        <img :src="form.icon" width="60" height="60" alt="">
      </el-form-item>
      <el-form-item label="账号" >
        <el-input v-model="form.username"/>
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="form.email"/>
      </el-form-item>
<!--      <el-form-item label="头像">-->
<!--        <el-input v-model="form.icon"/>-->
<!--      </el-form-item>-->
      <el-form-item>
        <el-button :loading="loading" type="primary" @click="onSubmit">更新</el-button>
        <el-button @click="onCancel">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import {getInfo, updateInfo} from "@/api/profile";

export default {
    name: "ProfileInfo",
    inject: ['reload'],
    data(){
        return {
            form: {
                id: 0,
                username: '',
                email: '',
                icon: ''
            },
            loading: false
        }
    },
    created() {
        this.fetchData()
    },
    methods: {
        fetchData() {
            getInfo(this.$store.getters.user_id).then(response => {
                this.form = response.data
            })
        },
        onSubmit(){
            this.loading = true;
            updateInfo(this.form).then(response =>{
                this.loading = false;
                this.$message({
                    message: '更新成功！',
                    type: 'success'
                });
            }).catch(() =>{
                this.loading = false;
                this.$message({
                    message: '网络错误！',
                    type: 'error'
                });
            })
        },
        onCancel() {
            this.$message({
                message: 'cancel!',
                type: 'warning'
            })
        },

    }

}
</script>

<style scoped>

</style>
