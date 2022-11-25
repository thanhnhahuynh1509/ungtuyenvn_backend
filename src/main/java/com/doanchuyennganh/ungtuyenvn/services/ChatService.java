package com.doanchuyennganh.ungtuyenvn.services;

import com.doanchuyennganh.ungtuyenvn.entity.Chat;
import com.doanchuyennganh.ungtuyenvn.repository.ChatRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ChatService extends BaseService<Chat, Long>{
    public ChatService(ChatRepository baseRepository) {
        super(baseRepository, "chat");
    }

    @Override
    public Chat update(Long id, Chat model) {
        return null;
    }
}
