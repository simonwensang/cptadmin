package com.cpt.req;

import java.util.Date;

import lombok.Data;

@Data
public class ProjectReq {
 
    private Long id;

    private String code;

    private String name;

    private Byte report;

    private String tenderee;

    private String designer;

    private String agent;

    private String address;

    private Byte type;

    private String typeName;

    private Date tenderTime;

    private String commitUser;

    private Date commitTime;

    private Date updateTime;

    private String updateUser;

    private Byte status;

    private String projectManager;

    private String priceManager;

    private String priceOffer;

    private Long userId;

}
