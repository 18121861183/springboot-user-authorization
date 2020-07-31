package com.yaochen.manager.authorization.manager.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "common_dict")
public class CommonDict implements Serializable {

    @Id
    @Column(name = "id", length = 40)
    private String id;

    @Column(name = "dict_type", length = 100)
    private String dictType;

    @Column(name = "dict_name", length = 100)
    private String dictName;

    @Column(name = "dict_value", length = 100)
    private String dictValue;

    @Column(name = "dict_icon", length = 200)
    private String dictIcon;

    @Column(name = "sort_level")
    private Integer sortLevel;

    @Column(name = "description", length = 250)
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getDictIcon() {
        return dictIcon;
    }

    public void setDictIcon(String dictIcon) {
        this.dictIcon = dictIcon;
    }

    public Integer getSortLevel() {
        return sortLevel;
    }

    public void setSortLevel(Integer sortLevel) {
        this.sortLevel = sortLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
