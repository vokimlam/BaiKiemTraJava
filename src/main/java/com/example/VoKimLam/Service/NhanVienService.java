package com.example.VoKimLam.Service;


import com.example.VoKimLam.Repository.NhanVienRepository;
import com.example.VoKimLam.model.NhanVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    public List<NhanVien> getAllNhanVien() {
        return nhanVienRepository.findAll();
    }

    public void saveNhanVien(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    public Optional<NhanVien> findNhanVienById(String maNV) {
        return nhanVienRepository.findById(maNV);
    }

    public void deleteNhanVien(String maNV) {
        nhanVienRepository.deleteById(maNV);
    }
}
