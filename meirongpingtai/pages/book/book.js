// pages/book/book.js
// require 获取本地其他js文件，并将他保存到变量中
var data=require('../../utils/data.js')
var util=require('../../utils/util')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    // 获取地址源数据
    addrArray:util.replacePhone(data.userData().addrs,true),
    // 默认索引位置
    addrIndex:0,
    // 默认的日期
    date:"2021-08-09",
    // 默认时间
    time:"16:03",
    // 提示框是否隐藏
    bookToastHidden:true
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var index=options.index;
    console.log('跳转到了预订页面，预定页面是',index)
  },

  // 隐藏提示框出现
  bindToastTap:function(){
    this.setData({
        bookToastHidden:false
    })
  },
  hideToast:function(){
      this.setData({
          bookToastHidden:true
      })
  },

  // 改变地址的事件
  bindAddrPickerChange:function(event){
    console.log('标签地址属性值',event.detail.value)
    this.setData({
      addrIndex:event.detail.value
    })
  },

  // 绑定改变的时间
  bindDatePickerChange:function(event){
    console.log('标签日期属性值',event.detail.value)
    this.setData({
      date:event.detail.value
    })
  },
  bindTimePickerChange:function(event){
    console.log('标签时间属性值',event.detail.value)
    this.setData({
      time:event.detail.value
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