// index.js
// 获取应用实例
// require 获取本地其他js文件，并将他保存到变量中
var data=require('../../utils/data.js')

const app = getApp()
var httpUrl="http://localhost:81"
Page({
  data: {
    banner_url:data.getBannerData(),
    // 导航栏的图标数据
    navTopItems:data.getIndexNavData(),
    // 颜色的数组
    colors:["red","orange","yellow","green","purple"],
    // 选中id
    curNavID:1,
    // 列表内容的下标
    curIndex:0,
    // 导航列表数据
    list:data.getIndexNavSectionData(),
    // 接收首页轮播图数据
    banners:[],
    // 服务器路径
    imageUrl:"http://localhost:81/images/",
    // 导航图
    navs:[],
    // 页数 固定条数
    page:1,
    limit:10,
    pros:[],

  },

  switchTab:function(event){
    var id=parseInt(event.currentTarget.dataset.id);
    var index=parseInt(event.currentTarget.dataset.index);

    // 设置id和索引
    this.setData({
      // 选中的id
      curNavID:id,
      curIndex:index
    })
  },
 
  onLoad: function(options){
    var that=this;
    // 1、获取轮播图信息
    wx.request({
      url: httpUrl+'/image/queryImageByImagetype', //仅为示例，并非真实的接口地址
      data: {
        imagetype: "banner"
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success (res) {
        console.log("获取轮播图信息响应结果",res.data)
        if(res.data.code=="0"){
          // 请求成功
          that.setData({
            banners:res.data.data
          })
        }
      }
    })

    // 2、获取导航图信息
    wx.request({
      url: httpUrl+'/image/queryImageByImagetype', // 图片接口信息
      data: {
        imagetype: "nav"
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success (res) {
        console.log("获取导航图信息响应",res.data)
        if(res.data.code=="0"){
          // 请求成功
          that.setData({
            navs:res.data.data
          })
        }
      }
    })

    // 3、获取产品信息  f分页获取   当前页数（可变）  每页条数固定 10
    wx.request({
      url: httpUrl+'/project/queryProInfo',   // 项目接口
      data: {
        page: that.data.page,
        limit: that.data.limit
      },
      header: {
        'content-type': 'application/json' // 默认值
      },
      success (res) {
        console.log("获取产品信息响应",res.data)
        if(res.data.code=="0"){
          that.setData({
            pros:res.data.data
          })
        }
      }
    })
  },

  // 滚动到底部触发函数
  upper:function(){
    
  },

  // 上拉函数
  loadMore:function(){
    // console.log('hhsbxbhdhh')
  },

  // 跳转到详情页面函数
  navgateDetail:function(e){
    var index=e.currentTarget.dataset.index;
    console.log('index是',index)
    wx.navigateTo({
      url:'/pages/detail/detail?index='+index,
    })
  },

  // 跳转到预订页面函数
  bookTap:function(e){
    var index=e.currentTarget.dataset.index;
    console.log('index是',index)
    wx.navigateTo({
      url:'/pages/book/book?index='+index,
    })
  },

  getUserProfile(e) {
    // 推荐使用wx.getUserProfile获取用户信息，开发者每次通过该接口获取用户个人信息均需用户确认，开发者妥善保管用户快速填写的头像昵称，避免重复弹窗
    wx.getUserProfile({
      desc: '展示用户信息', // 声明获取用户个人信息后的用途，后续会展示在弹窗中，请谨慎填写
      success: (res) => {
        console.log(res)
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    })
  },
  getUserInfo(e) {
    // 不推荐使用getUserInfo获取用户信息，预计自2021年4月13日起，getUserInfo将不再弹出弹窗，并直接返回匿名的用户个人信息
    console.log(e)
    this.setData({
      userInfo: e.detail.userInfo,
      hasUserInfo: true
    })
  }
})
