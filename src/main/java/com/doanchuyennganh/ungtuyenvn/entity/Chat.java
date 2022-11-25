package com.doanchuyennganh.ungtuyenvn.entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "chats")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String content;
    private String date = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private NguoiDung owner;

    public Chat() {
    }

    public Chat(long id) {
        this.id = id;
    }

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

    public NguoiDung getOwner() {
        return owner;
    }

    public void setOwner(NguoiDung owner) {
        this.owner = owner;
    }
}
