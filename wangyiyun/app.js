// app.js
App({
  onLaunch() {
    // 展示本地存储能力
    const logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    // 登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
      }
    })
    // 配置云开发的环境
    wx.cloud.init({
      env: 'cloud1-7g5f3id084404c57'
    })
  },
  globalData: {
    userInfo: null
  }
})
