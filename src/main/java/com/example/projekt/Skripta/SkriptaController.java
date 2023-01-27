package com.example.projekt.Skripta;

import com.example.projekt.Uloha.Uloha;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SkriptaController {
    private final SkriptaService skriptaService;

    public SkriptaController(SkriptaService skriptaService) {
        this.skriptaService = skriptaService;
    }

    @PostMapping("api/skripta")
    public SkriptaEntity vytvorSkript(@RequestBody SkriptaEntity skriptaEntity) {
        return skriptaService.vytvorSkript(skriptaEntity);
    }

    @GetMapping("/api/cvicenia")
    public List<Skripta> dostanSkript(){
        return skriptaService.dostanSkript();
    }

    @GetMapping("api/skripta/{id}")
    public SkriptaEntity dostanSkriptPodlaId(@PathVariable Long id) {
        return skriptaService.dostanSkriptPodlaId(id);
    }

    @PutMapping("api/skripta/{id}")
    public SkriptaEntity modifikujSkript(@PathVariable Long id, @RequestBody SkriptaEntity skriptaEntity) {
        return skriptaService.modifikujSkript(id, skriptaEntity);
    }

    @DeleteMapping("api/skripta/{id}")
    public void vymazSkript(@PathVariable Long id) {
        skriptaService.vymazSkript(id);
    }
}
