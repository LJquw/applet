// pages/my/my.js
var httpUrl = "http://120.25.195.65/takeaway-1.0-SNAPSHOT"
Page({

  /**
   * 页面的初始数据
   */
  data: {
    isLogin:false,
    navTab: ['我的订单','待付款','已消费','配送中'],        
    currentTab: 0,
    sendList:[],
    imageUrl:"http://120.25.195.65/takeaway-1.0-SNAPSHOT/img/",
    userInfo:{}
  },

  
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    //本地缓存获取数据
    wx.getStorage({
      key: 'userInfo',
      success (res) {
        console.log("从本地缓存获取微信用户信息",res.data);
        that.setData({
          userInfo:res.data
        })
      }
    })
    //默认查询全部订单
    wx.getStorage({
      key: 'token',
      success (res) {
        wx.request({
          url: httpUrl+"/order/queryOrderByType", //仅为示例，并非真实的接口地址
          data: {
            token:res.data,
            orderstate:""
          },
          header: {
            'content-type': 'application/json' // 默认值
          },
          success (res) {
            console.log(res.data)
            that.setData({
              sendList:res.data.data
            })
          }
        })
      }
    })
   
  },

  curTab1:function(even){
    var that = this;
    var orderstate = "";
    var index = even.currentTarget.dataset.idx;
    console.log("点击的角标",even.currentTarget.dataset.idx);
    if(index=="0"){  //我的订单
      orderstate = ""
    }else if(index=="1"){ //待付款
      orderstate = "1"
    }else if(index=="2"){ //已消费
      orderstate = "2"
    }else if(index=="3"){ //配送中
      orderstate = "0"
    }

    this.setData({
      currentTab:even.currentTarget.dataset.idx
    })
    //根据订单的状态，获取订单信息  token
    //1.校验是否登录   2.  获取本地token   3.传递参数
    wx.checkSession({
      success () {
        //session_key 未过期，并且在本生命周期一直有效
        wx.getStorage({
          key: 'token',
          success (res) {
            console.log("获取token",res.data);
            wx.request({
              url: httpUrl+"/order/queryOrderByType", //仅为示例，并非真实的接口地址
              data: {
                token:res.data,
                orderstate:orderstate
              },
              header: {
                'content-type': 'application/json' // 默认值
              },
              success (res) {
                console.log(res.data)
                that.setData({
                  sendList:res.data.data
                })
              }
            })

          }
        })

      },
      fail () {
        // session_key 已经失效，需要重新执行登录流程
        wx.login() //重新登录
      }
    })

  },

  loginView:function(){
    var that=this;
    wx.navigateTo({
      url: "/pages/login/login"
    })
    that.setData({
      isLogin:true
    })
  },
  regView:function(){
    wx.navigateTo({
      url: "/pages/register/register"
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