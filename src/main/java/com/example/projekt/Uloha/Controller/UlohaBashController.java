package com.example.projekt.Uloha.Controller;

import com.example.projekt.Uloha.Entity.UlohaBashEntity;
import com.example.projekt.Uloha.Service.UlohaBashService;
import com.example.projekt.Uloha.Uloha;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UlohaBashController {
    private final UlohaBashService ulohaBashService;

    public UlohaBashController(UlohaBashService ulohaBashService) {
        this.ulohaBashService = ulohaBashService;
    }

    //controller pre Bash ULOHY vseobecne
    @PostMapping("api/cvicenia/bash")
    public UlohaBashEntity vytvorBashUlohu(@RequestBody UlohaBashEntity ulohaBashEntity) {
        return ulohaBashService.vytvorBashUlohu(ulohaBashEntity);
    }

    @GetMapping("/api/cvicenia/bash")
    public List<Uloha> dostanBashOtazku(){
        return ulohaBashService.dostanBashOtazku();
    }

    @GetMapping("api/cvicenia/bash/{id}")
    public Uloha dostanBashOtazkuCezId(@PathVariable Long id) {
        return ulohaBashService.dostanBashOtazkuCezId(id);
    }

    @PutMapping("api/cvicenia/bash/{id}")
    public UlohaBashEntity modifikujBashOtazku(@PathVariable Long id, @RequestBody UlohaBashEntity ulohaBashEntity) {
        return ulohaBashService.modifikujBashOtazku(id, ulohaBashEntity);
    }

    @DeleteMapping("api/cvicenia/bash/{id}")
    public void vymazBashOtazku(@PathVariable Long id) {
        ulohaBashService.vymazBashOtazku(id);
    }

}
