package com.example.dampouring.model.request;

public class UpdateMenuReq {
    private Integer id;

    private String menuName;

    private Integer superMenuId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
