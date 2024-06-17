package com.example.VoKimLam.Service;

import com.example.VoKimLam.Repository.PhongBanRepository;
import com.example.VoKimLam.model.PhongBan;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
@Transactional
public class PhongBanService {
    private final PhongBanRepository phongBanRepository;

    public List<PhongBan> getAllPhongBan() {
        return phongBanRepository.findAll();
    }

    public PhongBan savePhongBan(PhongBan phongBan) {
        return phongBanRepository.save(phongBan);
    }

    public void deletePhongBan(String maPhong) {
        phongBanRepository.deleteById(maPhong);
    }

    public Optional<PhongBan> findPhongBanById(String maPhong) {
        return phongBanRepository.findById(maPhong);
    }
}
