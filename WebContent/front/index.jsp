<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DM宿舍管理</title>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<link href="../front/css/publice.css" type="text/css"
	rel="stylesheet" />
<link href="../front/css/style.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="../front/js/jquery1.42.min.js"></script>
<script type="text/javascript"
	src="../front/js/jquery.SuperSlide.2.1.1.js"></script>
<script type="text/javascript" src="../front/js/style.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.container ul li {
	font-size: 1.3em;
	list-style: circle;
	margin-bottom: 10px;
}

.container ul li span {
	float: right;
}
</style>
</head>
<body>
	<!--top_bar-->
	<div class="clear"></div>
	<div class="topWrap" style="width: 100%;">
		<div class="top_bar" style="width: 100%;">
			<div class="top_left" style="margin-left: 5%;">欢迎访问DM宿舍管理网站！</div>
			<div class="top_right" style="float: right; margin-right: 2%;">
				<p class="icon icon2">
					<a href="../background/index.html" style="color: white;">登录</a>
				</p>
			</div>
		</div>
	</div>
	<!--nav-->
	<div class="clear"></div>
	<div class="navWrap">
		<div class="logo"></div>
		<div class="nav_bar">
			<a href="index.jsp" class="cur">首页</a> <a href="roomview.jsp">公寓预览</a>
			<a href="announce.jsp">通知公告</a>
			<c:choose>
				<c:when test="${userInfo eq null}">
					<a href="../background/index.html">自助申请</a>
					<a href="../background/index.html"> 个人中心</a>
				</c:when>
				<c:otherwise>
					<a href="self.jsp">自助申请</a>
					<a href=userInfo.jsp>个人中心</a>
				</c:otherwise>
			</c:choose>


		</div>
	</div>
	<!--banner-->
	<div class="clear"></div>
	<div class="index_banner">
		<div id="slideBox" class="slideBox">
			<div class="hd">
				<ul>
					<li></li>
					<li></li>
					<li></li>
				</ul>
			</div>
			<div class="bd">
				<ul>
					<li><a href="#" target="_blank"><img
							src="../front/temp/build.jpg" /></a></li>
					<li><a href="#" target="_blank"><img
							src="../front/temp/build.jpg" /></a></li>
					<li><a href="#" target="_blank"><img
							src="../front/temp/build.jpg" /></a></li>
				</ul>
			</div>
		</div>
	</div>
	<!--main-->

	<div class="clear"></div>

	<div class="container"
		style="width: 96%; height: 500px; margin: 50px auto;">
		<div class="col-md-2 column">
			<div></div>
		</div>

		<div class="row clearfix">
			<div class="col-md-5 column"
				style="height: 800px; padding-right: 30px;">
				<span
					style="border-bottom: 1px solid #D4D4D4; display: block; font-size: 1.7em; margin-bottom: 10px;">最新公告&nbsp;<span
					style="line-height: 40px; float: right; font-size: 0.5em;"><a
						style="text-decoration: underline;"
						href="../front/announce.jsp">查看更多</a></span></span>
				<ul id="news">

				</ul>

			</div>
			<div class="col-md-4 column">
				<div style="width: 100%; height: 500px;">
					<iframe width="100%" height="480px" frameborder="0" scrolling="no"
						src="../front/jquery-lunar-calendar/index.html"></iframe>
				</div>
			</div>

		</div>

	</div>
	</div>
	<div class="clear"></div>
	<div class="mainWrap">
		<div class="main_one">
			<h2>公寓环境</h2>
			<div class="picScroll-left">
				<div class="hd">
					<a class="next"></a> <a class="prev"></a>
				</div>
				<div class="bd">
					<ul class="picList">
						<li>
							<div class="pic">
								<a href="#" target="_blank"><img
									src="../front/temp/1.jpg" /></a>
							</div>
						</li>
						<li>
							<div class="pic">
								<a href="#" target="_blank"><img
									src="../front/temp/2.jpg" /></a>
							</div>
						</li>
						<li>
							<div class="pic">
								<a href="#" target="_blank"><img
									src="../front/temp/3.jpg" /></a>
							</div>
						</li>
						<li>
							<div class="pic">
								<a href="#" target="_blank"><img
									src="../front/temp/4.jpg" /></a>
							</div>
						</li>
						<li>
							<div class="pic">
								<a href="#" target="_blank"><img
									src="../front/temp/5.jpg" /></a>
							</div>
						</li>

					</ul>
				</div>
			</div>
		</div>
	</div>
	<!--foot-->
	<div class="clear"></div>
	<div class="footWrap">
		<div class="footer">
			<div class="foot_l">
				<p>
					<img src="../front/img/foot_icon1.png">138-9361-5566
				</p>
				<p>
					<img src="../front/img/foot_icon2.png">138-9361-5566
				</p>
			</div>
			<div class="foot_r">
				<p class="wz wza">
					<img src="../front/img/foot_icon3.png">甘ICP备456543号-1&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="#">留言反馈</a>| <a href="#" class="linkUs">联系我们</a>
				</p>
				<p class="wz">©2019光宗耀组版权所有，并保留所有权利</p>
			</div>
		</div>
	</div>
</body>

</html>
<script>
	$(function() {
		$.ajax({
			url : "../AnnounceServlet",
			data : {
				op : "query"
			},
			success : function(msg) {
				var list = jQuery.parseJSON(msg);
				for (var i = 0; i < list.length; i++) {
					addTr(list[i][0].id, list[i][0].title, list[i][0].content,
							list[i][0].pic, list[i][1], list[i][0].time);
				}
				tableStyle();
			}
		})
	});

	function addTr(id, title, content, img, admin, time) {
		var li = '<li><a href="#">​' + title + '<span>' + time
				+ '</span></a></li>';
		var $Li = $(li);
		$("#news").append($Li);
	}
</script>