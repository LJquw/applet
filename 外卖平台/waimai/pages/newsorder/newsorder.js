// pages/order/order.js
var httpUrl = "http://120.25.195.65/takeaway-1.0-SNAPSHOT"
var util = require("../../utils/util.js")
Page({

  /**
   * 页面的初始数据
   */

  data: {
    imageUrl:"http://120.25.195.65/takeaway-1.0-SNAPSHOT/img/",
    newsorderinfo:{},
    curentTime:util.formatT(new Date()),
    tecid:"0"
  },
  bindDateChange: function(e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    //console.log(date);
    this.setData({
      curentData: e.detail.value
    })
  },
  bindTimeChange: function(e) {
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      curentTime: e.detail.value
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    //接收上一个页面传递的数据
    console.log("接收详情页面点击的产品id = ",options.id)
    console.log("广告id = ",options.tecid);
      //根据商家id获取商家信息    data.data.busid
      wx.request({
        url: httpUrl+'/advertisement/queryBusInfoById', //仅为示例，并非真实的接口地址
        data: {
          id: options.id
        },
        header: {
          'content-type': 'application/json' // 默认值
        },
        success (res) {
          console.log("获取产品对应的信息",res.data);
          that.setData({
            newsorderinfo:res.data.data,
            tecid:options.tecid
          })
        }
      })
  },
  //表单提交
  submit:function(even){
    var that = this;
    console.log(even.detail.value);
    //校验微信登录时候过期，不用管怎校验，
    wx.checkSession({
      success () {
        //session_key 未过期，并且在本生命周期一直有效
        //拿到广告id，如果是undefined，那么赋值 0
        var tecid = that.data.tecid;
        console.log("=======",typeof(tecid));
        if(typeof(tecid)=="undefined"){
          console.log("=====================")
          tecid = "0";
        }
        //获取本地缓存的token
        wx.getStorage({
          key: 'token',
          success (res) {
            console.log("token = ",res.data)
            wx.request({
              url: httpUrl+"/order/addOrder",
              method:"POST",
              header: {
                "content-Type": "application/x-www-form-urlencoded"
              },
              data: {
                token:res.data,
                foodname:that.data.newsorderinfo.adname,
                makedate:that.data.curentTime,
                username:even.detail.value.username,
                usertell:even.detail.value.usertell,
                information:even.detail.value.information,
                busid:that.data.newsorderinfo.businesss.id,
                foodid:that.data.newsorderinfo.adfood.id,
                tecid:tecid
              },
              success:function(result){
                 if(result.data.code=="0"){
                    //1.跳转页面  我的
                    wx.switchTab({
                      url: '/pages/my/my'
                    })
                 }else{
                   //2.显示错误信息
                   wx.showToast({
                    title: result.data.msg,
                    icon: 'error',
                    duration: 2000
                  })
                 }
              }
            })  
          }
        })
      },
      fail () {
        // session_key 已经失效，需要重新执行登录流程
        //跳转到登录页面
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