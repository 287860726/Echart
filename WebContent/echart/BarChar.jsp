<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- 引入 ECharts 文件 -->
<script src="<%=basePath%>/js/echarts.min.js"></script>
<script src="<%=basePath%>/js/jquery-2.1.3.min.js"></script>
<title>柱状图</title>
</head>
<body>
	<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	<div id="barchar" style="width: 600px; height: 400px;"></div>
	<script type="text/javascript">
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('barchar'));


		// 显示标题，图例和空的坐标轴
		myChart.setOption(
		{
			title :
			{
				text : '类型数量表'
			},
			tooltip :
			{},
			legend :
			{
				data :
				[ '数量' ]
			},
			xAxis :
			{
				data :
				[]
			},
			yAxis :
			{},
			series :
			[
			{
				name : '数量',
				type : 'bar',
				data :
				[]
			} ]
		});

		$.ajax(
		{
			type : 'GET',
			async : false,
			url : '/Echarts/JsonDataSvl',
			data :
			{

			},
			dataType : 'json',
			success : function(mag)
			{
				// 填入数据
				console.info(mag)
				myChart.setOption(
				{
					xAxis :
					{
						data : mag.leixin
					},
					series :
					[
					{
						// 根据名字对应到相应的系列
						name : '数量',
						data : mag.num
					} ]
				});

			},
			error : function(msg)
			{

			}
		})

		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	</script>
</body>
</html>