<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
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
<script src="assets/layer/layer.js" type="text/javascript"></script>
<script src="assets/laydate/laydate.js" type="text/javascript"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/typeahead-bs2.min.js"></script>
<script src="assets/js/jquery.dataTables.min.js"></script>
<script src="assets/js/jquery.dataTables.bootstrap.js"></script>

<title>个人信息管理</title>
</head>

<body>
	<div class="clearfix">
		<div class="admin_info_style">
			<div class="admin_modify_style" id="Personal">
				<div class="type_title">个人信息</div>
				<div class="xinxi">
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">用户名： </label>
						<div class="col-sm-9">
							<input id="name" type="text" name="用户名" id="website-title"
								value="${adminInfo.name }" class="col-xs-7 text_info"
								disabled="disabled"> &nbsp;&nbsp;&nbsp;<a
								href="javascript:void()" onclick="change_Password()"
								class="btn btn-warning btn-xs">修改密码</a>
						</div>

					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">权限： </label>
						<div class="col-sm-9">
							<span>${userPermission.name }</span>
						</div>
					</div>
					<div class="form-group"></div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"
							for="form-field-1">移动电话： </label>
						<div class="col-sm-9">
							<input id="tel" type="text" name="移动电话" id="website-title"
								value="${adminInfo.phone }" class="col-xs-7 text_info"
								disabled="disabled">
						</div>
					</div>



					<div class="Button_operation clearfix">
						<button onclick="modify();" class="btn btn-danger radius"
							type="submit">修改信息</button>
						<button onclick="save_info();" class="btn btn-success radius"
							type="button">保存修改</button>
					</div>
				</div>
			</div>
			<div class="recording_style">
				<div class="type_title">登录记录</div>
				<div class="recording_list">
					<table
						class="table table-border table-bordered table-bg table-hover table-sort"
						id="sample-table">
						<thead>
							<tr class="text-c">

								<th width="120">客户端IP</th>
								<th width="150">时间</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>61.233.7.80</td>
								<td>2014-6-11 11:11:42</td>
							</tr>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!--修改密码样式-->
	<div class="change_Pass_style" id="change_Pass">
		<ul class="xg_style">
			<li><label class="label_name">原&nbsp;&nbsp;密&nbsp;码</label><input
				id="oldpwd" name="原密码" type="password" class="" id="password"></li>
			<li><label class="label_name">新&nbsp;&nbsp;密&nbsp;码</label><input
				name="新密码" type="password" class="" id="Nes_pas"></li>
			<li><label class="label_name">确认密码</label><input id="pwd"
				name="再次确认密码" type="password" class="" id="c_mew_pas"></li>

		</ul>
		<!--       <div class="center"> <button class="btn btn-primary" type="button" id="submit">确认修改</button></div>-->
	</div>
</body>
</html>
<script>
	$(function() {
		$("#oldpwd").blur(function() {
			$.ajax({
				url : "/DM-2/AdminServlet",
				data : {
					phone : $("#tel").val(),
					code : $("#pwd").val(),
					op : "login"
				},
				success : function(msg) {
					if (mag == "error") {
						alert("密码错误");
					}

				}
			})
		})
	});
	//按钮点击事件
	function modify() {
		$('.text_info').attr("disabled", false);
		$('.text_info').addClass("add");
		$('#Personal').find('.xinxi').addClass("hover");
		$('#Personal').find('.btn-success').css({
			'display' : 'block'
		});
	};
	function save_info() {
		var num = 0;
		var str = "";
		$(".xinxi input[type$='text']").each(function(n) {
			if ($(this).val() == "") {

				layer.alert(str += "" + $(this).attr("name") + "不能为空！\r\n", {
					title : '提示框',
					icon : 0,
				});
				num++;
				return false;
			}
		});
		if (num > 0) {
			return false;
		} else {
			var name = $("#name").val();
			var tel = $("#tel").val();
			$.ajax({
				url : "/DM-2/AdminServlet",
				data : {
					op : "updateInfo",
					name : name,
					tel : tel
				},
				success : function(msg) {
					if ("success" == msg) {
						layer.alert('修改成功！', {
							title : '提示框',
							icon : 1,
						});
						$('#Personal').find('.xinxi').removeClass("hover");
						$('#Personal').find('.text_info').removeClass("add")
								.attr("disabled", true);
						$('#Personal').find('.btn-success').css({
							'display' : 'none'
						});
						layer.close(index);
					}

				}
			})

		}
	};
	//初始化宽度、高度    
	$(".admin_modify_style").height($(window).height());
	$(".recording_style").width($(window).width() - 400);
	//当文档窗口发生改变时 触发  
	$(window).resize(function() {
		$(".admin_modify_style").height($(window).height());
		$(".recording_style").width($(window).width() - 400);
	});
	//修改密码
	function change_Password() {
		layer.open({
			type : 1,
			title : '修改密码',
			area : [ '300px', '300px' ],
			shadeClose : true,
			content : $('#change_Pass'),
			btn : [ '确认修改' ],
			yes : function(index, layero) {
				if ($("#password").val() == "") {
					layer.alert('原密码不能为空!', {
						title : '提示框',
						icon : 0,

					});
					return false;
				}
				if ($("#Nes_pas").val() == "") {
					layer.alert('新密码不能为空!', {
						title : '提示框',
						icon : 0,

					});
					return false;
				}

				if ($("#c_mew_pas").val() == "") {
					layer.alert('确认新密码不能为空!', {
						title : '提示框',
						icon : 0,

					});
					return false;
				}
				if (!$("#c_mew_pas").val
						|| $("#c_mew_pas").val() != $("#Nes_pas").val()) {
					layer.alert('密码不一致!', {
						title : '提示框',
						icon : 0,

					});
					return false;
				} else {
					var pwd = $("#pwd").val();
					$.ajax({
						url : "/DM-2/AdminServlet",
						data : {
							op : "updatepwd",
							pwd : pwd
						},
						success : function(msg) {
							if ("success" == msg) {
								layer.alert('修改成功！', {
									title : '提示框',
									icon : 1,
								});
								layer.close(index);
							}

						}
					})

				}
			}
		});
	}
</script>
<script>
	jQuery(function($) {
		var oTable1 = $('#sample-table').dataTable({
			"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
			"bStateSave" : true,//状态保存
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [ 0 ]
			} // 制定列不参与排序
			]
		});

		$('table th input:checkbox').on(
				'click',
				function() {
					var that = this;
					$(this).closest('table').find(
							'tr > td:first-child input:checkbox').each(
							function() {
								this.checked = that.checked;
								$(this).closest('tr').toggleClass('selected');
							});

				});
	});
</script>
