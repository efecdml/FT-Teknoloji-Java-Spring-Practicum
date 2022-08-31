package org.efecdml.ftteknolojijavaspringpracticum.urunyorum;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UrunYorumRepository extends JpaRepository<UrunYorum, Long> {
    @Query(value = "SELECT * FROM urun_yorum u WHERE u.urun_id = :id", nativeQuery = true)
    List<UrunYorum> findByUrunId(Long id);

    @Query(value = "SELECT * FROM urun_yorum u WHERE u.urun_id = :urunId AND DATE(u.yorum_tarihi) > :startDate AND DATE(u.yorum_tarihi) < :endDate", nativeQuery = true)
    List<UrunYorum> findAllByUrunAndTarih(Long urunId, LocalDateTime startDate, LocalDateTime endDate);

    @Query(value = "SELECT * FROM urun_yorum u WHERE u.kullanici_id = :kullaniciId", nativeQuery = true)
    List<UrunYorum> findAllByKullaniciId(Long kullaniciId);

    @Query(value = "SELECT * FROM urun_yorum u WHERE u.kullanici_id = :kullaniciId AND DATE(u.yorum_tarihi) > :startDate AND DATE(u.yorum_tarihi) < :endDate", nativeQuery = true)
    List<UrunYorum> findAllByKullaniciIdAndDate(Long kullaniciId, LocalDateTime startDate, LocalDateTime endDate);
}
