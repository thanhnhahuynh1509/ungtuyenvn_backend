package com.doanchuyennganh.ungtuyenvn.services;

import com.doanchuyennganh.ungtuyenvn.entity.Chat;
import com.doanchuyennganh.ungtuyenvn.entity.ChatUser;
import com.doanchuyennganh.ungtuyenvn.repository.ChatRepository;
import com.doanchuyennganh.ungtuyenvn.repository.ChatUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatUserService extends BaseService<ChatUser, Long>{
    private final ChatUserRepository chatUserRepository;
    public ChatUserService(ChatUserRepository baseRepository) {
        super(baseRepository, "chat user");
        this.chatUserRepository = baseRepository;
    }

    @Override
    public ChatUser update(Long aLong, ChatUser model) {
        return null;
    }

    public boolean isExists(Long ownerId, Long toId) {
        return chatUserRepository.findByOwnerAndTo(ownerId, toId).isPresent();
    }

    public List<ChatUser> getAllByOwner(Long ownerId) {
        return chatUserRepository.findAllByOwner(ownerId);
    }

    public List<Chat> getAllByChatUser(long id) {
        List<Chat> chats = chatUserRepository.findByChatUser(id);

        return chats.stream()
                .sorted((a, b) -> (int) (b.getId() - a.getId()))
                .collect(Collectors.toList());
    }
}
