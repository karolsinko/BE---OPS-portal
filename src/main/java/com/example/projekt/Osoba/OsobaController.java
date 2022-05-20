package com.example.projekt.Osoba;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class OsobaController {

    private final OsobaService osobaService;

    public OsobaController(OsobaService osobaService){
        this.osobaService = osobaService;
    }

    @PostMapping("/api/osoba")
    public int createOsoba(@RequestBody Osoba osoba){
        return osobaService.createOsoba(osoba);
    }

    @GetMapping("/api/osoba")
    public List<Osoba> getOsobaByPriezvisko(@RequestParam(required = false) String priezvisko){
        return osobaService.getOsobaByPriezvisko();
    }

    @GetMapping("/api/osoba/{id}")
    public Osoba getOsobaById(@PathVariable int id){
        return osobaService.getOsobaById(id);
    }

    @DeleteMapping("/api/osoba/{id}")
    public void deleteOsoba(@PathVariable int id){
        osobaService.deleteOsoba(id);
    }

    @PutMapping("/api/osoba/{id}")
    public void updateOsoba(@PathVariable int id, @RequestBody Osoba osoba){
        osobaService.updateOsoba(id, osoba);
    }
}
