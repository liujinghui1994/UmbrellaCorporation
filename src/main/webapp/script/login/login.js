$(function(){
	
    //获取当前网址，如： http://localhost:80/ybzx/index.jsp  
    var curPath=window.document.location.href;  
    //获取主机地址之后的目录，如： ybzx/index.jsp  
    var pathName=window.document.location.pathname; 
    var pos=curPath.indexOf(pathName); 
    //获取主机地址，如： http://localhost:80  
    var localhostPaht=curPath.substring(0,pos);  
    //获取带"/"的项目名，如：/ybzx
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1); 
    
    
	var vue = new Vue({
		el: "#login",
		router:new VueRouter({path:'/loginPage'}),
		methods:{
			//注册
			login: function(){
				var url = contextPath+'/doLogin';
				$.ajax({
					url :url,
					 data:{      
						 user_id : vue.user_id,      
						 user_name : vue.user_name,      
						 user_password:vue.user_password      
					 },
					type:"post",
					success : function(result){
						if(result.flag){
							swal({
								  title: "SIGN SUCCESS",
								  text: result.returnMsg,
								  type: "success",
								},
								function(){
									window.location.href = contextPath + "/MainIndexPage";
								});
						}else{
							swal({
								  title: "ERROR",
								  text: result.returnMsg,
								  type: "error",
								  timer: 2000
								});
						}
					}
				});
			}
		}
	});
});
