<%--
  Created by IntelliJ IDEA.
  User: ning
  Date: 2014/6/30 0030
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<!--[if IE 8]><html class="ie8 no-js" lang="en"><![endif]-->
<!--[if IE 9]><html class="ie9 no-js" lang="en"><![endif]-->
<!--[if !IE]><!-->
<html class="no-js">
<!--<![endif]-->
<!-- start: HEAD -->
<head>
    <title>wwxt2014版首页</title>
    <meta charset="utf-8" />
    <!--[if IE]><meta http-equiv='X-UA-Compatible' content="IE=edge,IE=9,IE=8,chrome=1" /><![endif]-->
    <!-- start: MAIN CSS -->
    <link rel="stylesheet" id="theme" type="text/css" href="${ctx}/resources/global/css/theme/default/style.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/global/css/ui-core.css" />
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/ztree/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/resources/asyncbox/skins/default.css" type="text/css" charset="utf-8"/>
    <!-- end: MAIN CSS -->
    <!-- start: CSS REQUIRED FOR THIS PAGE ONLY -->
    <style type="text/css">
        .ztree li{display:block;}
        .headerNav {
            padding-top: 5px;
        }
        .logoword {
            height: 50px;
            font-size: 32px;
            color: #ffffff;
        }
        #header .nav li.first {
            background: none;
        }
    </style>
    <!-- end: CSS REQUIRED FOR THIS PAGE ONLY -->
</head>
<!-- end: HEAD -->
<!-- start: BODY -->
<body>
<div id="layout">
    <div id="header">
        <div class="headerNav">
            <span class="logoword" >企业信用信息年报系统</span>
            <ul class="nav">
                <li class="first"><a>当前登陆人员：<shiro:principal/> </a></li>
                <li><a href="javascript:void(0);" target="dialog" width="600">设置</a></li>
                <li><a href="${ctx}/logout">退出</a></li>
            </ul>

        </div>
    </div>
    <div id="leftside">
<%--        <div id="sidebar_s">
            <div class="collapse">
                <div class="toggleCollapse"><div></div></div>
            </div>
        </div>
        <div id="sidebar">
            <div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>
            <div class="accordion dwz-accordion" fillspace="sideBar">
                <div class="accordionHeader">
                    <h2 class="collapsable"><span>Folder</span>界面组件</h2>
                </div>
                <div class="accordionContent">
                    <ul class="tree treeFolder">
                        <li>
                            <div>
                                <div class="expandable"></div>
                                <div class="folder_expandable"></div><a>常用组件</a>
                            </div>
                            <ul style="display: none;">
                                <!-- <li><div><div class="line"></div><div class="node"></div><div class="file"></div><a rel="w_tabs" target="navTab" href="w_tabs.html">选项卡面板</a></div></li> -->
                                <li class="done"><div><div class="line"></div><div class="node"></div><div class="file"></div><a rel="w_dialog" target="navTab" href="/form/dialog">弹出窗口</a></div></li>
                                <!-- <li><div><div class="line"></div><div class="node"></div><div class="file"></div><a rel="w_list" target="navTab" href="w_list.html">CSS表格容器</a></div></li> -->
                                <!-- <li><div><div class="line"></div><div class="node"></div><div class="file"></div><a rel="w_table1" target="navTab" href="w_removeSelected.html">表格数据库排序+批量删除</a></div></li> -->
                                <li class="done"><div><div class="line"></div><div class="node"></div><div class="file"></div><a rel="w_tree" target="navTab" href="/ztree/index">树形菜单</a></div></li>
                                <!-- <li><div><div class="line"></div><div class="node"></div><div class="file"></div><a rel="w_accordion" target="navTab" href="w_accordion.html">滑动菜单</a></div></li> -->
                                <li class="done"><div><div class="line"></div><div class="node"></div><div class="file"></div><a rel="w_editor" target="navTab" href="/form/editor">编辑器</a></div></li>
                                <li class="done"><div><div class="line"></div><div class="node"></div><div class="file"></div><a rel="w_datepicker" target="navTab" href="/form/date">日期控件</a></div></li>
                                <!-- <li><div><div class="line"></div><div class="node"></div><div class="file"></div><a rel="db" target="navTab" href="demo/database/db_widget.html">suggest+lookup+主从结构</a></div></li>
                                <li><div><div class="line"></div><div class="node"></div><div class="file"></div><a rel="db" target="navTab" href="demo/database/treeBringBack.html">tree查找带回</a></div></li>
                                <li><div><div class="line"></div><div class="node"></div><div class="file"></div><a rel="sortDrag" target="navTab" href="demo/sortDrag/1.html">单个sortDrag示例</a></div></li>
                                <li><div><div class="line"></div><div class="node"></div><div class="file"></div><a rel="sortDrag" target="navTab" href="demo/sortDrag/2.html">多个sortDrag示例</a></div></li>
                                <li class="last"><div><div class="line"></div><div class="node"></div><div class="file"></div><a rel="sortDrag" target="navTab" href="demo/sortDrag/form.html">可拖动表单示例</a></div></li> -->
                            </ul>
                        </li>
                        <li>
                            <div>
                                <div class="first_collapsable"></div>
                                <div class="folder_collapsable"></div><a>表单组件</a>
                            </div>
                            <ul>
                                <li><div><div class="line"></div><div class="node"></div><div class="file"></div><a rel="f_button" target="navTab" href="/demo/comp/button">按钮</a></div></li>
                                <li><div><div class="line"></div><div class="node"></div><div class="file"></div><a rel="f_combobox" target="navTab" href="/demo/comp/combobox">下拉框</a></div></li>
                                <li class="done"><div><div class="line"></div><div class="node"></div><div class="file"></div><a rel="w_textInput" target="navTab" href="/form/editor">文本框/文本域</a></div></li>
                                <li class="done"><div><div class="line"></div><div class="node"></div><div class="file"></div><a rel="w_uniformjs" target="navTab" href="/form/uniform">表单样式</a></div></li>
                                <li class="done"><div><div class="line"></div><div class="node"></div><div class="file"></div><a rel="w_validation" target="navTab" href="/form/validate">表单验证</a></div></li>
                                <li class="done"><div><div class="line"></div><div class="node"></div><div class="file"></div><a rel="w_query" target="navTab" href="/form/query">条件查询</a></div></li>
                                <li class="done"><div><div class="line"></div><div class="node"></div><div class="file"></div><a rel="w_jilian" target="navTab" href="/form/jilian">级联菜单</a></div></li>
                                <!-- <li><div><div class="line"></div><div class="node"></div><div class="file"></div><a rel="w_checkbox" target="navTab" href="http://www.qq.com">多选框/单选框</a></div></li>
                                <li><div><div class="line"></div><div class="node"></div><div class="file"></div><a rel="demo_upload" target="navTab" href="demo_upload.html">iframeCallback表单提交</a></div></li>
                                <li class="last"><div><div class="line"></div><div class="node"></div><div class="file"></div><a rel="w_uploadify" target="navTab" href="w_uploadify.html">uploadify多文件上传</a></div></li> -->
                            </ul>
                        </li>
                        <li>
                            <div>
                                <div class="expandable"></div>
                                <div class="folder_expandable"></div>
                                <a>功能演示</a>
                            </div>
                            <ul style="display: none;">
                                <li class="done"><div><div class="line"></div><div class="node"></div><div class="file"></div><a rel="nsrxx_table" target="navTab" href="/nsrxx">表格容器</a></div></li>
                            </ul>
                        </li>
                        <li style="display:none;">
                            <div>
                                <div class="expandable"></div>
                                <div class="folder_expandable"></div><a target="navTab">主框架面板</a>
                            </div>
                            <ul style="display:none;">
                                <li><div><div class="line"></div><div class="node"></div><div class="file"></div><a rel="main" target="navTab" href="main.html">我的主页</a></div></li>
                                <li><div><div class="line"></div><div class="node"></div><div class="file"></div><a rel="page1" target="navTab" href="http://www.baidu.com">页面一(外部页面)</a></div></li>
                                <li><div><div class="line"></div><div class="node"></div><div class="file"></div><a external="true" rel="external" target="navTab" href="demo_page2.html">iframe navTab页面</a></div></li>
                                <li><div><div class="line"></div><div class="node"></div><div class="file"></div><a fresh="false" rel="page1" target="navTab" href="demo_page1.html">替换页面一</a></div></li>
                                <li><div><div class="line"></div><div class="node"></div><div class="file"></div><a rel="page2" target="navTab" href="demo_page2.html">页面二</a></div></li>
                                <li><div><div class="line"></div><div class="node"></div><div class="file"></div><a title="页面三（自定义标签名）" rel="page3" target="navTab" href="demo_page4.html">页面三</a></div></li>
                                <li><div><div class="line"></div><div class="node"></div><div class="file"></div><a fresh="false" rel="page4" target="navTab" href="demo_page4.html">测试页面（fresh="false"）</a></div></li>
                                <li><div><div class="line"></div><div class="node"></div><div class="file"></div><a target="navTab" href="w_editor.html">表单提交会话超时</a></div></li>
                                <li><div><div class="line"></div><div class="node"></div><div class="file"></div><a target="navTab" href="demo/common/ajaxTimeout.html">navTab会话超时</a></div></li>
                                <li><div><div class="line"></div><div class="node"></div><div class="file"></div><a target="dialog" href="demo/common/ajaxTimeout.html">dialog会话超时</a></div></li>
                                <li class="last"><div><div class="line"></div><div class="node"></div><div class="file"></div><a target="_blank" href="index_menu.html">横向导航条</a></div></li>
                            </ul>
                        </li>
                        <li style="display:none;">
                            <div>
                                <div class="expandable"></div>
                                <div class="folder_expandable"></div>
                                <a>图表</a>
                            </div>
                            <ul style="display: none;">
                                <li><div><div class="line"></div><div class="node"></div><div class="file"></div><a href="chart/test/barchart.html" target="navTab" rel="chart">柱状图(垂直)</a></div></li>
                                <li><div><div class="line"></div><div class="node"></div><div class="file"></div><a href="chart/test/hbarchart.html" target="navTab" rel="chart">柱状图(水平)</a></div></li>
                                <li><div><div class="line"></div><div class="node"></div><div class="file"></div><a href="chart/test/linechart.html" target="navTab" rel="chart">折线图</a></div></li>
                                <li><div><div class="line"></div><div class="node"></div><div class="file"></div><a href="chart/test/linechart2.html" target="navTab" rel="chart">曲线图</a></div></li>
                                <li><div><div class="line"></div><div class="node"></div><div class="file"></div><a href="chart/test/linechart3.html" target="navTab" rel="chart">曲线图(自定义X坐标)</a></div></li>
                                <li class="last"><div><div class="line"></div><div class="node"></div><div class="file"></div><a href="chart/test/piechart.html" target="navTab" rel="chart">饼图</a></div></li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <shiro:hasPermission name="admin:*">
                    <div class="accordionHeader">
                        <h2><span>Folder</span>系统管理</h2>
                    </div>
                </shiro:hasPermission>
                <div class="accordionContent" style="display:none;">
                    <ul id="treeDemo" class="ztree"></ul>
                </div>
                <div class="accordionHeader">
                    <h2><span>Folder</span>流程演示</h2>
                </div>
                <div class="accordionContent" style="display: none;">
                    <h4>这里什么都没有</h4>
                </div>
            </div>
        </div>--%>
    </div>
    <div id="container">
        <div id="navTab" class="tabsPage">
            <div id="navTabHeader" class="tabsPageHeader">
                <div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
                    <ul class="navTab-tab" style="left: 0px;">
                        <li tabid="main" class="main selected">
                            <a href="javascript:;"><span><span class="home_icon">我的主页</span></span></a>
                        </li>
                    </ul>
                </div>
                <div class="tabsLeft" style="display: none;">left</div>
                <!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
                <div class="tabsRight" style="display: none;"></div>
                <!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
                <div class="tabsMore">more</div>
            </div>
            <ul id="tabsMoreList" class="tabsMoreList" style="display: none;">
                <li class="selected"><a href="javascript:;">我的主页</a></li>
            </ul>
            <div id="navTab-panel" class="navTab-panel tabsPageContent layoutBox">
                <div class="page unitBox"></div>
            </div>
        </div>
    </div>
    <div id="taskbar" style="left: 0px; display: none; top: 387px; width: 1280px;">
        <div class="taskbarContent">
            <ul></ul>
        </div>
        <div class="taskbarLeft taskbarLeftDisabled" style="display:none;">taskbarLeft</div>
        <div class="taskbarRight" style="display:none;">taskbarRight</div>
    </div>
</div>
<div id="footer">Copyright &copy; 2010-2014 <a href="javascript:void(0);" target="dialog"></a> </div>
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
<script type="text/javascript" src="${ctx}/resources/ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/asyncbox/asyncbox.v1.5.min.js"></script>
<script type="text/javascript" src="${ctx}/resources/global/js/common.js"></script>
<!-- end: MAIN JAVASCRIPTS -->
<!-- start: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
<script type="text/javascript" src="${ctx}/resources/global/js/home.js"></script>
<!-- end: JAVASCRIPTS REQUIRED FOR THIS PAGE ONLY -->
<script type="text/javascript">
    var ctx = "${ctx}";
    $(function(){
        Home.init();
    });
</script>
</body>
<!-- end: BODY -->
</html>