package com.example.projekt.Skripta.Controller;

import com.example.projekt.Skripta.Model.Skripta;
import com.example.projekt.Skripta.Entity.SkriptaEntity;
import com.example.projekt.Skripta.Service.SkriptaService;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
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

    @GetMapping("/api/skripta")
    public List<Skripta> dostanSkript(){
        List<Skripta> entities = skriptaService.dostanSkript();
        entities.sort(new Comparator<>() {
            @Override
            public int compare(Skripta entity1, Skripta entity2) {
                return Integer.compare(Math.toIntExact(entity1.getId()), Math.toIntExact(entity2.getId()));
            }
        });
        return entities;
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
