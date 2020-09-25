package com.yaochen.manager.authorization.manager.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "common_config")
public class CommonConfig implements Serializable {

    @Id
    @Column(name = "id", length = 40)
    private String id;

    @Column(name = "config_name", length = 100)
    private String configName;

    @Column(name = "config_code", length = 100)
    private String configCode;

    @Column(name = "config_value", length = 100)
    private String configValue;

    @Column(name = "disable", columnDefinition = "int(1) default 1")
    private Integer disable;

    @Column(name = "is_show", columnDefinition = "int(1) default 1")
    private Integer isShow;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "description", length = 250)
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getConfigCode() {
        return configCode;
    }

    public void setConfigCode(String configCode) {
        this.configCode = configCode;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    public Integer getDisable() {
        return disable;
    }

    public void setDisable(Integer disable) {
        this.disable = disable;
    }

    public Integer getShow() {
        return isShow;
    }

    public void setShow(Integer isShow) {
        this.isShow = isShow;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
