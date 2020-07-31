package com.yaochen.manager.authorization.manager.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "common_role")
public class CommonRole implements Serializable {

    @Id
    @Column(name = "id", length = 40)
    private String id;

    @Column(name = "role_name", length = 100)
    private String roleName;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "department_id", length = 40)
    private String departmentId;

    @Column(name = "create_user", length = 100)
    private String createUser;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "modify_user", length = 100)
    private String modifyUser;

    @Column(name = "modify_time")
    private Date modifyTime;

    @Column(name = "description", length = 250)
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
