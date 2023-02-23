package com.example.projekt.Cvicenia.Controller;

import com.example.projekt.Cvicenia.Entity.CviceniaCEntity;
import com.example.projekt.Cvicenia.Model.Cvicenia;
import com.example.projekt.Cvicenia.Service.CviceniaCService;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
public class CviceniaCController {

    private final CviceniaCService ulohaCService;

    public CviceniaCController(CviceniaCService ulohaCService) {
        this.ulohaCService = ulohaCService;
    }

    //controller pre C ULOHY vseobecne
    @PostMapping("api/cvicenia/c")
    public CviceniaCEntity vytvorCUlohu(@RequestBody CviceniaCEntity ulohaCEntity) {
        return ulohaCService.vytvorCUlohu(ulohaCEntity);
    }

    @GetMapping("/api/cvicenia/c")
    public List<Cvicenia> dostanCOtazku(){
        List<Cvicenia> entities = ulohaCService.dostanCOtazku();
        entities.sort(new Comparator<>() {
            @Override
            public int compare(Cvicenia entity1, Cvicenia entity2) {
                return Integer.compare(Math.toIntExact(entity1.getId()), Math.toIntExact(entity2.getId()));
            }
        });
        return entities;
    }

    @GetMapping("api/cvicenia/c/{id}")
    public Cvicenia dostanCOtazkuCezId(@PathVariable Long id) {
        return ulohaCService.dostanCOtazkuCezId(id);
    }

    @PutMapping("api/cvicenia/c/{id}")
    public CviceniaCEntity modifikujCOtazku(@PathVariable Long id, @RequestBody CviceniaCEntity ulohaCEntity) {
        return ulohaCService.modifikujCOtazku(id, ulohaCEntity);
    }

    @DeleteMapping("api/cvicenia/c/{id}")
    public void vymazCOtazku(@PathVariable Long id) {
        ulohaCService.vymazCOtazku(id);
    }

}
