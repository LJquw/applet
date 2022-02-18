// pages/index/index.js
var httpUrl = "http://120.25.195.65/takeaway-1.0-SNAPSHOT"
Page({
  /**
   * 页面的初始数据
   */
  data: {
    banners:[],
    imageUrl:"http://120.25.195.65/takeaway-1.0-SNAPSHOT/img/",
    navs:[],
    page:1,
    limit:10,
    pros:[],
    isData:true

  },

  /**
   * 生命周期函数--监听页面加载12
   */
  onLoad: function (options) {
    var that = this;
    //1.获取轮播图信息
    wx.request({
      url: httpUrl+'/image/queryImageByImagetype', //仅为示例，并非真实的接口地址
      data: {
        imagetype: 'banner'
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success (res) {
        console.log("获取轮播图信息响应",res.data)
        if(res.data.code=="0"){ //请求成功
          that.setData({
            banners:res.data.data
          }) 
        }       
      }
    })
   //2.获取导航图信息
   wx.request({
    url: httpUrl+'/image/queryImageByImagetype', //仅为示例，并非真实的接口地址
    data: {
      imagetype: 'nav'
    },
    header: {
      'content-type': 'application/json' // 默认值
    },
    success (res) {
      console.log("获取导航图信息响应",res.data)
      if(res.data.code=="0"){ //请求成功
        that.setData({
          navs:res.data.data
        }) 
      }       
    }
    })
    //3.获取产品信息   分页获取  当前页数（可变）   每页条数固定 10
    this.getDate(that.data.page,that.data.limit);

  },

  //滑动底部触发
  lower(e) {
    var that = this;
    console.log("底部",e)
    //1.当前页面自增1   page
    that.data.page++
    console.log("分页，当前页数:",that.data.page)
    //2.发起请求   page  limit
    this.getDate(that.data.page,that.data.limit);
  },

  //自定义：分页获取数据
  getDate:function(page,limit){
    var that = this;
    if(that.data.isData==true){   //说明还有数据
      wx.request({
        url: httpUrl+'/food/queryProInfo', //仅为示例，并非真实的接口地址
        data: {
          page: page,
          limit: limit
        },
        header: {
          'content-type': 'application/json' // 默认值
        },
        success (res) {
          console.log("获取产品信息响应",res.data)
          if(res.data.code=="0"){
            //res.data.data:后台拿到的数据，和之前的数据拼接 that.data.pros
            var prolist = [...that.data.pros,...res.data.data]  //新的数组数据
            //判断新数据的条数  和  数据库的数据总条数对比
            console.log("count = ",res.data.count);
            console.log("length = ",prolist.length)
            that.setData({
              pros:prolist,
              isData:res.data.count>prolist.length
            })
          }
        }
      })
    }

    

  },

  navDetail:function(even){
    console.log("点击分类为：",even.currentTarget.dataset.type);
    //跳转页面
    wx.navigateTo({
      url: '/pages/navDetail/navDetail?type='+ even.currentTarget.dataset.type
    })
  },
  
  //自定义的点击产品的方法
  proDetail:function(even){
    console.log("点击产品",even.currentTarget.dataset.proid);
    wx.navigateTo({
      url: '/pages/detail/detail?proid='+even.currentTarget.dataset.proid
    })
  },

  orderTap:function(even){
    console.log("到订单页面")
    wx.navigateTo({
      url: '/pages/order/order?id='+even.currentTarget.dataset.id,    
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