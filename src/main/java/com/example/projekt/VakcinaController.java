package com.example.projekt;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class VakcinaController {
    private VakcinaService vakcinaService;

    public VakcinaController(VakcinaService vakcinaService){
        this.vakcinaService = vakcinaService;
    }

    @GetMapping("/api/vakcina")
    public List<Vakcina> getVakcinaByNazov(@RequestParam(required = false) String nazov){
        return vakcinaService.getVakcinaByNazov(nazov);
    }

    @GetMapping("/api/vakcina/{id}")
    public Vakcina getVakcinaById(@PathVariable int id){
        return vakcinaService.getVakcinaById(id);
    }

    @PostMapping("/api/vakcina")
    public int createVakcina(@RequestBody Vakcina vakcina){
        return vakcinaService.createVakcina(vakcina);
    }

    @DeleteMapping("/api/vakcina/{id}")
    public void deleteVakcina(@PathVariable int id){
        vakcinaService.deleteVakcina(id);
    }

    @PutMapping("/api/vakcina/{id}")
    public void updateVakcina(@PathVariable int id, @RequestBody Vakcina vakcina){
        vakcinaService.updateVakcina(id, vakcina);
    }
}

