<template>
<div class="content">

<div class="text main-text">欢迎使用 {{this.$project.projectName}}</div>
<div style="text-align: center;width: 900px;">
	<div id="statistic" style="width:100%;height:600px;"></div>
</div>

</div>
</template>
<script>
import router from '@/router/router-static'
export default {
  mounted(){
    this.init();
  },
  methods:{
    init(){
        if(this.$storage.get('Token')){
        this.$http({
            url: `${this.$storage.get('sessionTable')}/session`,
            method: "get"
        }).then(({ data }) => {
            if (data && data.code != 0) {
            router.push({ name: 'login' })
            }
        });
        }else{
            router.push({ name: 'login' })
        }
		
		////饼状图
		this.$nextTick(()=>{
		    var statistic = this.$echarts.init(document.getElementById("statistic"),'macarons');
		    let params = {
		        tableName: "fangyiwuzi",
		        groupColumn: "fangyiwuzi_types",
		    }
		    this.$http({
		        url: "newSelectGroupCount",
		        method: "get",
		        params: params
		    }).then(({data}) => {
		        if (data && data.code === 0) {
		            let res = data.data;
		            let xAxis = [];
		            let yAxis = [];
		            let pArray = []
		            var option = {};
		            for(let i=0;i<res.length;i++){
		                xAxis.push(res[i].name);
		                yAxis.push(res[i].value);
		                pArray.push({
		                    value: res[i].value,
		                    name: res[i].name
		                })
		                option = {
		                    title: {
		                        text: '物资数量统计',
		                        left: 'center'
		                    },
		                    tooltip: {
		                        trigger: 'item',
		                        formatter: '{b} : {c} ({d}%)'
		                    },
		                    series: [
		                        {
		                            type: 'pie',
		                            radius: '55%',
		                            center: ['50%', '60%'],
		                            data: pArray,
		                            emphasis: {
		                                itemStyle: {
		                                    shadowBlur: 10,
		                                    shadowOffsetX: 0,
		                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		                                }
		                            }
		                        }
		                    ]
		                };
		            }
		                statistic.setOption(option,true);
		                window.onresize = function() {
		                    statistic.resize();
		                };
		        }
		    });
		})
    }
  }
};
</script>

<style lang="scss" scoped>
.content {
  display: flex;
  align-items: center;
  flex-direction: column;
  width: 100%;
  height: 100%;
  min-height: 500px;
  text-align: center;
  .main-text{
    font-size: 38px;
    font-weight: bold;
    margin-top: 20px;
  }
  .text {
    font-size: 24px;
    font-weight: bold;
    color: #333;
  }
}
</style>