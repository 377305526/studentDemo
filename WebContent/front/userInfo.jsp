<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<title>兰州丰收机械制造官网--简介页</title>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<link href="css/publice.css" type="text/css" rel="stylesheet" />
<link href="css/style.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery1.42.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.2.1.1.js"></script>
<script type="text/javascript" src="js/style.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
p {
	margin-bottom: 0;
}

.update {
	border: 1px solid black;
}
</style>
</head>

<body>
	<!--top_bar-->
	<div class="clear"></div>
	<div class="topWrap">
		<div class="top_bar" style="width: 100%; padding-right: 2%;">
			<div class="top_left">欢迎访问丰收机械制造官方网站！</div>
			<div class="top_right">
				<p class="icon icon3">
					<a style="color: white" href="#">消息（${fn:length(msg) }）</a>
				</p>
				<p class="icon icon4">
					<a style="color: white" href="/DM-2/StudentServlet?op=out">注销</a>
				</p>
			</div>
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
	<div class="trends_banner brief_banner">
		<a href="#"><img src="temp/brief_banner.jpg"></a>
	</div>
	<!--content-->
	<div class="clear"></div>
	<div class="contentWrap">
		<div class="content_slide">
			<div class="slide_top">
				<h2>个人中心</h2>
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
		<div class="content_trends content_brief">
			<h2>
				<a href="index.html">首页</a><i>></i><a href="brief.html">个人中心</a>
			</h2>
			<div class="about_l" style="height: 500px;">
				<p style="margin-bottom: 0; font-size: 1.5em;">
					姓名：<span>${userInfo.name }</span>
				</p>
				<p style="margin-bottom: 0; font-size: 1.5em;">
					身份证号：<span>${userInfo.idcard }</span>
				</p>
				<p style="margin-bottom: 0; font-size: 1.5em;">
					*联系方式：<input id="phone" style="font-size: 1em;" type="tel"
						value="${userInfo.phone }" />
				</p>
				<p style="margin-bottom: 0; font-size: 1.5em;">
					*email：<input id="email" style="font-size: 1em;" type="email"
						value="<c:choose><c:when test="${empty userInfo.email}">待完善</c:when><c:otherwise>${userInfo.email}</c:otherwise></c:choose>" />
				</p>
				<p style="margin-bottom: 0; font-size: 1.5em;">
					家乡：<span>${userInfo.hometown }</span>
				</p>





				<c:choose>
					<c:when test="${userInfo.bedid ==0}">
						<p style="margin-bottom: 0; font-size: 1.5em;">
							宿舍：<span><c:choose>
									<c:when test="${userInfo.bedid ==0 }">
										<span style="font-size: 0.9em">班级：</span>
										<select id="classInfo">
											<option>-班级-</option>
										</select>
										<span style="font-size: 0.9em">公寓：</span>
										<select id="build">
											<option>-公寓-</option>
										</select>
										<span style="font-size: 0.9em">性别：</span>
										<select id="sextype">
											<option>-类型-</option>
											<option>男</option>
											<option>女</option>
										</select>
										<span style="font-size: 0.9em">类型：</span>
										<select id="type">
											<option>-类型-</option>
											<option>有阳台</option>
											<option>无阳台</option>
										</select>

										<span style="font-size: 0.9em">宿舍：</span>
										<select id="room">
											<option>-宿舍-</option>

										</select>
										<span style="font-size: 0.9em">床位：</span>
										<select id="bednum">
											<option value="1">-床位-</option>
										</select>



										<button id="getbtn" style="height: 30px" type="button"
											class="btn btn-info">预分配</button>
									</c:when>
									<c:otherwise>

									</c:otherwise>
								</c:choose></span>
						</p>
					</c:when>
					<c:otherwise>
						<c:if test="${userInfo.statu =='在宿' }">
							<p style="margin-bottom: 0; font-size: 1.5em;">
								所在班级：<span>${classInfo }</span>
							</p>
							<p style="margin-bottom: 0; font-size: 1.5em;">
								所在公寓：<span>${buildInfo }</span>
							</p>
							<p style="margin-bottom: 0; font-size: 1.5em;">
								所在宿舍：<span>${roomInfo }</span>
							</p>
						</c:if>

					</c:otherwise>
				</c:choose>
				<p style="margin-bottom: 0; font-size: 1.5em;">
					*联系地址：<input id="location" style="font-size: 1em;" type="text"
						value="<c:choose><c:when test="${empty userInfo.location}">待完善</c:when><c:otherwise>${userInfo.location}</c:otherwise></c:choose>" />
				</p>
				<p style="margin-bottom: 0; font-size: 1.5em;">
					*公司：<input id="company" style="font-size: 1em;" type="text"
						value="<c:choose><c:when test="${empty userInfo.company}">待完善</c:when><c:otherwise>${userInfo.company}</c:otherwise></c:choose>" />
				</p>
				<p style="margin-bottom: 0; font-size: 1.5em;">
					*职位：<input id="job" style="font-size: 1em;" type="text"
						value="<c:choose><c:when test="${empty userInfo.job}">待完善</c:when><c:otherwise>${userInfo.job}</c:otherwise></c:choose>" />
				</p>
				<p style="margin-bottom: 0; font-size: 1.5em;">&nbsp;</p>
				<p style="margin-bottom: 0; font-size: 1.5em;">
					<button id="updatebtn" type="button" class="btn btn-success">保存修改</button>

				</p>

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
						<img src="img/foot_icon3.png">甘ICP备456543号-1&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="#">留言反馈</a>| <a href="#" class="linkUs">联系我们</a>
					</p>
					<p class="wz">©2015-2020 机械制造有限责任公司版权所有，并保留所有权利</p>
				</div>
			</div>
		</div>
</body>
<script>
	$(function() {
		var build;
		var type;
		var sextype;
		var room;
		var bed;
		var classid;
		$.ajax({
			url : "/DM-2/BuildServlet",
			data : {
				op : "queryAll"
			},
			success : function(msg) {
				var list = jQuery.parseJSON(msg);
				for (var i = 0; i < list.length; i++) {
					var $option = $("<option value="+list[i][0].id+">"
							+ list[i][0].buildname + "</option>")
					$("#build").append($option)
				}
			}
		});

		$.ajax({
			url : "/DM-2/ClassServlet",
			data : {
				op : "query"
			},
			success : function(msg) {
				var list = jQuery.parseJSON(msg);
				for (var i = 0; i < list.length; i++) {
					var $option = $("<option value="+list[i].id+">"
							+ list[i].classname + "</option>")
					$("#classInfo").append($option)
				}
			}
		});

		$("#type").change(
				function() {
					type = $(this).children('option:selected').text();
					$("#room").empty();
					$("bednum").empty();
					$.ajax({
						url : "/DM-2/RoomServlet",
						data : {
							op : "query2",
							build : build,
							type : type,
							sex : sextype
						},
						success : function(msg) {
							var list = jQuery.parseJSON(msg);
							var $option = $("<option>宿舍</option>");
							$("#room").append($option)
							for (var i = 0; i < list.length; i++) {
								var $option = $("<option value="+list[i].id+">"
										+ list[i].roomname + "</option>")
								$("#room").append($option)
							}

						}
					});
				});
		$("#build").change(function() {
			build = $(this).children('option:selected').val();
			$("#room").empty();
			$("#bednum").empty();
		});
		$("#sextype").change(function() {
			sextype = $(this).children('option:selected').text();
			$("#room").empty();
			$("bednum").empty();

		});
		$("#bednum").change(function() {
			bed = $(this).children('option:selected').val();
		});
		$("#classInfo").change(function() {
			classid = $(this).children('option:selected').val();
		});
		$("#room").change(
				function() {
					room = $(this).children('option:selected').val();
					$("bednum").empty();
					$.ajax({
						url : "/DM-2/BedServlet",
						data : {
							op : "queryBeds",
							room : room
						},
						success : function(msg) {
							var list = jQuery.parseJSON(msg);
							if (list.length == 0) {
								var $option = $("<option>无</option>");
								$("#bednum").append($option)
							}
							for (var i = 0; i < list.length; i++) {
								var $option = $("<option value="+list[i].id+">"
										+ list[i].bedno + "</option>")
								$("#bednum").append($option)
							}

						}
					})
				});

		$("#getbtn").click(function() {
			$.ajax({
				url : "/DM-2/StudentServlet",
				data : {
					op : "tobed",
					bed : bed,
					classid : classid
				},
				success : function(msg) {
					alert(msg);
					location.href = "/DM-2/background/index.html";
				}
			});
		});

		$("#updatebtn").click(
				function() {
					var phone = $("#phone").val();
					var email = $("#email").val();
					var location = $("#location").val();
					var company = $("#company").val();
					var job = $("#job").val();
					console.log(phone + " " + email + " " + location + " "
							+ company + " " + job);
					$.ajax({
						url : "/DM-2/StudentServlet",
						data : {
							op : "updateInfo",
							phone : phone,
							email : email,
							location : location,
							company : company,
							job : job
						},
						success : function(msg) {
							alert(msg);
						}
					});
				});
	});
</script>

</html>