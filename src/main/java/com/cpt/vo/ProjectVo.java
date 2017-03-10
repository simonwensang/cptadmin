package com.cpt.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ProjectVo {
    private Long id;

    private String code;

    private String name;

    private String report;

    private String tenderee;

    private String designer;

    private String agent;

    private String address;

    private Byte type;

    private String typeName;

    private String tenderTime;

    private String commitUser;

    private Long commitUserId;

    private Date commitTime;

    private Date updateTime;

    private String updateUser;

    private Long updateUserId;

    private Byte status;

    private String projectManager;

    private Long projectManagerId;

    private Date projectManagerTime;

    private String priceManager;

    private Long priceManagerId;

    private Date priceManagerTime;

    private String priceOffer;

    private Long priceOfferId;

    private Date priceOfferTime;
    
    private List<Byte> authority;
 
    private List<ProjectPriceVo> projectPriceList;
    
    //("是否显示指定项目负责人")
	private Boolean showSelectProjectManager=false;
	//("是否显示选择报价负责人")
	private Boolean showSelectPriceManager=false;
	//("是否显示管理报价人")
	private Boolean showSelectPriceOffer=false;
	//("是否显示报价")
	private Boolean showPriceOffer=false;
	//("是否显示项目管理")
	private Boolean showProjectManager=false;
	//("是否显示查看明细")
	private Boolean showDetail=false;
	//("是否显示删除")
	private Boolean showDelete=false;
}
