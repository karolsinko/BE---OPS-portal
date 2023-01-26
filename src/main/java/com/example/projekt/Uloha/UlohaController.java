package com.example.projekt.Uloha;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cvicenia")
public class UlohaController {

    private final UlohaService ulohaService;

    public UlohaController(UlohaService ulohaService) {
        this.ulohaService = ulohaService;
    }

    @PostMapping("api/cvicenia")
    public UlohaEntity vytvorUlohu(@RequestBody UlohaEntity ulohaEntity) {
        return ulohaService.vytvorUlohu(ulohaEntity);
    }

    @GetMapping("api/cvicenia/{id}")
    public UlohaEntity dostanOtazkuPodlaId(@PathVariable Long id) {
        return ulohaService.dostanOtazkuPodlaId(id);
    }

    @PutMapping("api/cvicenia/{id}")
    public UlohaEntity modifikujOtazku(@PathVariable Long id, @RequestBody UlohaEntity ulohaEntity) {
        return ulohaService.modifikujOtazku(id, ulohaEntity);
    }

    @DeleteMapping("api/cvicenia/{id}")
    public void vymazOtazku(@PathVariable Long id) {
        ulohaService.vymazOtazku(id);
    }
}
