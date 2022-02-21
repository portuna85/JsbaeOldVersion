package com.example.jsbae.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
    private Long idx;
    private Long userIdx;
    private Long boardIdx;
    private String title;
    private String description;
    private String delete;
    private Date update;
    private Date created;

    private List<Reply> replyList = new ArrayList<>();

    public Post() {
    }

    public Post(Long userIdx, Long boardIdx, String title, String description) {
        this.userIdx = userIdx;
        this.boardIdx = boardIdx;
        this.title = title;
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

    public Long getBoardIdx() {
        return boardIdx;
    }

    public void setBoardIdx(Long boardIdx) {
        this.boardIdx = boardIdx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }

    public List<Reply> getReplyList() {
        return replyList;
    }
}
