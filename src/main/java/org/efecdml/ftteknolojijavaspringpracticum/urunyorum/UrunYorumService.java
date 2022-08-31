package org.efecdml.ftteknolojijavaspringpracticum.urunyorum;

import lombok.AllArgsConstructor;
import org.efecdml.ftteknolojijavaspringpracticum.kullanici.Kullanici;
import org.efecdml.ftteknolojijavaspringpracticum.kullanici.KullaniciRepository;
import org.efecdml.ftteknolojijavaspringpracticum.urun.Urun;
import org.efecdml.ftteknolojijavaspringpracticum.urun.UrunRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class UrunYorumService {
    private final UrunYorumRepository urunYorumRepository;
    private final KullaniciRepository kullaniciRepository;
    private final UrunRepository urunRepository;

    public List<UrunYorum> getAllUrunYorums() {
        return urunYorumRepository.findAll();
    }

    public List<UrunYorum> getAllUrunYorumsByUrunId(Long urunId) {
        return urunYorumRepository.findByUrunId(urunId);
    }

    public List<UrunYorum> getAllUrunYorumsByUrunIdAndDate(
            Long urunId,
            LocalDateTime startDate,
            LocalDateTime endDate
    ) {
        return urunYorumRepository.findAllByUrunAndTarih(
                urunId,
                startDate,
                endDate
        );
    }

    public List<UrunYorum> getAllUrunYorumsByKullaniciId(Long kullaniciId) {
        return urunYorumRepository.findAllByKullaniciId(kullaniciId);
    }

    public List<UrunYorum> getAllUrunYorumsByKullaniciIdAndDate(
            Long kullaniciId,
            LocalDateTime startDate,
            LocalDateTime endDate
    ) {
        return urunYorumRepository.findAllByKullaniciIdAndDate(kullaniciId, startDate, endDate);
    }

    public void addUrunYorum(
            String yorum,
            Long kullaniciId,
            Long urunId
    ) {
        UrunYorum urunYorum = new UrunYorum();

        Kullanici kullanici = kullaniciRepository.findById(kullaniciId)
                .orElseThrow(() -> new IllegalStateException("Kullanıcı bulunamadı.."));

        Urun urun = urunRepository.findById(urunId)
                .orElseThrow(() -> new IllegalStateException("Ürün bulunamadı.."));

        urunYorum.setKullaniciId(kullanici);
        urunYorum.setUrunId(urun);
        urunYorum.setYorumTarihi(LocalDateTime.now());
        urunYorum.setYorum(yorum);

        urunYorumRepository.save(urunYorum);
    }
}
