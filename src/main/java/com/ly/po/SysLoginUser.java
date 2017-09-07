package com.ly.po;

import java.io.Serializable;

public class SysLoginUser implements Serializable {
    private Integer id;

    private String loginUserName;

    private String loginUserPass;

    private String loginType;

    private Integer sysUserId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginUserName() {
        return loginUserName;
    }

    public void setLoginUserName(String loginUserName) {
        this.loginUserName = loginUserName == null ? null : loginUserName.trim();
    }

    public String getLoginUserPass() {
        return loginUserPass;
    }

    public void setLoginUserPass(String loginUserPass) {
        this.loginUserPass = loginUserPass == null ? null : loginUserPass.trim();
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType == null ? null : loginType.trim();
    }

    public Integer getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
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
        SysLoginUser other = (SysLoginUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLoginUserName() == null ? other.getLoginUserName() == null : this.getLoginUserName().equals(other.getLoginUserName()))
            && (this.getLoginUserPass() == null ? other.getLoginUserPass() == null : this.getLoginUserPass().equals(other.getLoginUserPass()))
            && (this.getLoginType() == null ? other.getLoginType() == null : this.getLoginType().equals(other.getLoginType()))
            && (this.getSysUserId() == null ? other.getSysUserId() == null : this.getSysUserId().equals(other.getSysUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLoginUserName() == null) ? 0 : getLoginUserName().hashCode());
        result = prime * result + ((getLoginUserPass() == null) ? 0 : getLoginUserPass().hashCode());
        result = prime * result + ((getLoginType() == null) ? 0 : getLoginType().hashCode());
        result = prime * result + ((getSysUserId() == null) ? 0 : getSysUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", loginUserName=").append(loginUserName);
        sb.append(", loginUserPass=").append(loginUserPass);
        sb.append(", loginType=").append(loginType);
        sb.append(", sysUserId=").append(sysUserId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}