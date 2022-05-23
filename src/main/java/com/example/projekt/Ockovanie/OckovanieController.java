package com.example.projekt.Ockovanie;

import com.example.projekt.Osoba.OsobaService;
import com.example.projekt.Vakcina.VakcinaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OckovanieController {
    private final OckovanieService ockovanieService;
    private OsobaService osobaService;
    private VakcinaService vakcinaService;

    public OckovanieController(OckovanieService ockovanieService) {
        this.ockovanieService = ockovanieService;
    }

    @GetMapping("/api/ockovanost/{id}")
    public Ockovanie getOckovanie(@PathVariable int id) {
        return ockovanieService.getOckovanie(id);
    }

    @GetMapping("/api/ockovanost")
    public List<Ockovanie> getOckovania() {
        return ockovanieService.getOckovania();
    }

    @PostMapping("/api/ockovanost")
    public int createOckovanie(@RequestBody Ockovanie ockovanie) {
        return ockovanieService.createOckovanie(ockovanie);
    }

    @DeleteMapping("/api/ockovanost/{id}")
    public void deleteOckovanie(@PathVariable int id) {
        ockovanieService.deleteOckovanie(id);
    }

    @PutMapping("/api/ockovanost/{id}")
    public void upddateOckovanie(@PathVariable int id, @RequestBody Ockovanie ockovanie) {
        ockovanieService.updateOckovanie(id, ockovanie);
    }
}