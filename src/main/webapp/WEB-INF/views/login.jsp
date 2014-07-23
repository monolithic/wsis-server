<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<!--[if IE 8]><html class="ie8 no-js" lang="en"><![endif]-->
<!--[if IE 9]><html class="ie9 no-js" lang="en"><![endif]-->
<!--[if !IE]><!-->
<html class="no-js">
<!--<![endif]-->
<!-- start: HEAD -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>海口市企业年报系统</title>
<meta charset="utf-8" />
<!--[if IE]><meta http-equiv='X-UA-Compatible' content="IE=edge,IE=9,IE=8,chrome=1" /><![endif]-->
<!-- start: MAIN CSS -->
<link rel="stylesheet" type="text/css" href="${ctx}/resources/global/css/ui-core.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/resources/jquery.validate/jquery.validator.css" />
<!-- end: MAIN CSS -->
<!-- start: CSS REQUIRED FOR THIS PAGE ONLY -->
<style>
#tips{font-size:30px;color:white;font-weight:bolder;position:absolute;display:none;top:0px;left:45%;}
.load{float:right;margin:6px;width:56px;height:14px;display:inline-block;background:url(${ctx}/resources/global/images/loading.gif) no-repeat;}
.btn{width:80px;height:30px;margin-left:-16px;}
</style>
<!-- end: CSS REQUIRED FOR THIS PAGE ONLY -->
<!-- end: HEAD -->
<!-- start: BODY -->
</head>
<body class="login_body" style="color: #fff;">
<div style="padding: 100px 0;margin-bottom: -200px;"><h2 style="font-size: 32px;">企业信用信息公示年报系统</h2></div>
<div id="tips">${shiroLoginFailure}</div>
<div class="login_main">
	<form id="loginForm" action="${ctx}/login" method="post">
	<div><label>用户名</label><input name="username" id="username" data-rule="required" class="login_input" value="${username}" /></div>
	<div><label>密　码</label><input type="password" id="password" data-rule="required;password" class="login_input" name="password" /></div>

	<div align="center">
		<input id="btn_login" type="submit" class="btn" value="登录" style="margin-left:16px;"/>
		<a id="btn_reg" class="btn"  href="${ctx}/reg" style="margin-left:58px;">注册</a>

	</div>
    <div align="center">
        <a id="btn_qrcode" class="btn"  href="${ctx}/qr_login" style="margin-left:58px;">扫码登录</a>
    </div>
	</form>
</div>
<!-- start: MAIN JAVASCRIPTS -->
<!--[if lt IE 9]>
<script src="assets/plugins/respond.min.js"></script>
<script src="assets/plugins/excanvas.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/jquery/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/jquery/jquery-migrate-1.2.1.min.js"></script>
<![endif]-->
<!--[if gte IE 9]><!-->
<script type="text/javascript" src="${ctx}/resources/jquery/jquery-2.1.1.min.js"></script>
<!--<![endif]-->
<script type="text/javascript" src="${ctx}/resources/jquery.validate/jquery.validator.js"></script>
<script type="text/javascript" src="${ctx}/resources/jquery.validate/zh_CN.js"></script>
<script type="text/javascript" src="${ctx}/resources/global/js/common.js"></script>
<!-- end: MAIN JAVASCRIPTS -->
<!-- start: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
<script>
$(document).ready(function() {

	$("#submit").click(function(){
		//console.log("submit it");
		//$("#loginForm").submit();
		//$("form:first").submit();
	});
	$("#loginForm").validator({
		stopOnError: true,
		theme:'yellow_top',
		ignore: ':hidden'	//忽略隐藏文本
	});
	if($("#tips").text() != ""){
		$("#tips").slideDown(300, function(){
			setTimeout(function(){$("#tips").slideUp(200)}, 2000);
		});
	}
});
</script>
<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
</body>
<!-- end: BODY -->
</html>