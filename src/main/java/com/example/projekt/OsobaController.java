package com.example.projekt;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class OsobaController {
    private List<Osoba> osoby;

    private OsobaService osobaService;

    public OsobaController(OsobaService osobaService){
        this.osobaService = osobaService;
    }

    @GetMapping("/api/osoba")
    public List<Osoba> getOsobaByPriezvisko(@RequestParam(required = false) String priezvisko){
        return osobaService.getOsobaByPriezvisko(priezvisko);
    }

    @GetMapping("/api/osoba/{id}")
    public List<Osoba> getOsobaById(@PathVariable int id){
        return osobaService.getOsobaById(id);
    }

    @PostMapping("/api/osoba")
    public List<Osoba> createOsoba(@RequestBody Osoba osoba){
        return osobaService.createOsoba(osoba);
    }

    @DeleteMapping("/api/osoba/{id}")
    public void deleteOsoba(@PathVariable int id){
        this.osobaService.deleteOsoba(id);
    }

    @PutMapping("/api/osoba/{id}")
    public List<Osoba> updateOsoba(@PathVariable int id, @RequestBody Osoba osoba){
        return this.osobaService.updateOsoba(id, osoba);
    }
}
