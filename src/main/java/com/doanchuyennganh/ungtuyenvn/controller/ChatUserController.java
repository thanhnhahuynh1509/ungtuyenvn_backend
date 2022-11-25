package com.doanchuyennganh.ungtuyenvn.controller;

import com.doanchuyennganh.ungtuyenvn.dto.ChatDTO;
import com.doanchuyennganh.ungtuyenvn.dto.ChatUserDTO;
import com.doanchuyennganh.ungtuyenvn.dto.NguoiDungShortDTO;
import com.doanchuyennganh.ungtuyenvn.entity.Chat;
import com.doanchuyennganh.ungtuyenvn.entity.ChatUser;
import com.doanchuyennganh.ungtuyenvn.entity.NguoiDung;
import com.doanchuyennganh.ungtuyenvn.services.ChatUserService;
import com.doanchuyennganh.ungtuyenvn.services.NguoiDungService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/chatusers")
public class ChatUserController {
    private final ChatUserService chatUserService;
    private final NguoiDungService nguoiDungService;
    private final ModelMapper modelMapper;

    public ChatUserController(ChatUserService baseService, NguoiDungService nguoiDungService, ModelMapper modelMapper) {
        this.chatUserService = baseService;
        this.nguoiDungService = nguoiDungService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("")
    public ResponseEntity<ChatUserDTO> save(@RequestBody ChatUserDTO chatUserDTO) {
        if(chatUserService.isExists(chatUserDTO.getOwner().getId(), chatUserDTO.getTo().getId())
        || chatUserService.isExists(chatUserDTO.getTo().getId(), chatUserDTO.getOwner().getId())) {
            return new ResponseEntity<>(new ChatUserDTO(), HttpStatus.OK);
        }
        ChatUser chat = modelMapper.map(chatUserDTO, ChatUser.class);
        chat = chatUserService.save(chat);
        ChatUserDTO result = modelMapper.map(chat, ChatUserDTO.class);
        NguoiDung owner = nguoiDungService.get(result.getOwner().getId());
        NguoiDung to = nguoiDungService.get(result.getTo().getId());
        result.setOwner(modelMapper.map(owner, NguoiDungShortDTO.class));
        result.setTo(modelMapper.map(to, NguoiDungShortDTO.class));
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<ChatUserDTO>> gets() {
        List<ChatUserDTO> chatUserDTOS = new ArrayList<>();
        for(ChatUser chatUser : chatUserService.gets()) {
            chatUserDTOS.add(modelMapper.map(chatUser, ChatUserDTO.class));
        }
        return new ResponseEntity<>(chatUserDTOS, HttpStatus.OK);
    }

    @GetMapping("/chat/{id}")
    public ResponseEntity<List<ChatDTO>> getByChatUser(@PathVariable long id) {
        List<ChatDTO> chatDTOS = new ArrayList<>();
        for(Chat chat : chatUserService.getAllByChatUser(id)) {
            chatDTOS.add(modelMapper.map(chat, ChatDTO.class));
        }
        return new ResponseEntity<>(chatDTOS, HttpStatus.OK);
    }

    @GetMapping("/all/{ownerId}")
    public ResponseEntity<List<ChatUserDTO>> getAllByOwnerAndTo(@PathVariable long ownerId) {
        List<ChatUserDTO> chatUserDTOS = new ArrayList<>();
        List<ChatUser> chatUsers = chatUserService.getAllByOwner(ownerId);
        for(ChatUser chatUser : chatUsers) {
            chatUserDTOS.add(modelMapper.map(chatUser, ChatUserDTO.class));
        }
        return new ResponseEntity<>(chatUserDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatUserDTO> get(@PathVariable long id) {
        ChatUser chatUser = chatUserService.get(id);
        ChatUserDTO chatUserDTO = modelMapper.map(chatUser, ChatUserDTO.class);
        return new ResponseEntity<>(chatUserDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        chatUserService.delete(id);
        return "OK";
    }

}
