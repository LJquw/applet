// pages/my/my.js
const innerAudioContext = wx.createInnerAudioContext()
const db = wx.cloud.database();
Page({

  /**
   * 页面的初始数据
   */
  data: {
   
    state:"play",//当前歌曲的播放状态

    //当前得歌曲
    songid:"",
    //歌曲信息
    song:[],
    songs:[],
    //定义歌词的数组
    lyricArray:null,
    //控制歌词滚动的变量
    // 改变marginTop的值产生歌词滚动的效果
    marinTop:0,
    // 当前歌曲播放到的行号
    currentIndex:0,
    //当前时长
    playTime:"00:00",
    //总时长
    duration:0,
    //结束的时间
    endTime:"",
    //当前进度条的取值
    move:0,
    //是否收藏
    islike:false,


  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    
    var that = this;
    //查询收藏的所有的
    db.collection('mysong').where({
      _openid: 'ohrgE5HvjhtSFMPzKaY0FRHnhjms',
    
    })
    .get({
      success: function(res) {
        // res.data 是包含以上定义的两条记录的数组
        console.log("我自己收藏的数据是",res.data)
        //直接将从数据库查询的数据，给data中的变量
        that.setData({
          songs:res.data,
          songid:res.data[0].songid

        })

        console.log("查询数据库等待",that.data)

        var id = that.data.songs[0].songid;
    
        console.log('在播放页面接受到了id',id)
        // 获取全部得歌曲id 和歌曲名称的对象
        //var songsArray = JSON.parse(options.songs);
        console.log("hahahah3423432",that.data.songs)
        //取消自动播放
        // 微信的音频的小bug 重复点进某一首歌导致 onTimeUpdate 不会触发
        // 可以先暂停在调用播放方法， onTimeUpdate就可以生效了
        //innerAudioContext.autoplay = true
        innerAudioContext.src = "https://music.163.com/song/media/outer/url?id="+id;
        innerAudioContext.pause();
        innerAudioContext.play();
        // 获取歌曲的详情
        that.getMusicInfoById(id);
        // 根据歌曲的id获取歌词
        that.getLyricById(id);
        
        // 音频的监听的事件,
        //可以播放事件
        innerAudioContext.onCanplay(()=>{
    
          var  duration = innerAudioContext.duration;
          console.log('可以播放的总时常',duration)
        })
    
        // 监听播放事件
        innerAudioContext.onPlay(()=>{
          var  duration = innerAudioContext.duration;
          console.log('正常播放的总时常',duration)
    
        })
      
         //监听音频播放进度更新事件
        innerAudioContext.onTimeUpdate(()=>{
          //获取当前音频的播放进度
           var  currentTime = innerAudioContext.currentTime;
          //获取音频的总时长
          var duration = innerAudioContext.duration;
          //输出这两个变量
         //console.log(currentTime,'.........',duration)
          // 可以根据以上两个参数 当前进度  和总时间完成歌词的滚动
          // 歌词滚动的方法,在歌词滚动函数里有变量能控制 maginTop
          // 模拟滚动效果
          //  setTimeout(function(){
          //    var value=that.data.marinTop +1;
          //    that.setData({
          //      marinTop:value
          //    })
    
          //  },1500)
           // 歌词滚动的方法，需要控制marginTop
          that.lyricScroll(currentTime,duration);
        })   
    

      }
    })

   
  },

  //完成进度条的拖拽事件
  dragSilder:function(e){
    //获取拖拽后进度条的值
    var value = e.detail.value;
    console.log('进度条的值是',value)
    //音频跳转到当前的进度
    innerAudioContext.seek(value)
    // 需要一个总时长和当前时长的变量


  },
  //滚动函数
  lyricScroll:function(currentTime,duration){
    // 将当前时长和 总时长转化为  分和秒的格式，方便进行进度条的展示   
  // 获得当前时间的分钟
   var playMinute = Math.floor(currentTime/60)
   //获得当前时间的秒
   var  playSecond = Math.floor(currentTime%60)
   // "07:12"
   playMinute = playMinute<10?"0"+playMinute:playMinute;
   playSecond = playSecond<10?"0"+playSecond:playSecond;
     // 获得当前结束的分钟
   var endMinute = Math.floor(duration/60)
     //获得当前结束的秒
   var  endSecond = Math.floor(duration%60)
      // "07:12"
   endMinute = endMinute<10?"0"+endMinute:endMinute;
   endSecond = endSecond<10?"0"+endSecond:endSecond;
   this.setData({
       duration:duration,
       playTime:playMinute+":"+playSecond,
       endTime:endMinute+":"+endSecond,
       move:currentTime

   })

    var lyricArray = this.data.lyricArray;
    if(lyricArray!=null){
       // 因为歌词最后一行是没有下句的，所以将最后和之前的歌词分开判断，从倒数第二行开始
       if(this.data.currentIndex==lyricArray.length-2){
         // 如果唱到了倒数第二句，等把倒数第二句唱完，才能修改currentIndex，再将倒数第一句表红
         if(currentTime>lyricArray[lyricArray.length-1][0]){
          //表明在唱最后一句了
          this.setData({
            currentIndex:lyricArray.length-1
          })
         }
           
       }
       else{
         
        // currentTime 大于当前行的播放时间  lyricArray[i][0]，小于下一行的播放时间  lyricArray[i+1][0]
        // 定义一个i 把这个行号
        // 遍历所有的歌词
        for(var i=0;i<lyricArray.length-1;i++){
          //判断 currentTime大于歌词数组中的哪一个行的时间
          // 小于哪一个 下一行的时间
          if(currentTime >=lyricArray[i][0]&&currentTime <lyricArray[i+1][0]){
            //记录当前唱的行号
            this.setData({
              currentIndex:i
            })
          }
         }
      }     

      //歌词唱完 6句之后，歌词在进行滚动
      if(this.data.currentIndex>=4){
        this.setData({          
          //上升的距离 要是30rpx 30rpx是歌词之前的行高
          // line-height: 30rpx;
          marinTop:(this.data.currentIndex-4)*50
        })
      }
      else{
        this.setData({
          
          marinTop:0
        })
      }



    }

  },

   //获取歌词的方法
   getLyricById:function(id){
     var that = this;
    wx.request({
      url: 'https://music.163.com/api/song/lyric?os=pc&id='+id+'&lv=-1&kv=-1&tv=-1',
      success:function(res){
       //获取歌词
        var result = res.data.lrc.lyric
        //console.log(result)
       //解析歌词，将时间和歌曲内容，提炼出来
       // 用数组存储  歌曲的时间和 歌词内容
         var lyricArray1=that.parseLyric(result)
       // 去除歌词为空的内容
         lyricArray1  = that.sliceNUll(lyricArray1)
         //观察孔的选项是否去除掉
         console.log("是否为空",lyricArray1)
         //将最后的歌词给data 中的data数组
         that.setData({
          lyricArray:lyricArray1
         })      }
    })
   },

   //去除歌词为空的函数
   sliceNUll:function(lyricArray1){
      var result =[];
      for (var i=0;i<lyricArray1.length;i++){
         //判断歌词数组中内容不为为空的选项
         if(lyricArray1[i][1]!=""){
           result.push(lyricArray1[i])
         }        
      }
      return result;
   },

   //歌词的解析函数
   parseLyric:function(lyric){
    var  lyricArray1 = lyric.split("\n")
    // 最后一行 是索引长度-1
    if(lyricArray1[lyricArray1.length-1] == ""){
      //删除最后一行
      console.log('删之前',lyricArray1)
      lyricArray1.pop()
      console.log('删掉了最后一行',lyricArray1)         
    }
    //歌词的格式 ：[XX:XX.XXX或者是xx]

    //匹配任意一个数组 [0-9]
    //匹配任意一个字母[a-zA-Z]
    //匹配 1或者2或者3 [123]
    // {n} 匹配前面的字符数量为n个  \d{2}
    // {n,m} 匹配前面字符数量为n个到m个
    //根据时间 去编写正则表达式,匹配时间字符串
    var   re = /\[\d{2}:\d{2}\.\d{2,3}\]/;
    //定义一个存储时间和最终的内容的数组
    var  finalResult = [];
    //边遍历数组 边拿到时间字符串
    // v代表数组中的每一个元素，i数组中每一个元素的小标，a代表被遍历的数组本身
    lyricArray1.forEach(function(v,i,a){
      // 通过正则把歌词提炼出来
      var lyricOne = v.replace(re,"")
     
      //提取符合正则规律的时间
      var time  = v.match(re)[0]     
      //通过字符串截取，截取时间
      // substring(a,b) 字符串从a截取到b 区间是左闭右开的
      time = time.substring(1,time.length-1)   
      //将时间换算成秒 例如 01:32.93   
      var time=parseFloat(time.split(":")[0])*60+parseFloat(time.split(":")[1])
      //console.log('过滤后的时间',time)   
       //把歌词和对应的时间加到
      finalResult.push([time,lyricOne])
      //console.log(finalResult)
    }


    )

    return finalResult;


   },

   //根据歌曲的id获取歌曲详情的方法

   getMusicInfoById:function(id){
    var that = this;
    wx.request({
      url: "https://music.163.com/api/song/detail/?id="+id+"&ids=["+id+"]",
      success:function(res){
         //输出歌曲的详情信息
         console.log('歌曲的详情信息',res)
         that.setData({

          song:res.data.songs[0]
         })
      }
    })


   },



   // 歌曲的暂停与播放
   pauseOrplay:function(){
        //获取当前歌曲的播放状态
        var state = this.data.state;
        //如果状态是播放状态，变为暂停状态
        if(state == "play"){

          innerAudioContext.pause();
          this.setData({
            state:"pause"
          })
        }
        else{
          //播放歌曲
          innerAudioContext.play();
          this.setData({
            state:"play"
          })
        }        

   },
  //  上一首的函数
  prev:function(){
   //找到当前播放歌曲的索引
   console.log('当前首歌曲',this.data.songid)
   var  songArray = this.data.songs;
   console.log("hahahhahjhhah234324",songArray)
    var curentIndex = 0;
    for (var i=0;i<songArray.length;i++){
       if(songArray[i].songid==this.data.songid){

         curentIndex = i;
       }

    }
    // 把当前歌曲换成上一首歌曲
    if (curentIndex !=0){
          this.setData({
            //更新歌曲为上一首的id
            songid:songArray[curentIndex-1].songid
          })
    }
    console.log('上一首歌曲',this.data.songid)
    innerAudioContext.stop();
    innerAudioContext.src = "https://music.163.com/song/media/outer/url?id="+this.data.songid;    
    innerAudioContext.play();
    // // 根据歌曲的id获取歌词
    this.getLyricById(this.data.songid);
    // // 获取歌曲的详情
    this.getMusicInfoById(this.data.songid);   

  },

//  上一首的函数
  next:function(){
   //找到当前播放歌曲的索引
   console.log('当前首歌曲',this.data.songid)
   var  songArray = this.data.songs;
   console.log("hahahhahjhhah234324",songArray)
    var curentIndex = 0;
    for (var i=0;i<songArray.length;i++){
       if(songArray[i].songid==this.data.songid){

         curentIndex = i;
       }

    }
    // 把当前歌曲换成上一首歌曲
    if (curentIndex !=songArray.length-1){
          this.setData({
            //更新歌曲为上一首的id
            songid:songArray[curentIndex+1].songid
          })
    }
    console.log('下首歌曲',this.data.songid)
    innerAudioContext.stop();
    innerAudioContext.src = "https://music.163.com/song/media/outer/url?id="+this.data.songid;    
    innerAudioContext.play();
    // // 根据歌曲的id获取歌词
    this.getLyricById(this.data.songid);
    // // 获取歌曲的详情
    this.getMusicInfoById(this.data.songid);
    

  },

  //歌曲的收藏函数
  likeAction:function(){
    // 让收藏的文字出现
    this.setData({
      islike:true

    })
    var  that = this;
    //三秒钟后让收藏的文字消失
    setTimeout(function(){     
      that.setData({
        islike:false
  
      })

    },1500)
    //调用云开发数据函数
    
    const todos = db.collection('mysong');
    db.collection('mysong').add({
      // data 字段表示需新增的 JSON 数据
      data: {
        // _id: 'todo-identifiant-aleatoire', // 可选自定义 _id，在此处场景下用数据库自动分配的就可以了
        songid: this.data.song.id,
        name: this.data.song.name,       
       
      },
      success: function(res) {
        // res 是一个对象，其中有 _id 字段标记刚创建的记录的 id
        console.log('收藏成功',res)
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
    //当页面卸载的收，歌曲停止
    //停止歌曲
    innerAudioContext.stop();
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