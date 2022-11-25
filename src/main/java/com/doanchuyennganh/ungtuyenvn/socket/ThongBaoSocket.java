package com.doanchuyennganh.ungtuyenvn.socket;

import com.doanchuyennganh.ungtuyenvn.entity.Chat;
import com.doanchuyennganh.ungtuyenvn.entity.ChatUser;
import com.doanchuyennganh.ungtuyenvn.entity.NguoiDung;
import com.doanchuyennganh.ungtuyenvn.entity.ThongBao;
import com.doanchuyennganh.ungtuyenvn.services.ChatUserService;
import com.doanchuyennganh.ungtuyenvn.services.NguoiDungService;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ThongBaoSocket {

    private final NguoiDungService nguoiDungService;
    private final ChatUserService chatUserService;

    public ThongBaoSocket(NguoiDungService nguoiDungService, ChatUserService chatUserService) {
        this.nguoiDungService = nguoiDungService;
        this.chatUserService = chatUserService;
    }

    @MessageMapping("/{maNguoiGui}/{maNguoiNhan}")
    @SendTo("/topic/{maNguoiNhan}")
    public NguoiDung nhanThongBao(@DestinationVariable long maNguoiGui, @DestinationVariable long maNguoiNhan) {
        NguoiDung nguoiGui = nguoiDungService.get(maNguoiGui);

        ThongBao thongBao = new ThongBao();
        thongBao.setNgayThongBao(new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new Date()));
        String tenNguoiGui = nguoiGui.getTen() + " " + nguoiGui.getHo();
        thongBao.setTieuDe("Người dùng " + tenNguoiGui + " muốn chiêu mộ bạn");
        thongBao.setNoiDung("Liên hệ với " + tenNguoiGui + " qua email " + nguoiGui.getEmail());
        return nguoiDungService.themThongBao(maNguoiNhan, thongBao);
    }

    @MessageMapping("/chat/{maNguoiGui}/{maNguoiNhan}/{chatUserId}")
    @SendTo("/topic/chat/{maNguoiNhan}")
    public String nhanTin(@DestinationVariable long maNguoiGui, @DestinationVariable long maNguoiNhan, @DestinationVariable long chatUserId, String message) {
        new Thread(() -> {
            Chat chat = new Chat();
            chat.setContent(message);
            chat.setOwner(new NguoiDung(maNguoiGui));

            ChatUser chatUser = chatUserService.get(chatUserId);
            chatUser.setRead(false);
            chatUser.getChats().add(chat);
            chatUserService.save(chatUser);
            System.out.println("done");
        }).start();
        return message;
    }

}
