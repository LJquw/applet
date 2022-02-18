// pages/detail/detail.js

var httpUrl = "http://120.25.195.65/takeaway-1.0-SNAPSHOT"
Page({

  /**
   * 页面的初始数据
   */
  data: {

    proInfo:{},
    imageUrl:"http://120.25.195.65/takeaway-1.0-SNAPSHOT/img/"
  },
  goumai:function(even){
   
    //1.页面跳转，只传递产品id值
    wx.navigateTo({
      url: '/pages/order/order?id='+this.data.proInfo.id,    
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    console.log("详情页面",options.proid);
    //1.发送请求，获取数据  根据产品id获取产品信息
    wx.request({
      url: httpUrl+'/food/queryProInfoById', //仅为示例，并非真实的接口地址
      data: {
        id: options.proid
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success (res) {
        console.log("根据id获取产品信息",res.data.data);
        //把数据存在data的proInfo
        that.setData({
          proInfo:res.data.data
        })
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