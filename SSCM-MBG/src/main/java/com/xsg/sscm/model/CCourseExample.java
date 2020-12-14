package com.xsg.sscm.model;

import java.util.ArrayList;
import java.util.List;

public class CCourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CCourseExample() {
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

        public Criteria andCreditIsNull() {
            addCriterion("credit is null");
            return (Criteria) this;
        }

        public Criteria andCreditIsNotNull() {
            addCriterion("credit is not null");
            return (Criteria) this;
        }

        public Criteria andCreditEqualTo(Integer value) {
            addCriterion("credit =", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotEqualTo(Integer value) {
            addCriterion("credit <>", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditGreaterThan(Integer value) {
            addCriterion("credit >", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditGreaterThanOrEqualTo(Integer value) {
            addCriterion("credit >=", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditLessThan(Integer value) {
            addCriterion("credit <", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditLessThanOrEqualTo(Integer value) {
            addCriterion("credit <=", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditIn(List<Integer> values) {
            addCriterion("credit in", values, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotIn(List<Integer> values) {
            addCriterion("credit not in", values, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditBetween(Integer value1, Integer value2) {
            addCriterion("credit between", value1, value2, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotBetween(Integer value1, Integer value2) {
            addCriterion("credit not between", value1, value2, "credit");
            return (Criteria) this;
        }

        public Criteria andClassHoursIsNull() {
            addCriterion("class_hours is null");
            return (Criteria) this;
        }

        public Criteria andClassHoursIsNotNull() {
            addCriterion("class_hours is not null");
            return (Criteria) this;
        }

        public Criteria andClassHoursEqualTo(Integer value) {
            addCriterion("class_hours =", value, "classHours");
            return (Criteria) this;
        }

        public Criteria andClassHoursNotEqualTo(Integer value) {
            addCriterion("class_hours <>", value, "classHours");
            return (Criteria) this;
        }

        public Criteria andClassHoursGreaterThan(Integer value) {
            addCriterion("class_hours >", value, "classHours");
            return (Criteria) this;
        }

        public Criteria andClassHoursGreaterThanOrEqualTo(Integer value) {
            addCriterion("class_hours >=", value, "classHours");
            return (Criteria) this;
        }

        public Criteria andClassHoursLessThan(Integer value) {
            addCriterion("class_hours <", value, "classHours");
            return (Criteria) this;
        }

        public Criteria andClassHoursLessThanOrEqualTo(Integer value) {
            addCriterion("class_hours <=", value, "classHours");
            return (Criteria) this;
        }

        public Criteria andClassHoursIn(List<Integer> values) {
            addCriterion("class_hours in", values, "classHours");
            return (Criteria) this;
        }

        public Criteria andClassHoursNotIn(List<Integer> values) {
            addCriterion("class_hours not in", values, "classHours");
            return (Criteria) this;
        }

        public Criteria andClassHoursBetween(Integer value1, Integer value2) {
            addCriterion("class_hours between", value1, value2, "classHours");
            return (Criteria) this;
        }

        public Criteria andClassHoursNotBetween(Integer value1, Integer value2) {
            addCriterion("class_hours not between", value1, value2, "classHours");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIsNull() {
            addCriterion("plan_type is null");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIsNotNull() {
            addCriterion("plan_type is not null");
            return (Criteria) this;
        }

        public Criteria andPlanTypeEqualTo(String value) {
            addCriterion("plan_type =", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotEqualTo(String value) {
            addCriterion("plan_type <>", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeGreaterThan(String value) {
            addCriterion("plan_type >", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeGreaterThanOrEqualTo(String value) {
            addCriterion("plan_type >=", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeLessThan(String value) {
            addCriterion("plan_type <", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeLessThanOrEqualTo(String value) {
            addCriterion("plan_type <=", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeLike(String value) {
            addCriterion("plan_type like", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotLike(String value) {
            addCriterion("plan_type not like", value, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeIn(List<String> values) {
            addCriterion("plan_type in", values, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotIn(List<String> values) {
            addCriterion("plan_type not in", values, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeBetween(String value1, String value2) {
            addCriterion("plan_type between", value1, value2, "planType");
            return (Criteria) this;
        }

        public Criteria andPlanTypeNotBetween(String value1, String value2) {
            addCriterion("plan_type not between", value1, value2, "planType");
            return (Criteria) this;
        }

        public Criteria andTeachingClassIsNull() {
            addCriterion("teaching_class is null");
            return (Criteria) this;
        }

        public Criteria andTeachingClassIsNotNull() {
            addCriterion("teaching_class is not null");
            return (Criteria) this;
        }

        public Criteria andTeachingClassEqualTo(String value) {
            addCriterion("teaching_class =", value, "teachingClass");
            return (Criteria) this;
        }

        public Criteria andTeachingClassNotEqualTo(String value) {
            addCriterion("teaching_class <>", value, "teachingClass");
            return (Criteria) this;
        }

        public Criteria andTeachingClassGreaterThan(String value) {
            addCriterion("teaching_class >", value, "teachingClass");
            return (Criteria) this;
        }

        public Criteria andTeachingClassGreaterThanOrEqualTo(String value) {
            addCriterion("teaching_class >=", value, "teachingClass");
            return (Criteria) this;
        }

        public Criteria andTeachingClassLessThan(String value) {
            addCriterion("teaching_class <", value, "teachingClass");
            return (Criteria) this;
        }

        public Criteria andTeachingClassLessThanOrEqualTo(String value) {
            addCriterion("teaching_class <=", value, "teachingClass");
            return (Criteria) this;
        }

        public Criteria andTeachingClassLike(String value) {
            addCriterion("teaching_class like", value, "teachingClass");
            return (Criteria) this;
        }

        public Criteria andTeachingClassNotLike(String value) {
            addCriterion("teaching_class not like", value, "teachingClass");
            return (Criteria) this;
        }

        public Criteria andTeachingClassIn(List<String> values) {
            addCriterion("teaching_class in", values, "teachingClass");
            return (Criteria) this;
        }

        public Criteria andTeachingClassNotIn(List<String> values) {
            addCriterion("teaching_class not in", values, "teachingClass");
            return (Criteria) this;
        }

        public Criteria andTeachingClassBetween(String value1, String value2) {
            addCriterion("teaching_class between", value1, value2, "teachingClass");
            return (Criteria) this;
        }

        public Criteria andTeachingClassNotBetween(String value1, String value2) {
            addCriterion("teaching_class not between", value1, value2, "teachingClass");
            return (Criteria) this;
        }

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Long value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Long value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Long value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Long value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Long value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Long value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Long> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Long> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Long value1, Long value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Long value1, Long value2) {
            addCriterion("tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andLimitedElectionIsNull() {
            addCriterion("limited_election is null");
            return (Criteria) this;
        }

        public Criteria andLimitedElectionIsNotNull() {
            addCriterion("limited_election is not null");
            return (Criteria) this;
        }

        public Criteria andLimitedElectionEqualTo(Integer value) {
            addCriterion("limited_election =", value, "limitedElection");
            return (Criteria) this;
        }

        public Criteria andLimitedElectionNotEqualTo(Integer value) {
            addCriterion("limited_election <>", value, "limitedElection");
            return (Criteria) this;
        }

        public Criteria andLimitedElectionGreaterThan(Integer value) {
            addCriterion("limited_election >", value, "limitedElection");
            return (Criteria) this;
        }

        public Criteria andLimitedElectionGreaterThanOrEqualTo(Integer value) {
            addCriterion("limited_election >=", value, "limitedElection");
            return (Criteria) this;
        }

        public Criteria andLimitedElectionLessThan(Integer value) {
            addCriterion("limited_election <", value, "limitedElection");
            return (Criteria) this;
        }

        public Criteria andLimitedElectionLessThanOrEqualTo(Integer value) {
            addCriterion("limited_election <=", value, "limitedElection");
            return (Criteria) this;
        }

        public Criteria andLimitedElectionIn(List<Integer> values) {
            addCriterion("limited_election in", values, "limitedElection");
            return (Criteria) this;
        }

        public Criteria andLimitedElectionNotIn(List<Integer> values) {
            addCriterion("limited_election not in", values, "limitedElection");
            return (Criteria) this;
        }

        public Criteria andLimitedElectionBetween(Integer value1, Integer value2) {
            addCriterion("limited_election between", value1, value2, "limitedElection");
            return (Criteria) this;
        }

        public Criteria andLimitedElectionNotBetween(Integer value1, Integer value2) {
            addCriterion("limited_election not between", value1, value2, "limitedElection");
            return (Criteria) this;
        }

        public Criteria andClassNumberIsNull() {
            addCriterion("class_number is null");
            return (Criteria) this;
        }

        public Criteria andClassNumberIsNotNull() {
            addCriterion("class_number is not null");
            return (Criteria) this;
        }

        public Criteria andClassNumberEqualTo(Integer value) {
            addCriterion("class_number =", value, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberNotEqualTo(Integer value) {
            addCriterion("class_number <>", value, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberGreaterThan(Integer value) {
            addCriterion("class_number >", value, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("class_number >=", value, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberLessThan(Integer value) {
            addCriterion("class_number <", value, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberLessThanOrEqualTo(Integer value) {
            addCriterion("class_number <=", value, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberIn(List<Integer> values) {
            addCriterion("class_number in", values, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberNotIn(List<Integer> values) {
            addCriterion("class_number not in", values, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberBetween(Integer value1, Integer value2) {
            addCriterion("class_number between", value1, value2, "classNumber");
            return (Criteria) this;
        }

        public Criteria andClassNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("class_number not between", value1, value2, "classNumber");
            return (Criteria) this;
        }

        public Criteria andChooseNumberIsNull() {
            addCriterion("choose_number is null");
            return (Criteria) this;
        }

        public Criteria andChooseNumberIsNotNull() {
            addCriterion("choose_number is not null");
            return (Criteria) this;
        }

        public Criteria andChooseNumberEqualTo(Integer value) {
            addCriterion("choose_number =", value, "chooseNumber");
            return (Criteria) this;
        }

        public Criteria andChooseNumberNotEqualTo(Integer value) {
            addCriterion("choose_number <>", value, "chooseNumber");
            return (Criteria) this;
        }

        public Criteria andChooseNumberGreaterThan(Integer value) {
            addCriterion("choose_number >", value, "chooseNumber");
            return (Criteria) this;
        }

        public Criteria andChooseNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("choose_number >=", value, "chooseNumber");
            return (Criteria) this;
        }

        public Criteria andChooseNumberLessThan(Integer value) {
            addCriterion("choose_number <", value, "chooseNumber");
            return (Criteria) this;
        }

        public Criteria andChooseNumberLessThanOrEqualTo(Integer value) {
            addCriterion("choose_number <=", value, "chooseNumber");
            return (Criteria) this;
        }

        public Criteria andChooseNumberIn(List<Integer> values) {
            addCriterion("choose_number in", values, "chooseNumber");
            return (Criteria) this;
        }

        public Criteria andChooseNumberNotIn(List<Integer> values) {
            addCriterion("choose_number not in", values, "chooseNumber");
            return (Criteria) this;
        }

        public Criteria andChooseNumberBetween(Integer value1, Integer value2) {
            addCriterion("choose_number between", value1, value2, "chooseNumber");
            return (Criteria) this;
        }

        public Criteria andChooseNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("choose_number not between", value1, value2, "chooseNumber");
            return (Criteria) this;
        }

        public Criteria andStatesIsNull() {
            addCriterion("states is null");
            return (Criteria) this;
        }

        public Criteria andStatesIsNotNull() {
            addCriterion("states is not null");
            return (Criteria) this;
        }

        public Criteria andStatesEqualTo(Integer value) {
            addCriterion("states =", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesNotEqualTo(Integer value) {
            addCriterion("states <>", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesGreaterThan(Integer value) {
            addCriterion("states >", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesGreaterThanOrEqualTo(Integer value) {
            addCriterion("states >=", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesLessThan(Integer value) {
            addCriterion("states <", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesLessThanOrEqualTo(Integer value) {
            addCriterion("states <=", value, "states");
            return (Criteria) this;
        }

        public Criteria andStatesIn(List<Integer> values) {
            addCriterion("states in", values, "states");
            return (Criteria) this;
        }

        public Criteria andStatesNotIn(List<Integer> values) {
            addCriterion("states not in", values, "states");
            return (Criteria) this;
        }

        public Criteria andStatesBetween(Integer value1, Integer value2) {
            addCriterion("states between", value1, value2, "states");
            return (Criteria) this;
        }

        public Criteria andStatesNotBetween(Integer value1, Integer value2) {
            addCriterion("states not between", value1, value2, "states");
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