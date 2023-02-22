package com.example.projekt.Skripta.Controller;

import com.example.projekt.Skripta.Entity.SkriptaCEntity;
import com.example.projekt.Skripta.Model.Skripta;
import com.example.projekt.Skripta.Service.SkriptaCService;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
public class SkriptaCController {
    private final SkriptaCService skriptaCService;

    public SkriptaCController(SkriptaCService skriptaCService) {
        this.skriptaCService = skriptaCService;
    }

    @PostMapping("api/skripta/c")
    public SkriptaCEntity vytvorSkript(@RequestBody SkriptaCEntity skriptaCEntity) {
        return skriptaCService.vytvorSkript(skriptaCEntity);
    }

    @GetMapping("/api/skripta/c")
    public List<Skripta> dostanSkript(){
        List<Skripta> entities = skriptaCService.dostanSkript();
        entities.sort(new Comparator<Skripta>() {
            @Override
            public int compare(Skripta entity1, Skripta entity2) {
                return Integer.compare(Math.toIntExact(entity1.getId()), Math.toIntExact(entity2.getId()));
            }
        });
        return entities;
    }

    @GetMapping("api/skripta/c/{id}")
    public SkriptaCEntity dostanSkriptPodlaId(@PathVariable Long id) {
        return skriptaCService.dostanSkriptPodlaId(id);
    }

    @PutMapping("api/skripta/c/{id}")
    public SkriptaCEntity modifikujSkript(@PathVariable Long id, @RequestBody SkriptaCEntity skriptaCEntity) {
        return skriptaCService.modifikujSkript(id, skriptaCEntity);
    }

    @DeleteMapping("api/skripta/c/{id}")
    public void vymazSkript(@PathVariable Long id) {
        skriptaCService.vymazSkript(id);
    }
}
