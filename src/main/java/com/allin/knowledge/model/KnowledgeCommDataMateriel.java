package com.allin.knowledge.model;

import com.allin.knowledge.util.BaseForm;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "knowledge_comm_data_materiel")
public class KnowledgeCommDataMateriel extends BaseForm {

    /**
     * 物料名称
     */
    @Column(name = "materiel_name")
    private String materielName;

    /**
     * 物料分类1-肌肉2-骨骼
     */
    @Column(name = "materiel_category")
    private Integer materielCategory;

    /**
     * 分类类型1(1-附属肌2-轴向肌肉)
     */
    @Column(name = "category_type")
    private Integer categoryType;

    /**
     * 节点级别
     */
    @Column(name = "tree_level")
    private Integer treeLevel;

    /**
     * 是否子节点(0-否；1-是)
     */
    @Column(name = "is_leaf")
    private Integer isLeaf;

    /**
     * 父节点
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 路径
     */
    @Column(name = "full_path")
    private String fullPath;

    /**
     * 方向0-正面1-反面
     */
    @Column(name = "direction_id")
    private Integer directionId;

    /**
     * 位置0-双侧1-左侧2-右侧
     */
    @Column(name = "position_id")
    private Integer positionId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

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
     * 获取物料名称
     *
     * @return materiel_name - 物料名称
     */
    public String getMaterielName() {
        return materielName;
    }

    /**
     * 设置物料名称
     *
     * @param materielName 物料名称
     */
    public void setMaterielName(String materielName) {
        this.materielName = materielName;
    }

    /**
     * 获取物料分类1-肌肉2-骨骼
     *
     * @return materiel_category - 物料分类1-肌肉2-骨骼
     */
    public Integer getMaterielCategory() {
        return materielCategory;
    }

    /**
     * 设置物料分类1-肌肉2-骨骼
     *
     * @param materielCategory 物料分类1-肌肉2-骨骼
     */
    public void setMaterielCategory(Integer materielCategory) {
        this.materielCategory = materielCategory;
    }

    /**
     * 获取分类类型1(1-附属肌2-轴向肌肉)
     *
     * @return category_type - 分类类型1(1-附属肌2-轴向肌肉)
     */
    public Integer getCategoryType() {
        return categoryType;
    }

    /**
     * 设置分类类型1(1-附属肌2-轴向肌肉)
     *
     * @param categoryType 分类类型1(1-附属肌2-轴向肌肉)
     */
    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    /**
     * 获取节点级别
     *
     * @return tree_level - 节点级别
     */
    public Integer getTreeLevel() {
        return treeLevel;
    }

    /**
     * 设置节点级别
     *
     * @param treeLevel 节点级别
     */
    public void setTreeLevel(Integer treeLevel) {
        this.treeLevel = treeLevel;
    }

    /**
     * 获取是否子节点(0-否；1-是)
     *
     * @return is_leaf - 是否子节点(0-否；1-是)
     */
    public Integer getIsLeaf() {
        return isLeaf;
    }

    /**
     * 设置是否子节点(0-否；1-是)
     *
     * @param isLeaf 是否子节点(0-否；1-是)
     */
    public void setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
    }

    /**
     * 获取父节点
     *
     * @return parent_id - 父节点
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父节点
     *
     * @param parentId 父节点
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取路径
     *
     * @return full_path - 路径
     */
    public String getFullPath() {
        return fullPath;
    }

    /**
     * 设置路径
     *
     * @param fullPath 路径
     */
    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    /**
     * 获取方向0-正面1-反面
     *
     * @return direction_id - 方向0-正面1-反面
     */
    public Integer getDirectionId() {
        return directionId;
    }

    /**
     * 设置方向0-正面1-反面
     *
     * @param directionId 方向0-正面1-反面
     */
    public void setDirectionId(Integer directionId) {
        this.directionId = directionId;
    }

    /**
     * 获取位置0-双侧1-左侧2-右侧
     *
     * @return position_id - 位置0-双侧1-左侧2-右侧
     */
    public Integer getPositionId() {
        return positionId;
    }

    /**
     * 设置位置0-双侧1-左侧2-右侧
     *
     * @param positionId 位置0-双侧1-左侧2-右侧
     */
    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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