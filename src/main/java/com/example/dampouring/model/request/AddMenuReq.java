package com.example.dampouring.model.request;

public class AddMenuReq {
    private String menuName;

    private Integer superMenuId;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getSuperMenuId() {
        return superMenuId;
    }

    public void setSuperMenuId(Integer superMenuId) {
        this.superMenuId = superMenuId;
    }
}
