package com.example.VoKimLam.controller;



import com.example.VoKimLam.Service.PhongBanService;
import com.example.VoKimLam.model.PhongBan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PhongBanController {
    @Autowired
    private PhongBanService phongBanService;

    @GetMapping("/phongban")
    public String danhSachPhongBan(Model model) {
        List<PhongBan> danhSachPhongBan = phongBanService.getAllPhongBan();
        model.addAttribute("danhSachPhongBan", danhSachPhongBan);
        return "phongban/danhsach";
    }

    @GetMapping("/phongban/add")
    public String addPhongBanForm(Model model) {
        model.addAttribute("phongban", new PhongBan());
        return "phongban/form";
    }

    @PostMapping("/phongban/save")
    public String savePhongBan(@ModelAttribute("phongban") PhongBan phongBan) {
        phongBanService.savePhongBan(phongBan);
        return "redirect:/phongban";
    }

    @GetMapping("/phongban/edit/{maPhong}")
    public String editPhongBanForm(@PathVariable String maPhong, Model model) {
        PhongBan phongBan = phongBanService.findPhongBanById(maPhong)
                .orElseThrow(() -> new IllegalArgumentException("Invalid PhongBan ID:" + maPhong));
        model.addAttribute("phongban", phongBan);
        return "phongban/form";
    }

    @GetMapping("/phongban/delete/{maPhong}")
    public String deletePhongBan(@PathVariable String maPhong) {
        phongBanService.deletePhongBan(maPhong);
        return "redirect:/phongban";
    }
}
