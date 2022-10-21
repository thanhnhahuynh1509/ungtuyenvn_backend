package com.doanchuyennganh.ungtuyenvn.socket;

import com.doanchuyennganh.ungtuyenvn.entity.NguoiDung;
import com.doanchuyennganh.ungtuyenvn.entity.ThongBao;
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

    public ThongBaoSocket(NguoiDungService nguoiDungService) {
        this.nguoiDungService = nguoiDungService;
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
}
