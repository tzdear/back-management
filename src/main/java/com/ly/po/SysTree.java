package com.ly.po;

import java.io.Serializable;

public class SysTree implements Serializable {
    private Integer id;

    private String chName;

    private String enName;

    private String treeUrl;

    private String treeOrder;

    private String treeType;

    private Integer parentId;

    private Integer treeNo;

    private String treeIcon;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChName() {
        return chName;
    }

    public void setChName(String chName) {
        this.chName = chName == null ? null : chName.trim();
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName == null ? null : enName.trim();
    }

    public String getTreeUrl() {
        return treeUrl;
    }

    public void setTreeUrl(String treeUrl) {
        this.treeUrl = treeUrl == null ? null : treeUrl.trim();
    }

    public String getTreeOrder() {
        return treeOrder;
    }

    public void setTreeOrder(String treeOrder) {
        this.treeOrder = treeOrder == null ? null : treeOrder.trim();
    }

    public String getTreeType() {
        return treeType;
    }

    public void setTreeType(String treeType) {
        this.treeType = treeType == null ? null : treeType.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getTreeNo() {
        return treeNo;
    }

    public void setTreeNo(Integer treeNo) {
        this.treeNo = treeNo;
    }

    public String getTreeIcon() {
        return treeIcon;
    }

    public void setTreeIcon(String treeIcon) {
        this.treeIcon = treeIcon == null ? null : treeIcon.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysTree other = (SysTree) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getChName() == null ? other.getChName() == null : this.getChName().equals(other.getChName()))
            && (this.getEnName() == null ? other.getEnName() == null : this.getEnName().equals(other.getEnName()))
            && (this.getTreeUrl() == null ? other.getTreeUrl() == null : this.getTreeUrl().equals(other.getTreeUrl()))
            && (this.getTreeOrder() == null ? other.getTreeOrder() == null : this.getTreeOrder().equals(other.getTreeOrder()))
            && (this.getTreeType() == null ? other.getTreeType() == null : this.getTreeType().equals(other.getTreeType()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getTreeNo() == null ? other.getTreeNo() == null : this.getTreeNo().equals(other.getTreeNo()))
            && (this.getTreeIcon() == null ? other.getTreeIcon() == null : this.getTreeIcon().equals(other.getTreeIcon()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getChName() == null) ? 0 : getChName().hashCode());
        result = prime * result + ((getEnName() == null) ? 0 : getEnName().hashCode());
        result = prime * result + ((getTreeUrl() == null) ? 0 : getTreeUrl().hashCode());
        result = prime * result + ((getTreeOrder() == null) ? 0 : getTreeOrder().hashCode());
        result = prime * result + ((getTreeType() == null) ? 0 : getTreeType().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getTreeNo() == null) ? 0 : getTreeNo().hashCode());
        result = prime * result + ((getTreeIcon() == null) ? 0 : getTreeIcon().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", chName=").append(chName);
        sb.append(", enName=").append(enName);
        sb.append(", treeUrl=").append(treeUrl);
        sb.append(", treeOrder=").append(treeOrder);
        sb.append(", treeType=").append(treeType);
        sb.append(", parentId=").append(parentId);
        sb.append(", treeNo=").append(treeNo);
        sb.append(", treeIcon=").append(treeIcon);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}