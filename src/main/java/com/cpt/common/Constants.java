package com.cpt.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:harding
 * Date:2016/10/26 13:58
 * Description:
 */
public class Constants {

    /*删除状态*/
    public static final Integer DELETE = 0;//未删除
    public static final Integer DELETED = 1;//已删除


    public static final Integer DICTTYPEIDDEGREE = 1;//数据字典


    /*系统日志 常量*/
    public static class LogTheme {
        //方法类型
        public static final Integer METHOD_TYPE_ONE = 1;//记录正常日志方法
        public static final Integer METHOD_TYPE_TWO = 2;//记录异常日志方法

    }

    /*完成状态*/
    public static final Integer STEP_STATUS_FINISH = 1;//完成
    public static final Integer STEP_STATUS_UNFINISHED = -1;//未完成

    /*上下线状态*/
    public static final Integer OPEN_STATUS_UP = 1;//上线
    public static final Integer OPEN_STATUS_DOWN = 0;//下线
    /*上下线状态*/
    public static final Integer IS_ONLINE = 1;//上线
    public static final Integer IS_OFFLINE = -1;//下线
    /*是否冻结*/
    public static final Integer IS_LOCK_YES = 1;//是
    public static final Integer IS_LOCK_NO = 0;//否

    /*是否支付节点*/
    public static final Integer IS_PAY = 1;//是
    public static final Integer IS_PAY_NO = 0;//否

    /*是否结算节点*/
    public static final Integer IS_SETTLEMENT = 1;//是
    public static final Integer IS_SETTLEMENT_NO = 0;//否

    /*是否提醒节点*/
    public static final Integer IS_ALERT = 1;//是
    public static final Integer IS_ALERT_NO = 0;//否

    /*是否验收节点*/
    public static final Integer IS_ACCEPT = 1;//是
    public static final Integer IS_ACCEPT_NO = 0;//否

    /*收费完成度，比例*/
    public static final Integer ONE_HUNDRED = 100;

    /*模板支付比例总额不为100%*/
    public static final Integer NO_ONE_HUNDRED_PAY = -2;
    /*结算比例总额不为100%*/
    public static final Integer NO_ONE_HUNDRED_SET = -3;
    /*审核状态*/
    public static final Integer STATUS_DRAFT = 1;//草稿
    public static final Integer STATUS_REBUT = 2;//驳回
    public static final Integer STATUS_REVIEW_PASS = 3;//审核通过
    public static final Integer STATUS_NO_REVIEW = 4;//未审核

    /*jz_opt_log中的opt_type 业务日志数据字典*/
    public static final String SERVICE_LOG_TYPE_CASE = "case";//方案
    public static final String SERVICE_LOG_TYPE_DESIGNER = "designer";//设计师
    public static final String SERVICE_LOG_TYPE_COMPANY = "company";//公司
    public static final String SERVICE_LOG_TYPE_MANAGER = "manager";//项目经理
    public static final String SERVICE_LOG_TYPE_SUB_MATERIAL = "subMaterial";//辅材
    public static final String SERVICE_LOG_TYPE_REBUT_STR = "审核驳回";
    public static final String SERVICE_LOG_TYPE_PASS_STR = "审核通过";
    public static final String SERVICE_LOG_TYPE_LEVEL_STR = "调整等级";
    public static final String SERVICE_LOG_TYPE_ISNOTWORKING_STR = "下线";
    public static final String SERVICE_LOG_TYPE_ISWORKING_STR = "上线";
    public static final String SERVICE_LOG_TYPE_ISLOCK_STR = "冻结";
    public static final String SERVICE_LOG_TYPE_ISNOTLOCK_STR = "取消冻结";
    /*controller 层返回弹出的信息*/
    public static final String IS_NOT_WAIT_REVIEW = "待审核状态才能操作！";
    
    /*查询语句中标的别名*/
    public static final String DESIGNER_TABLE_SPOT = "d.";

    /*上海市  市code*/
    public static final String CITY_CODE_SHANGHAI = "310100";

    /*国家地区表 区域level*/
    public static final Integer NATION_REGION_LEVEL_NATION = 0;
    public static final Integer NATION_REGION_LEVEL_PROVINCE = 1;
    public static final Integer NATION_REGION_LEVEL_CITY = 2;
    public static final Integer NATION_REGION_LEVEL_DISTRICT = 3;

    //常用数据字典配置
    public static final int HOUSE_TYPE = 70;//房屋类型
    public static final int DECORATION_TYPE = 67;//装修类型
    public static final int DESIGNER_BUDGET = 80;//设计预算
    public static final int DECORATION_BUDGET = 87;//装修预算
    public static final int DESIGNER_IN_TYPE = 95;//入驻类型
    public static final int DESIGN_STYLE = 13;//风格
    public static final int WORKING_HOURS = 7;//工作年限
    public static final int ASSISTANT_COUNT = 31;//助理团队人数
    public static final int EDUCATION_ID = 1;//学历
    public static final int REFERENCE_ID = 40;//参考价格
    public static final int BRAND_ID = 44;//主材品牌价格
    public static final int COMPANY_LEVEL = 96;//公司等级
    public static final int DECORATION = 80;//装修预算
    public static final int HOUSE_AREA = 2;//房屋面积
    public static final int NEXT_MAX_BOOKING = 5;//下月最大预约上限默认值
    public static final int MAX_BOOKING = 5;//当月最大预约上限默认值
    public static final int STATISTICS_TYPE_DESIGNER = 1;//数据字典统计表类型为设计师
    public static final int STATISTICS_TYPE_CASE = 2;//数据字典统计表类型为设计师
    public static final int REAL_IMAGE_TYPE = 56;//数据字典实景空间图类型
    public static final int DESIGN_TEMPLATE_STAGE = 8;//数据字典设计模板项目阶段
    public static final int DESIGN_TEMPLATE_PAY = 9;//数据字典支付次数
    public static final int DESIGN_TEMPLATE_SETTLEMENT = 10;//数据字典结算次数
    /**
     * 设计师图片类型
     */
    public static class DesignerImageType {
        /**
         * 设计师大头相片
         */
        public static final int DESIGNER_IMAGE_PHOTO = 1;
        /**
         * 封面
         */
        public static final int DESIGNER_IMAGE_COVER = 2;
    }

    /*模板 开启时如果该模板已经存在，则提示不能同时开启两个以上*/
    public static final String IS_OPEN_LOG = "【模板类型+模板名称】只能开启一个！";


    /*模板 未完成状态 不能开启 提示*/
    public static final String IS_NO_FINISH_DESIGN_TEMPLATE = "模板未保存不能开启,请先保存该模板！";



    /*默认无效模板id*/
    public static final Integer  INVALID_TEMPLATE_ID = -1;


    /*订单状态*/
    public static final Integer  ORDER_STATUS_ZERO = 0;//用户待确认
    public static final Integer  ORDER_STATUS_ONT = 1;//用户已确认
    public static final Integer  ORDER_STATUS_TWO = 2;//用户取消
    public static final Integer  ORDER_STATUS_THREE = 3;//订单关闭
    public static final Integer  ORDER_STATUS_FOUR = 4;//退款中
    public static final Integer  ORDER_STATUS_FIVE = 5;//退款成功（无效状态）

    /*主订单退款成功*/
    public static final String ORDER_STATUS_REFUND = "退款成功";

    /*主订单退款成功确认*/
    public static final String ORDER_STATUS_INVALID = "无效确认成功";//退款成功 确认

    /**
     * 公司等级对应未冻结项目经理最大上限
     */
    public enum CompanyLevelLimit {
        LEVEL_LIMIT_ONE(1, 5),
        LEVEL_LIMIT_TWO(2, 15),
        LEVEL_LIMIT_THREE(3, 50),
        LEVEL_LIMIT_FOUR(4, 100);

        private final Integer level;//等级
        private final Integer limit;//上限

        CompanyLevelLimit(Integer level, Integer limit) {
            this.level = level;
            this.limit = limit;
        }

        private final static Map<Integer, Integer> param = new HashMap<>();

        static {
            for (CompanyLevelLimit companyLevelLimit : CompanyLevelLimit.values()) {
                param.put(companyLevelLimit.getLevel(), companyLevelLimit.getLimit());
            }
        }

        public static Map<Integer, Integer> getParam() {
            return param;
        }

        public Integer getLevel() {
            return level;
        }

        public Integer getLimit() {
            return limit;
        }
    }


}
