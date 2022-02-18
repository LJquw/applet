// pages/register/register.js
var httpUrl = "http://120.25.195.65/takeaway-1.0-SNAPSHOT"
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },
  submit:function(e){
    var that = this;
    console.log("注册",e.detail.value)  //获取表单数据
    //发起请求   后台
    //1.本地缓存获取昵称和头像
    wx.getStorage({
      key: 'userInfo',
      success (res) {
        console.log("注册功能",res.data);
        //2.发起请求   注册功能   POST请求安全
        wx.request({
          url: httpUrl+"/user/regUser", //仅为示例，并非真实的接口地址
          method:"post",
          data: {
            nickname:res.data.nickName,
            imageurl:res.data.avatarUrl,
            username:e.detail.value.username,
            phone:e.detail.value.phone,
            password:e.detail.value.password
          },
          header: {
            "content-Type": "application/x-www-form-urlencoded"
          },
          success (res) {
            console.log(res.data);
            if(res.data.code=="0"){ //成功
              //跳转到登录页面
              wx.navigateTo({
                url: "/pages/login/login"
              })

            }else{  //提示用户
              wx.showToast({
                title: res.data.msg,
                icon: 'error',
                duration: 2000
              })
            }


          }
        })

      }
    })

    
  },
  loginView:function(){
    wx.navigateTo({
      url: "/pages/login/login"
    })
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})