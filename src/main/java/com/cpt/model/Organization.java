package com.cpt.model;

import java.math.BigDecimal;
import java.util.Date;

public class Organization {
    private Long id;

    private String name;

    private Long parentId;

    private Byte level;

    private Date createTime;

    private BigDecimal expanse;
    
    public BigDecimal getExpanse() {
		return expanse;
	}

	public void setExpanse(BigDecimal expanse) {
		this.expanse = expanse;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}