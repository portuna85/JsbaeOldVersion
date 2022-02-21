package com.example.jsbae.domain;

import java.util.Date;

public class Reply {
    private Long idx;
    private Long userIdx;
    private Long postIdx;
    private String description;
    private Date updated;
    private Date created;

    public Reply() {
    }

    public Reply(Long userIdx, Long postIdx, String description) {
        this.userIdx = userIdx;
        this.postIdx = postIdx;
        this.description = description;
    }

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public Long getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(Long userIdx) {
        this.userIdx = userIdx;
    }

    public Long getPostIdx() {
        return postIdx;
    }

    public void setPostIdx(Long postIdx) {
        this.postIdx = postIdx;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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