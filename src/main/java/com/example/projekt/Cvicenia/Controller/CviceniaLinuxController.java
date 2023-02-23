package com.example.projekt.Cvicenia.Controller;

import com.example.projekt.Cvicenia.Entity.CviceniaLinuxEntity;
import com.example.projekt.Cvicenia.Model.Cvicenia;
import com.example.projekt.Cvicenia.Service.CviceniaLinuxService;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
public class CviceniaLinuxController {

    private final CviceniaLinuxService cviceniaLinuxService;

    public CviceniaLinuxController(CviceniaLinuxService cviceniaLinuxService) {
        this.cviceniaLinuxService = cviceniaLinuxService;
    }

    //controller pre LINUX ULOHY vseobecne
    @PostMapping("api/cvicenia/linux")
    public CviceniaLinuxEntity vytvorLinuxUlohu(@RequestBody CviceniaLinuxEntity ulohaLinuxEntity) {
        return cviceniaLinuxService.vytvorLinuxUlohu(ulohaLinuxEntity);
    }

    @GetMapping("/api/cvicenia/linux")
    public List<Cvicenia> dostanLinuxOtazku(){
        List<Cvicenia> entities = cviceniaLinuxService.dostanLinuxOtazku();
        entities.sort(new Comparator<>() {
            @Override
            public int compare(Cvicenia entity1, Cvicenia entity2) {
                return Integer.compare(Math.toIntExact(entity1.getId()), Math.toIntExact(entity2.getId()));
            }
        });
        return entities;
    }

    @GetMapping("api/cvicenia/linux/{id}")
    public Cvicenia dostanLinuxOtazkuCezId(@PathVariable Long id) {
        return cviceniaLinuxService.dostanLinuxOtazkuCezId(id);
    }

    @PutMapping("api/cvicenia/linux/{id}")
    public CviceniaLinuxEntity modifikujLinuxOtazku(@PathVariable Long id, @RequestBody CviceniaLinuxEntity ulohaLinuxEntity) {
        return cviceniaLinuxService.modifikujLinuxOtazku(id, ulohaLinuxEntity);
    }

    @DeleteMapping("api/cvicenia/linux/{id}")
    public void vymazLinuxOtazku(@PathVariable Long id) {
        cviceniaLinuxService.vymazCOtazku(id);
    }

}
