package com.example.projekt.Uloha.Controller;

import com.example.projekt.Uloha.Entity.UlohaCEntity;
import com.example.projekt.Uloha.Service.UlohaCService;
import com.example.projekt.Uloha.Uloha;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
public class UlohaCController {

    private final UlohaCService ulohaCService;

    public UlohaCController(UlohaCService ulohaCService) {
        this.ulohaCService = ulohaCService;
    }

    //controller pre C ULOHY vseobecne
    @PostMapping("api/cvicenia/c")
    public UlohaCEntity vytvorCUlohu(@RequestBody UlohaCEntity ulohaCEntity) {
        return ulohaCService.vytvorCUlohu(ulohaCEntity);
    }

    @GetMapping("/api/cvicenia/c")
    public List<Uloha> dostanCOtazku(){
        List<Uloha> entities = ulohaCService.dostanCOtazku();
        entities.sort(new Comparator<Uloha>() {
            @Override
            public int compare(Uloha entity1, Uloha entity2) {
                return Integer.compare(Math.toIntExact(entity1.getId()), Math.toIntExact(entity2.getId()));
            }
        });
        return entities;
    }

    @GetMapping("api/cvicenia/c/{id}")
    public Uloha dostanCOtazkuCezId(@PathVariable Long id) {
        return ulohaCService.dostanCOtazkuCezId(id);
    }

    @PutMapping("api/cvicenia/c/{id}")
    public UlohaCEntity modifikujCOtazku(@PathVariable Long id, @RequestBody UlohaCEntity ulohaCEntity) {
        return ulohaCService.modifikujCOtazku(id, ulohaCEntity);
    }

    @DeleteMapping("api/cvicenia/c/{id}")
    public void vymazCOtazku(@PathVariable Long id) {
        ulohaCService.vymazCOtazku(id);
    }

}
