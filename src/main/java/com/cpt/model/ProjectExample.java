package com.cpt.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProjectExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andReportIsNull() {
            addCriterion("report is null");
            return (Criteria) this;
        }

        public Criteria andReportIsNotNull() {
            addCriterion("report is not null");
            return (Criteria) this;
        }

        public Criteria andReportEqualTo(String value) {
            addCriterion("report =", value, "report");
            return (Criteria) this;
        }

        public Criteria andReportNotEqualTo(String value) {
            addCriterion("report <>", value, "report");
            return (Criteria) this;
        }

        public Criteria andReportGreaterThan(String value) {
            addCriterion("report >", value, "report");
            return (Criteria) this;
        }

        public Criteria andReportGreaterThanOrEqualTo(String value) {
            addCriterion("report >=", value, "report");
            return (Criteria) this;
        }

        public Criteria andReportLessThan(String value) {
            addCriterion("report <", value, "report");
            return (Criteria) this;
        }

        public Criteria andReportLessThanOrEqualTo(String value) {
            addCriterion("report <=", value, "report");
            return (Criteria) this;
        }

        public Criteria andReportLike(String value) {
            addCriterion("report like", value, "report");
            return (Criteria) this;
        }

        public Criteria andReportNotLike(String value) {
            addCriterion("report not like", value, "report");
            return (Criteria) this;
        }

        public Criteria andReportIn(List<String> values) {
            addCriterion("report in", values, "report");
            return (Criteria) this;
        }

        public Criteria andReportNotIn(List<String> values) {
            addCriterion("report not in", values, "report");
            return (Criteria) this;
        }

        public Criteria andReportBetween(String value1, String value2) {
            addCriterion("report between", value1, value2, "report");
            return (Criteria) this;
        }

        public Criteria andReportNotBetween(String value1, String value2) {
            addCriterion("report not between", value1, value2, "report");
            return (Criteria) this;
        }

        public Criteria andTendereeIsNull() {
            addCriterion("tenderee is null");
            return (Criteria) this;
        }

        public Criteria andTendereeIsNotNull() {
            addCriterion("tenderee is not null");
            return (Criteria) this;
        }

        public Criteria andTendereeEqualTo(String value) {
            addCriterion("tenderee =", value, "tenderee");
            return (Criteria) this;
        }

        public Criteria andTendereeNotEqualTo(String value) {
            addCriterion("tenderee <>", value, "tenderee");
            return (Criteria) this;
        }

        public Criteria andTendereeGreaterThan(String value) {
            addCriterion("tenderee >", value, "tenderee");
            return (Criteria) this;
        }

        public Criteria andTendereeGreaterThanOrEqualTo(String value) {
            addCriterion("tenderee >=", value, "tenderee");
            return (Criteria) this;
        }

        public Criteria andTendereeLessThan(String value) {
            addCriterion("tenderee <", value, "tenderee");
            return (Criteria) this;
        }

        public Criteria andTendereeLessThanOrEqualTo(String value) {
            addCriterion("tenderee <=", value, "tenderee");
            return (Criteria) this;
        }

        public Criteria andTendereeLike(String value) {
            addCriterion("tenderee like", value, "tenderee");
            return (Criteria) this;
        }

        public Criteria andTendereeNotLike(String value) {
            addCriterion("tenderee not like", value, "tenderee");
            return (Criteria) this;
        }

        public Criteria andTendereeIn(List<String> values) {
            addCriterion("tenderee in", values, "tenderee");
            return (Criteria) this;
        }

        public Criteria andTendereeNotIn(List<String> values) {
            addCriterion("tenderee not in", values, "tenderee");
            return (Criteria) this;
        }

        public Criteria andTendereeBetween(String value1, String value2) {
            addCriterion("tenderee between", value1, value2, "tenderee");
            return (Criteria) this;
        }

        public Criteria andTendereeNotBetween(String value1, String value2) {
            addCriterion("tenderee not between", value1, value2, "tenderee");
            return (Criteria) this;
        }

        public Criteria andDesignerIsNull() {
            addCriterion("designer is null");
            return (Criteria) this;
        }

        public Criteria andDesignerIsNotNull() {
            addCriterion("designer is not null");
            return (Criteria) this;
        }

        public Criteria andDesignerEqualTo(String value) {
            addCriterion("designer =", value, "designer");
            return (Criteria) this;
        }

        public Criteria andDesignerNotEqualTo(String value) {
            addCriterion("designer <>", value, "designer");
            return (Criteria) this;
        }

        public Criteria andDesignerGreaterThan(String value) {
            addCriterion("designer >", value, "designer");
            return (Criteria) this;
        }

        public Criteria andDesignerGreaterThanOrEqualTo(String value) {
            addCriterion("designer >=", value, "designer");
            return (Criteria) this;
        }

        public Criteria andDesignerLessThan(String value) {
            addCriterion("designer <", value, "designer");
            return (Criteria) this;
        }

        public Criteria andDesignerLessThanOrEqualTo(String value) {
            addCriterion("designer <=", value, "designer");
            return (Criteria) this;
        }

        public Criteria andDesignerLike(String value) {
            addCriterion("designer like", value, "designer");
            return (Criteria) this;
        }

        public Criteria andDesignerNotLike(String value) {
            addCriterion("designer not like", value, "designer");
            return (Criteria) this;
        }

        public Criteria andDesignerIn(List<String> values) {
            addCriterion("designer in", values, "designer");
            return (Criteria) this;
        }

        public Criteria andDesignerNotIn(List<String> values) {
            addCriterion("designer not in", values, "designer");
            return (Criteria) this;
        }

        public Criteria andDesignerBetween(String value1, String value2) {
            addCriterion("designer between", value1, value2, "designer");
            return (Criteria) this;
        }

        public Criteria andDesignerNotBetween(String value1, String value2) {
            addCriterion("designer not between", value1, value2, "designer");
            return (Criteria) this;
        }

        public Criteria andAgentIsNull() {
            addCriterion("agent is null");
            return (Criteria) this;
        }

        public Criteria andAgentIsNotNull() {
            addCriterion("agent is not null");
            return (Criteria) this;
        }

        public Criteria andAgentEqualTo(String value) {
            addCriterion("agent =", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentNotEqualTo(String value) {
            addCriterion("agent <>", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentGreaterThan(String value) {
            addCriterion("agent >", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentGreaterThanOrEqualTo(String value) {
            addCriterion("agent >=", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentLessThan(String value) {
            addCriterion("agent <", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentLessThanOrEqualTo(String value) {
            addCriterion("agent <=", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentLike(String value) {
            addCriterion("agent like", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentNotLike(String value) {
            addCriterion("agent not like", value, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentIn(List<String> values) {
            addCriterion("agent in", values, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentNotIn(List<String> values) {
            addCriterion("agent not in", values, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentBetween(String value1, String value2) {
            addCriterion("agent between", value1, value2, "agent");
            return (Criteria) this;
        }

        public Criteria andAgentNotBetween(String value1, String value2) {
            addCriterion("agent not between", value1, value2, "agent");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Byte value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Byte value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Byte value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Byte value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Byte value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Byte> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Byte> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Byte value1, Byte value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNull() {
            addCriterion("type_name is null");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNotNull() {
            addCriterion("type_name is not null");
            return (Criteria) this;
        }

        public Criteria andTypeNameEqualTo(String value) {
            addCriterion("type_name =", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotEqualTo(String value) {
            addCriterion("type_name <>", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThan(String value) {
            addCriterion("type_name >", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("type_name >=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThan(String value) {
            addCriterion("type_name <", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThanOrEqualTo(String value) {
            addCriterion("type_name <=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLike(String value) {
            addCriterion("type_name like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotLike(String value) {
            addCriterion("type_name not like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameIn(List<String> values) {
            addCriterion("type_name in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotIn(List<String> values) {
            addCriterion("type_name not in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameBetween(String value1, String value2) {
            addCriterion("type_name between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotBetween(String value1, String value2) {
            addCriterion("type_name not between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTenderTimeIsNull() {
            addCriterion("tender_time is null");
            return (Criteria) this;
        }

        public Criteria andTenderTimeIsNotNull() {
            addCriterion("tender_time is not null");
            return (Criteria) this;
        }

        public Criteria andTenderTimeEqualTo(String value) {
            addCriterion("tender_time =", value, "tenderTime");
            return (Criteria) this;
        }

        public Criteria andTenderTimeNotEqualTo(String value) {
            addCriterion("tender_time <>", value, "tenderTime");
            return (Criteria) this;
        }

        public Criteria andTenderTimeGreaterThan(String value) {
            addCriterion("tender_time >", value, "tenderTime");
            return (Criteria) this;
        }

        public Criteria andTenderTimeGreaterThanOrEqualTo(String value) {
            addCriterion("tender_time >=", value, "tenderTime");
            return (Criteria) this;
        }

        public Criteria andTenderTimeLessThan(String value) {
            addCriterion("tender_time <", value, "tenderTime");
            return (Criteria) this;
        }

        public Criteria andTenderTimeLessThanOrEqualTo(String value) {
            addCriterion("tender_time <=", value, "tenderTime");
            return (Criteria) this;
        }

        public Criteria andTenderTimeLike(String value) {
            addCriterion("tender_time like", value, "tenderTime");
            return (Criteria) this;
        }

        public Criteria andTenderTimeNotLike(String value) {
            addCriterion("tender_time not like", value, "tenderTime");
            return (Criteria) this;
        }

        public Criteria andTenderTimeIn(List<String> values) {
            addCriterion("tender_time in", values, "tenderTime");
            return (Criteria) this;
        }

        public Criteria andTenderTimeNotIn(List<String> values) {
            addCriterion("tender_time not in", values, "tenderTime");
            return (Criteria) this;
        }

        public Criteria andTenderTimeBetween(String value1, String value2) {
            addCriterion("tender_time between", value1, value2, "tenderTime");
            return (Criteria) this;
        }

        public Criteria andTenderTimeNotBetween(String value1, String value2) {
            addCriterion("tender_time not between", value1, value2, "tenderTime");
            return (Criteria) this;
        }

        public Criteria andCommitUserIsNull() {
            addCriterion("commit_user is null");
            return (Criteria) this;
        }

        public Criteria andCommitUserIsNotNull() {
            addCriterion("commit_user is not null");
            return (Criteria) this;
        }

        public Criteria andCommitUserEqualTo(String value) {
            addCriterion("commit_user =", value, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserNotEqualTo(String value) {
            addCriterion("commit_user <>", value, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserGreaterThan(String value) {
            addCriterion("commit_user >", value, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserGreaterThanOrEqualTo(String value) {
            addCriterion("commit_user >=", value, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserLessThan(String value) {
            addCriterion("commit_user <", value, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserLessThanOrEqualTo(String value) {
            addCriterion("commit_user <=", value, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserLike(String value) {
            addCriterion("commit_user like", value, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserNotLike(String value) {
            addCriterion("commit_user not like", value, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserIn(List<String> values) {
            addCriterion("commit_user in", values, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserNotIn(List<String> values) {
            addCriterion("commit_user not in", values, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserBetween(String value1, String value2) {
            addCriterion("commit_user between", value1, value2, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserNotBetween(String value1, String value2) {
            addCriterion("commit_user not between", value1, value2, "commitUser");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdIsNull() {
            addCriterion("commit_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdIsNotNull() {
            addCriterion("commit_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdEqualTo(Long value) {
            addCriterion("commit_user_id =", value, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdNotEqualTo(Long value) {
            addCriterion("commit_user_id <>", value, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdGreaterThan(Long value) {
            addCriterion("commit_user_id >", value, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("commit_user_id >=", value, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdLessThan(Long value) {
            addCriterion("commit_user_id <", value, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdLessThanOrEqualTo(Long value) {
            addCriterion("commit_user_id <=", value, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdIn(List<Long> values) {
            addCriterion("commit_user_id in", values, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdNotIn(List<Long> values) {
            addCriterion("commit_user_id not in", values, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdBetween(Long value1, Long value2) {
            addCriterion("commit_user_id between", value1, value2, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdNotBetween(Long value1, Long value2) {
            addCriterion("commit_user_id not between", value1, value2, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitTimeIsNull() {
            addCriterion("commit_time is null");
            return (Criteria) this;
        }

        public Criteria andCommitTimeIsNotNull() {
            addCriterion("commit_time is not null");
            return (Criteria) this;
        }

        public Criteria andCommitTimeEqualTo(Date value) {
            addCriterion("commit_time =", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeNotEqualTo(Date value) {
            addCriterion("commit_time <>", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeGreaterThan(Date value) {
            addCriterion("commit_time >", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("commit_time >=", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeLessThan(Date value) {
            addCriterion("commit_time <", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeLessThanOrEqualTo(Date value) {
            addCriterion("commit_time <=", value, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeIn(List<Date> values) {
            addCriterion("commit_time in", values, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeNotIn(List<Date> values) {
            addCriterion("commit_time not in", values, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeBetween(Date value1, Date value2) {
            addCriterion("commit_time between", value1, value2, "commitTime");
            return (Criteria) this;
        }

        public Criteria andCommitTimeNotBetween(Date value1, Date value2) {
            addCriterion("commit_time not between", value1, value2, "commitTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNull() {
            addCriterion("update_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIsNotNull() {
            addCriterion("update_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdEqualTo(Long value) {
            addCriterion("update_user_id =", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotEqualTo(Long value) {
            addCriterion("update_user_id <>", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThan(Long value) {
            addCriterion("update_user_id >", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("update_user_id >=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThan(Long value) {
            addCriterion("update_user_id <", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdLessThanOrEqualTo(Long value) {
            addCriterion("update_user_id <=", value, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdIn(List<Long> values) {
            addCriterion("update_user_id in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotIn(List<Long> values) {
            addCriterion("update_user_id not in", values, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdBetween(Long value1, Long value2) {
            addCriterion("update_user_id between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIdNotBetween(Long value1, Long value2) {
            addCriterion("update_user_id not between", value1, value2, "updateUserId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andProjectManagerIsNull() {
            addCriterion("project_manager is null");
            return (Criteria) this;
        }

        public Criteria andProjectManagerIsNotNull() {
            addCriterion("project_manager is not null");
            return (Criteria) this;
        }

        public Criteria andProjectManagerEqualTo(String value) {
            addCriterion("project_manager =", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerNotEqualTo(String value) {
            addCriterion("project_manager <>", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerGreaterThan(String value) {
            addCriterion("project_manager >", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerGreaterThanOrEqualTo(String value) {
            addCriterion("project_manager >=", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerLessThan(String value) {
            addCriterion("project_manager <", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerLessThanOrEqualTo(String value) {
            addCriterion("project_manager <=", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerLike(String value) {
            addCriterion("project_manager like", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerNotLike(String value) {
            addCriterion("project_manager not like", value, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerIn(List<String> values) {
            addCriterion("project_manager in", values, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerNotIn(List<String> values) {
            addCriterion("project_manager not in", values, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerBetween(String value1, String value2) {
            addCriterion("project_manager between", value1, value2, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerNotBetween(String value1, String value2) {
            addCriterion("project_manager not between", value1, value2, "projectManager");
            return (Criteria) this;
        }

        public Criteria andProjectManagerIdIsNull() {
            addCriterion("project_manager_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectManagerIdIsNotNull() {
            addCriterion("project_manager_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectManagerIdEqualTo(Long value) {
            addCriterion("project_manager_id =", value, "projectManagerId");
            return (Criteria) this;
        }

        public Criteria andProjectManagerIdNotEqualTo(Long value) {
            addCriterion("project_manager_id <>", value, "projectManagerId");
            return (Criteria) this;
        }

        public Criteria andProjectManagerIdGreaterThan(Long value) {
            addCriterion("project_manager_id >", value, "projectManagerId");
            return (Criteria) this;
        }

        public Criteria andProjectManagerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("project_manager_id >=", value, "projectManagerId");
            return (Criteria) this;
        }

        public Criteria andProjectManagerIdLessThan(Long value) {
            addCriterion("project_manager_id <", value, "projectManagerId");
            return (Criteria) this;
        }

        public Criteria andProjectManagerIdLessThanOrEqualTo(Long value) {
            addCriterion("project_manager_id <=", value, "projectManagerId");
            return (Criteria) this;
        }

        public Criteria andProjectManagerIdIn(List<Long> values) {
            addCriterion("project_manager_id in", values, "projectManagerId");
            return (Criteria) this;
        }

        public Criteria andProjectManagerIdNotIn(List<Long> values) {
            addCriterion("project_manager_id not in", values, "projectManagerId");
            return (Criteria) this;
        }

        public Criteria andProjectManagerIdBetween(Long value1, Long value2) {
            addCriterion("project_manager_id between", value1, value2, "projectManagerId");
            return (Criteria) this;
        }

        public Criteria andProjectManagerIdNotBetween(Long value1, Long value2) {
            addCriterion("project_manager_id not between", value1, value2, "projectManagerId");
            return (Criteria) this;
        }

        public Criteria andProjectManagerTimeIsNull() {
            addCriterion("project_manager_time is null");
            return (Criteria) this;
        }

        public Criteria andProjectManagerTimeIsNotNull() {
            addCriterion("project_manager_time is not null");
            return (Criteria) this;
        }

        public Criteria andProjectManagerTimeEqualTo(Date value) {
            addCriterion("project_manager_time =", value, "projectManagerTime");
            return (Criteria) this;
        }

        public Criteria andProjectManagerTimeNotEqualTo(Date value) {
            addCriterion("project_manager_time <>", value, "projectManagerTime");
            return (Criteria) this;
        }

        public Criteria andProjectManagerTimeGreaterThan(Date value) {
            addCriterion("project_manager_time >", value, "projectManagerTime");
            return (Criteria) this;
        }

        public Criteria andProjectManagerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("project_manager_time >=", value, "projectManagerTime");
            return (Criteria) this;
        }

        public Criteria andProjectManagerTimeLessThan(Date value) {
            addCriterion("project_manager_time <", value, "projectManagerTime");
            return (Criteria) this;
        }

        public Criteria andProjectManagerTimeLessThanOrEqualTo(Date value) {
            addCriterion("project_manager_time <=", value, "projectManagerTime");
            return (Criteria) this;
        }

        public Criteria andProjectManagerTimeIn(List<Date> values) {
            addCriterion("project_manager_time in", values, "projectManagerTime");
            return (Criteria) this;
        }

        public Criteria andProjectManagerTimeNotIn(List<Date> values) {
            addCriterion("project_manager_time not in", values, "projectManagerTime");
            return (Criteria) this;
        }

        public Criteria andProjectManagerTimeBetween(Date value1, Date value2) {
            addCriterion("project_manager_time between", value1, value2, "projectManagerTime");
            return (Criteria) this;
        }

        public Criteria andProjectManagerTimeNotBetween(Date value1, Date value2) {
            addCriterion("project_manager_time not between", value1, value2, "projectManagerTime");
            return (Criteria) this;
        }

        public Criteria andPriceManagerIsNull() {
            addCriterion("price_manager is null");
            return (Criteria) this;
        }

        public Criteria andPriceManagerIsNotNull() {
            addCriterion("price_manager is not null");
            return (Criteria) this;
        }

        public Criteria andPriceManagerEqualTo(String value) {
            addCriterion("price_manager =", value, "priceManager");
            return (Criteria) this;
        }

        public Criteria andPriceManagerNotEqualTo(String value) {
            addCriterion("price_manager <>", value, "priceManager");
            return (Criteria) this;
        }

        public Criteria andPriceManagerGreaterThan(String value) {
            addCriterion("price_manager >", value, "priceManager");
            return (Criteria) this;
        }

        public Criteria andPriceManagerGreaterThanOrEqualTo(String value) {
            addCriterion("price_manager >=", value, "priceManager");
            return (Criteria) this;
        }

        public Criteria andPriceManagerLessThan(String value) {
            addCriterion("price_manager <", value, "priceManager");
            return (Criteria) this;
        }

        public Criteria andPriceManagerLessThanOrEqualTo(String value) {
            addCriterion("price_manager <=", value, "priceManager");
            return (Criteria) this;
        }

        public Criteria andPriceManagerLike(String value) {
            addCriterion("price_manager like", value, "priceManager");
            return (Criteria) this;
        }

        public Criteria andPriceManagerNotLike(String value) {
            addCriterion("price_manager not like", value, "priceManager");
            return (Criteria) this;
        }

        public Criteria andPriceManagerIn(List<String> values) {
            addCriterion("price_manager in", values, "priceManager");
            return (Criteria) this;
        }

        public Criteria andPriceManagerNotIn(List<String> values) {
            addCriterion("price_manager not in", values, "priceManager");
            return (Criteria) this;
        }

        public Criteria andPriceManagerBetween(String value1, String value2) {
            addCriterion("price_manager between", value1, value2, "priceManager");
            return (Criteria) this;
        }

        public Criteria andPriceManagerNotBetween(String value1, String value2) {
            addCriterion("price_manager not between", value1, value2, "priceManager");
            return (Criteria) this;
        }

        public Criteria andPriceManagerIdIsNull() {
            addCriterion("price_manager_id is null");
            return (Criteria) this;
        }

        public Criteria andPriceManagerIdIsNotNull() {
            addCriterion("price_manager_id is not null");
            return (Criteria) this;
        }

        public Criteria andPriceManagerIdEqualTo(Long value) {
            addCriterion("price_manager_id =", value, "priceManagerId");
            return (Criteria) this;
        }

        public Criteria andPriceManagerIdNotEqualTo(Long value) {
            addCriterion("price_manager_id <>", value, "priceManagerId");
            return (Criteria) this;
        }

        public Criteria andPriceManagerIdGreaterThan(Long value) {
            addCriterion("price_manager_id >", value, "priceManagerId");
            return (Criteria) this;
        }

        public Criteria andPriceManagerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("price_manager_id >=", value, "priceManagerId");
            return (Criteria) this;
        }

        public Criteria andPriceManagerIdLessThan(Long value) {
            addCriterion("price_manager_id <", value, "priceManagerId");
            return (Criteria) this;
        }

        public Criteria andPriceManagerIdLessThanOrEqualTo(Long value) {
            addCriterion("price_manager_id <=", value, "priceManagerId");
            return (Criteria) this;
        }

        public Criteria andPriceManagerIdIn(List<Long> values) {
            addCriterion("price_manager_id in", values, "priceManagerId");
            return (Criteria) this;
        }

        public Criteria andPriceManagerIdNotIn(List<Long> values) {
            addCriterion("price_manager_id not in", values, "priceManagerId");
            return (Criteria) this;
        }

        public Criteria andPriceManagerIdBetween(Long value1, Long value2) {
            addCriterion("price_manager_id between", value1, value2, "priceManagerId");
            return (Criteria) this;
        }

        public Criteria andPriceManagerIdNotBetween(Long value1, Long value2) {
            addCriterion("price_manager_id not between", value1, value2, "priceManagerId");
            return (Criteria) this;
        }

        public Criteria andPriceManagerTimeIsNull() {
            addCriterion("price_manager_time is null");
            return (Criteria) this;
        }

        public Criteria andPriceManagerTimeIsNotNull() {
            addCriterion("price_manager_time is not null");
            return (Criteria) this;
        }

        public Criteria andPriceManagerTimeEqualTo(Date value) {
            addCriterion("price_manager_time =", value, "priceManagerTime");
            return (Criteria) this;
        }

        public Criteria andPriceManagerTimeNotEqualTo(Date value) {
            addCriterion("price_manager_time <>", value, "priceManagerTime");
            return (Criteria) this;
        }

        public Criteria andPriceManagerTimeGreaterThan(Date value) {
            addCriterion("price_manager_time >", value, "priceManagerTime");
            return (Criteria) this;
        }

        public Criteria andPriceManagerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("price_manager_time >=", value, "priceManagerTime");
            return (Criteria) this;
        }

        public Criteria andPriceManagerTimeLessThan(Date value) {
            addCriterion("price_manager_time <", value, "priceManagerTime");
            return (Criteria) this;
        }

        public Criteria andPriceManagerTimeLessThanOrEqualTo(Date value) {
            addCriterion("price_manager_time <=", value, "priceManagerTime");
            return (Criteria) this;
        }

        public Criteria andPriceManagerTimeIn(List<Date> values) {
            addCriterion("price_manager_time in", values, "priceManagerTime");
            return (Criteria) this;
        }

        public Criteria andPriceManagerTimeNotIn(List<Date> values) {
            addCriterion("price_manager_time not in", values, "priceManagerTime");
            return (Criteria) this;
        }

        public Criteria andPriceManagerTimeBetween(Date value1, Date value2) {
            addCriterion("price_manager_time between", value1, value2, "priceManagerTime");
            return (Criteria) this;
        }

        public Criteria andPriceManagerTimeNotBetween(Date value1, Date value2) {
            addCriterion("price_manager_time not between", value1, value2, "priceManagerTime");
            return (Criteria) this;
        }

        public Criteria andPriceOfferIsNull() {
            addCriterion("price_offer is null");
            return (Criteria) this;
        }

        public Criteria andPriceOfferIsNotNull() {
            addCriterion("price_offer is not null");
            return (Criteria) this;
        }

        public Criteria andPriceOfferEqualTo(String value) {
            addCriterion("price_offer =", value, "priceOffer");
            return (Criteria) this;
        }

        public Criteria andPriceOfferNotEqualTo(String value) {
            addCriterion("price_offer <>", value, "priceOffer");
            return (Criteria) this;
        }

        public Criteria andPriceOfferGreaterThan(String value) {
            addCriterion("price_offer >", value, "priceOffer");
            return (Criteria) this;
        }

        public Criteria andPriceOfferGreaterThanOrEqualTo(String value) {
            addCriterion("price_offer >=", value, "priceOffer");
            return (Criteria) this;
        }

        public Criteria andPriceOfferLessThan(String value) {
            addCriterion("price_offer <", value, "priceOffer");
            return (Criteria) this;
        }

        public Criteria andPriceOfferLessThanOrEqualTo(String value) {
            addCriterion("price_offer <=", value, "priceOffer");
            return (Criteria) this;
        }

        public Criteria andPriceOfferLike(String value) {
            addCriterion("price_offer like", value, "priceOffer");
            return (Criteria) this;
        }

        public Criteria andPriceOfferNotLike(String value) {
            addCriterion("price_offer not like", value, "priceOffer");
            return (Criteria) this;
        }

        public Criteria andPriceOfferIn(List<String> values) {
            addCriterion("price_offer in", values, "priceOffer");
            return (Criteria) this;
        }

        public Criteria andPriceOfferNotIn(List<String> values) {
            addCriterion("price_offer not in", values, "priceOffer");
            return (Criteria) this;
        }

        public Criteria andPriceOfferBetween(String value1, String value2) {
            addCriterion("price_offer between", value1, value2, "priceOffer");
            return (Criteria) this;
        }

        public Criteria andPriceOfferNotBetween(String value1, String value2) {
            addCriterion("price_offer not between", value1, value2, "priceOffer");
            return (Criteria) this;
        }

        public Criteria andPriceOfferIdIsNull() {
            addCriterion("price_offer_id is null");
            return (Criteria) this;
        }

        public Criteria andPriceOfferIdIsNotNull() {
            addCriterion("price_offer_id is not null");
            return (Criteria) this;
        }

        public Criteria andPriceOfferIdEqualTo(Long value) {
            addCriterion("price_offer_id =", value, "priceOfferId");
            return (Criteria) this;
        }

        public Criteria andPriceOfferIdNotEqualTo(Long value) {
            addCriterion("price_offer_id <>", value, "priceOfferId");
            return (Criteria) this;
        }

        public Criteria andPriceOfferIdGreaterThan(Long value) {
            addCriterion("price_offer_id >", value, "priceOfferId");
            return (Criteria) this;
        }

        public Criteria andPriceOfferIdGreaterThanOrEqualTo(Long value) {
            addCriterion("price_offer_id >=", value, "priceOfferId");
            return (Criteria) this;
        }

        public Criteria andPriceOfferIdLessThan(Long value) {
            addCriterion("price_offer_id <", value, "priceOfferId");
            return (Criteria) this;
        }

        public Criteria andPriceOfferIdLessThanOrEqualTo(Long value) {
            addCriterion("price_offer_id <=", value, "priceOfferId");
            return (Criteria) this;
        }

        public Criteria andPriceOfferIdIn(List<Long> values) {
            addCriterion("price_offer_id in", values, "priceOfferId");
            return (Criteria) this;
        }

        public Criteria andPriceOfferIdNotIn(List<Long> values) {
            addCriterion("price_offer_id not in", values, "priceOfferId");
            return (Criteria) this;
        }

        public Criteria andPriceOfferIdBetween(Long value1, Long value2) {
            addCriterion("price_offer_id between", value1, value2, "priceOfferId");
            return (Criteria) this;
        }

        public Criteria andPriceOfferIdNotBetween(Long value1, Long value2) {
            addCriterion("price_offer_id not between", value1, value2, "priceOfferId");
            return (Criteria) this;
        }

        public Criteria andPriceOfferTimeIsNull() {
            addCriterion("price_offer_time is null");
            return (Criteria) this;
        }

        public Criteria andPriceOfferTimeIsNotNull() {
            addCriterion("price_offer_time is not null");
            return (Criteria) this;
        }

        public Criteria andPriceOfferTimeEqualTo(Date value) {
            addCriterion("price_offer_time =", value, "priceOfferTime");
            return (Criteria) this;
        }

        public Criteria andPriceOfferTimeNotEqualTo(Date value) {
            addCriterion("price_offer_time <>", value, "priceOfferTime");
            return (Criteria) this;
        }

        public Criteria andPriceOfferTimeGreaterThan(Date value) {
            addCriterion("price_offer_time >", value, "priceOfferTime");
            return (Criteria) this;
        }

        public Criteria andPriceOfferTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("price_offer_time >=", value, "priceOfferTime");
            return (Criteria) this;
        }

        public Criteria andPriceOfferTimeLessThan(Date value) {
            addCriterion("price_offer_time <", value, "priceOfferTime");
            return (Criteria) this;
        }

        public Criteria andPriceOfferTimeLessThanOrEqualTo(Date value) {
            addCriterion("price_offer_time <=", value, "priceOfferTime");
            return (Criteria) this;
        }

        public Criteria andPriceOfferTimeIn(List<Date> values) {
            addCriterion("price_offer_time in", values, "priceOfferTime");
            return (Criteria) this;
        }

        public Criteria andPriceOfferTimeNotIn(List<Date> values) {
            addCriterion("price_offer_time not in", values, "priceOfferTime");
            return (Criteria) this;
        }

        public Criteria andPriceOfferTimeBetween(Date value1, Date value2) {
            addCriterion("price_offer_time between", value1, value2, "priceOfferTime");
            return (Criteria) this;
        }

        public Criteria andPriceOfferTimeNotBetween(Date value1, Date value2) {
            addCriterion("price_offer_time not between", value1, value2, "priceOfferTime");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Boolean value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Boolean value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Boolean value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Boolean value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Boolean> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Boolean> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}