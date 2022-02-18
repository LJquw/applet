// pages/play/play.js
const innerAudioContext = wx.createInnerAudioContext();
const db = wx.cloud.database();
Page({

    /**
     * 页面的初始数据
     */
    data: {
        // action:{
        //     method:"play"
        // },

        state:"play", // 当前歌曲的播放状态
        // 当前的歌曲
        songid:"",
        // 歌曲列表
        song:[],
        songs:[],
        // 定义歌词的数组
        lyricArray:null,
        // 控制歌词滚动的变量
        // 改变marinTop的值产生歌词滚动的效果
        marinTop:0,
        // 当前歌曲播放到的行号
        currentIndex:0,
        // 当前时长
        playTime:"00:00",
        // 总时长
        duration:0,
        // 结束时间
        endTime:"",
        // 当前进度条的取值
        move:0,
        // 是否收藏
        islike:false
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        var id = options.id;
        
        // console.log('在播放页面接收到了id',id)
        // 获取全部的歌曲id和歌曲名对象
        var songsArray = JSON.parse(options.songs);
        // console.log("啦啦啦啦啦222",songsArray);
        // 给当前播放的歌曲id进行赋值
        this.setData({
            songid:id,
            songs:songsArray
        })
        // console.log("hahahah",this.data.songs)
        var that=this;
        
      // const innerAudioContext = wx.createInnerAudioContext()
      // 取消自动播放
      // 微信的音频小bug 重复的点进某首歌导致监听音频播放事件(onTimeUpdate)不触发
      // 可以先暂停再调用播放方法，onTimeUpdate就可以生效了
      // innerAudioContext.autoplay = true
      innerAudioContext.src = "https://music.163.com/song/media/outer/url?id="+id;
      innerAudioContext.pause();
      innerAudioContext.play();

      // 根据歌曲的id获取歌词
      this.getLyricById(id)
      // 获取歌曲的详情
      this.getMusicTnfoById(id)
      // 音频的监听事件
      // 可以播放事件
      innerAudioContext.onCanplay(() => {
        var duration=innerAudioContext.duration;
        // console.log('可以播放的总时长',duration)
      })

      // 监听播放事件
      innerAudioContext.onPlay(()=>{
        var duration=innerAudioContext.duration;
        // console.log('正常播放的总时长',duration)
      })

      // 监听音频播放进度更新事件
      innerAudioContext.onTimeUpdate(()=>{
        // 获取当前音频的播放进度
        var currentTime=innerAudioContext.currentTime;
        // 获取音频的总时长
        var duration=innerAudioContext.duration;

        // 输出这两个变量
        // console.log(currentTime,'.......',duration)
        // 根据以上两个参数，当前进度和总时间完成歌词的滚动
        // 歌词滚动的方法,在歌词的滚动函数里，有变量能控制marinTop

        // 模拟滚动效果
        // setTimeout(function(){
        //   var value=that.data.marinTop+1;
        //   that.setData({
        //     marinTop:value
        //   })
        // },1500)

        // 歌词滚动的方法，需要控制marinTop
        that.lyricScroll(currentTime,duration);
      })

      // innerAudioContext.onPlay(() => {
      //   console.log('开始播放')
      // })
      // innerAudioContext.onError((res) => {
      //   console.log(res.errMsg)
      //   console.log(res.errCode)
      // })

    this.setData({
      audio:innerAudioContext
    })
  },

  // 完成进度条的拖拽事件
  dragSlider:function(e){
    // 获取拖拽后的进度条的值
    var value=e.detail.value;
    console.log('进度条的值是',value)

    // 音频跳转到当前的进度
    innerAudioContext.seek(value)
  },

  // 歌词滚动的函数
  lyricScroll:function(currentTime,duration){
    // 将总时长和当前时长转化为 分和秒的格式，方便进行进度条展示
    // 获得当前时间的分
    var playMinute=Math.floor(currentTime/60)
    // 获得当前时间的秒
    var playSecond=Math.floor(currentTime%60)
    // "07:12"
    playMinute=playMinute<10?"0"+playMinute:playMinute;
    playSecond=playSecond<10?"0"+playSecond:playSecond;

    // 获取结束时间的分
    var endMinute=Math.floor(duration/60)
    // 获取结束时间的秒
    var endSecond=Math.floor(duration%60)
    // "07:12"
    endMinute=endMinute<10?"0"+endMinute:endMinute;
    endSecond=endSecond<10?"0"+endSecond:endSecond;

    this.setData({
      duration:duration,
      playTime:playMinute+":"+playSecond,
      endTime:endMinute+":"+endSecond,
      move:currentTime
    })

    var lyricArray=this.data.lyricArray;
    if(lyricArray!=null){
      // 因为歌词的最后一行是没有下一句的，所以将最后一行和之前的歌词分开判断，从倒数第二行开始
      if(this.data.currentIndex==lyricArray.length-2){
        // 如果唱到倒数第二句，等把倒数第二句唱完，才能修改currentIndex,将倒数第一句标红
        if(currentTime>lyricArray[lyricArray.length-1][0]){
          // 表明已经在唱最后一句了
          this.setData({
            currentIndex:lyricArray.length-1
          })
        }

      }else{
      // currentTime大于当前播放行的时间且lyricArray[i][0]小于下一行播放的时间
      // 定义一个i，相当于行号
      // 遍历所有的歌词
        for(var i=0;i<lyricArray.length-1;i++){
          // 开始判断currentTime是大于歌词列表中哪一个行的时间，小于哪一个下一行的时间
          if(currentTime>=lyricArray[i][0]&&currentTime<lyricArray[i+1][0]){
            // 记录当前唱到的行号
            this.setData({
              currentIndex:i
            })
          }

        }

      }
      // 歌词唱完4句之后再进行滚动
      if(this.data.currentIndex>=5){
        this.setData({
          // 上升的距离是50rpx 50rpx是歌词之前的行高
          marinTop:(this.data.currentIndex-5)*50
        })
      }else{
        this.setData({
          marinTop:0
        })
      }
      
    }
  },

  // 获取歌词的方法
  getLyricById:function(id){
    var that=this;
        wx.request({
          url: 'https://music.163.com/api/song/lyric?os=pc&id='+id+'&lv=-1&kv=-1&tv=-1',
          success:function(res){
            // 获取歌词
            var result=res.data.lrc.lyric;
            // console.log(result)

            // 解析歌词，，将时间和歌曲内容提炼出来
            // 用数组存储，歌曲的时间和歌词内容
            var lyricArray1=that.parseLyric(result)
            // 去歌词为空的内容
            lyricArray1=that.sliceNULL(lyricArray1)
            // 观察空的选项是否为空
            // console.log('是否为空',lyricArray1)
            // 将最后的歌词给data中的data数组
            that.setData({
              lyricArray:lyricArray1
            })
          }
        })
  },

  // 去除歌词为空的函数
  sliceNULL:function(lyricArray1){
    var result=[];
    for(var i=0;i<lyricArray1.length;i++){
      // 判断歌词数组中内容不为空的选项
      if(lyricArray1[i][1]!=""){
        result.push(lyricArray1[i])
      }
    }
    return result;
  },

  // 歌词的解析函数
  parseLyric:function(lyric){
    var lyricArray1=lyric.split("\n")
    // 最后一行是索引的长度-1
    if(lyricArray1[lyricArray1.length-1]==""){
      // 删除最后一行
      // console.log('删掉之前',lyricArray1)
      lyricArray1.pop()
      // console.log('删掉的最后一行',lyricArray1)
    }
    // 歌词的格式 ：[xx:xx.xxx或者是xx]

    // 匹配任意一个数字 [0-9]
    // 匹配任意一个字母 [a-z   A-Z]
    // 匹配1或者2或者3   [123]
    // {n} 匹配前面的字符数量为n个  \d{2}
    // {n,m} 匹配前面字符数量为 n~m个
    // 根据时间去编写正则表达式,匹配时间字符串
    var re=/\[\d{2}:\d{2}\.\d{2,3}\]/;
    // 定义一个存储时间和最终的内容的数组
    var finalResult=[];
    // 边遍历数组边拿到时间字符串
    // v代表数组中的每一个元素，i代表数组中每个元素的下标，a代表被遍历数组本身
    lyricArray1.forEach(function(v,i,a){
      // 通过正则把歌词提炼出来
      var lyricOne=v.replace(re,"")
      // console.log('过滤后的歌词',lyricOne)
      // 提取符合正则规则的时间
      var time=v.match(re)[0]
      
      // 通过字符转截取，截取时间
      // substring(a,b) 字符串从a截取到b [a,b)
      time=time.substring(1,time.length-1)
      
      // 将时间换算成秒 例如 01:32.93 
      var time=parseFloat(time.split(":")[0])*60+parseFloat(time.split(":")[1])
      // console.log('过滤后的时间',time)
      // 把歌词和对应的时间加到finalResult
      finalResult.push([time,lyricOne])
      // console.log(finalResult)
    })

    // this.setData({
    //   lyricArray:lyricArray1
    // })

    return finalResult;
  },

  // 根据歌曲的id获取歌词详情
  getMusicTnfoById:function(id){
      var that=this;
      wx.request({
        url: "https://music.163.com/api/song/detail/?id="+id+"&ids=["+id+"]",
        success:function(res){
          // 输出歌曲的详情信息
          console.log('歌曲的详情信息',res)
          that.setData({
            song:res.data.songs[0]
          })
        }
      })
  },

  // 歌曲的暂停与播放函数
  pauseOrplay:function(){
    // 获取当前歌曲的播放状态
    var state=this.data.state;
    // 如果状态是播放状态，则变为暂停状态
    if(state=="play"){
      innerAudioContext.pause();
      this.setData({
        state:"pause"
      })
    }else{
      // 播放歌曲
      innerAudioContext.play();
      this.setData({
        state:"play"
      })
    }
  },

  // 上一首的函数
  prev:function(){
    // 找到当前播放歌曲的索引
    console.log('上一首歌曲')
    var songArray=this.data.songs;
    console.log('hahahhah',songArray)
    var currentIndex=0;
    for(var i=0;i<songArray.length;i++){
      if(songArray[i].id==this.data.songid){
        currentIndex=i;
      }
    }
    // 把当前歌曲换成上一首歌曲
    if(currentIndex!=0){
      this.setData({
        // 更新歌曲为上一首的id
        songid:songArray[currentIndex-1].id
      })
    }
      innerAudioContext.src = "https://music.163.com/song/media/outer/url?id="+this.data.songid;
      innerAudioContext.pause();
      innerAudioContext.play();
      // 根据歌曲的id获取歌词
      this.getLyricById(this.data.songid)
      // 获取歌曲的详情
      this.getMusicTnfoById(this.data.songid)
  },

  // 下一首的函数
  next:function(){
    // 找到当前播放歌曲的索引
    console.log('下一首歌曲')
    var songArray=this.data.songs;
    console.log('hahahhah',songArray)
    var currentIndex=0;
    for(var i=0;i<songArray.length;i++){
      if(songArray[i].id==this.data.songid){
        currentIndex=i;
      }
    }
    // 把当前歌曲换成下一首歌曲
    if(currentIndex!=songArray.length-1){
      this.setData({
        // 更新歌曲为下一首的id
        songid:songArray[currentIndex+1].id
      })
    }
      innerAudioContext.src = "https://music.163.com/song/media/outer/url?id="+this.data.songid;
      innerAudioContext.pause();
      innerAudioContext.play();
      // 根据歌曲的id获取歌词
      this.getLyricById(this.data.songid)
      // 获取歌曲的详情
      this.getMusicTnfoById(this.data.songid)
  },

  // 歌曲收藏函数
  likeAction:function(){
    // 让收藏的文字出现
    this.setData({
      islike:true
    })
    var that=this;
    // 3秒钟后让收藏的文字消失
    setTimeout(function(){
      that.setData({
        islike:false
      })
    },3000)
    
    // 开始调用云开发数据函数
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
      // 当页面卸载的收，歌曲停止
      // 停止歌曲
     this.data.audio.stop();
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