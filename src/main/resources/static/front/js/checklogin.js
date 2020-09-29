let login = new Vue({
	el: "#login_info",
	data:{
		onlogin: false,
		loginName: "匿名",
		loginId: "",
		email:"",
		tel:"",
		realName:"",
		sex:"",
		headImg:""
	},
	mounted: function(){
		axios.get("/zyl/user/findCurrent").then(result =>{
			if(result.data.success){
				this.loginName = result.data.data.account;
				this.onlogin=true;
				this.loginId = result.data.data.uid;
				this.email = result.data.data.email;
				this.tel = result.data.data.tel;
				this.realName = result.data.data.uname;
				this.sex = result.data.data.sex;
				this.headImg= result.data.data.headImg;
			}else{
				this.onlogin = false;
				this.loginName = ">>>";
			}

		})
	
}})

function checkLogin(){
	return axios.get("/zyl/user/findCurrent")
}
