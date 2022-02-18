// pages/tecDetail/tecDetail.js
var httpUrl = "http://120.25.195.65/takeaway-1.0-SNAPSHOT"
Page({

  /**
   * 页面的初始数据
   */
  data: {
    shopInfo:{},
    imageUrl:"http://120.25.195.65/takeaway-1.0-SNAPSHOT/img/"
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    console.log("商家详情页面获取id",options.id);
    //发送请求，获取食物和所包含的项目信息
    wx.request({
      url: httpUrl+'/businesss/queryInfoById', //仅为示例，并非真实的接口地址
      data: {
        id: options.id
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success (res) {
        console.log("商家详情页面返回数据",res.data.data);
        if(res.data.code=="0"){
            that.setData({
              shopInfo:res.data.data
            })
        }
      }
    })
  },
  order:function(even){
    console.log("点击购买,",even.currentTarget.dataset.id);
    //直接跳转页面  到预定页面   传产品id   和  技师id
    wx.navigateTo({
      url: '/pages/order/order?id='+even.currentTarget.dataset.id+'&tecid='+this.data.shopInfo.id, 
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