// pages/songList/songList.js

Page({

  /**
   * 页面的初始数据
   */
  data: {
    imgUrls:[
      'https://images.unsplash.com/photo-1551334787-21e6bd3ab135?w=640',
      'https://images.unsplash.com/photo-1551214012-84f95e060dee?w=640',
      'https://images.unsplash.com/photo-1551446591-142875a901a1?w=640'
    ],
    kw:"",
    songs:[]//存放二十首歌曲信息的数组

  },
   //赋值函数，关键词赋值
  inputKeyWord:function(e){
     //获取关键字的内容，将关键词给kw
     var  inputWord = e.detail.value;
     this.setData({
       kw:inputWord,
      

     })

  },
  //搜索按钮对应的点击函数
  doSearch:function(){
   // 获取关键词
   var keyWord = this.data.kw;
   console.log('keyword是',keyWord)
   // 记住this 对象，因为在wx.reqeust回调函数中，this会发生改变
   var that = this;
   wx.request({
     url: 'https://music.163.com/api/search/get?s='+keyWord+"&type=1&limit=20",
     success:function(res){
         // 解析数据，获取歌曲数组 
         // 歌曲数组就是，数组里加了很多歌曲的字典
         //console.log(res)
         var resultSongs = res.data.result.songs;
         console.log(resultSongs)
        //  //记住this 对象，因为在wx.reqeust回调函数中，this会发生改变
        that.setData({
           songs:resultSongs
        })

     }
   })

  },

  gotoPlay:function(e){
    var songId = e.currentTarget.dataset.id;
    console.log(songId);
    // 将对象数组转化为 json字符串格式
     var objs= []; 
     //过滤出歌曲列表得id  和歌曲名称
     for(var i=0;i<this.data.songs.length;i++){
        objs.push({"id":this.data.songs[i].id,"name":this.data.songs[i].name})
     }
     // 将对象转化为字符串方便进行传输
     objs = JSON.stringify(objs)

     console.log("哈哈哈",objs)
    wx.navigateTo({
      url: '/pages/play/play?id='+songId+"&songs="+objs
    })

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    const db = wx.cloud.database();
    const todos = db.collection('songlist');
    // db.collection('songlist').add({
    //   // data 字段表示需新增的 JSON 数据
    //   data: {
    //     // _id: 'todo-identifiant-aleatoire', // 可选自定义 _id，在此处场景下用数据库自动分配的就可以了
    //     songid: "8764443",
    //     name: '挪威森林',       
       
    //   },
    //   success: function(res) {
    //     // res 是一个对象，其中有 _id 字段标记刚创建的记录的 id
    //     console.log('哈哈哈操作成功',res)
    //   }
    // })

    // // 在刷新完首页之后，根据id获取一条数据
    // db.collection('songlist').doc('2d44d6c2610fca8803c028201880ad42').get({
    //   success: function(res) {
    //     // res.data 包含该记录的数据
    //     console.log('我查找到的id是',res.data)
    //   }
    // })

    // 查找所有的数据
    // db.collection('songlist').where({
    //   _openid: 'ozrvp5HeMM5nYnihiIF8m4D7RdmU',
    
    // })
    // .get({
    //   success: function(res) {
    //     // res.data 是包含以上定义的两条记录的数组
    //     console.log("查找到的所有的数据是",res.data)
    //   }
    // })

    //云json数据库的更新方法
    // db.collection('songlist').doc('2d44d6c2610fca8803c028201880ad42').update({
    //   // data 传入需要局部更新的数据
    //   data: {
    //     // 表示将 done 字段置为 true
    //     name: "村上春树"
    //   },
    //   success: function(res) {
    //     console.log("更新完之后",res.data)
    //   }
    // })
   
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