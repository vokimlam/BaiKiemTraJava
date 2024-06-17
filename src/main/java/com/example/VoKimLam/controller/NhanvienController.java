package com.example.VoKimLam.controller;

import com.example.VoKimLam.Service.NhanVienService;
import com.example.VoKimLam.Service.PhongBanService;
import com.example.VoKimLam.model.NhanVien;
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
public class NhanvienController {
    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private PhongBanService phongBanService;

    @GetMapping("/nhanvien")
    public String danhSachNhanVien(Model model) {
        List<NhanVien> danhSachNhanVien = nhanVienService.getAllNhanVien();
        model.addAttribute("danhSachNhanVien", danhSachNhanVien);
        return "nhanvien/danhsach";
    }

    @GetMapping("/nhanvien/add")
    public String addNhanVienForm(Model model) {
        List<PhongBan> danhSachPhongBan = phongBanService.getAllPhongBan();
        model.addAttribute("nhanvien", new NhanVien());
        model.addAttribute("danhSachPhongBan", danhSachPhongBan);
        return "nhanvien/form";
    }

    @PostMapping("/nhanvien/save")
    public String saveNhanVien(@ModelAttribute("nhanvien") NhanVien nhanVien) {
        nhanVienService.saveNhanVien(nhanVien);
        return "redirect:/nhanvien";
    }

    @GetMapping("/nhanvien/edit/{maNV}")
    public String editNhanVienForm(@PathVariable String maNV, Model model) {
        NhanVien nhanVien = nhanVienService.findNhanVienById(maNV)
                .orElseThrow(() -> new IllegalArgumentException("Invalid NhanVien ID:" + maNV));
        List<PhongBan> danhSachPhongBan = phongBanService.getAllPhongBan();
        model.addAttribute("nhanvien", nhanVien);
        model.addAttribute("danhSachPhongBan", danhSachPhongBan);
        return "nhanvien/edit";
    }

    @GetMapping("/nhanvien/delete/{maNV}")
    public String deleteNhanVien(@PathVariable String maNV) {
        nhanVienService.deleteNhanVien(maNV);
        return "redirect:/nhanvien";
    }
}

