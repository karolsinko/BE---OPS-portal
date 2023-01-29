package com.example.projekt.Uloha.Controller;

import com.example.projekt.Uloha.Entity.UlohaEntity;
import com.example.projekt.Uloha.Uloha;
import com.example.projekt.Uloha.Service.UlohaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UlohaController {

    private final UlohaService ulohaService;

    public UlohaController(UlohaService ulohaService) {
        this.ulohaService = ulohaService;
    }

    //controller pre ULOHY vseobecne
    @PostMapping("api/cvicenia")
    public UlohaEntity vytvorUlohu(@RequestBody UlohaEntity ulohaEntity) {
        return ulohaService.vytvorUlohu(ulohaEntity);
    }

    @GetMapping("/api/cvicenia")
    public List<Uloha> dostanOtazku(){
        return ulohaService.dostanOtazku();
    }

    @GetMapping("api/cvicenia/{id}")
    public Uloha dostanOtazkuCezId(@PathVariable Long id) {
        return ulohaService.dostanOtazkuCezId(id);
    }

    @PutMapping("api/cvicenia/{id}")
    public UlohaEntity modifikujOtazku(@PathVariable Long id, @RequestBody UlohaEntity ulohaEntity) {
        return ulohaService.modifikujOtazku(id, ulohaEntity);
    }

    @DeleteMapping("api/cvicenia/{id}")
    public void vymazOtazku(@PathVariable Long id) {
        ulohaService.vymazOtazku(id);
    }
}
