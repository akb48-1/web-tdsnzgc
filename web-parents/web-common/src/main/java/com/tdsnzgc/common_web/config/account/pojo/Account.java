package com.tdsnzgc.common_web.config.account.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Account {
    String user_id;
    String username;
    String password;
    String name;
    String roles_id;
    String organs_id;
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

    public String getRoles_id() {
        return roles_id;
    }

    public void setRoles_id(String roles_id) {
        if(roles_id == null || "null".equals(roles_id)) {
            this.roles_id = "";
            return;
        }
        this.roles_id = roles_id;
    }

    public String getOrgans_id() {
        return organs_id;
    }

    public void setOrgans_id(String organs_id) {
        if(organs_id == null || "null".equals(organs_id)) {
            this.organs_id = "";
            return;
        }
        this.organs_id = organs_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
