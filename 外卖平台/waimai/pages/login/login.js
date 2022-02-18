// pages/login/login.js
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
  regView:function(){
    wx.navigateTo({
      url: "/pages/register/register"
    })
  },
  //用户登录
  submit:function(e){
    console.log("用户点击登录:",e.detail.value);
    //发起请求
    wx.login({
      success (res) {
        if (res.code) {
          //发起网络请求
          wx.request({
            url: httpUrl+"/user/userLogin",
            method:"POST",
            header: {
              "content-Type": "application/x-www-form-urlencoded"
            },
            data: {
              code: res.code,
              phone: e.detail.value.phone,
              password: e.detail.value.password
            },
            success:function(result){
                console.log(result.data)
                if(result.data.code=="0"){  //说明成功  保存token
                    //1.获取到token，放入本地缓存
                    wx.setStorage({
                      key:"token",
                      data:result.data.data
                    });
                    //2.到首页
                    wx.switchTab({
                      url: "/pages/index/index"
                    })
                }else{
                  wx.showToast({
                    title: result.data.msg,
                    icon: 'error',
                    duration: 2000
                  })
                }

            }
          })
        } else {
          console.log('登录失败！' + res.errMsg)
        }
      }
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