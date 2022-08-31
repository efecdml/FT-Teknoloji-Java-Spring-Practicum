package org.efecdml.ftteknolojijavaspringpracticum.kullanici;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Kullanici {
    @SequenceGenerator(
            name = "kullanici_sequence",
            sequenceName = "kullanici_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "kullanici_sequence"
    )
    @Id
    private Long id;
    @Column(length = 50, nullable = false)
    private String adi;
    @Column(length = 50, nullable = false)
    private String soyadi;
    @Column(length = 50, nullable = false)
    private String email;
    @Column(length = 15, nullable = false)
    private int telefon;
}
