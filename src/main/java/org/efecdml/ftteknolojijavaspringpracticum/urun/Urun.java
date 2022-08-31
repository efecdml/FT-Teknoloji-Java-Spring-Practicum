package org.efecdml.ftteknolojijavaspringpracticum.urun;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Urun {
    @SequenceGenerator(
            name = "urun_sequence",
            sequenceName = "urun_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "urun_sequence"
    )
    @Id
    private Long id;
    @Column(nullable = false)
    private String adi;
    @Column(nullable = false)
    private double fiyat;
    private LocalDateTime sonKullanmaTarihi;
}
