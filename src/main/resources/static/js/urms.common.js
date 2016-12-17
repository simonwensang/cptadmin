/**
 * Created by yinchun.ling on 2016/12/5.
 */

// 公用方法


//显示第一个table 页
var showIndex = function () {
    try {
        var $navtabs = $(".nav-tabs", parent.document);
        var $tabcontent = $(".tab-content", parent.document);

        $navtabs.find('li').removeClass('active');
        $tabcontent.find('div.tab-pane').removeClass('active');
        $tabcontent.find('div.tab-pane').removeClass('in');

        $navtabs.find('li').eq(0).addClass('active');//第一个 table ID
        $tabcontent.find('div').eq(0).addClass('active');//第一个 table ID
        $tabcontent.find('div').eq(0).addClass('in');//第一个 table ID
    } catch (expandNode) {
        console.log('打开第一个table 页 失败');
    }
};

//显示某个页面
var showTable = function (code) {
    console.log('显示 ID / class = ' + code + ' 的 table 页');
    try {
        var $navtabs = $(".nav-tabs", parent.document);
        var $tabcontent = $(".tab-content", parent.document);

        $navtabs.find('li').removeClass('active');
        $tabcontent.find('div.tab-pane').removeClass('active');
        $tabcontent.find('div.tab-pane').removeClass('in');

        $navtabs.find("li[name='tab_" + code + "']").addClass('active');
        $tabcontent.find("div[name='tab_" + code + "']").addClass('active');
        $tabcontent.find("div[name='tab_" + code + "']").addClass('in');
    } catch (expandNode) {
        console.log('显示 '+code+'   失败');
        showIndex();
    }
};

/**
 * 生成一个 table 页
 * @param tabObj
 * @param .idCode
 * @param .iframeUrl
 */
var addNewTabs = function (tabObj) {

    if (!tabObj) {
        alert('参数错误');
        return;
    }

    var idCode = tabObj.title,
        iframeUrl = tabObj.url;

    console.log('传入参数 idCode = ' + idCode + " , iframeUrl = " + iframeUrl);

    var htmIframe = '<iframe name="tab_iframe" class="iframe-page" ' +
        'src="' + iframeUrl + '" frameborder="0" scrolling="yes" style="width:100%;height:' +
        ($(document).height()) +
        'px;"></iframe>';

    try {
        $("div.work-space-active").removeAttr('style');
    } catch (expandNode) {
    }

    var $navtabs = $(".nav-tabs", parent.document);
    var $tabcontent = $(".tab-content", parent.document);

    var navTabLi = $navtabs.find('li').length;

    //已存在
    if ($navtabs.find('li').find('a[href="#tab_' + idCode + '"]').length != 0) {
        $navtabs.find("li[name='tab_" + idCode + "']").off().remove();
        $tabcontent.find("div[name='tab_" + idCode + "']").off().remove();
    }
    ;

    if (navTabLi > 8) {
        var showId = $navtabs.find('li').eq((navTabLi - 1)).attr('name');//前面一个 table ID
        showId = showId.substring(4);
        $navtabs.find('li.tab_' + showId).off().remove();
        $tabcontent.find('div#tab_' + showId).off().remove();
    }
    
    var tabHead = '<li name="tab_' + idCode + '">' +
        '<a href="#tab_' + idCode + '" data-toggle="tab">' + idCode +
        '&nbsp;&nbsp;<span style="display: inline-block;" closeid="' + idCode +
        '" class="glyphicon glyphicon-remove"></span>' +
        '</a>' +
        '</li>';
    var tabHtml = '<div class="tab-pane fade" id="tab_' + idCode + '" name="tab_' + idCode + '">' +
        htmIframe +
        '</div>';
    $navtabs.append(tabHead);
    $tabcontent.append(tabHtml);
    showTable(idCode);//显示某页
};

var closeIframeTab = function (idCode, showCode) {
    console.log("closeIframeTab() :  idCode = " + idCode);
    var $navtabs = $(".nav-tabs", parent.document);
    var $tabcontent = $(".tab-content", parent.document);

    //如果 showCode 不为空，则打开 showCode table页
    if (!!showCode) {
        showTable(showCode);//显示某页
    } else {
        var showId = $navtabs.find("li[name='tab_" + idCode + "']").prev().attr('name');//前面一个 table ID
        if (!showId) {
            showIndex();
        } else {
            showId = showId.substring(4);
        }

        showTable(showId);//显示某页
    }
    ;

    $navtabs.find("li[name='tab_" + idCode + "']").off().remove();
    $tabcontent.find("div[name='tab_" + idCode + "']").off().remove();
};



$(function () {

    $(".nav-tabs").on("click", "[closeid]", function (e) {
        id = $(this).attr("closeid");
        closeIframeTab(id);
    });

});