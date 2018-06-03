$(function(){
	var vue = new Vue({
		el: "#register",
		router:new VueRouter({path:'/registerPage'}),
		methods:{
			//注册
			register: function(){
				var url = contextPath + '/saveRegisterDetail';
				$.ajax({
					url :url,
					 data:{      
						 user_id : vue.user_id,      
						 user_name : vue.user_name,      
						 user_sex:vue.user_sex,
						 user_birth:vue.user_birth,
						 user_national:vue.user_national,
						 user_phone:vue.user_phone,
						 user_address:vue.user_address,
						 user_level:vue.user_level,
						 user_photoid:vue.user_photoid,
						 user_department:vue.user_department,
						 user_email:vue.user_email,
						 user_password:vue.user_password      
					 },
					type:"post",
					success : function(result){
						if(result.flag){
							alert(result.returnMsg);
						}else{
							alert(result.returnMsg);
						}
					}
				});
			}
		}
	});
});