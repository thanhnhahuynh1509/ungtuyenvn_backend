package com.doanchuyennganh.ungtuyenvn.dto;

import com.doanchuyennganh.ungtuyenvn.entity.NguoiDung;

public class ChatDTO {
    private long id;
    private String content;
    private String date;
    private NguoiDungShortDTO owner;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public NguoiDungShortDTO getOwner() {
        return owner;
    }

    public void setOwner(NguoiDungShortDTO owner) {
        this.owner = owner;
    }
}
