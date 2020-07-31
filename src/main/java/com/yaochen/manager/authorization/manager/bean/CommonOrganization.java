package com.yaochen.manager.authorization.manager.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "common_organization")
public class CommonOrganization implements Serializable {

    @Id
    @Column(name = "id", length = 40)
    private String id;

    @Column(name = "org_name", length = 100)
    private String orgName;

    @Column(name = "org_code", length = 100)
    private String orgCode;

    @Column(name = "org_icon", length = 100)
    private String orgIcon;

    @Column(name = "leaderName", length = 100)
    private String leaderName;

    @Column(name = "leader_id", length = 100)
    private String leaderId;

    @Column(name = "show")
    private Integer show;

    @Column(name = "disable")
    private Integer disable;

    @Column(name = "parent", length = 50)
    private String parent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgIcon() {
        return orgIcon;
    }

    public void setOrgIcon(String orgIcon) {
        this.orgIcon = orgIcon;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId;
    }

    public Integer getShow() {
        return show;
    }

    public void setShow(Integer show) {
        this.show = show;
    }

    public Integer getDisable() {
        return disable;
    }

    public void setDisable(Integer disable) {
        this.disable = disable;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
