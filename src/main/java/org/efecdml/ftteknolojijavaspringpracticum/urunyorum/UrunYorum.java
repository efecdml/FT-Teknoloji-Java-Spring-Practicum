package org.efecdml.ftteknolojijavaspringpracticum.urunyorum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.efecdml.ftteknolojijavaspringpracticum.kullanici.Kullanici;
import org.efecdml.ftteknolojijavaspringpracticum.urun.Urun;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UrunYorum {
    @SequenceGenerator(
            name = "urunYorum_sequence",
            sequenceName = "urunYorum_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "urunYorum_sequence"
    )
    @Id
    private Long id;
    @Column(length = 500, nullable = false)
    private String yorum;
    @Column(nullable = false)
    private LocalDateTime yorumTarihi;
    @JoinColumn(name = "urunId", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Urun urunId;
    @JoinColumn(name = "kullaniciId", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Kullanici kullaniciId;
}
