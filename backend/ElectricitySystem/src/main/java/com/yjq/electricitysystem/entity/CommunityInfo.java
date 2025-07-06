package com.yjq.electricitysystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 对应数据库表：OMS.t_community
 */
@Entity
@Table(name = "t_community", schema = "OMS")
public class CommunityInfo {

    /** 区域编码（主键） */
    @Id
    @Column(name = "area_code")
    private Integer areaCode;

    /** 街道编码 */
    @Column(name = "community_code")
    private Integer communityCode;

    /** 街道名称 */
    @Column(name = "community_name", length = 50, nullable = false)
    private String communityName;

    public CommunityInfo() {
    }

    public CommunityInfo(Integer areaCode, Integer communityCode, String communityName) {
        this.areaCode = areaCode;
        this.communityCode = communityCode;
        this.communityName = communityName;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public Integer getCommunityCode() {
        return communityCode;
    }

    public void setCommunityCode(Integer communityCode) {
        this.communityCode = communityCode;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }
}
