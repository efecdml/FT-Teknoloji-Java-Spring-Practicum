package org.efecdml.ftteknolojijavaspringpracticum.urun;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UrunRepository extends JpaRepository<Urun, Long> {
    @Query(value = "SELECT * FROM urun u WHERE DATE(u.son_kullanma_tarihi) <= now()", nativeQuery = true)
    List<Urun> findAllBySonKullanmaTarihiGecmis();

    @Query(value = "SELECT * FROM urun u WHERE DATE(u.son_kullanma_tarihi) > now() OR DATE(u.son_kullanma_tarihi) is NULL", nativeQuery = true)
    List<Urun> findAllBySonKullanmaTarihiGecmemis();
}
