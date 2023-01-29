package com.example.projekt.Uloha.Controller;

import com.example.projekt.Uloha.Entity.UlohaLinuxEntity;
import com.example.projekt.Uloha.Service.UlohaLinuxService;
import com.example.projekt.Uloha.Uloha;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UlohaLinuxController {

    private final UlohaLinuxService ulohaLinuxService;

    public UlohaLinuxController(UlohaLinuxService ulohaLinuxService) {
        this.ulohaLinuxService = ulohaLinuxService;
    }

    //controller pre LINUX ULOHY vseobecne
    @PostMapping("api/cvicenia/linux")
    public UlohaLinuxEntity vytvorLinuxUlohu(@RequestBody UlohaLinuxEntity ulohaLinuxEntity) {
        return ulohaLinuxService.vytvorLinuxUlohu(ulohaLinuxEntity);
    }

    @GetMapping("/api/cvicenia/linux")
    public List<Uloha> dostanLinuxOtazku(){
        return ulohaLinuxService.dostanLinuxOtazku();
    }

    @GetMapping("api/cvicenia/linux/{id}")
    public Uloha dostanLinuxOtazkuCezId(@PathVariable Long id) {
        return ulohaLinuxService.dostanLinuxOtazkuCezId(id);
    }

    @PutMapping("api/cvicenia/linux/{id}")
    public UlohaLinuxEntity modifikujLinuxOtazku(@PathVariable Long id, @RequestBody UlohaLinuxEntity ulohaLinuxEntity) {
        return ulohaLinuxService.modifikujLinuxOtazku(id, ulohaLinuxEntity);
    }

    @DeleteMapping("api/cvicenia/linux/{id}")
    public void vymazLinuxOtazku(@PathVariable Long id) {
        ulohaLinuxService.vymazCOtazku(id);
    }

}
