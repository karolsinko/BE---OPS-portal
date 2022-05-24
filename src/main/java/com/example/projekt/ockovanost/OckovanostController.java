package com.example.projekt.ockovanost;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class OckovanostController {
    private OckovanostService ockovanostService;

    public OckovanostController(OckovanostService ockovanostService){
        this.ockovanostService = ockovanostService;
    }

    @GetMapping("/api/ockovanost")
    public List<Ockovanost> getOckovanost(@RequestParam(required = false) String datum){
        return ockovanostService.getOckovanostByDatum(datum);
    }

    @GetMapping("/api/ockovanost/{id}")
    public Ockovanost getOckovanostById(@PathVariable int id){
        return ockovanostService.getOckovanostById(id);
    }

    @PostMapping("/api/ockovanost")
    public int createOckovanost(@RequestBody Ockovanie ockovanie){
        return ockovanostService.createOckovanost(ockovanie);
    }

}
