package com.doanchuyennganh.ungtuyenvn.controller;

import com.doanchuyennganh.ungtuyenvn.dto.ChatDTO;
import com.doanchuyennganh.ungtuyenvn.entity.Chat;
import com.doanchuyennganh.ungtuyenvn.entity.NguoiDung;
import com.doanchuyennganh.ungtuyenvn.services.ChatService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController  {
    private final ChatService chatService;
    private final ModelMapper modelMapper;

    public ChatController(ChatService baseService, ModelMapper modelMapper) {
        this.chatService = baseService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("")
    public ResponseEntity<ChatDTO> save(@RequestBody ChatDTO chatDTO) {
        Chat chat = modelMapper.map(chatDTO, Chat.class);
        chat = chatService.save(chat);
        chatDTO.setId(chat.getId());
        return new ResponseEntity<>(chatDTO, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<ChatDTO>> gets() {
        List<ChatDTO> list = new ArrayList<>();

        for(Chat chat : chatService.gets()) {
            ChatDTO chatDTO = modelMapper.map(chat, ChatDTO.class);
            list.add(chatDTO);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatDTO> get(@PathVariable long id) {
        Chat chat = chatService.get(id);
        ChatDTO chatDTO = modelMapper.map(chat, ChatDTO.class);
        return new ResponseEntity<>(chatDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        chatService.delete(id);
        return "OK";
    }

}
