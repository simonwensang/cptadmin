<!--列表页刷新（原页面刷新） -->
function reloadTable(pageListUrl) {
    var p = $(this).jqGrid('getGridParam', 'page');//获取当前页
    $('#grid_table').jqGrid('setGridParam', {
        url: pageListUrl,
        datatype: 'json',
        page: p,
    }).trigger("reloadGrid");
}

<!--列表页刷新第一页 -->
function reloadFirstTable(tabId,pageListUrl) {
    $('#'+tabId).jqGrid('setGridParam', {
        url: pageListUrl,
        datatype: 'json',
        page: 1,
    }).trigger("reloadGrid");
}

/**
 * 时间对象的格式化
 */
Date.prototype.format = function (format) {
    /*
     * format="yyyy-MM-dd hh:mm:ss";
     */
    var o = {
        "M+": this.getMonth() + 1,
        "d+": this.getDate(),
        "h+": this.getHours(),
        "m+": this.getMinutes(),
        "s+": this.getSeconds(),
        "q+": Math.floor((this.getMonth() + 3) / 3),
        "S": this.getMilliseconds()
    }

    if (/(y+)/.test(format)) {
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4
            - RegExp.$1.length));
    }

    for (var k in o) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1
                ? o[k]
                : ("00" + o[k]).substr(("" + o[k]).length));
        }
    }
    return format;
}

/**
 * 模拟 confirm dialog
 * @param content
 * @param callback
 * @param params
 */
function confirmShow(content, callback, params) {
    var confirmShowModal = $('.confirm_show_modal',parent.document);
    if (confirmShowModal.length != 0) {
        confirmShowModal.remove();
    }

    $("body",parent.document).append(
        '<div class="bootbox modal fade confirm_show_modal"  role="dialog"  aria-hidden="true"></div>');
    confirmShowModal = $('.confirm_show_modal',parent.document);
    confirmShowModal.append(
        '<div class="modal-dialog" style="padding-top: 15%"><div class="modal-content confirm_show"></div></div>')
    var confirmShow = $('.confirm_show',parent.document);
    confirmShow.append(
        '<div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-label="Close" aria-hidden="true" style="font-size: 14px">×</button><h5 class="modal-title">提示</h5></div>');
    confirmShow.append('<div class="modal-body" style="height: 50%">' + content + '</div>');
    confirmShow.append(
        '<div class="modal-footer" style="background-color:#FFFFFF"><button class="btn" id="cancelBtn" data-dismiss="modal" aria-hidden="true">取消</button><button class="btn btn-primary confirm_show_btn" data-dismiss="modal">确认</button></div>');

    $("body",parent.document).append('<div class="modal-backdrop fade in"></div>');

    $('#cancelBtn,.close',parent.document).click(function(){
        confirmShowModal.remove();
        if($('.modal-backdrop',parent.document).length != 0){
            $('.modal-backdrop',parent.document).remove();
        }
    });

    $('.confirm_show_btn',parent.document).click(function () {
        $('.in',parent.document).fadeOut(400, function () {
            $('.in',parent.document).hide();
        });
        confirmShowModal.remove();
        if (callback) {
            callback(params);
        }
        if ($('.modal-backdrop',parent.document).length != 0) {
            $('.modal-backdrop',parent.document).remove();
        }
    });

    confirmShowModal.modal({keyboard: false, backdrop: false, show: true});
}

/**
 * 此弹出框确定之后会，后面跟的方法callback为：关闭此tab，打开需要的tab
 * @param content
 * @param callback
 * @param params
 */
function alertCallbackShow(content, callback, params) {
    var confirmShowModal = $('.confirm_show_modal',parent.document);
    if (confirmShowModal.length != 0) {
        confirmShowModal.remove();
    }

    $("body",parent.document).append(
        '<div class="bootbox modal fade confirm_show_modal"  role="dialog"  aria-hidden="true"></div>');
    confirmShowModal = $('.confirm_show_modal',parent.document);
    confirmShowModal.append(
        '<div class="modal-dialog" style="padding-top: 15%"><div class="modal-content confirm_show"></div></div>')
    var confirmShow = $('.confirm_show',parent.document);
    confirmShow.append(
        '<div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-label="Close" aria-hidden="true" style="font-size: 14px">×</button><h5 class="modal-title">提示</h5></div>');
    confirmShow.append('<div class="modal-body" style="height: 50%">' + content + '</div>');
    confirmShow.append(
        '<div class="modal-footer" style="background-color:#FFFFFF"><button class="btn btn-primary confirm_show_btn" data-dismiss="modal">确认</button></div>');

    $("body",parent.document).append('<div class="modal-backdrop fade in modal_div_js"></div>');

    $('#cancelBtn,.close',parent.document).click(function(){
        confirmShowModal.remove();
        if($('.modal-backdrop',parent.document).length != 0){
            $('.modal-backdrop',parent.document).remove();
        }
    });

    $('.confirm_show_btn',parent.document).click(function () {
        $('.modal_div_js',parent.document).fadeOut(400, function () {
            $('.modal_div_js',parent.document).hide();
        });
        confirmShowModal.remove();

        if ($('.modal-backdrop',parent.document).length != 0) {
            $('.modal-backdrop',parent.document).remove();
        }

        if (callback) {
            callback(params);
        }
    });

    confirmShowModal.modal({keyboard: false, backdrop: false, show: true});
}

/**
 * 此弹出框确定之后会，后面跟的方法callback为：关闭此tab，打开需要的tab
 * @param content
 * @param callback
 * @param params
 */
function confirmCallbackShow(content, callback, params) {
    var confirmShowModal = $('.confirm_show_modal',parent.document);
    if (confirmShowModal.length != 0) {
        confirmShowModal.remove();
    }

    $("body",parent.document).append(
        '<div class="bootbox modal fade confirm_show_modal"  role="dialog"  aria-hidden="true"></div>');
    confirmShowModal = $('.confirm_show_modal',parent.document);
    confirmShowModal.append(
        '<div class="modal-dialog" style="padding-top: 15%"><div class="modal-content confirm_show"></div></div>')
    var confirmShow = $('.confirm_show',parent.document);
    confirmShow.append(
        '<div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-label="Close" aria-hidden="true" style="font-size: 14px">×</button><h5 class="modal-title">确认</h5></div>');
    confirmShow.append('<div class="modal-body" style="height: 50%">' + content + '</div>');
    confirmShow.append(
        '<div class="modal-footer" style="background-color:#FFFFFF"><button class="btn" id="cancelBtn" data-dismiss="modal" aria-hidden="true">取消</button><button class="btn btn-primary confirm_show_btn" data-dismiss="modal">确认</button></div>');
    $("body",parent.document).append('<div class="modal-backdrop fade in modal_div_js"></div>');

    $('#cancelBtn,.close',parent.document).click(function(){
        confirmShowModal.remove();
        if($('.modal-backdrop',parent.document).length != 0){
            $('.modal-backdrop',parent.document).remove();
        }
    });

    $('.confirm_show_btn',parent.document).click(function () {
        $('.modal_div_js',parent.document).fadeOut(400, function () {
            $('.modal_div_js',parent.document).hide();
        });
        confirmShowModal.remove();

        if ($('.modal-backdrop',parent.document).length != 0) {
            $('.modal-backdrop',parent.document).remove();
        }

        if (callback) {
            callback(params);
        }
    });

    confirmShowModal.modal({keyboard: false, backdrop: false, show: true});
}



/**
 * 模拟 confirm dialog，弹框之上还有弹框的情况调用此方法
 * @param content
 * @param callback
 * @param params
 */
function confirmShows(content, callback, params) {
    var confirmShowModal = $('.confirm_show_modal',parent.document);
    if (confirmShowModal.length != 0) {
        confirmShowModal.modal('hide');
        confirmShowModal.remove();
    }

    $("body",parent.document).append(
        '<div class="bootbox modal fade confirm_show_modal"  role="dialog"  aria-hidden="true"></div>');
    confirmShowModal = $('.confirm_show_modal',parent.document);
    confirmShowModal.append(
        '<div class="modal-dialog" style="padding-top: 15%"><div class="modal-content confirm_show"></div></div>')
    var confirmShow = $('.confirm_show',parent.document);
    confirmShow.append(
        '<div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-label="Close" aria-hidden="true" style="font-size: 14px">×</button><h5 class="modal-title">提示</h5></div>');
    confirmShow.append('<div class="modal-body" style="height: 50%">' + content + '</div>');
    confirmShow.append(
        '<div class="modal-footer" style="background-color:#FFFFFF"><button class="btn" id="cancelBtn" data-dismiss="modal" aria-hidden="true">取消</button><button class="btn btn-primary confirm_show_btn" data-dismiss="modal">确认</button></div>');

    $("body",parent.document).append('<div class="modal-backdrop fade in modal_div_js"></div>');

    $('#cancelBtn,.close',parent.document).click(function(){
        confirmShowModal.remove();
        if($('.modal-backdrop',parent.document).length != 0){
            $('.modal-backdrop',parent.document).remove();
        }
    });

    $('.confirm_show_btn',parent.document).click(function () {
        confirmShowModal.remove();
        if (callback) {
            callback(params);
        }
        if ($('.modal-backdrop',parent.document).length != 0) {
            $('.modal-backdrop',parent.document).remove();
        }
    });

    confirmShowModal.modal({keyboard: false,backdrop:false,show:true});

}

/**
 * 模拟 alert dialog
 * @param content
 * @param callback
 * @param params
 */
function alertShow(content, callback, params) {
    var alertShowModal = $('.alert_show_modal',parent.document);
    if (alertShowModal.length != 0) {
        alertShowModal.remove();
    }

    $("body",parent.document).append(
        '<div class="bootbox modal fade alert_show_modal"  role="dialog"  aria-hidden="true"></div>');
    alertShowModal = $('.alert_show_modal',parent.document);
    alertShowModal.append(
        '<div class="modal-dialog" style="padding-top: 15%"><div class="modal-content alert_show"></div></div>')
    var alertShow = $('.alert_show',parent.document);
    alertShow.append(
        '<div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-label="Close" aria-hidden="true" style="font-size: 14px">×</button><h5 class="modal-title">提示</h5></div>');
    alertShow.append('<div class="modal-body" style="height: 50%">' + content + '</div>');
    alertShow.append(
        '<div class="modal-footer" style="background-color:#FFFFFF"><button class="btn btn-primary alert_show_btn" data-dismiss="modal">确认</button></div>');

    $("body",parent.document).append('<div class="modal-backdrop fade in close_js"></div>');

    $('.close',parent.document).click(function(){
        alertShowModal.remove();
        if($('.modal-backdrop',parent.document).length != 0){
            $('.modal-backdrop',parent.document).remove();
        }
    });

    $('.alert_show_btn',parent.document).click(function () {
        $('.close_js',parent.document).fadeOut(400, function () {
            $('.close_js',parent.document).hide();
        });
        if (callback) {
            callback(params);
        }
        alertShowModal.remove();
        if ($('.modal-backdrop',parent.document).length != 0) {
            $('.modal-backdrop',parent.document).remove();
        }

    });

    alertShowModal.modal({keyboard: false, backdrop: false, show: true});
}

/**
 * replace icons with FontAwesome icons like above
 * 更新jqgrid表格翻页按钮图标
 * @param table
 */
function updatePagerIcons(table) {
    var replacement =
    {
        'ui-icon-seek-first' : 'ace-icon fa fa-angle-double-left bigger-140',
        'ui-icon-seek-prev' : 'ace-icon fa fa-angle-left bigger-140',
        'ui-icon-seek-next' : 'ace-icon fa fa-angle-right bigger-140',
        'ui-icon-seek-end' : 'ace-icon fa fa-angle-double-right bigger-140'
    };
    $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
        var icon = $(this);
        var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

        if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
    })
}

function errorPlacement(error, element){
    if (element.is('input[type=checkbox]') || element.is('input[type=radio]')) {
        var controls = element.closest('div[class*="col-"]');
        if (controls.find(':checkbox,:radio').length > 1) controls.append(error);
        else error.insertAfter(element.nextAll('.lbl:eq(0)').eq(0));
    }
    else if (element.is('.select2')) {
        error.insertAfter(element.siblings('[class*="select2-container"]:eq(0)'));
    }
    else if (element.is('.chosen-select')) {
        error.insertAfter(element.siblings('[class*="chosen-container"]:eq(0)'));
    }
    else error.insertAfter(element.parent());
}

/*
 *jgfrom查询
 * grid:table id
 * form:form id
 * */

var search = function (options) {
    var jqg = $('#' + options.grid);
    var form = $('#' + options.form);
    jqg.jqGrid('setGridParam', {
        postData: getFormJson(form),
        page: 1
    }).trigger("reloadGrid");
};

/*获取form数组*/
// 如：{Name:'摘取天上星',position:'IT技术'}
// ps:注意将同名的放在一个数组里
function getFormJson(form) {
    var o = {};
    var a = $(form).serializeArray();
    $.each(a, function () {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};


/*列表中鼠标悬停具体信息事件*/
function onmouth(cellvalue, options, rowObject){
    /* return "<a href='javascript:void(0)' class='tooltip_js' title="+cellvalue+"  onmouseover='showtitle(&quot;"+cellvalue+"&quot;)'>"+cellvalue.substring(0,3)+"...</a>";*/
    var text = "";
    if(cellvalue != undefined && cellvalue != null && cellvalue.length >= 7){
        text =  cellvalue.substring(0,7)+"...</a>";
    }else if(null ==cellvalue || 	NaN == cellvalue){
        text =  "...</a>";
    }else{
        text = cellvalue+ "</a>";
    }
    return "<a href='javascript:void(0)' class='tooltip_js' title="+cellvalue+" >"+text


};


/*列表中渲染图片*/
function showImg(cellvalue, options, rowObject){
    if(null != cellvalue&&"" != cellvalue){
        return "<img name='showImg_js' width='100' height='50' title="+cellvalue+" src="+cellvalue+">";
    }
    return "";

};

//格式化日期
function formatDate(cellvalue, options, cell) {
    if (!cellvalue) {
        return "-";
    }
    var d = new Date(cellvalue);
    return d.format('yyyy-MM-dd hh:mm:ss');
}

function formatImage(cellvalue, options, cell) {
    if (!cellvalue) {
        return "-";
    }
	return "<span class='imgmove'><img src='"+cellvalue+"' style='width:100px;height:75px' onmouseover='zoompic(this)' onmouseout='zoompic1()'></span>";
}

$(function(){
    //textare 提示
    $('textarea.limited').inputlimiter({remText: '还可以输入 %n 字符...',limitText: '最多可输入,%n.'});
});

function zoompic(t){
    var imgsrc = t.src;
    $(".imgpreview0 img").attr("src",imgsrc);
    $(".imgpreview0").show()
}
function zoompic1(){
    $(".imgpreview0").hide();
}

//ifram自适应高度
function changeFrameHeight() {
    var height = $(document).height();
    $("iframe[name='tab_iframe']").each(function (i) {
        $(this).height(height );
    });
    $("iframe[name='tab_iframe']", parent.document).each(function (i) {
        $(this).height(height);
    });
};



window.onresize = function () {
    changeFrameHeight();
};



$(function(){
    //iframe自适应高度
    var height = $(document).height();
    $("iframe[name='tab_iframe']").each(function (i) {
        $(this).height(height );
    });
    $("iframe[name='tab_iframe']", parent.document).each(function (i) {
        $(this).height(height);
    });
})