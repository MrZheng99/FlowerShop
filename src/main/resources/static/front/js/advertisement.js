let adv = new Vue({
	el: "#demo",
	data:{
		advertisements:[], //全部广告
		first:""
	},
	mounted: function(){
		axios.get("/zyl/advertisement/findAll").then(result =>{
				this.advertisements = result.data.data;
				this.first= this.advertisements[0];
				console.info(this.first);
		})
	
}})

