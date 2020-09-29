<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>兰州丰收机械制造官网--公司动态</title>
<link href="css/publice.css" type="text/css" rel="stylesheet" />
<link href="css/style.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery1.42.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.2.1.1.js"></script>
<script type="text/javascript" src="js/style.js"></script>
</head>
<body>
	<!--top_bar-->
	<div class="clear"></div>
	<div class="topWrap">
		<div class="top_bar">
			<div class="top_left">欢迎访问丰收机械制造官方网站！</div>

		</div>
	</div>
	<!--nav-->
	<div class="clear"></div>
	<div class="navWrap">
		<div class="logo">
			<a href="#"><img src="img/logo.png"></a>
		</div>
		<div class="nav_bar">
			<a href="index.jsp" class="cur">首页</a> <a href="roomview.jsp">公寓预览</a>
			<a href="announce.jsp">通知公告</a>
			<c:choose>
				<c:when test="${userInfo eq null}">
					<a href="../background/index.html">自助申请</a>
					<a href="../background/index.html">个人中心</a>
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
	<div class="trends_banner">
		<a href="#"><img src="temp/trends_banner.jpg"></a>
	</div>
	<!--content-->
	<div class="clear"></div>
	<div class="contentWrap">
		<div class="content_slide">
			<div class="slide_top">
				<h2>通知公告</h2>
				<p></p>

			</div>
			<div class="slide_bot">
				<ul>
					<li><a href="#"> <img src="img/slide_wx.png">
							<p>官方微信</p>
					</a></li>
					<li><a href="#"> <img src="img/slide_wb.png">
							<p>企业微博</p>
					</a></li>
				</ul>
				<strong>机械制造有限责任公司</strong> <img src="img/slide_ewm.png" class="img" />
			</div>
		</div>
		<div class="content_trends">
			<h2>
				<a href="index.html">首页</a><i>></i><a href="trends.html">通知公告</a>
			</h2>
			<ul id="news">

			</ul>
			<div class="page">
				<a href="#" class="cur">1</a> <a href="#">2</a> <a href="#">3</a> <a
					href="#">4</a>
			</div>
		</div>

	</div>

	<!--foot-->
	<div class="clear"></div>
	<div class="footWrap">
		<div class="footer">
			<div class="foot_l">
				<p>
					<img src="img/foot_icon1.png">138-9361-5566
				</p>
				<p>
					<img src="img/foot_icon2.png">138-9361-5566
				</p>
			</div>
			<div class="foot_r">
				<p class="wz wza">
					<img src="img/foot_icon3.png">甘ICP备456543号-1&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
						href="#">留言反馈</a>|<a href="#" class="linkUs">联系我们</a>
				</p>
				<p class="wz">©2015-2020 机械制造有限责任公司版权所有，并保留所有权利</p>
			</div>
		</div>
	</div>
</body>
</html>
<script>
	$(function() {
		$.ajax({
			url : "/DM-2/AnnounceServlet",
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

		var li = '<li><a href="#">';
		li += '<h3>' + title + '&nbsp;&nbsp;&nbsp;' + time + '</h3>';
		li += '<p>' + content + '</p>';
		li += '</a></li>';
		var $Li = $(li);
		$("#news").append($Li);
	}
</script>

