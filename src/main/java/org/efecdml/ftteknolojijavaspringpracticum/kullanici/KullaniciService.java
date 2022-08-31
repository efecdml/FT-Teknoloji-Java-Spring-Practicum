package org.efecdml.ftteknolojijavaspringpracticum.kullanici;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class KullaniciService {
    private final KullaniciRepository kullaniciRepository;

    public List<Kullanici> getAllKullanicis() {
        return kullaniciRepository.findAll();
    }

    public void addKullanici(Kullanici kullanici) {
        kullaniciRepository.save(kullanici);
    }
}
