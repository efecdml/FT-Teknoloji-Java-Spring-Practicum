package org.efecdml.ftteknolojijavaspringpracticum.kullanici;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/kullanici")
@AllArgsConstructor
@RestController
public class KullaniciController {
    private final KullaniciService kullaniciService;

    @GetMapping
    public List<Kullanici> getAllKullanicis() {
        return kullaniciService.getAllKullanicis();
    }

    @PostMapping
    public void addKullanici(@RequestBody Kullanici kullanici) {
        kullaniciService.addKullanici(kullanici);
    }
}
