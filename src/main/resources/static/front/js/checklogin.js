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
		/*
		axios.all([checkLogin(), getCartInfo()]).then(axios.spread((fn1, fn2)=>{
			if(fn1.data.code == 200){
				this.onlogin = true;
				this.loginName = fn1.data.data.nickName;
				this.loginId = fn1.data.data.mno;
			} else{
				this.onlogin = false;
			}
			
			if( fn2.data.code == 200){
				this.cartCount = fn2.data.data.length;
				this.carts = fn2.data.data;
			} else{
				this.cartCount = 0;
			}
		}))
	}
	*/
}})

function checkLogin(){
	return axios.get("/zyl/user/findCurrent")
}
/*
function getCartInfo(){
	return axios.get("cart", {params:{op:"info"}})
}
*/