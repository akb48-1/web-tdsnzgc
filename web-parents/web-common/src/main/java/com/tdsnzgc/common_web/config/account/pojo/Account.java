package com.tdsnzgc.common_web.config.account.pojo;

public class Account {
    String user_id;
    String username;
    String password;
    String name;
    String role_ids;
    String organ_ids;
    Integer status;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole_ids() {
        return role_ids;
    }

    public void setRole_ids(String role_ids) {
        if(role_ids == null || "null".equals(role_ids)) {
            this.role_ids = "";
            return;
        }
        this.role_ids = role_ids;
    }

    public String getOrgans_id() {
        return organ_ids;
    }

    public void setOrgans_id(String organs_id) {
        if(organs_id == null || "null".equals(organs_id)) {
            this.organ_ids = "";
            return;
        }
        this.organ_ids = organs_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
