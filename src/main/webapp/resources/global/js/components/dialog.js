jQuery.extend({
	dialog: function(option){
		var $mask = $("#mask"), $dialog = $(""), settings = {
			type: "confirm",
			content: "无内容",
			showIcon: true,
			draggable: true
		};
		$.extend(true, settings, option);
		if($mask.size() == 0){
			$mask = $('<div class="mask" style="display:none;width:2000px;height:5000px;position:absolute;left:0px;top:0px;margin:0px;padding:0px;overflow:hidden;background-color:gray;opacity:0.6;filter:alpha(opacity=60);"></div>');
			$(document.body).append($mask);
		}
		$dialog.init = function(){
			$dialog = $('<div id="dialog_confirm" class="qm_dialog">'),
				$dialog_head = $('<div class="dialog_head"><span>删除确认</span><a title="关闭" class="ico_close_d" href="javascript:;"></a></div>'),
				$dialog_inner = $('<div class="dialog_inner"></div>'),
				$dialog_content = $('<div class="dialog_content"><div class="cnfx_content"><span class="dialog_icon icon_info_b"></span><div class="dialog_f_c">彻底删除后邮件将无法恢复，您确定要删除吗？</div></div></div>'),
				$dialog_oparate = $('<div class="dialog_operate"><div class=" txt_right cnfx_btn"><a href="javascript:;" class="btn_gray confirm">确定</a><a href="javascript:;" class="btn_gray cancel">取消</a></div><div class="clr"></div></div>');
			$dialog.append($dialog_head);
			$dialog_inner.append($dialog_content).append($dialog_oparate);
			$dialog.append($dialog_inner);
			$(document.body).append($dialog);
			if(settings.draggable == true){
				$dialog.draggable({
					cursor: "move",
					containment: "document"
				});
			}
		};
		$dialog.show = function(){
			$mask.show();
			$this.show();
		};
		$dialog.close = function(){
			$mask.hide();
			$this.hide();
		};
		$dialog.init();
		return $dialog;
	}
});