$(function() {
	var myChart = echarts.init(document.getElementById('report'));
	common.ajax({
		url : $('#basePath').val() + '/orderReport/count',
		success : function(data) {
			var option = {
			    title: {
			        text: '商户类别订单数'
			    },
			    tooltip: {
			        trigger: 'axis'
			    },
			    grid: {
			        left: '3%',
			        right: '4%',
			        bottom: '3%',
			        containLabel: true
			    },
			    toolbox: {
			        feature: {
			            saveAsImage: {}
			        }
			    },
			    xAxis: {
			        type: 'category',
			        boundaryGap: false
			    },
			    yAxis: {
			        type: 'value'
			    }
			};
			//true表示深拷贝，浅拷贝合并时会覆盖第一层属性下的数据，深拷贝是递归合并
			$.extend(true,option,data);
			myChart.setOption(option);
		},
		type : 'GET'
	});
});