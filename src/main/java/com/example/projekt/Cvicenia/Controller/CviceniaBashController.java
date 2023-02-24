package com.example.projekt.Cvicenia.Controller;

import com.example.projekt.Cvicenia.Entity.CviceniaBashEntity;
import com.example.projekt.Cvicenia.Model.Cvicenia;
import com.example.projekt.Cvicenia.Service.CviceniaBashService;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
public class CviceniaBashController {
    private final CviceniaBashService ulohaBashService;

    public CviceniaBashController(CviceniaBashService ulohaBashService) {
        this.ulohaBashService = ulohaBashService;
    }

    //controller pre Bash ULOHY vseobecne
    @PostMapping("api/cvicenia/bash")
    public CviceniaBashEntity vytvorBashUlohu(@RequestBody CviceniaBashEntity ulohaBashEntity) {
        return ulohaBashService.vytvorBashUlohu(ulohaBashEntity);
    }

    @GetMapping("/api/cvicenia/bash")
    public List<Cvicenia> dostanBashOtazku() {
        List<Cvicenia> entities = ulohaBashService.dostanBashOtazku();
        entities.sort(new Comparator<>() {
            @Override
            public int compare(Cvicenia entity1, Cvicenia entity2) {
                return Integer.compare(Math.toIntExact(entity1.getId()), Math.toIntExact(entity2.getId()));
            }
        });
        return entities;
    }

    @GetMapping("api/cvicenia/bash/{id}")
    public Cvicenia dostanBashOtazkuCezId(@PathVariable Long id) {
        return ulohaBashService.dostanBashOtazkuCezId(id);
    }

    @PutMapping("api/cvicenia/bash/{id}")
    public CviceniaBashEntity modifikujBashOtazku(@PathVariable Long id, @RequestBody CviceniaBashEntity ulohaBashEntity) {
        return ulohaBashService.modifikujBashOtazku(id, ulohaBashEntity);
    }

    @DeleteMapping("api/cvicenia/bash/{id}")
    public void vymazBashOtazku(@PathVariable Long id) {
        ulohaBashService.vymazBashOtazku(id);
    }

}
