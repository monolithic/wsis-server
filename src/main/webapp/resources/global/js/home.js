var Home = function() {
    var initAccordion = function() {
        //$("#sidebar, .navTab-tab").unselectable();
        $(".accordionHeader").hover(function() {
            $(this).addClass("hover");
        }, function() {
            $(this).removeClass("hover");
        }).click(function() {
            if ($(this).next(".accordionContent:first").is(":hidden")) {
                $(".collapsable").removeClass("collapsable");
                $(".accordionContent:visible").slideUp(250);
                $(this).find("h2").addClass("collapsable");
                $(this).next(".accordionContent:first").slideDown(250);
            }
        });
    };
    var initTheme = function() {
        // 样式切换
        $("#themeList li").click(function() {
            $(this).siblings("li").find("div").removeClass("selected");
            $(this).find("div").addClass("selected");
            $("#theme").attr("href", ctx + "/resources/global/css/theme/" + $(this).attr("theme") + "/style.css");
        });
    };
    var initToggleSidebar = function() {
        // 左侧面板收缩
        $(".toggleCollapse div").click(function() {
            if ($("#sidebar").css("left").replace("px", "") > 0) {
                $("#sidebar").animate({
                    left: -200
                }, 300, function() {
                    $("#sidebar_s").show(function() {
                        $(this).animate({
                            left: 5
                        }, 200);
                    });
                });
                $("#container").animate({
                    left: 34,
                    width: "+=" + ($("#sidebar").width() - 24)
                }, 300);
            } else {
                $("#sidebar_s").animate({
                    left: -25
                }, 200, function() {
                    $("#container").animate({
                        left: 210,
                        width: "-=" + ($("#sidebar").width() - 24)
                    }, 300);
                    $("#sidebar").animate({
                        left: 5
                    }, 300);
                });
            }
        });
    };
    var initMenuTree = function() {
        // 左侧树菜单上下收缩事件
        $(".tree li div").click(function() {
            var cls = $(this).find("div").attr("class");
            if (typeof cls != 'undefined' && cls.contains("collapsable")) {
                $(this).find("div").each(function() {
                    $(this).attr("class", $(this).attr("class").replace("collapsable", "expandable"));
                });
                $(this).next("ul:first").stop(false, true).slideUp(300);
            } else {
                $(this).find("div").each(function() {
                    $(this).attr("class", $(this).attr("class").replace("expandable", "collapsable"));
                });
                $(this).next("ul:first").stop(false, true).slideDown(300);
            }
        });
        // 左侧树点击事件
        $(".tree li ul li a,.tree li div a").on("click", function() {
            var $rel = $(this).attr("rel");
            if (!$rel) return false;
            // 处理树链接样式、选项卡样式、更多选项卡标签样式
            $(".tree .selected").removeClass("selected");
            $(".navTab-tab .selected").removeClass("selected");
            $(".tabsMoreList .selected").removeClass("selected");
            $(".navTab-panel .unitBox").hide();
            $(this).addClass("selected");
            if ($("li[rel='" + $rel + "']").size() == 0) {
                var url = $(this).attr("href"),
                    height = $(".navTab-panel").height();
                if (url.substring(0, 1) == "/") {
                    url = ctx + url;
                }
                var li = '<li class="external selected" rel="' + $rel + '" url="' + url + '"><a href="javascript:void(0);" title="' + $(this).text() + '"><span>' + $(this).text() + '</span></a><a href="javascript:void(0);" class="close">close</a></li>';
                $(".navTab-tab").append(li);
                $(".tabsMoreList").append('<li class="selected"><a href="javascript:void(0);">' + $(this).text() + '</a></li>');
                // 处理内容页
                $(".navTab-panel").append('<div class="page unitBox"><iframe src="' + url + '" style="width:100%;height:' + height + 'px;" frameborder="no" border="0" marginwidth="0" marginheight="0"></iframe></div>');
            } else {
                var $li_rel = $("li[rel='" + $rel + "']");
                $li_rel.addClass("selected");
                $(".tabsMoreList li:eq(" + $li_rel.index() + ")").addClass("selected");
                $(".navTab-panel .unitBox:eq(" + $li_rel.index() + ")").show();
            }
            return false;
        });
    };
    var initMenuTree2 = function(rootId) {
    	var curMenu = null, zTree_Menu = null;
        var setting = {
        		view: {
    				dblClickExpand: false,
    				showLine: false
    			},
            async: {
                enable: true,
                type: 'get',
                url: ctx + "/menu/list",
                autoParam: ["id=pid"],
                otherParam: {
                    "rootId": rootId
                },
                dataFilter: filter
            },
            callback: {
                beforeClick: beforeClick,
                onClick: onClick,
                onAsyncError: onAsyncError,
                onAsyncSuccess: onAsyncSuccess
            }
        };

        function filter(treeId, parentNode, childNodes) {
            if (!childNodes) return null;
            for (var i = 0, l = childNodes.length; i < l; i++) {
                childNodes[i].isParent = childNodes[i].leaf;
                childNodes[i].icon = '';
                if (childNodes[i].isParent) {
                	childNodes[i].url = '';
                    continue;
                }
                childNodes[i].rel = 'rel_' + childNodes[i].id;
                childNodes[i].url = ctx + childNodes[i].url;
                
                childNodes[i].target = 'navTab';
            }
            return childNodes;
        }

        function beforeClick(treeId, treeNode, clickFlag) {
            if (treeNode.isParent) {
				zTree_Menu.expandNode(treeNode);
                return false;
            }
            return true;
        }

        function onClick(event, treeId, treeNode, clickFlag) {
            event.preventDefault();
            
            var rel = treeNode.rel;
            var $navTabPanel = $("#navTab-panel");
            var $tabsMoreList = $("#tabsMoreList");
            var $li = $("#navTabHeader li[rel='" + rel + "']");
            $("#navTabHeader .navTab-tab .selected").removeClass("selected");
            $("#tabsMoreList .selected").removeClass("selected");
            $navTabPanel.find(".unitBox").hide();
            if ($li.size() == 0) {
                var url = treeNode.url;
                var name = treeNode.name;
                var li_str = '<li class="external selected" rel="' + rel + '" url="' + url + '"><a href="javascript:void(0);" title="' + name + '"><span>' + name + '</span></a><a href="javascript:void(0);" class="close">close</a></li>';
                $("#navTabHeader .navTab-tab").append(li_str);
                $tabsMoreList.append('<li class="selected"><a href="javascript:void(0);">' + name + '</a></li>');
                // 处理内容页 $(this)
                $navTabPanel.append('<div class="page unitBox"><iframe src="' + url + '" style="width:100%;height:' + $navTabPanel.height() + 'px;" frameborder="no" border="0" marginwidth="0" marginheight="0"></iframe></div>');
            } else {
                $li.addClass("selected");
                $tabsMoreList.find("li:eq(" + $li.index() + ")").addClass("selected");
                $navTabPanel.find(".unitBox:eq(" + $li.index() + ")").show();
            }
        }



        function onAsyncError(event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {

        }

        function onAsyncSuccess(event, treeId, treeNode, msg) {

        }
        $.fn.zTree.init($("#treeDemo"), setting);
        zTree_Menu = $.fn.zTree.getZTreeObj("treeDemo");
    };
    var initTabbar = function() {
        // tab关闭按钮点击事件

        $("#navTabHeader").on("click", ".close", function() {
            var index = $(this).parent().index();
            $(this).parent().remove();
            $(".unitBox:eq(" + index + "), .tabsMoreList li:eq(" + index + "), .navTab-panel .unitBox:eq(" + index + ")").remove();
            if ($(".navTab-tab .selected").size() == 0) {
                $(".navTab-tab li:last, .tabsMoreList li:last").addClass("selected");
                $(".navTab-panel .unitBox:eq(" + $(".navTab-tab li:last").index() + ")").show();
            }
        });
        // tab选项卡切换事件
        $("#navTabHeader").on("click", "li", function() {
            if (!$(this).is(":visible")) return false;
            $(".navTab-tab .selected, .tabsMoreList .selected").removeClass("selected");
            $(".tabsMoreList li:eq(" + $(this).index() + ")").addClass("selected");
            $(".navTab-panel .unitBox").hide().eq($(this).index()).show();
            $(this).addClass("selected");
        });
        // 点击右侧更多，显示已打开选项卡事件
        $(".tabsPageHeader .tabsMore").click(function() {
            $(".tabsMoreList").toggle();
            return false;
        })
        $(document).click(function() {
            $(".tabsMoreList").hide()
        });
        // 右侧更多选项卡列表点击事件
        $(".tabsMoreList").on("click", "li", function() {
            var index = $(this).index();
            var $li_rel = $(".navTab-tab li:eq(" + index + ")");
            $(".tree .selected, .navTab-tab .selected, .tabsMoreList .selected").removeClass("selected");
            $li_rel.addClass("selected");
            $(this).addClass("selected");
            $(".tree li ul li a[rel=" + $li_rel.attr("rel") + "]").addClass("selected");
            $(".navTab-panel .unitBox").hide().eq(index).show();
        });
    };
    var initLayout = function() {
        var iContentW = $(window).width() - ($("#sidebar_s").css("left") == "5px" ? 34 : ($("#sidebar").width() + 10)) - 5;
        var iContentH = $(window).height() - $("#header").height() - 34;
        $("#container").width(iContentW);
        $("#container .tabsPageContent, #container .unitBox iframe").height(iContentH - 34);
        $("#sidebar, #sidebar_s .collapse, #splitBar, #splitBarProxy").height(iContentH - 5);
        $("#taskbar").css({
            top: iContentH + $("#header").height() + 5,
            width: $(window).width()
        });
    };
    var fillSpace = function() {
        setTimeout(function() {
            var obj = $(".accordion");
            if (obj.length == 0) return;
            var parent = obj.parent()
            var height = parent.height() - (($(".accordionHeader", obj).size()) * ($(".accordionHeader:first-child", obj).outerHeight())) - 2;

            var os = parent.children().not(obj);
            $.each(os, function(i) {
                height -= $(os[i]).outerHeight();
            });
            $(".accordionContent", obj).height(height);
        }, 100);
    };
    var runWindowResize = function() {
        $(window).resize(function() {
            initLayout();
            fillSpace();
        });
    };

    return {
        init: function() {
            initAccordion();
            initTheme();
            initToggleSidebar();
            initMenuTree();
            initMenuTree2('xtgl');
            initTabbar();
            initLayout();
            fillSpace();
            runWindowResize();
        }
    };
}();