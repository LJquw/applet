// pages/technician/technician.js
var httpUrl = "http://120.25.195.65/takeaway-1.0-SNAPSHOT"
Page({

  /**
   * 页面的初始数据
   */
  data: {
    shopInfo:[],
    imageUrl:"http://120.25.195.65/takeaway-1.0-SNAPSHOT/img/",
    page:1,
    limit:6,
    isData:true
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    this.getData(that.data.page,that.data.limit);
  },
  
  lower:function(){
    var that = this;
    //当前第几页新增  page
    that.data.page++;
    //发送请求
    this.getData(that.data.page,that.data.limit);
  },

  getData:function(page,limit){
    var that = this;
    if(that.data.isData==true){
      wx.request({
        url: httpUrl+'/businesss/queryBusInfo',
        data:{
          page:page,
          limit:limit
        },
        header: {
          'content-type': 'application/json' // 默认值
        },
        success (res) {
          console.log("商家信息",res.data.data);  //that.data.shopInfo
          var shopList = [...that.data.shopInfo,...res.data.data]
          that.setData({
            shopInfo:shopList,
            isData:res.data.count>shopList.length
          })
        }
      })
    }

   
  },


  shopDetail:function(even){
    console.log("点击商家",even.currentTarget.dataset.id);
    //跳转到技师详情页面
    wx.navigateTo({
      url: "/pages/shopDetail/shopDetail?id="+even.currentTarget.dataset.id
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