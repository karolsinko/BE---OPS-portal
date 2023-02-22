package com.example.projekt.Skripta.Controller;

import com.example.projekt.Skripta.Entity.SkriptaBashEntity;
import com.example.projekt.Skripta.Model.Skripta;
import com.example.projekt.Skripta.Service.SkriptaBashService;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
public class SkriptaBashController {
    private final SkriptaBashService skriptaBashService;

    public SkriptaBashController(SkriptaBashService skriptaBashService) {
        this.skriptaBashService = skriptaBashService;
    }

    @PostMapping("api/skripta/bash")
    public SkriptaBashEntity vytvorSkript(@RequestBody SkriptaBashEntity skriptaBashEntity) {
        return skriptaBashService.vytvorSkript(skriptaBashEntity);
    }

    @GetMapping("/api/skripta/bash")
    public List<Skripta> dostanSkript(){
        List<Skripta> entities = skriptaBashService.dostanSkript();
        entities.sort(new Comparator<>() {
            @Override
            public int compare(Skripta entity1, Skripta entity2) {
                return Integer.compare(Math.toIntExact(entity1.getId()), Math.toIntExact(entity2.getId()));
            }
        });
        return entities;
    }

    @GetMapping("api/skripta/bash/{id}")
    public SkriptaBashEntity dostanSkriptPodlaId(@PathVariable Long id) {
        return skriptaBashService.dostanSkriptPodlaId(id);
    }

    @PutMapping("api/skripta/bash/{id}")
    public SkriptaBashEntity modifikujSkript(@PathVariable Long id, @RequestBody SkriptaBashEntity skriptaBashEntity) {
        return skriptaBashService.modifikujSkript(id, skriptaBashEntity);
    }

    @DeleteMapping("api/skripta/bash/{id}")
    public void vymazSkript(@PathVariable Long id) {
        skriptaBashService.vymazSkript(id);
    }
}
