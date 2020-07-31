package com.yaochen.manager.authorization.manager.bean;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "common_user")
public class CommonUser implements Serializable {

    @Id
    @Column(name = "id", length = 40)
    private String id;

    @Column(name = "username", length = 100)
    private String username;

    @Column(name = "alias", length = 100)
    private String alias;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "department", length = 50)
    private String department;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "auth_key", length = 200)
    private String authKey;

    @Column(name = "auth_model", length = 20)
    private String authModel;

    @Column(name = "birthday", length = 100)
    private String birthday;

    @Column(name = "gender", length = 50)
    private String gender;

    @Column(name = "mail", length = 100)
    private String mail;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_user", length = 100)
    private String createUser;

    @Column(name = "modify_time")
    private Date modifyTime;

    @Column(name = "modify_user", length = 100)
    private String modifyUser;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

    @Column(name = "login_failure_times")
    private Integer loginFailureTimes;

    @Column(name = "description", length = 250)
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    public String getAuthModel() {
        return authModel;
    }

    public void setAuthModel(String authModel) {
        this.authModel = authModel;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getLoginFailureTimes() {
        return loginFailureTimes;
    }

    public void setLoginFailureTimes(Integer loginFailureTimes) {
        this.loginFailureTimes = loginFailureTimes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
