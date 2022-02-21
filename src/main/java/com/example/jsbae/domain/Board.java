package com.example.jsbae.domain;

import java.util.Date;

public class Board {
    private Long idx;
    private String title;
    private String type;
    private Date updated;
    private Date created;

    public Board() {
    }

    public Board(String title, String type) {
        this.title = title;
        this.type = type;
    }

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
