package org.efecdml.ftteknolojijavaspringpracticum.urunyorum;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/urunyorum")
@AllArgsConstructor
@RestController
public class UrunYorumController {
    private final UrunYorumService urunYorumService;

    @GetMapping
    public List<UrunYorum> getAllUrunYorums() {
        return urunYorumService.getAllUrunYorums();
    }

    @GetMapping("/getAllUrunYorumsByUrunId")
    public List<UrunYorum> getAllUrunYorumsByUrunId(@RequestParam Long urunId) {
        return urunYorumService.getAllUrunYorumsByUrunId(urunId);
    }

    @GetMapping("/getAllUrunYorumsByUrunIdAndDate")
    public List<UrunYorum> getAllUrunYorumsByUrunIdAndDate(
            @RequestParam Long urunId,
            @RequestParam String startDate,
            @RequestParam String endDate
    ) {
        return urunYorumService.getAllUrunYorumsByUrunIdAndDate(
                urunId,
                LocalDateTime.parse(startDate),
                LocalDateTime.parse(endDate)
        );
    }

    @GetMapping("/getAllUrunYorumsByKullaniciId")
    public List<UrunYorum> getAllUrunYorumsByKullaniciId(@RequestParam Long kullaniciId) {
        return urunYorumService.getAllUrunYorumsByKullaniciId(kullaniciId);
    }

    @GetMapping("/getAllUrunYorumsByKullaniciIdAndDate")
    public List<UrunYorum> getAllUrunYorumByKullaniciIdAndDate(
            @RequestParam Long kullaniciId,
            @RequestParam String startDate,
            @RequestParam String endDate
    ) {
        return urunYorumService.getAllUrunYorumsByKullaniciIdAndDate(
                kullaniciId,
                LocalDateTime.parse(startDate),
                LocalDateTime.parse(endDate)
        );
    }

    @PostMapping("/{kullaniciId}/{urunId}")
    public void addUrunYorum(
            @PathVariable("kullaniciId") Long kullaniciId,
            @PathVariable("urunId") Long urunId,
            @RequestParam(required = false) String urunYorum
    ) {
        urunYorumService.addUrunYorum(
                urunYorum,
                kullaniciId,
                urunId);
    }
}
