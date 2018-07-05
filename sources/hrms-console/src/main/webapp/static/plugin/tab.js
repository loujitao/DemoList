$(function() {

	$("#changePageSize").val(pageSize);

	/**
	 * 页码设置
	 */
	$("#changePageSize").change(function() {
		var pageSize = $(this).val(); // 获取当前选中的值
		$("#pagesize").val(pageSize);
		$("#queryForm").submit();

	});

	/**
	 * 全选
	 */
	$("#checkAll").click(function() {
		var status = $(this).attr("checked");
		if (status == "checked") {
			$(".choose").each(function() {
				$(this).attr("checked", true);
			});
		} else {
			$(".choose").each(function() {
				$(this).attr("checked", false);
			});
		}
	});

	/**
	 * 删除所有
	 */
	$("#deleteAll").click(function() {
		var url = $(this).attr("url");
		var ids = [];// 声明数组

		$(".choose").each(function() {
			var status = $(this).attr("checked");
			var id = $(this).val();
			if (status == "checked") {
				ids.push(id);
			}
		});
		if (ids.length > 0) {
			var flag = window.confirm("你确定要删除这些数据么？");
			if (flag) {
				window.location.href = url + "&ids=" + ids.toString();
			}
		}

	});
	/*
	 * 
	 * 
	 * 删除单个
	 */
	$(".delete").click(function() {
		var url = $(this).attr("url");
		var id = $(this).attr("id");
		var flag = window.confirm("你确定要删除这条数据么？");
		if (flag) {
			window.location.href = url + "&id=" + id;
		}
	});

	/**
	 * 修改 2.修改之前要先查询 findbyid modifybyid 3.修改只能修改一条数据 批修改
	 */
	$("#modify").click(function() {
		var url = $(this).attr("url");
		var ids = [];// 声明数组
		$(".choose").each(function() {
			var status = $(this).attr("checked");
			var id = $(this).val();
			if (status == "checked") {
				ids.push(id);
			}
		});
		if (ids.length == 1) {
			window.location.href = url + "&id=" + ids.toString();
		} else {
			window.alert("请选择一行进行修改!");
		}
	});

	/**
	 * 选中行选中该复选框
	 */
	$(".row").click(function() {
		var checkbox = $(this).find("input[type='checkbox']");
		console.log(checkbox);
		var status = checkbox.attr("checked");
		if (status == "checked") {
			checkbox.attr("checked", false);
		} else {
			checkbox.attr("checked", true);
		}
	});

	/**
	 * 首页
	 */
	$("#first").click(function() {
		$("#pageindex").val(1);
		$("#queryForm").submit();
	})

	/**
	 * 下一页
	 */
	$("#next").click(function() {
		var pageindex = $("#pageindex").val();
		pageindex = parseInt(pageindex) + 1;
		$("#pageindex").val(pageindex);
		$("#queryForm").submit();
	})

	/**
	 * 上一页
	 */
	$("#last").click(function() {
		var pageindex = $("#pageindex").val();
		pageindex = parseInt(pageindex) - 1;
		$("#pageindex").val(pageindex);
		$("#queryForm").submit();
	})

	/**
	 * 尾页
	 */
	$("#end").click(function() {
		var pagesum = $("#pagesum").val();
		$("#pageindex").val(pagesum);
		$("#queryForm").submit();
	})

	/**
	 * 转到
	 */
	$("#go").click(function() {
		var pageIndex = $("#page").val();
		$("#pageindex").val(pageIndex);
		$("#queryForm").submit();
	});

	/**
	 * 查询按钮
	 */
	$("#search").click(function() {
		console.log("search running....")
		$("#queryForm").submit();
	})

});