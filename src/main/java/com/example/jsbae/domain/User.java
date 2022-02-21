package com.example.jsbae.domain;

import java.util.Date;

public class User {
    private Long idx;
    private String email;
    private String name;
    private String delete;
    private Date updated;
    private Date created;

    public User() {
    }

    public User(String email, Date updated) {
        this.email = email;
        this.updated = updated;
    }

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
