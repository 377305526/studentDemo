<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
	String path = request.getRequestURI();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="css/style.css" />
<link href="assets/css/codemirror.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/ace.min.css" />
<link rel="stylesheet" href="font/css/font-awesome.min.css" />
<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
<script src="js/jquery-1.9.1.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/typeahead-bs2.min.js"></script>
<script src="assets/layer/layer.js" type="text/javascript"></script>
<script src="assets/laydate/laydate.js" type="text/javascript"></script>
<title>交易金额</title>
</head>

<body>
	<div class="margin clearfix">
		<div class="detailed_style clearfix">
			<em class="type"></em>
			<div class="shop_logo">
				<img src="images/detailnoimg.png" />
			</div>
			<ul class="shop_content clearfix">
				<li><label style="font-weight: bold;" class="label_name">申请类型：</label><span
					class="info">${detail.type }</span></li>
				<li><label style="font-weight: bold;" class="label_name">申请人姓名：</label><span
					class="info">${applicant.name }</span></li>
				<li><label style="font-weight: bold;" class="label_name">所在宿舍：</label><span
					class="info">${room.roomname }</span></li>
				<li><label style="font-weight: bold;" class="label_name">所在班级：</label><span
					class="info">${classInfo.classname }</span></li>
				<li><label style="font-weight: bold;" class="label_name">联系电话：</label><span
					class="info">${applicant.phone }</span></li>
				<li><label style="font-weight: bold;" class="label_name">申请时间：</label><span
					class="info">${detail.time }</span></li>
				<li><label style="font-weight: bold;" class="label_name">审核时间：</label><span
					class="info">${detail.approvalTime }</span></li>
				<li><label style="font-weight: bold;" class="label_name">状&nbsp;&nbsp;&nbsp;&nbsp;态：</label><span
					class="info">${detail.statu }</span></li>
				<li><label style="font-weight: bold;" class="label_name">备注信息：</label><span
					class="info">${detail.remark }</span></li>
			</ul>
		</div>
		<div class="Store_Introduction">
			<div style="font-weight: bold;" class="title_name">申请描述</div>
			<div class="info">${detail.content }</div>
		</div>

		<div class="At_button">
			<button onclick="return_close();" class="btn btn-default radius"
				type="button">返回上一步</button>
		</div>
	</div>
</body>
</html>
<script>
	//返回操作
	function return_close() {
		location.href = "historicalreview.html";
		parent.$('#parentIframe').css("display", "none");
		parent.$('.Current_page').css({
			"color" : "#333333"
		});

	}
</script>

