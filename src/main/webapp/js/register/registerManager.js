 var myChart;
 
$(function(){
	 $(".query").find('.find').click(function(){
		 var stime =  $('.stime').val();
		 var etime =  $('.etime').val();
		 $.ajax({
				type : "POST",
				url : "register/findRegisterCountAndFee.do",
				async:false,
				data : {
					'stime':stime,
					'etime':etime
				},
				dataType : 'json',
				success : function(data) {
					if (data.status == "0000") {
						var departmentList4 = Handlebars.compile($("#departmentList4").html());
						$('#count_list').html(departmentList4(data.list));
						 showEcharts();
						
						 myChart.setOption({
							    series : [
							        {
							            data:data.data
							        }
							    ]
							})
					}else{
						alert('获取失败');
					}  
				},
				error : function() {
					alert("error");
				}
			});
	     });
	 showEcharts();
	 showEchartsLine();
 });
 
 function showEcharts(){
   myChart = echarts.init(document.getElementById('main'));
     // 绘制图表
   myChart.setOption({
    series : [
        {
            name: '挂号统计',
            type: 'pie',
            radius: '55%',
            data:[
            ]
        }
    ]
})
 }
 
 function showEchartsLine(){
	 var time;
	 var count;
	 $.ajax({
			type : "POST",
			url : "register/findRegisterCount.do",
			async:false,
			data : {
				 
			},
			dataType : 'json',
			success : function(data) {
				if (data.status == "0000") {
					 time = data.time;
					 count = data.count;
				}else{
					alert('获取失败');
				}  
			},
			error : function() {
				alert("error");
			}
		});
//   // 基于准备好的dom，初始化echarts实例
    myChart = echarts.init(document.getElementById('main'));
	
	myChart.setOption(option = {
	  title: {
	      text: '挂号量统计'
	  },
	  tooltip: {
	      trigger: 'axis'
	  },
	  xAxis: {
	      data: time
	  },
	  yAxis: {
	      splitLine: {
	          show: false
	      }
	  },
	  toolbox: {
	      left: 'center',
	      feature: {
	          dataZoom: {
	              yAxisIndex: 'none'
	          },
	          restore: {},
	          saveAsImage: {}
	      }
	  },
	  dataZoom: [{
	      startValue: '2016-08-01'
	  }, {
	      type: 'inside'
	  }],
	  
	  series: {
	      name: '挂号量统计',
	      type: 'line',
	      data:  count,
	      markLine: {
	          silent: true,
	          data: [{
	              yAxis: 50
	          }, {
	              yAxis: 100
	          }, {
	              yAxis: 150
	          }, {
	              yAxis: 200
	          }, {
	              yAxis: 300
	          }]
	      }
	  }
	});
	 }