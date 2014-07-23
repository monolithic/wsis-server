<%--
  Created by IntelliJ IDEA.
  User: ning
  Date: 2014/7/3 0003
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <title>注册页</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/global/css/ui-core.css" />
    <link rel="stylesheet" id="theme" type="text/css" href="${ctx}/resources/jquery.validate/jquery.validator.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/global/css/reg.css" />

    <style>
        .msg-box {
            position: absolute;
            display: block;
            cursor: pointer;
        }
    </style>
</head>
<body style="">
<!-- banner开始 -->
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tbody><tr>
        <td height="97" align="center">
            <table width="1000" border="0" cellspacing="0" cellpadding="0" align="center">
            <tbody><tr>
                <td width="5"></td>
                <td width="315" height="105" align="left" valign="middle">
                    <div style="font-size: 30px;text-align: center">企业信用信息年报系统</div>
                </td>

                <td width="5"></td>
            </tr>
            </tbody></table>
        </td>
    </tr>
    </tbody></table>
<!-- banner结束 -->

<!-- 导航开始 -->

<!-- 导航结束 -->
<div id="main">
    <div id="main_1">
        <div id="title">
            <p class="head">个人用户注册</p>
        </div>
        <div class="errmsg"></div>
        <div class="okmsg"></div>
        <div>
            <form id="regForm" name="regForm" method="post" action="/reg" class="formbox" enctype="multipart/form-data">
                <input type="hidden" name="action" value="saveRegUser">
                <input type="hidden" name="uid" value="" id="uid">
                <input type="hidden" name="servicecode" value="">
                <input type="hidden" name="phoneUnique" value="" id="phoneUnique">
                <div class="text">
                    <table>
                        <tbody>
                        <tr>
                            <td colspan="5">
                                <div class="tabinfo"> 以下为注册内容</div>
                            </td>
                        </tr>
                        <%--<tr>
                            <td class="name">用户名：</td>
                            <td class="right"><div class="div-shadow"><input type="text" name="loginName" value="" data-rule="用户名：required;username"></div></td>
                            <td colspan="2" class="description"><span class="req">*</span>以字母开头，由字母、数字和下划线组成</td>
                        </tr>--%>
                        <tr>
                            <td class="name">姓名：</td>
                            <td class="right"><div class="div-shadow"><input type="text" name="realName" value="" data-rule="姓名：required"></div></td>
                            <td colspan="2" class="description"><span class="req">*</span></td>
                        </tr>
                        <tr>
                            <td class="name">身份证：</td>
                            <td class="right"><div class="div-shadow"><input type="text" name="idCard" value="" data-rule="身份证：required"></div></td>
                            <td colspan="2" class="description"><span class="req">*</span></td>
                        </tr>
                        <tr>
                            <td class="name" id="pwdLable">密码：</td>
                            <td><div class="div-shadow"><input type="password" name="password" maxlength="50" value="" id="password" data-rule="密码: required;password"></div></td>
                            <td colspan="2" class="description"><span class="req">*</span>密码由6-20个字符组成，且字母有大小写之分</td>
                        </tr>
                        <tr>
                            <td class="name" id="rePwdLable">重复密码：</td>
                            <td><div class="div-shadow"><input type="password" name="rePwd" maxlength="50" value="" id="rePwd" data-rule="确认密码: required;match(password);"></div></td>
                            <td colspan="2" class="description"><span class="req">*</span></td>
                        </tr>
                        <tr>
                            <td class="name">手机：</td>
                            <td class="right"><div class="div-shadow"><input type="text" name="mobilePhone" value="" id="mobilePhone" data-rule="手机：required;mobile"></div>
                            </td>
                            <td><input disabled="disabled" type="button" class="btn-long" onclick="fireGetMobilekey();" id="getCodeAgain" value="获取验证码" name="verifycode"></td>
                        </tr>
                        <tr>
                            <td class="name">验证码：</td>
                            <td class="right"><div class="div-shadow"><input type="text" name="code" value="" id="code" ></div></td>
                            <td colspan="2" class="description"><span class="req">*</span></td>
                        </tr>
                        <tr>
                            <td class="name">电子邮件：</td><td class="right"><div class="div-shadow"><input type="text" name="email" value="" id="email" data-rule="邮箱：required;email"></div></td>
                            <td colspan="2" class="description"><span class="req">*</span></td>
                        </tr>

                        <tr>
                            <td class="name">联系地址：</td><td class="right"><div class="div-shadow"><input type="text" name="homeAddress" value="" ></div></td>
                            <td class="name">邮编：</td><td class="right"><div class="div-shadow"><input type="text" name="postCode" value="" ></div></td>
                        </tr>
                        <tr>
                            <td class="name">电话：</td><td class="right"><div class="div-shadow"><input type="text" name="officePhone" value="" ></div></td>
                        </tr>
                        <tr>
                        </tr>
                        </tbody></table>
                </div>
                <div style="margin: 0 auto;text-align: center;">
                    <div style="margin: 10px;"><input id="isread" type="checkbox" value="1" class="checkboxbox">我已阅读并同意《<a id="xieyi" style="text-decoration: underline;">xxxxx系统用户注册协议</a>》</div>
                    <input type="submit" id="btn-reg" value="注册">&nbsp;&nbsp;&nbsp;<input type="button" id="btn_reset" value="重置">
                </div>
            </form>
        </div>
    </div>
</div>
<!-- 版权和底部导航开始 -->
<table width="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#ededed">
    <tbody><tr>
        <td height="112" align="center">

            <table border="0" cellspacing="0" cellpadding="0" align="center">
                <tbody><tr>
                    <td style="color:#959595; font-size:14px;line-height:24px" align="center">主办单位：xxxxx &nbsp;&nbsp;备案：xxxxxx&nbsp;&nbsp; <br>建议使用1366*768分辨率/IE9.0或以上浏览器访问达到最佳效果</td>
                </tr>
                </tbody></table>

        </td>
    </tr>
    </tbody>
</table>
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
<script>
$(function() {
    var fcous = ""; //目前焦点的name
    $(":text:not(.inputbox),:password:not(.inputbox)").addClass("inputbox");
       $('.inputbox').hover(function() {
                $(this).removeClass('inputbox').addClass('inputbox-over');
            },
            function() {
                if (!$(this).is('[name=' + fcous + ']')) {
                    $(this).removeClass('inputbox-over').addClass('inputbox');
                }
            });
    $('.inputbox').focus(function() {
        $(this).removeClass('inputbox').addClass('inputbox-over');
        fcous = $(this).attr("name");
    });
    $('.inputbox').blur(function() {
        $(this).removeClass('inputbox-over').addClass('inputbox');
        fcous = "";
    });
    $("#regForm").validator({
        stopOnError: true,
        theme:'yellow_right_effect',
        ignore: ':hidden',	//忽略隐藏文本
        msgWrapper:'div',
        valid: function(form){
            $.ajax({
                url: "${ctx}/reg",
                type: "post",
                dataType:'json',
                data: $(form).serialize(),
                success: function(d){
                    //do something
                    location.href = "${ctx}";
                }
            });
        }
    });
//    showError();
//    function showError(obj, msg) {
//
//        var errorDiv = getErrorDirName(obj);
//        var error = $(buildErrorDir()).addClass(errorDiv);
//        error.find('.formErrorContent').html(msg);
//        obj.parent().append(error);
//        var top = obj.offset().top + obj.height() + 4;
//
//        if ($(window).scrollTop() == 0) {
//            top = top + document.documentElement.scrollTop;
//
//        }
//        var ow = obj.width();
//        var left = obj.position().left + (ow / 2 < 20 ? ow / 2 : ow - 20) - 20;
//        error.css("top", top).css("left", left);
//    }
//
//    function getErrorDirName(obj) {
//        return obj.attr("name") + "ErrorDir";
//    }
//
//    function buildErrorDir() {
//        var div = "<div class='parentFormformID formError'>" +
//                "<div class='formErrorArrow'>" +
//                "<div class='line1'></div><div class='line2'></div><div class='line3'></div><div class='line4'></div><div class='line5'></div><div class='line6'></div><div class='line7'></div>" +
//                "</div>" +
//                "<div class='formErrorContent'></div>" +
//                "</div>";
//        return div;
//    }
});
</script>


</body>
</html>
