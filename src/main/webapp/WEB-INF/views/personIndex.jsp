<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta charset="utf-8">
<title>主页</title>
<link rel="stylesheet" href="css/index.css">
</head>
<style>
body{
background-color:g }
</style>
<body>
<header>
  <nav id="nav">
    <ul class="left">
      	<li><a href='/'>首页</a></li>
      	
      	<li><a href='/a/jishu/'>技术探讨</a></li>
      	
      	<li><a href='/a/HTML/'>碎言碎语</a></li>
      	
      	<li><a href='/a/msh/'>慢生活</a></li>
      	
      	<li><a href='/a/sysy/'>我的博客</a></li>
      	
    </ul>
    <ul class="right">
    	<li><a href='register.jsp'>注册</a></li>
      	
      	<li><a href='login.jsp'>登录</a></li>
    </ul>
  </nav>
</header>

<!--header end-->
<div id="mainbody">
  <div class="info">
  <figure><img src="images/1-15052R305270-L.jpg"  alt="渡人如渡己，渡已，亦是渡">
  </figure>

    <div class="card">
      <h1>我的名片</h1>
      <p>网名：帅比</p>
      <p>职业：Web后端工程师、网页设计</p>
      <p>电话：186225*****</p>
      <p>Email：16431001@qq.com</p>
      <img src="images/artwork.png">
      <ul class="linkmore">
        <li><a href="javascript:alert('糟糕，没有链接。');" class="talk" title="给我留言"></a></li>
        <li><a href="javascript:alert('糟糕，没有链接。');" class="address" title="联系地址"></a></li>
        <li><a href="javascript:alert('糟糕，没有链接。');" class="email" title="给我写信"></a></li>
        <li><a href="javascript:alert('糟糕，没有链接。');" class="photos" title="生活照片"></a></li>
        <li><a href="javascript:alert('糟糕，没有链接。');" class="heart" title="关注我"></a></li>
      </ul>
    </div>
  </div>
  <!--info end-->
  <div class="blank"></div>
  <div class="blogs">
    <ul class="bloglist">
   	 <li>
        <div class="arrow_box">
          <div class="ti"></div>
          <!--三角形-->
          <div class="ci"></div>
          <!--圆形-->
          <h2 class="title"><a href="/a/jishu/1.html" target="_blank">响应式web网站设计制作方法</a></h2>
          <ul class="textinfo">
            <a href="/a/jishu/1.html"><img src="images/1-15052R224460-L.png"></a>
            <p>在研究响应式的时候，记录了一些感想，分享出来，抛砖引玉，希望可以和大家一起讨论。总结下来，响应式比之前想象的要复杂得多。 1. ie9以下（不包括ie9）采用ie条件注释，...</p>
          </ul>
          <ul class="details">
            <li class="likes"><a href="#">0</a></li>
            <li class="comments"><a href="#">492</a></li>
            <li class="icon-time"><a href="#">2016-03-12</a></li>
          </ul>
        </div>
        <!--arrow_box end--> 
      </li>
<li>
        <div class="arrow_box">
          <div class="ti"></div>
          <!--三角形-->
          <div class="ci"></div>
          <!--圆形-->
          <h2 class="title"><a href="/a/HTML/9.html" target="_blank">HTML5技术将推动移动浏览器变革</a></h2>
          <ul class="textinfo">
            <a href="/a/HTML/9.html"><img src="images/1-15052R224460-L.png"></a>
            <p>在网络条件日渐成熟的今天，横跨智能手机、平板电脑以及PC终端的HTML5有其无可替代的优势。业内人士分析称，HTML5将为移动互联网带来技术革命，推动移动浏览器变革。 HTML5...</p>
          </ul>
          <ul class="details">
            <li class="likes"><a href="#">0</a></li>
            <li class="comments"><a href="#">474</a></li>
            <li class="icon-time"><a href="#">2015-05-29</a></li>
          </ul>
        </div>
        <!--arrow_box end--> 
      </li>
<li>
        <div class="arrow_box">
          <div class="ti"></div>
          <!--三角形-->
          <div class="ci"></div>
          <!--圆形-->
          <h2 class="title"><a href="/a/HTML/8.html" target="_blank">使用CSS3制作文字、图片倒影</a></h2>
          <ul class="textinfo">
            <a href="/a/HTML/8.html"><img src="images/1-15052R224460-L.png"></a>
            <p>CSS3制作文字、图片倒影需要涉及到使用CSS3.0新属性之box-reflect。box-reflect属性目前仅在Chrome、Safari和Opera浏览器下支持，但这并不影响我们来学习这个属性的应用。 ...</p>
          </ul>
          <ul class="details">
            <li class="likes"><a href="#">0</a></li>
            <li class="comments"><a href="#">424</a></li>
            <li class="icon-time"><a href="#">2015-05-29</a></li>
          </ul>
        </div>
        <!--arrow_box end--> 
      </li>
      <li>
        <div class="arrow_box">
          <div class="ti"></div>
          <!--三角形-->
          <div class="ci"></div>
          <!--圆形-->
          <h2 class="title"><a href="/a/msh/7.html" target="_blank">两只蜗牛艰难又浪漫的一吻</a></h2>
          <ul class="textinfo">
            <a href="/a/msh/7.html"><img src="images/1-15052R224460-L.png"></a>
            <p>这是国外一摄影师拍摄到的，看到这一幕，还真有爱！于是想查查蜗牛是哪科的，百度科普了一下，原来蜗牛是蜗牛是陆生贝壳类软体动物，关键是蜗牛雌雄同体，异体交配，雌雄均...</p>
          </ul>
          <ul class="details">
            <li class="likes"><a href="#">0</a></li>
            <li class="comments"><a href="#">458</a></li>
            <li class="icon-time"><a href="#">2015-05-29</a></li>
          </ul>
        </div>
        <!--arrow_box end--> 
      </li>
  <li>
        <div class="arrow_box">
          <div class="ti"></div>
          <!--三角形-->
          <div class="ci"></div>
          <!--圆形-->
          <h2 class="title"><a href="/a/msh/7.html" target="_blank">两只蜗牛艰难又浪漫的一吻</a></h2>
          <ul class="textinfo">
            <a href="/a/msh/7.html"><img src="images/1-15052R224460-L.png"></a>
            <p>这是国外一摄影师拍摄到的，看到这一幕，还真有爱！于是想查查蜗牛是哪科的，百度科普了一下，原来蜗牛是蜗牛是陆生贝壳类软体动物，关键是蜗牛雌雄同体，异体交配，雌雄均...</p>
          </ul>
          <ul class="details">
            <li class="likes"><a href="#">0</a></li>
            <li class="comments"><a href="#">458</a></li>
            <li class="icon-time"><a href="#">2015-05-29</a></li>
          </ul>
        </div>
        <!--arrow_box end--> 
      </li>
  <li>
        <div class="arrow_box">
          <div class="ti"></div>
          <!--三角形-->
          <div class="ci"></div>
          <!--圆形-->
          <h2 class="title"><a href="/a/msh/7.html" target="_blank">两只蜗牛艰难又浪漫的一吻</a></h2>
          <ul class="textinfo">
            <a href="/a/msh/7.html"><img src="images/1-15052R224460-L.png"></a>
            <p>这是国外一摄影师拍摄到的，看到这一幕，还真有爱！于是想查查蜗牛是哪科的，百度科普了一下，原来蜗牛是蜗牛是陆生贝壳类软体动物，关键是蜗牛雌雄同体，异体交配，雌雄均...</p>
          </ul>
          <ul class="details">
            <li class="likes"><a href="#">0</a></li>
            <li class="comments"><a href="#">458</a></li>
            <li class="icon-time"><a href="#">2015-05-29</a></li>
          </ul>
        </div>
        <!--arrow_box end--> 
      </li>
 
    </ul>
    <!--bloglist end-->
    <aside>
      <div class="search">
        <form class="searchform" name="formsearch" action="/plus/search.php">
        <input type="hidden" name="kwtype" value="0" />
        <input name="q" type="text" id="search-keyword" value="输入关键词后按回车..." onfocus="if(this.value=='输入关键词后按回车...'){this.value='';}"  onblur="if(this.value==''){this.value='输入关键词后按回车...';}" />
        </form>
      </div>
	 <div class="viny">
        <dl>
          <dt class="art"><img src="images/1-15052R224460-L.png" alt="专辑"></dt>
          <dd class="icon-song"><span></span>输了你赢了世界又如何</dd>
          <dd class="icon-artist"><span></span>歌手：A-Lin</dd>
          <dd class="icon-album"><span></span>所属专辑：《A-Lin》</dd>
          <dd class="icon-like"><span></span><a href="javascript:;">喜欢</a></dd>
          <dd class="music">
            <audio src="http://cdjsqwx.com/skin/images/A-Lin.mp3" controls></audio>
         </dd>
          <!--也可以添加loop属性 音频加载到末尾时，会重新播放-->
        </dl>
      </div>
      <div class="tuijian">
        <h2>推荐文章</h2>
        <ol>
        <li><span><strong>1</strong></span><a href="/a/jishu/1.html">响应式web网站设计制作方法</a></li>
<li><span><strong>2</strong></span><a href="/a/HTML/9.html">HTML5技术将推动移动浏览器变革</a></li>
<li><span><strong>3</strong></span><a href="/a/HTML/8.html">使用CSS3制作文字、图片倒影</a></li>
<li><span><strong>4</strong></span><a href="/a/msh/7.html">两只蜗牛艰难又浪漫的一吻</a></li>
<li><span><strong>5</strong></span><a href="/a/msh/6.html">犯错了怎么办？</a></li>
<li><span><strong>6</strong></span><a href="/a/msh/5.html">女程序员职业生涯该如何发展？</a></li>
<li><span><strong>7</strong></span><a href="/a/jishu/3.html">即便是坑，我也想要拉你入伙！</a></li>
<li><span><strong>8</strong></span><a href="/a/sysy/4.html">渡人如渡己，渡已，亦是渡</a></li>
<li><span><strong>9</strong></span><a href="/a/msh/2.html">【孕期日记】生活本该如此</a></li>

        </ol>
      </div>
      <div class="toppic">
        <h2>图文并茂</h2>
        <ul>
          <li style="margin:10px 0;"><a href="/a/jishu/1.html"><img src="/uploads/allimg/150528/1-15052R224460-L.png">响应式web网站设计制作方法...
            <p>查看详细</p>
            </a></li>
<li style="margin:10px 0;"><a href="/a/HTML/9.html"><img src="/uploads/allimg/150529/1-15052Z014400-L.jpg">HTML5技术将推动移动浏览器变革...
            <p>查看详细</p>
            </a></li>
<li style="margin:10px 0;"><a href="/a/HTML/8.html"><img src="/uploads/allimg/150529/00135Q956-0-lp.jpg">使用CSS3制作文字、图片倒影...
            <p>查看详细</p>
            </a></li>
<li style="margin:10px 0;"><a href="/a/msh/7.html"><img src="/uploads/allimg/150529/1-15052Z009560-L.png">两只蜗牛艰难又浪漫的一吻...
            <p>查看详细</p>
            </a></li>
<li style="margin:10px 0;"><a href="/a/msh/6.html"><img src="/uploads/allimg/150529/1-15052Z00T50-L.jpg">犯错了怎么办？...
            <p>查看详细</p>
            </a></li>

        </ul>
      </div>
      <div class="clicks">
        <h2>热门点击</h2>
        <ol>
        <li><span><a href='/a/jishu/'>技术探讨</a></span><a href="/a/jishu/1.html">响应式web网站设计制作方法</a></li>
<li><span><a href='/a/msh/'>慢生活</a></span><a href="/a/msh/2.html">【孕期日记】生活本该如此</a></li>
<li><span><a href='/a/HTML/'>HTML5 / CSS3</a></span><a href="/a/HTML/9.html">HTML5技术将推动移动浏览器变革</a></li>
<li><span><a href='/a/msh/'>慢生活</a></span><a href="/a/msh/7.html">两只蜗牛艰难又浪漫的一吻</a></li>
<li><span><a href='/a/msh/'>慢生活</a></span><a href="/a/msh/6.html">犯错了怎么办？</a></li>
<li><span><a href='/a/HTML/'>HTML5 / CSS3</a></span><a href="/a/HTML/8.html">使用CSS3制作文字、图片倒影</a></li>
<li><span><a href='/a/sysy/'>碎言碎语</a></span><a href="/a/sysy/4.html">渡人如渡己，渡已，亦是渡</a></li>
<li><span><a href='/a/msh/'>慢生活</a></span><a href="/a/msh/5.html">女程序员职业生涯该如何发展？</a></li>
<li><span><a href='/a/jishu/'>技术探讨</a></span><a href="/a/jishu/3.html">即便是坑，我也想要拉你入伙！</a></li>

        </ol>
      </div>
    </aside>
  </div>
  <!--blogs end--> 
</div>
<!--mainbody end-->

<footer>
  <div class="footer-mid"></div>
  <div class="footer-bottom">
  </div>
</footer>
</body>
</html>