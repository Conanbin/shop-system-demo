<template>
  <div class="components-container">
    <pan-thumb :image="image" />

    <el-button :loading="updateLoading"type="primary" icon="el-icon-upload" style="position: absolute;bottom: 15px;margin-left: 40px;" @click="toggleShow">
      更改头像
    </el-button>
    <image-cropper field="multipartFile"
               @crop-success="cropSuccess"
               @crop-upload-success="cropUploadSuccess"
               @crop-upload-fail="cropUploadFail"
               @close="close"
               v-model="show"
               :width="300"
               :height="300"
               :loading="saveLoading"
               :url="url"
               :params="params"
               :headers="headers"
               img-format="png"></image-cropper>
<!--    <image-cropper-->
<!--      v-show="imagecropperShow"-->
<!--      :key="imagecropperKey"-->
<!--      :width="300"-->
<!--      :height="300"-->
<!--      url="https://httpbin.org/post"-->
<!--      lang-type="en"-->
<!--      @close="close"-->
<!--      @crop-upload-success="cropSuccess"-->
<!--    />-->
  </div>
</template>

<script>
    import ImageCropper from 'vue-image-crop-upload';
    import PanThumb from '@/components/PanThumb'
    import {getToken} from "../../utils/auth";
    import {updateIcon} from "@/api/profile";
    export default {
        name: "ProfileIcon",
        components: { ImageCropper, PanThumb },
        data() {
            return {
                updateLoading : false,
                saveLoading : false,
                url: process.env.BASE_API + '/storage/auth/upload',
                imagecropperKey: 0,
                image: this.$store.getters.avatar,
                show: false,
                params: {
                    access_token: getToken(),
                },
                headers: {
                    smail: '*_~'
                },
                imgDataUrl: ''
            }
        },
        methods: {
            toggleShow() {
                this.updateLoading = true;
                this.show = !this.show;
            },
            cropSuccess(image, field){
                this.image = image;
            },
            cropUploadSuccess(jsonData, field){
                console.log('-------- upload success --------');
                console.log(jsonData);
                console.log('field: ' + field);
                this.saveLoading = true;

                if (jsonData.code === 20000){
                    updateIcon({
                        id : this.$store.getters.user_id,
                        icon : jsonData.data
                    }).then(response =>{
                        this.$message({
                            message: '更新用户头像成功！',
                            type: 'success'
                        });
                        this.$store.dispatch('SetAvatar', jsonData.data);
                    }).catch(() =>{
                        this.$message({
                            message: '更新用户头像失败！',
                            type: 'error'
                        });
                    });
                }else {
                    this.$message({
                        message: jsonData.message,
                        type: 'error'
                    });
                }
                this.saveLoading = false;
                this.updateLoading = false;

            },
            cropUploadFail(status, field){
                console.log('-------- upload fail --------');
                console.log(status);
                console.log('field: ' + field);
                this.updateLoading = false;
                this.saveLoading = false;
            },
            close() {
                this.updateLoading = false;
            }
        }
    }
</script>

<style scoped>
  .avatar{
    width: 200px;
    height: 200px;
    border-radius: 50%;
  }
</style>
