package com.doanchuyennganh.ungtuyenvn.dto;

import com.doanchuyennganh.ungtuyenvn.entity.Chat;
import com.doanchuyennganh.ungtuyenvn.entity.NguoiDung;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ChatUserDTO {

    private long id;
    private NguoiDungShortDTO owner;
    private NguoiDungShortDTO to;
    private boolean isRead;
    private List<ChatDTO> chats;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public NguoiDungShortDTO getOwner() {
        return owner;
    }

    public void setOwner(NguoiDungShortDTO owner) {
        this.owner = owner;
    }

    public NguoiDungShortDTO getTo() {
        return to;
    }

    public void setTo(NguoiDungShortDTO to) {
        this.to = to;
    }

    public List<ChatDTO> getChats() {
        return chats;
    }

    public void setChats(List<ChatDTO> chats) {
        this.chats = chats;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
