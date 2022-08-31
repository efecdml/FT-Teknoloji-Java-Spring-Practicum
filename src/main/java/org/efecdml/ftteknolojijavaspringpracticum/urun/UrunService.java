package org.efecdml.ftteknolojijavaspringpracticum.urun;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class UrunService {
    private final UrunRepository urunRepository;

    public List<Urun> getAllUruns() {
        return urunRepository.findAll();
    }

    public void addUrun(Urun urun) {
        urunRepository.save(urun);
    }

    public List<Urun> getAllSonKullanmaTarihiGecmisUruns() {
        return urunRepository.findAllBySonKullanmaTarihiGecmis();
    }

    public List<Urun> getAllSonKullanmaTarihiGecmemisUruns() {
        return urunRepository.findAllBySonKullanmaTarihiGecmemis();
    }
}
