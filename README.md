## 一、项目简介

​		该项目是一个JavaWeb的在线考试系统，用户可以注册、登录、在线答题、查看历史记录。目前，只有单选题，日后有时间有精力还可以扩张出多选题，简答题……（该项目是阶段学习的成果，功能比较单一）

## 二、所用技术

开发工具：IntelliJ IDEA 2018.3.5

操作系统：win10 专业版

所用语言：Java

前台框架：layui

后台框架：Spring Data Jpa、Spring Boot 、Mybatis

数据库：MySQL 5.7

## 三、考试流程：

1. 用户前台注册
2. 管理员后台登录，添加考试,添加题目，发布考试
3. 考生登录前台参加考试，交卷
4. 系统自动比对答案
5. 考生可以在考试历史查看成绩

## 四、部分界面

### 1、前台

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190814011707669.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80Mzg0MTYzMw==,size_16,color_FFFFFF,t_70)

答题

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190814011722452.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80Mzg0MTYzMw==,size_16,color_FFFFFF,t_70)
考试历史
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190814011741193.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80Mzg0MTYzMw==,size_16,color_FFFFFF,t_70)
### 2、后台

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190814011756446.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80Mzg0MTYzMw==,size_16,color_FFFFFF,t_70)
试卷管理

![在这里插入图片描述](https://img-blog.csdnimg.cn/20190814011810717.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80Mzg0MTYzMw==,size_16,color_FFFFFF,t_70)
历史试卷管理
![历史试卷管理](https://img-blog.csdnimg.cn/20190814011822474.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80Mzg0MTYzMw==,size_16,color_FFFFFF,t_70)



## 五、数据库表

### 1.user表

| 字段名   | 类型        | 是否为主键 | 是否为空 | 描述   |
| -------- | ----------- | ---------- | -------- | ------ |
| id       | int         | 是         | 否       | 主键ID |
| name     | varchar(20) | 否         | 否       | 姓名   |
| email    | varchar(50) | 否         | 否       | 邮箱   |
| password | varchar(20) | 否         | 否       | 密码   |

### 2.题目表question

| 字段名  | 类型          | 是否为主键 | 是否为空 | 描述   |
| ------- | ------------- | ---------- | -------- | ------ |
| id      | int           | 是         | 否       | 主键ID |
| content | varchar(1000) | 否         | 否       | 题干   |
| sa      | varchar(200)  | 否         | 否       | A选项  |
| sb      | varchar(200)  | 否         | 否       | B选项  |
| sc      | varchar(200)  | 否         | 否       | C选项  |
| sd      | varchar(200)  | 否         | 否       | D选项  |
| answer  | char          | 否         | 否       | 答案   |
| pid     | int           | 否         | 否       | 试卷ID |

### 3.试卷表paper

| 字段名 | 类型        | 是否为主键 | 是否为空 | 描述   |
| ------ | ----------- | ---------- | -------- | ------ |
| id     | int         | 是         | 否       | 主键ID |
| pname  | varchar(20) | 否         | 否       | 试卷名 |

### 4、历史试卷表spaper

| 字段名    | 类型        | 是否为主键 | 是否为空 | 描述     |
| --------- | ----------- | ---------- | -------- | -------- |
| id        | int         | 是         | 否       | 主键ID   |
| papername | varchar(20) | 否         | 否       | 试卷名称 |
| userid    | int         | 否         | 否       | 用户ID   |
| time      | datetime    | 否         | 否       | 做题时间 |
| num       | int         | 否         | 否       | 分数     |
| username  | varchar(20) | 否         | 否       | 用户名   |

### 5.历史试题表squestion

| 字段名   | 类型          | 是否为主键 | 是否为空 | 描述         |
| -------- | ------------- | ---------- | -------- | ------------ |
| id       | int           | 是         | 否       | 主键ID       |
| answer   | char          | 否         | 否       | 正确答案     |
| doanswer | char          | 否         | 否       | 答题者的答案 |
| sa       | varchar(200)  | 否         | 否       | A选项        |
| sb       | varchar(200)  | 否         | 否       | B选项        |
| sc       | varchar(200)  | 否         | 否       | C选项        |
| sd       | varchar(200)  | 否         | 否       | D选项        |
| spid     | int           | 否         | 否       | 历史试卷ID   |
| content  | varchar(1000) | 否         | 否       | 题干         |

### 6.管理员表admin

| 字段名   | 类型        | 是否为主键 | 是否为空 | 描述   |
| -------- | ----------- | ---------- | -------- | ------ |
| id       | int         | 是         | 否       | 主键ID |
| email    | varchar(20) | 否         | 否       | 邮箱   |
| password | varchar(50) | 否         | 否       | 密码   |
| name     | varchar(20) | 否         | 否       | 姓名   |

## 六、知识总结

### 1.前台上传json数组，后台SpringBoot接受方法。

前台先用JSON.stringify()【从一个对象中解析出字符串】，在上传给后台，后台接受字符串后，使用谷歌的Gson.jar从json转换为list。

```java
//json转换为list
Gson gson = new Gson();  
List<Person> persons = gson.fromJson(str, new TypeToken<List<Person>>(){}.getType());

//list转换为json
Gson gson = new Gson();  
List<Person> persons = new ArrayList<Person>();  
String str = gson.toJson(persons);  
```

前台

```javascript
var q = JSON.stringify(questions)
$.ajax({
    type:"post",
    url:'insSquestion',
    data:{questions:q},
    success:function (res) {
        if (res > 0){
            alert('提交成功')
            window.location.href="index"
        }
    }
})
```

后台

```java
@RequestMapping(value="insSquestion")
    public int insSquestion(String questions){
        Gson gson = new Gson();
        List<Squestion> qs = gson.fromJson(questions, new TypeToken<List<Squestion>>() {}.getType());
        return squestionServiceImpl.insSquestions(qs);
    }
```

### 2.时间插件jquery.countdown.js的使用

1.在页面中引入jquery、jquery.countdown.js。

2.可以通过一个有效时间的字符串

```html
<div>12:30</div>
<div>12:30:39</div>
<div>12:30:39.929</div>
```

3.在页面DOM元素加载完毕之后，可以通过`countDown()`方法来初始化该倒计时插件。

```javascript
$('div, h1, time').countDown();      
```

4.事件

`time.elapsed`：倒计时结束时立刻触发该事件。

```javascript
$('#my-countdown').on('time.elapsed', function () {
    // do something...
}); 
```

## 七、不好之处

1.数据库设计的不合理，由于对Spring Data Jpa的连表查询的不熟悉，导致数据库设计出现重复字段。

2.功能单一，只有选择题。
