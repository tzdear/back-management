package com.ly.po;

import java.io.Serializable;
import java.util.Date;

public class SysHisLoginUser implements Serializable {
    private Integer id;

    private String ip;

    private Date tiemdate;

    private String type;

    private String status;

    private String choms;

    private String browserType;

    private String terminalName;

    private String userAgent;

    private String userId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Date getTiemdate() {
        return tiemdate;
    }

    public void setTiemdate(Date tiemdate) {
        this.tiemdate = tiemdate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getChoms() {
        return choms;
    }

    public void setChoms(String choms) {
        this.choms = choms == null ? null : choms.trim();
    }

    public String getBrowserType() {
        return browserType;
    }

    public void setBrowserType(String browserType) {
        this.browserType = browserType == null ? null : browserType.trim();
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName == null ? null : terminalName.trim();
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent == null ? null : userAgent.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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
        SysHisLoginUser other = (SysHisLoginUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getTiemdate() == null ? other.getTiemdate() == null : this.getTiemdate().equals(other.getTiemdate()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getChoms() == null ? other.getChoms() == null : this.getChoms().equals(other.getChoms()))
            && (this.getBrowserType() == null ? other.getBrowserType() == null : this.getBrowserType().equals(other.getBrowserType()))
            && (this.getTerminalName() == null ? other.getTerminalName() == null : this.getTerminalName().equals(other.getTerminalName()))
            && (this.getUserAgent() == null ? other.getUserAgent() == null : this.getUserAgent().equals(other.getUserAgent()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getTiemdate() == null) ? 0 : getTiemdate().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getChoms() == null) ? 0 : getChoms().hashCode());
        result = prime * result + ((getBrowserType() == null) ? 0 : getBrowserType().hashCode());
        result = prime * result + ((getTerminalName() == null) ? 0 : getTerminalName().hashCode());
        result = prime * result + ((getUserAgent() == null) ? 0 : getUserAgent().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ip=").append(ip);
        sb.append(", tiemdate=").append(tiemdate);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", choms=").append(choms);
        sb.append(", browserType=").append(browserType);
        sb.append(", terminalName=").append(terminalName);
        sb.append(", userAgent=").append(userAgent);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}