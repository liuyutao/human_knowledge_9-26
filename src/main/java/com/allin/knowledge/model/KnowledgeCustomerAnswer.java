package com.allin.knowledge.model;

import com.allin.knowledge.util.BaseForm;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "knowledge_customer_answer")
public class KnowledgeCustomerAnswer extends BaseForm {

    /**
     * 会员id
     */
    @Column(name = "customer_id")
    private Long customerId;

    /**
     * 业务主键id
     */
    @Column(name = "answer_id")
    private Long answerId;

    /**
     * 考卷id(用户作答一套题的业务键)
     */
    @Column(name = "exam_id")
    private Long examId;

    /**
     * 物料id(外键)
     */
    @Column(name = "materiel_id")
    private Long materielId;

    /**
     * 物料名称(冗余)
     */
    @Column(name = "materiel_name")
    private String materielName;

    /**
     * 用户的选择
     */
    @Column(name = "option_id")
    private String optionId;

    /**
     * 用户的答案描述(备用)
     */
    @Column(name = "option_name")
    private String optionName;

    /**
     * 是否正确(0-不是,1-是)(冗余)
     */
    @Column(name = "is_right_option")
    private Integer isRightOption;


    /**
     * 创建日期
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 是否有效(0-无效,1-有效)
     */
    @Column(name = "is_valid")
    private Integer isValid;

    /**
     * 顺序号
     */
    @Column(name = "sort_id")
    private Integer sortId;


    /**
     * 获取会员id
     *
     * @return customer_id - 会员id
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * 设置会员id
     *
     * @param customerId 会员id
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * 获取业务主键id
     *
     * @return answer_id - 业务主键id
     */
    public Long getAnswerId() {
        return answerId;
    }

    /**
     * 设置业务主键id
     *
     * @param answerId 业务主键id
     */
    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    /**
     * 获取考卷id(用户作答一套题的业务键)
     *
     * @return exam_id - 考卷id(用户作答一套题的业务键)
     */
    public Long getExamId() {
        return examId;
    }

    /**
     * 设置考卷id(用户作答一套题的业务键)
     *
     * @param examId 考卷id(用户作答一套题的业务键)
     */
    public void setExamId(Long examId) {
        this.examId = examId;
    }

    /**
     * 获取物料id(外键)
     *
     * @return materiel_id - 物料id(外键)
     */
    public Long getMaterielId() {
        return materielId;
    }

    /**
     * 设置物料id(外键)
     *
     * @param materielId 物料id(外键)
     */
    public void setMaterielId(Long materielId) {
        this.materielId = materielId;
    }

    /**
     * 获取物料名称(冗余)
     *
     * @return materiel_name - 物料名称(冗余)
     */
    public String getMaterielName() {
        return materielName;
    }

    /**
     * 设置物料名称(冗余)
     *
     * @param materielName 物料名称(冗余)
     */
    public void setMaterielName(String materielName) {
        this.materielName = materielName;
    }

    /**
     * 获取用户的选择
     *
     * @return option_id - 用户的选择
     */
    public String getOptionId() {
        return optionId;
    }

    /**
     * 设置用户的选择
     *
     * @param optionId 用户的选择
     */
    public void setOptionId(String optionId) {
        this.optionId = optionId;
    }

    /**
     * 获取用户的答案描述(备用)
     *
     * @return option_desc - 用户的答案描述(备用)
     */
    public String getOptionName() {
        return optionName;
    }

    /**
     * 设置用户的答案描述(备用)
     *
     * @param optionName 用户的答案描述(备用)
     */
    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    /**
     * 获取是否正确(0-不是,1-是)(冗余)
     *
     * @return is_right_option - 是否正确(0-不是,1-是)(冗余)
     */
    public Integer getIsRightOption() {
        return isRightOption;
    }

    /**
     * 设置是否正确(0-不是,1-是)(冗余)
     *
     * @param isRightOption 是否正确(0-不是,1-是)(冗余)
     */
    public void setIsRightOption(Integer isRightOption) {
        this.isRightOption = isRightOption;
    }

    /**
     * 获取创建日期
     *
     * @return create_time - 创建日期
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建日期
     *
     * @param createTime 创建日期
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取是否有效(0-无效,1-有效)
     *
     * @return is_valid - 是否有效(0-无效,1-有效)
     */
    public Integer getIsValid() {
        return isValid;
    }

    /**
     * 设置是否有效(0-无效,1-有效)
     *
     * @param isValid 是否有效(0-无效,1-有效)
     */
    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    /**
     * 获取顺序号
     *
     * @return sort_id - 顺序号
     */
    public Integer getSortId() {
        return sortId;
    }

    /**
     * 设置顺序号
     *
     * @param sortId 顺序号
     */
    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }
}