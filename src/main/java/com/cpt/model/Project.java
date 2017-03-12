package com.cpt.model;

import java.util.Date;

public class Project {
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

    private String reason;

    private Boolean isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report == null ? null : report.trim();
    }

    public String getTenderee() {
        return tenderee;
    }

    public void setTenderee(String tenderee) {
        this.tenderee = tenderee == null ? null : tenderee.trim();
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer == null ? null : designer.trim();
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent == null ? null : agent.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public String getTenderTime() {
        return tenderTime;
    }

    public void setTenderTime(String tenderTime) {
        this.tenderTime = tenderTime == null ? null : tenderTime.trim();
    }

    public String getCommitUser() {
        return commitUser;
    }

    public void setCommitUser(String commitUser) {
        this.commitUser = commitUser == null ? null : commitUser.trim();
    }

    public Long getCommitUserId() {
        return commitUserId;
    }

    public void setCommitUserId(Long commitUserId) {
        this.commitUserId = commitUserId;
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager == null ? null : projectManager.trim();
    }

    public Long getProjectManagerId() {
        return projectManagerId;
    }

    public void setProjectManagerId(Long projectManagerId) {
        this.projectManagerId = projectManagerId;
    }

    public Date getProjectManagerTime() {
        return projectManagerTime;
    }

    public void setProjectManagerTime(Date projectManagerTime) {
        this.projectManagerTime = projectManagerTime;
    }

    public String getPriceManager() {
        return priceManager;
    }

    public void setPriceManager(String priceManager) {
        this.priceManager = priceManager == null ? null : priceManager.trim();
    }

    public Long getPriceManagerId() {
        return priceManagerId;
    }

    public void setPriceManagerId(Long priceManagerId) {
        this.priceManagerId = priceManagerId;
    }

    public Date getPriceManagerTime() {
        return priceManagerTime;
    }

    public void setPriceManagerTime(Date priceManagerTime) {
        this.priceManagerTime = priceManagerTime;
    }

    public String getPriceOffer() {
        return priceOffer;
    }

    public void setPriceOffer(String priceOffer) {
        this.priceOffer = priceOffer == null ? null : priceOffer.trim();
    }

    public Long getPriceOfferId() {
        return priceOfferId;
    }

    public void setPriceOfferId(Long priceOfferId) {
        this.priceOfferId = priceOfferId;
    }

    public Date getPriceOfferTime() {
        return priceOfferTime;
    }

    public void setPriceOfferTime(Date priceOfferTime) {
        this.priceOfferTime = priceOfferTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}