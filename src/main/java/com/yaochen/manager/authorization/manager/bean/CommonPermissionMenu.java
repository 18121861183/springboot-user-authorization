package com.yaochen.manager.authorization.manager.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "common_permission_menu")
public class CommonPermissionMenu implements Serializable {

    @Id
    private String id;

    @Column(name = "action", length = 300)
    private String action;

    @Column(name = "menu_id", length = 40)
    private String menuId;

    @Column(name = "permission_id", length = 40)
    private String permissionId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
}
