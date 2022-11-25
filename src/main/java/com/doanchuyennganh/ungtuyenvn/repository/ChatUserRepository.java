package com.doanchuyennganh.ungtuyenvn.repository;

import com.doanchuyennganh.ungtuyenvn.entity.Chat;
import com.doanchuyennganh.ungtuyenvn.entity.ChatUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatUserRepository extends JpaRepository<ChatUser, Long> {

    @Query("SELECT cu FROM ChatUser cu WHERE cu.owner.id = ?1 AND cu.to.id = ?2")
    Optional<ChatUser> findByOwnerAndTo(long ownerId, long toId);

    @Query("SELECT cu FROM ChatUser cu WHERE cu.owner.id = ?1 OR cu.to.id = ?1 ORDER BY cu.id DESC")
    List<ChatUser> findAllByOwner(long ownerId);


    @Query("SELECT cu.chats FROM ChatUser cu WHERE cu.id = ?1")
    List<Chat> findByChatUser(long chatUserId);

}
