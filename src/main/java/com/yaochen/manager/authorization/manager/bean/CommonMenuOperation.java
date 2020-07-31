package com.yaochen.manager.authorization.manager.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "common_menu_operation")
public class CommonMenuOperation implements Serializable {

    @Id
    private String id;

    @Column(name = "menu_id", length = 40)
    private String menuId;

    @Column(name = "operation_code", length = 100)
    private String operationCode;

    @Column(name = "operation_name", length = 100)
    private String operationName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }
}
