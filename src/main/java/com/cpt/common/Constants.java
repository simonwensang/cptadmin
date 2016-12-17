package com.cpt.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * web常量
 */
public abstract class Constants {
	// UTF-8编码
	public static final String UTF8 = "UTF-8";

	// 路径分隔符
	public static final String SPT = "/";

	// 前台访问路径
	public static final String FRONT_PTH = "/front";

	// 后台访问路径
	public static final String ADMIN_PTH = "/ssadmin";

	public static final String LEFTFRAME_PTH = "/left";

	public static final String RIGHTFRAME_PTH = "/right";

	public static final String PRE_PTH = "/pre";

	// HTTP POST请求
	public static final String POST = "POST";
	// HTTP GET请求
	public static final String GET = "GET";
	// HTTP PUT请求
	public static final String PUT = "PUT";
	// HTTP DELETE请求
	public static final String DELETE = "DELETE";

	// salt用于加密
	public static final String SALT = "winwho.com";

	/**
	 * cookie中的JSESSIONID名称
	 */
	public static final String JSESSION_COOKIE = "JSESSIONID";

	// 认证
	//public static final String RELOGINSESSION = "shiro-reloginsession";
	// 认证
	public static final String AUTHENTICATIONCACHENAME = "shiro-authenticationCacheName";
	// 授权
	public static final String AUTHORIZATIONCACHENAME = "shiro-authorizationCacheName";

	/**
	 * 默认验证码参数名称
	 */
	public static final String DEFAULT_CAPTCHA_PARAM = "captcha";

	/**
	 * 登录次数超出allowLoginNum时，存储在session记录是否展示验证码的key默认名称
	 */
	public static final String DEFAULT_SHOW_CAPTCHA_KEY_ATTRIBUTE = "showCaptcha";

	/**
	 * 默认在session中存储的登录次数名称
	 */
	public static final String DEFAULT_LOGIN_NUM_KEY_ATTRIBUTE = "loginNum";
	// 允许登录次数，当登录次数大于该数值时，会在页面中显示验证码
	public static final Integer allowLoginNum = 1;

	// 默认当前页码
	public static final int DEFAULT_PAGENO = 1;

	// 默认分页大小
	public static final int DEFAULT_PAGESIZE = 20;
	
	
	// 日期格式
	public static final DateFormat DF_MILLI = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss SSSS");
	public static final DateFormat DF_LONG = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final DateFormat DF_SHORT = new SimpleDateFormat("yyyy-MM-dd");
	public static final DateFormat DF_YEAR = new SimpleDateFormat("yyyy");
	public static final DateFormat DF_MONTH = new SimpleDateFormat("yyyy-MM");

	public static final int LONG_DATE = 19;
	/**
	 * 短类型日期长度
	 */
	public static final int SHORT_DATE = 10;
	
	public static final int YEAR_DATE = 4;
	
	public static final int MONTH_DATE = 7;
	
	public static final String[] allowUploadImgSuff = {"jpg","jpeg","gif"};
	public static final Long allowUploadLogoSize = 3145728L  ;  //3*1024*1024 b
	public static final Long allowUploaddivSize =  5242880L ;  //5*1024*1024b
	
	

	public static final String CONFIG_GRADE             = "grade";    //初始等级1
	public static final String CONFIG_INITBEAN          = "initbean";    //初始winbean(X1000)
	public static final String CONFIG_INITCOIN          = "initcoin";    //初始wincoin(X1000)
	public static final String CONFIG_AWARDBRAND        = "awardBrand";    //代言排行第1名
	public static final String CONFIG_AWARDCHARITY      = "awardCharity";    //公益排行第1名
	public static final String CONFIG_AWARDTREASURE     = "awardTreasure";    //财富排行第1名
	public static final String CONFIG_BIZWINDOWCOSTBEAN = "bizWindowCostBean";    //点亮商业橱窗每次需要花费50winbean
	public static final String CONFIG_WINDOWBIZ         = "windowbiz";    //橱窗大类
	public static final String CONFIG_USERTYPE          = "userType";    //用户类型
	public static final String CONFIG_BANKNAME          = "bankName";    //银行
	public static final String CONFIG_TRYLUCKY          = "tryLucky";    //试试手气扣除win豆
	public static final String CONFIG_REFAWARDCOIN      = "refAwardCoin";    //推荐人奖励win币
	public static final String CONFIG_TASKAWARDBEAN     = "taskAwardBean";   //推荐好友任务完成奖励win豆(X1000)
	public static final String CONFIG_MAXSIGNUPDAYS     = "maxSignupDays";   //成长最大有效天数
	public static final String CONFIG_LIGHTUPMAXWINDOW     = "lightUpMaxWindow";   //可点亮最大橱窗总数
	public static final String CONFIG_BIZLIGHTUPHOLDTIME     = "bizLightUpHoldTime";   //可点亮最大橱窗总数
	public static final String CONFIG_BIZLIGHTUPCOSTWINBEAN     = "bizLightUpCostWinbean";   //商业橱窗点亮消耗win豆
	public static final String CONFIG_MINCONVERTWINCOIN     = "minConvertWinCoin";   //提现最低单位
	public static final String CONFIG_INVITESMS     = "inviteSms";   //提现最低单位
	public static final String CONFIG_INVITEWEIXIN     = "inviteWeixin";   //提现最低单位
	public static final String CONFIG_UPDATETIMER     = "updateTimer";   //广告更新基准时间（单位：分钟）
	public static final String CONFIG_UPDATEOFFSET     = "updateOffset";   //广告更新浮动时间（单位：分钟）
	
	//MSG DOMAIN
	/**
	 * 消息类型:系统消息
	 */
	public static final String MSG_SYSTEM = "msgSystem";
	/**
	 * 消息类型:任务消息
	 */
	public static final String MSG_TASK ="msgTask";
	/**
	 * 消息类型:好友消息
	 */
	public static final String MSG_FRIENDS = "msgFriends" ;
	/**
	 * 消息类型:广场消息
	 */
	public static final String MSG_SQUARE = "msgSquare";
	/**
	 * 消息类型:锁屏引导消息
	 */
	public static final String MSG_NAV = "msgNav";
	
	
	
	
	//用户角色
	public static final String ROLE_ADMIN = "admin";
	
	

}
