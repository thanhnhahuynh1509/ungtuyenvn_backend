package com.doanchuyennganh.ungtuyenvn.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name= "chat_users")
public class ChatUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private NguoiDung owner;
    @ManyToOne
    @JoinColumn(name = "to_id")
    private NguoiDung to;

    private boolean isRead = false;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "chat_user_id")
    private Set<Chat> chats = new LinkedHashSet<>();

    public ChatUser() {
    }

    public ChatUser(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public NguoiDung getOwner() {
        return owner;
    }

    public void setOwner(NguoiDung owner) {
        this.owner = owner;
    }

    public NguoiDung getTo() {
        return to;
    }

    public void setTo(NguoiDung to) {
        this.to = to;
    }

    public Set<Chat> getChats() {
        return chats;
    }

    public void setChats(Set<Chat> chats) {
        this.chats = chats;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
