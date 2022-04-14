package com.example.projekt.Vakcina;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class VakcinaController {

    private VakcinaService vakcinaService;

    public VakcinaController(VakcinaService vakcinaService){
        this.vakcinaService = vakcinaService;
    }

    @PostMapping("/api/vakcina")
    public int createVakcina(@PathVariable Vakcina vakcina){
        return vakcinaService.createVakcina(vakcina);
    }

    @GetMapping("/api/vakcina")
    public List<Vakcina> getVakcinaByNazov(@RequestParam(required = false) String nazov){
        return vakcinaService.getVakcinaByNazov();
    }

    @GetMapping("/api/vakcina/{id}")
    public Vakcina getVakcinaById(@PathVariable int id){
        return vakcinaService.getVakcinaById(id);
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

