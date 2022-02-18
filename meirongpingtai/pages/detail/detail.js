// pages/detail/detail.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    index:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var index=options.index;
    console.log('跳转到了详情页面，详情页面是',index)
    this.setData({
      index:index
    })
  },

  // 预定跳转函数
  bookTap:function(){
    wx.navigateTo({
      url:'/pages/book/book?id='+this.data.id,
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