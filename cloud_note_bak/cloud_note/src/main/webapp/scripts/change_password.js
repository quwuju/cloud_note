//主处理
$(function(){
	//给修改密码的确定按钮绑定事件
	$("#changePassword").click(change_password);
});

//用户登录
function change_password(){
	//清除提示信息
	$("#last_password").html("");
	$("#new_password").html("");
	$("#final_password").html("");
	//获取用户名和密码
	var last_password = $("#last_password").val().trim();
	var new_password = $("#new_password").val().trim();
	var final_password = $("#final_password").val().trim();
	username=getCookie('userId');
	var ok = true;
	alert("1u2");
	//发送Ajax请求
	if(ok){//(通过格式检测)
		$.ajax({
			url:path+"/user/change.do",
			type:"post",
			data:{"last_password":lastPassword,"final_password":finalPassword,"userId":userId},
			dataType:"json",
			success:function(result){
				if(result.status == 0){
					//alert(result.msg);
					var userId = result.data.cn_user_id;
					alert("修改密码成功！！");
					window.location.href = "edit.html";
				}
				alert("111");
			},
			error:function(){
				alert("登陆失败");
			}
		});
	}
};
