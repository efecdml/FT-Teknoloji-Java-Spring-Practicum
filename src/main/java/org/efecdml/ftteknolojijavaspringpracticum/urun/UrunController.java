package org.efecdml.ftteknolojijavaspringpracticum.urun;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/urun")
@AllArgsConstructor
@RestController
public class UrunController {
    private final UrunService urunService;

    @GetMapping
    public List<Urun> getAllUruns() {
        return urunService.getAllUruns();
    }

    @GetMapping("/sonKullanmaTarihiGecmisUruns")
    public List<Urun> getAllSonKullanmaTarihiGecmisUruns() {
        return urunService.getAllSonKullanmaTarihiGecmisUruns();
    }

    @GetMapping("/sonKullanmaTarihiGecmemisUruns")
    public List<Urun> getAllSonKullanmaTarihiGecmemisUruns() {
        return urunService.getAllSonKullanmaTarihiGecmemisUruns();
    }

    @PostMapping
    public void addUrun(@RequestBody Urun urun) {
        urunService.addUrun(urun);
    }
}
