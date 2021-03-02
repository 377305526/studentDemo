<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
			<script src="assets/js/bootstrap.min.js"></script>
			<script src="assets/js/typeahead-bs2.min.js"></script>
			<script src="assets/js/jquery.dataTables.min.js"></script>
			<script src="assets/js/jquery.dataTables.bootstrap.js"></script>
			<script src="assets/layer/layer.js" type="text/javascript"></script>
			<script src="assets/laydate/laydate.js" type="text/javascript"></script>
			<title>宿舍管理</title>
</head>

<body>
	<div class="margin clearfix">
		<div class="" id="Other_Management">
			<div class="search_style">

				<ul class="search_content clearfix">
					<li><label class="l_f">宿舍号：</label><input name="" type="text"
						class="text_add" placeholder="输入宿舍名称" style="width: 400px"></li>
					<li style="width: 90px;"><button type="button"
							class="btn_search">
							<i class="fa fa-search"></i>查询
						</button></li>
				</ul>
			</div>
			<div class="border clearfix">
				<span class="l_f"> <a href="javascript:ovid()"
					id="member_add" class="btn btn-warning"><i class="fa fa-plus"></i>添加宿舍</a>
					<a href="javascript:ovid()" class="btn btn-danger"><i
						class="fa fa-trash"></i>&nbsp;批量删除</a>
				</span> <span class="r_f">共：<b>2345</b>条
				</span>
			</div>
			<div class="list_style">
				<table class="table table-striped table-bordered table-hover"
					id="sample-table">
					<thead>
						<tr>
							<th width="25"><label><input type="checkbox"
									class="ace"><span class="lbl"></span></label></th>
							<th width="80">宿舍ID</th>
							<th width="80">公寓名</th>
							<th width="80">宿舍号</th>
							<th width="100">床位(人)</th>
							<th width="100">已住(人)</th>
							<th width="80">阳台</th>
							<th width="120">类型（男、女）</th>
							<th width="80">租金</th>
							<th width="220">备注</th>
							<th width="150">操作</th>
						</tr>
					</thead>
					<tbody>


					</tbody>
				</table>
			</div>

		</div>
	</div>


	<!-- 新增 -->
	<div class="add_menber" id="add_menber_style" style="display: none">

		<ul class=" page-content">

			<li><label class="label_name">公寓：</label><span class="add_name">
					<select id="build">
						<option>--请选择公寓--</option>
						<c:forEach items="${builds }" var="build">
							<option value="${build.id }">${build.buildname }</option>
						</c:forEach>
				</select>
			</span>
				<div class="prompt r_f"></div></li>
			<li><label class="label_name">宿&nbsp;&nbsp;舍 &nbsp;号：</label><span
				class="add_name"><input id="room" value="" type="text"
					class="text_add" /></span>
				<div class="prompt r_f"></div></li>
			<li><label class="label_name">床位：</label><span class="add_name">
					<select id="bednum">
						<option>--请选择床位--</option>
						<option>4</option>
						<option>6</option>
				</select>
			</span>
				<div class="prompt r_f"></div></li>
			<li><label class="label_name">阳台：</label><span class="add_name">
					<select id="type">
						<option>--请选择--</option>
						<option>有阳台</option>
						<option>无阳台</option>
				</select>
			</span>
				<div class="prompt r_f"></div></li>
			<li><label class="label_name">类型：</label><span class="add_name">
					<select id="sextype">
						<option>--请选择--</option>
						<option>男</option>
						<option>女</option>
				</select>
			</span>
				<div class="prompt r_f"></div></li>
			<li><label class="label_name">租金：</label><span class="add_name"><input
					id="rent" value="" name="用户名" type="text" class="text_add" /></span>
				<div class="prompt r_f"></div></li>

			<li><label class="label_name">备注信息：</label><span
				class="add_name"> <textarea id="remark"
						style="width: 700px; height: 90px;"></textarea>
			</span>
				<div class="prompt r_f"></div></li>

		</ul>
	</div>

</body>

</html>
<script>
	/*
	 * 页面加载事件
	 */
	$(function() {
		query();
	});

	function query() {
		$.ajax({
			url : "/DM-2/RoomServlet",
			data : {
				op : "query"
			},
			success : function(msg) {
				console.log("测试");
				var list = jQuery.parseJSON(msg);
				for (var i = 0; i < list.length; i++) {
					addTr(list[i][0].id, list[i][1], list[i][0].roomname,
							list[i][0].bednum, list[i][0].peoplenum,
							list[i][0].type, list[i][0].sextype,
							list[i][0].rent, list[i][0].remark);
				}
				tableStyle();
			}
		});

	}

	function addTr(id, buildName, roomname, bednum, peoplenum, type, sextype,
			rent, remark) {
		var tr = '<tr><td><label><input type="checkbox" class="ace"><span class="lbl"></span></label></td>';
		tr += '<td>' + id + '</td><td>' + buildName + '</td><td>' + roomname
				+ '</td><td>' + bednum + '</td><td>' + peoplenum + '</td><td>'
				+ type + '</td><td>' + sextype + '</td>';
		tr += '<td>￥' + rent + '</td><td>' + remark + '</td><td>';
		tr += '<a title="编辑" onclick="member_edit(\'550\','
				+ id
				+ ')" href="javascript:;" class="btn btn-xs btn-info"><i class="fa fa-edit bigger-120"></i></a>';
		tr += '<a title="删除" href="javascript:;" onclick="member_del(this,'
				+ id
				+ ')" class="btn btn-xs btn-warning"><i class="fa fa-trash  bigger-120"></i></a>';
		tr += '</td></tr>';
		$Tr = $(tr);
		$("tbody").append($Tr);
	}
	/**
	 * 表格样式
	 */
	function tableStyle() {
		var oTable1 = $('#sample-table').dataTable({
			"aaSorting" : [ [ 1, "desc" ] ], //默认第几个排序
			"bStateSave" : true, //状态保存
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [ 0, 9, 10 ]
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
	}

	/*公寓-删除*/
	function member_del(obj, id) {
		layer.confirm('确认要删除吗？', function(index) {
			$.ajax({
				url : "/DM-2/RoomServlet",
				data : {
					op : "del",
					id : id
				},
				success : function(msg) {
					if (msg == 'success') {
						$(obj).parents("tr").remove();
						layer.msg('已删除!', {
							icon : 1,
							time : 1000
						});
					} else if (msg == 'error')
						layer.msg('有人入住，删除失败!', {
							icon : 2,
							time : 1000
						});
				}
			});

		});
	}

	/*宿舍-编辑*/
	function member_edit(id, roomid) {
		$.ajax({
			url : "/DM-2/RoomServlet",
			data : {
				op : "queryById",
				id : roomid
			},
			success : function(msg) {

				layer.open({
					type : 1,
					title : '修改宿舍信息',
					maxmin : true,
					shadeClose : false, //点击遮罩关闭层
					area : [ '800px', '450px' ],
					content : $('#add_menber_style'),
					btn : [ '提交', '取消' ],
					yes : function(index, layero) {
						var num = 0;
						var str = "";
						$(".add_menber input[type$='text']").each(
								function(n) {
									if ($(this).val() == "") {

										layer.alert(str += ""
												+ $(this).attr("name")
												+ "不能为空！\r\n", {
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
							layer.alert('添加成功！', {
								title : '提示框',
								icon : 1,
								time : 1000
							});
							layer.close(index);
						}
					}
				});

			}
		});

	}
	/*用户-添加*/
	$('#member_add').on('click', function() {
		layer.open({
			type : 1,
			title : '添加用户',
			maxmin : true,
			shadeClose : true, //点击遮罩关闭层
			area : [ '800px', '450px' ],
			content : $('#add_menber_style'),
			btn : [ '提交', '取消' ],
			yes : function(index, layero) {
				console.log("aaaa");
				var build = $("#build").find("option:selected").val();
				var room = $("#room").val();
				var type = $("#type").find("option:selected").text();
				var bednum = $("#bednum").find("option:selected").text();
				var sextype = $("#sextype").find("option:selected").text();
				var rent = $("#rent").val();
				var remark = $("#remark").val();
				$.ajax({
					url : "/DM-2/RoomServlet",
					data : {
						op : "add",
						buildid : build,
						room : room,
						bednum : bednum,
						type : type,
						sextype : sextype,
						rent : rent,
						remark : remark
					},
					success : function(msg) {
						if (msg == 'success') {
							layer.close(index);
							location.reload();
						}
					}
				});

			}
		});
	});
</script>