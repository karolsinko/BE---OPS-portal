package com.example.projekt.Skripta.Controller;

import com.example.projekt.Skripta.Entity.SkriptaLinuxEntity;
import com.example.projekt.Skripta.Model.Skripta;
import com.example.projekt.Skripta.Service.SkriptaLinuxService;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
public class SkriptaLinuxController {
    private final SkriptaLinuxService skriptaLinuxService;

    public SkriptaLinuxController(SkriptaLinuxService skriptaLinuxService) {
        this.skriptaLinuxService = skriptaLinuxService;
    }

    @PostMapping("api/skripta/linux")
    public SkriptaLinuxEntity vytvorSkript(@RequestBody SkriptaLinuxEntity skriptaLinuxEntity) {
        return skriptaLinuxService.vytvorSkript(skriptaLinuxEntity);
    }

    @GetMapping("/api/skripta/linux")
    public List<Skripta> dostanSkript() {
        List<Skripta> entities = skriptaLinuxService.dostanSkript();
        entities.sort(new Comparator<>() {
            @Override
            public int compare(Skripta entity1, Skripta entity2) {
                return Integer.compare(Math.toIntExact(entity1.getId()), Math.toIntExact(entity2.getId()));
            }
        });
        return entities;
    }

    @GetMapping("api/skripta/linux/{id}")
    public SkriptaLinuxEntity dostanSkriptPodlaId(@PathVariable Long id) {
        return skriptaLinuxService.dostanSkriptPodlaId(id);
    }

    @PutMapping("api/skripta/linux/{id}")
    public SkriptaLinuxEntity modifikujSkript(@PathVariable Long id, @RequestBody SkriptaLinuxEntity skriptaLinuxEntity) {
        return skriptaLinuxService.modifikujSkript(id, skriptaLinuxEntity);
    }

    @DeleteMapping("api/skripta/linux/{id}")
    public void vymazSkript(@PathVariable Long id) {
        skriptaLinuxService.vymazSkript(id);
    }
}
