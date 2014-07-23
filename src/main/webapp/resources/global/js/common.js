// 求字符串包含某字符
String.prototype.contains = function(item) {
    return RegExp(item).test(this);
};
// 求字符长度中英文（中文2字节，英文1个字节）
String.prototype.lengthEx = function() {
    return this.replace(/[^\x00-\xff]/g, "jj").length;
};
// 去左右空白
String.prototype.trim = function() {
    return this.replace(/(^\s*)|(\s*$)/g, "");
};
// 去左空白
String.prototype.ltrim = function() {
    return this.replace(/(^\s*)/g, "");
};
// 去右空白
String.prototype.rtrim = function() {
    return this.replace(/(\s*$)/g, "");
};
// 判断数组是否包含某个对象
Array.prototype.contains = function(item) {
    return RegExp(item).test(this);
};
Array.prototype.remove = function(val) {
    var index = this.indexOf(val);
    if (index > -1) {
        this.splice(index, 1);
    }
};
String.prototype.replaceAll = function(reallyDo, replaceWith, ignoreCase) {
    if (!RegExp.prototype.isPrototypeOf(reallyDo)) {
        return this.replace(new RegExp(reallyDo, (ignoreCase ? "gi" : "g")), replaceWith);
    } else {
        return this.replace(reallyDo, replaceWith);
    }
};
jQuery.fn.extend({
    /*
     * 设置不可选中状态
     * */
    unselectable: function() {
        this.bind(($.support.selectstart ? "selectstart" : "mousedown"), function(e) {
            e.preventDefault();
        });
        return this.each(function() {
            this.onselectstart = function() {
                return false;
            };
        });
    },
    getOptionData: function() {
        var dataOption = $(this).attr("data-option");
        if (dataOption) {
            var arr = dataOption.split(";"),
                o, d, map = {};
            for (var i = 0; i < arr.length; i++) {
                o = arr[i];
                d = o.split(":");
                if (d.length > 1) {
                    map[d[0].trim().replaceAll("\"", "").replaceAll("'", "")] = d[1].trim().replaceAll("\"", "").replaceAll("'", "");
                }
            }
            return map;
        }
        return [];
    },
    /**
     * 下拉框：2014-6-10 17:36:01
     */
    combobox: function(option, param) {
        var $this = $(this);
        if (option == 'getValue') {
            return $this.closest(".combo").find(".textbox-value").val();
        } else if (option == 'setValue') {
            return null;
        } else if (option == 'icon') {
            $this.each(function() {
                var $this = $(this),
                    _W = $this.width(),
                    dataOption = $this.getOptionData(),
                    $wrap = $('<div class="combo-icon"></div>');
                $wrap.append('<div class="item"><em class="more"></em><i class=""></i><a href="javascript:;" class="link link-first">&nbsp;</a></div>');
                $wrap.append('<div class="item-hide"></div>');
                var $hidden = $wrap.find('.item-hide');
                if (dataOption.url) {
                    $.getJSON(dataOption.url, function(os) {
                        if (os) {
                            for (var i = 0; i < os.length; i++) {
                                $hidden.append('<div class="item" style="width:' + _W + 'px;" value="' + os[i][dataOption.valueField] + '"><b></b>' + (os[i][dataOption.icon] ? ('<i class="' + os[i][dataOption.icon] + '"></i>') : '') + '<a href="javascript:;" class="link">' + os[i][dataOption.textField] + '</a></div>')
                            }
                        }
                    });
                } else if (dataOption.dataName) {
                    var data = eval(dataOption.dataName);
                    for (var i = 0; i < data.length; i++) {
                        $hidden.append('<div class="item" value="' + data[i][dataOption.valueField] + '"><b></b><i class="' + data[i][dataOption.icon] + '"></i><a href="javascript:;" class="link">' + data[i][dataOption.textField] + '</a></div>')
                    }
                }
                $this.after($wrap).remove();
                $wrap.find(".item").width(_W);
            });
            $(".combo-icon").hover(function() {
                $(this).toggleClass("link-hover");
            }, function() {
                $(this).toggleClass("link-hover");
            });
            $(".item-hide").on("click", ".item", function() {
                $(this).closest(".combo-icon").find(".item").removeClass("selected");
                $(this).addClass("selected");
                $(this).closest(".combo-icon").find(".link-first").text($(this).find(".link").text()).prev("i").attr("class", $(this).find("i").attr("class"));
            });
        } else {
            $this.each(function() {
                $this = $(this);
                var _H = $this.height() + 2,
                    _W = $this.width() + 2,
                    $combo = $('<span class="textbox combo"></span>').css({
                        width: _W,
                        height: _H
                    }),
                    $dropdown = $('<div class="panel dropdown"></div>').css({
                        position: 'absolute',
                        zIndex: 100 - $this.index(),
                        display: 'none'
                    }),
                    $dropdown_body = $('<div class="combo-panel panel-body panel-body-noheader"></div>');

                var _id = $this.attr("id") ? " id=\"" + $this.attr("id") + "\"" : "",
                    _name = $this.attr("name") ? " name=\"" + $this.attr("name") + "\"" : "",
                    _onchange = $this.attr("onchange");

                $combo.append('<input type="text" class="textbox-text" readonly="readonly" autocomplete="off" placeholder=""><span class="textbox-addon"><a href="javascript:void(0);" class="textbox-icon combo-arrow"></a></span><input type="hidden" class="textbox-value"' + _id + _name + ' value="">');

                var dataOption = $this.getOptionData();

                /**
                 * 处理options
                 */
                $this.find("option").each(function() {
                    $dropdown_body.append($('<div class="combobox-item" value="' + $(this).attr("value") + '">' + $(this).text() + '</div>'));
                });
                // 初始化默认选中项
                var index = $this.find("option:selected").index(),
                    $dropdown_items = $dropdown_body.find(".combobox-item");
                $dropdown_items.eq(index).addClass("combobox-item-selected");
                $combo.find(".textbox-text").val($this.find("option:selected").text());
                $combo.find(".textbox-value").val($this.find("option:selected").val());

                $dropdown.append($dropdown_body);
                $this.after($dropdown).after($combo).remove();

                var texts = [$this.find("option:selected").text()],
                    vals = [$this.find("option:selected").val()];

                /*事件注册*/

                // 点击↓箭头，展开/收起下拉框
                $combo.find(".combo-arrow").click(function() {
                    $combo.next(".dropdown:first").css("display", $combo.next(".dropdown:first").is(":visible") ? "none" : "block");
                    $dropdown.css({
                        left: Math.round($combo.offset().left - $(document.body).scrollLeft()),
                        top: Math.round($combo.offset().top + _H + 2 - $(document.body).scrollTop())
                    });
                });
                $dropdown_items.hover(function() {
                    $(this).addClass("combobox-item-hover");
                }, function() {
                    $(this).removeClass("combobox-item-hover");
                }).on("click", function() {
                    if (dataOption.multi == 'true') {
                        var text = $(this).text(),
                            val = $(this).attr("value");
                        if (texts.contains(text)) {
                            texts.remove(text);
                            $(this).removeClass("combobox-item-selected");
                        } else {
                            texts.push(text);
                            $(this).addClass("combobox-item-selected");
                        }
                        if (vals.contains(val)) {
                            vals.remove(val);
                        } else {
                            vals.push(val);
                        }
                        $combo.find(".textbox-text").val(texts.join(","));
                        $combo.find(".textbox-value").val(vals.join(","));
                    } else {
                        $combo.next(".dropdown:first").hide();
                        $(this).addClass("combobox-item-selected");
                        $dropdown_items.not($(this)).removeClass("combobox-item-selected");
                        $combo.find(".textbox-text").val($(this).text());
                        $combo.find(".textbox-value").val($(this).attr("value"));
                    }
                    eval(_onchange);
                });
                // 点击区域以外后，隐藏下拉框
                $(document).click(function(e) {
                    if (!e.target.className.contains("combo")) {
                        $combo.next(".dropdown:first").hide();
                    }
                });
                // 初始化宽、高、左、上

                function initSize() {
                    var _H = $combo.height() + 2,
                        _W = $combo.width() + 2;
                    $combo.find(".textbox-text").width(_W - 28);
                    $dropdown.css({
                        width: _W,
                        left: Math.round($combo.offset().left - $(document.body).scrollLeft()),
                        top: Math.round($combo.offset().top) + _H - $(document.body).scrollTop()
                    });
                    $dropdown_body.css({
                        width: _W - 2,
                        height: 220
                    });
                }
                // 拉伸后重定位
                $(window).resize(function() {
                    initSize();
                });
                initSize();
            });
        }
    },
    dropdown: function(option) {
        var $this = $(this),
            $dropdown = $this.find(".content");
        $this.hover(function() {
            $this.addClass("hover");
            $dropdown.show();
        }, function() {
            $this.removeClass("hover");
            $dropdown.hide();
        });
        return $this;
    }
});
jQuery(document).ready(function($) {
    /**
     * 按钮：2014-6-10 17:36:09
     */
    $("a.btn, button.btn, input.btn").each(function() {
        var icon = $(this).attr("icon");
        var icon_text = icon ? '<span class="btn-icon ' + icon + '">&nbsp;</span>' : '',
            icon_left = icon ? " btn-icon-left" : "";
        $(this).addClass("linkbutton").html('<span class="btn-left' + icon_left + '"><span class="btn-text">' + $(this).text() + '</span>' + icon_text + '</span>');
    }).unselectable();
});