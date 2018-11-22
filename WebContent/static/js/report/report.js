//$(function() {
//	var dom = document.getElementById("report");
//	var myChart = echarts.init(dom);
//	var basepath = $("input[name=basepath]").val();
//	$.ajax({
//		type: "post",
//		url: basepath + "/reportList",
//		async: true,
//		dataType: "json",
//		success: function(data) {
//			//console.log(data);
//			option = {
//				title: {
//					text: '堆叠区域图'
//				},
//				tooltip: {
//					trigger: 'axis',
//					axisPointer: {
//						type: 'cross',
//						label: {
//							backgroundColor: '#6a7985'
//						}
//					}
//				},
//				toolbox: {
//					feature: {
//						saveAsImage: {}
//					}
//				},
//				grid: {
//					left: '3%',
//					right: '4%',
//					bottom: '3%',
//					containLabel: true
//				},
//				xAxis: [{
//					type: 'category',
//					boundaryGap: false
//				}],
//				yAxis: [{
//					type: 'value'
//				}],
//				series: [{
//					areaStyle: {
//						normal: {}
//					},
//				}]
//			};
//			$.extend(true, option, data);
//
//			myChart.setOption(option);
//		}
//	});
//})

$(function() {
	var dom = document.getElementById("report");
	var myChart = echarts.init(dom);
	var basepath = $("input[name=basepath]").val();
	$.ajax({
		type: "post",
		url: basepath + "/reportList",
		async: true,
		dataType: "json",
		success: function(data) {

			option = {
				title: {
			        text: '订单类型数量统计'
			    },
				tooltip: {
					trigger: 'axis',
					axisPointer: { // 坐标轴指示器，坐标轴触发有效
						type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
					}
				},
				grid: {
					left: '3%',
					right: '4%',
					bottom: '3%',
					containLabel: true
				},
				xAxis: [{
					type: 'category',
				}],
				yAxis: [{
					type: 'value'
				}],
			};

			$.extend(true, option, data);

			myChart.setOption(option);
		}
	});
})