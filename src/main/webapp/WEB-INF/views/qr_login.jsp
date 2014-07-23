<%--
  User: ning
  Date: 2014/7/2 0002
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML>
<html>
<head>
    <title>网页扫描</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=yes">
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/global/css/ui-core.css" />
    <script>
        if(window.top!== window.self){top.location=self.location;}
        //if(location.protocol.indexOf("https")<0){location.href=location.href.replace(/http/i, "https");}
        developMode=0;
        window.t_t=+new Date;
        window.gDocTitle="网页扫描页";
        document.lang="zh_CN";
    </script>
    <style>
        body {
            position: relative;
        }
        html, body {
            background: #fff;
            /*color: #666;*/
            font: 14px/1.5 Helvetica,"微软雅黑","黑体",Arial,Tahoma;
            height: 100%;
            min-height: 755px;
            overflow-y: auto;
            text-align: center;
        }
        #login_container {
            height: 100%;
            text-shadow: 0 1px 1px #333333;
            width: 100%;
        }
        #login_container .mask {
            background: none repeat scroll 0 0 #000;
            display: none;
            height: 100%;
            left: 0;
            opacity: 0.4;
            position: absolute;
            top: 0;
            width: 100%;
            z-index: 998;
        }
        #login_container .normalPanel {

        }
        .loginPanel {
            border: 1px solid #ddd;
            border-radius: 4px;
            height: 380px;
            left: 400px;
            position: absolute;
            text-align: center;
            width: 500px;
        }
        #login_container .loginPanel {
            border: medium none;
            margin: 0 auto;
            padding: 17px 0 0;
            position: static;
            text-align: center;
        }
        #login_container .loginPanel .title {
            border-radius: 4px 4px 0 0;
            /*font-size: 32px;*/
            height: 50px;
            line-height: 50px;
            margin: 0 auto 10px;
            /*text-indent: -9999px;*/
            /*text-shadow: 0 2px 0 #333;*/
            width: 160px;
        }
        #login_container .loginPanel .panelContent {
            padding: 0;
        }
        #login_container .loginPanel .panelContent .qrcodeContent {
            height: 310px;
        }
        #login_container .loginPanel .info {
            height: 176px;
            margin: 0 auto;
            padding: 7px 0 0;
        }
        #login_container .loginPanel .qrcodePanel {
            height: 330px;
            margin: 0 auto;
            padding: 5px;
            width: 331px;
        }
    </style>
</head>
<body>
<div id="login_container" style="">
    <div class="mask" style="height:100%;width:100%;position:absolute;z-index:99;opacity:0.2;background-color:#000;display:none;"></div>
    <div class="main">
        <div class="loginPanel normalPanel">
            <div class="logoTitle title pngBackground">
                <h1>网页扫描登录</h1>
            </div>
            <div class="waiting panelContent">
                <div class="qrcodeContent" style="position:relative;">
                    <div class="qrcodePanel">
                        <div class="qrcode lightBorder" id="loginQrCode" ></div>
                    </div>
                    <div id="guideTrigger" style="position:absolute;z-index:9999;width:260px;height:100%;left:50%;top:0px;margin-left:-130px;"></div>
                </div>
                <div class="info">
                    <div class="normlDesc loginTip pngBackground" style="position:relative;">
                        <div class="loginTipL pngBackground"></div>
                        <div class="loginTipR pngBackground"></div>
                        <p>请使用移动APP软件扫描二维码以登录</p>
                        <div id="tipTrigger" style="position:absolute;z-index:9999;width:100%;height:100%;left:0px;top:0px;"></div>
                    </div>

                    <div class="successMsg msgBox">
                        <div class="msgBoxTop pngBackground"></div>
                        <div class="msgBoxMid pngBackground">
                            <div class="successMsgTipPic pngBackground"></div>
                            <h3>成功扫描</h3>
                            <p>请在手机点击确认以登录</p>
                        </div>
                        <div class="msgBoxBtm pngBackground"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--[if lt IE 9]>
<script src="assets/plugins/respond.min.js"></script>
<script src="assets/plugins/excanvas.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/jquery/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/jquery/jquery-migrate-1.2.1.min.js"></script>
<![endif]-->
<!--[if gte IE 9]><!-->
<script type="text/javascript" src="${ctx}/resources/jquery/jquery-2.1.1.min.js"></script>
<!--<![endif]-->
<script type="text/javascript" src="${ctx}/resources/jquery.qrcode/jquery.qrcode.min.js"></script>
<script>
    $(function(){
        show_tip = 1;
        _nAjaxTimeout = 100 * 1000;
        $("div.msgBox").hide();
        $('#loginQrCode').qrcode("${qr_login_validate_url}?uuid=${uuid}");
        _poll("${uuid}");
    })
    function _poll(_asUUID) {
        var _self = arguments.callee,
        _nTime = new Date().getTime();
        _sCurUUId = _asUUID;
        $.ajax({
            type: "GET",
            url: "${ctx}/qr_login_check?uuid=" + _asUUID + "&tip=" + show_tip,
            dataType: "json",
            cache: false,
            timeout: _nAjaxTimeout,
            success: function(data, textStatus, jqXHR) {
                console.log(data);
                if(data.status!='00'){
                    setTimeout(function(){
                        _self(_asUUID);
                    }, 5000);
                }else{
                    $("div.loginTip").hide();
                    $("div.msgBox").show();
                    window.location.href = "${ctx}";
                }

            },
            error: function(jqXHR, textStatus, errorThrown) {
                if (textStatus == 'timeout') {
                    setTimeout(function(){
                        _self(_asUUID);
                    }, 500);
                } else {
                    setTimeout(function(){
                        _self(_asUUID);
                    }, 500);
                }
            }
        });
    }
</script>
</body>
</html>
