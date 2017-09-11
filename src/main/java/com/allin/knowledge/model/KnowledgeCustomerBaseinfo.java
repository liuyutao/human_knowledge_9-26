package com.allin.knowledge.model;

import com.allin.knowledge.util.BaseForm;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "knowledge_customer_baseinfo")
public class KnowledgeCustomerBaseinfo extends BaseForm {
    /**
     * 用户ID
     */
    @Column(name = "customer_id")
    private Long customerId;

    /**
     * 用户名称
     */
    @Column(name = "customer_name")
    private String customerName;

    /**
     * 部门Id
     */
    @Column(name = "department_id")
    private Long departmentId;

    /**
     * 部门名称
     */
    @Column(name = "department_name")
    private String departmentName;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 排序
     */
    @Column(name = "sort_id")
    private Integer sortId;

    /**
     * 是否有效
     */
    @Column(name = "is_valid")
    private Integer isValid;

    /**
     * 获取用户ID
     *
     * @return customer_id - 用户ID
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * 设置用户ID
     *
     * @param customerId 用户ID
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * 获取用户名称
     *
     * @return customer_name - 用户名称
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 设置用户名称
     *
     * @param customerName 用户名称
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * 获取部门Id
     *
     * @return department_id - 部门Id
     */
    public Long getDepartmentId() {
        return departmentId;
    }

    /**
     * 设置部门Id
     *
     * @param departmentId 部门Id
     */
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * 获取部门名称
     *
     * @return department_name - 部门名称
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * 设置部门名称
     *
     * @param departmentName 部门名称
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取排序
     *
     * @return sort_id - 排序
     */
    public Integer getSortId() {
        return sortId;
    }

    /**
     * 设置排序
     *
     * @param sortId 排序
     */
    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    /**
     * 获取是否有效
     *
     * @return is_valid - 是否有效
     */
    public Integer getIsValid() {
        return isValid;
    }

    /**
     * 设置是否有效
     *
     * @param isValid 是否有效
     */
    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }
}