// pages/navDetail/navDetail.js
var httpUrl = "http://120.25.195.65/takeaway-1.0-SNAPSHOT"
Page({

  /**
   * 页面的初始数据
   */
  data: {
    typeTitle:"",
    page:1,
    limit:6,
    isDate:true,
    dataList:[],
    urlImage:"http://120.25.195.65/takeaway-1.0-SNAPSHOT/img/"

  },
  orderTap:function(even){
    console.log("到订单页面")
    wx.navigateTo({
      url: '/pages/order/order?id='+even.currentTarget.dataset.id,    
    })
  },
  proDetail:function(even){
    console.log("点击产品",even.currentTarget.dataset.proid);
    wx.navigateTo({
      url: '/pages/detail/detail?proid='+even.currentTarget.dataset.proid
    })
  },
  submit:function(even){
    var that = this;
    console.log(even.detail.value.keyword);
    //发起请求     keyword   类型 typeTitle    queryProInfoByKeyword
    wx.request({
      url: httpUrl+"/food/queryProInfoByKeyword", //仅为示例，并非真实的接口地址
      data: {
        keyword: even.detail.value.keyword,
        type: that.data.typeTitle
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success (res) {
        console.log(res.data)
        that.setData({
          dataList:res.data.data
        })
      }
    })

  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log("nav详情页面："+options.type);
    var that = this;
    that.setData({
      typeTitle:options.type
    })
    //发送请求，获取分类信息
    this.getData(options.type,that.data.page,that.data.limit);
  },
  lower:function(){
    var that = this;
    that.data.page++;
    //发起请求
    this.getData(that.data.typeTitle,that.data.page,that.data.limit);
  },

  getData:function(type,page,limit){
    var that = this;

    if(that.data.isDate==true){
      wx.request({
        url: httpUrl+'/food/queryProInfoByType', //仅为示例，并非真实的接口地址
        data: {
          type: type,
          page:page,
          limit:limit
        },
        header: {
          'content-type': 'application/json' // 默认值
        },
        success (res) {
         console.log(res.data.data);
          var proList = [...that.data.dataList,...res.data.data]
  
          if(res.data.code=="0"){
            that.setData({
              dataList:proList,
              isDate:res.data.count>proList.length
            })
          }
        }
      })
    }
   
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