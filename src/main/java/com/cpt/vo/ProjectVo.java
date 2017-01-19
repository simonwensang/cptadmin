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
 
    private List<ProjectPriceVo> projectPriceList;
    
}
