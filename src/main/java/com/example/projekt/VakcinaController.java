package com.example.projekt;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class VakcinaController {
    private List<Vakcina> vakciny;

    private VakcinaService vakcinaService;

    public VakcinaController(VakcinaService vakcinaService){
        this.vakcinaService = vakcinaService;
    }

    @GetMapping("/api/vakcina")
    public List<Vakcina> getVakcinaByNazov(@RequestParam(required = false) String nazov){
        return vakcinaService.getVakcinaByNazov(nazov);
    }

    @GetMapping("/api/vakcina/{id}")
    public List<Vakcina> getVakcinaById(@PathVariable int id){
        return vakcinaService.getVakcinaById(id);
    }

    @PostMapping("/api/vakcina")
    public List<Vakcina> createVakcina(@RequestBody Vakcina vakcina){
        return vakcinaService.createVakcina(vakcina);
    }

    @DeleteMapping("/api/vakcina/{id}")
    public void deleteVakcina(@PathVariable int id){
        this.vakcinaService.deleteVakcina(id);
    }

    @PutMapping("/api/vakcina/{id}")
    public List<Vakcina> updateVakcina(@PathVariable int id, @RequestBody Vakcina vakcina){
        return this.vakcinaService.updateVakcina(id, vakcina);
    }
}

