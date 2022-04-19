package com.example.projekt.Ockovanost;
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
    public int createOckovanost(@RequestBody Ockovanost ockovanost){
        return ockovanostService.createOckovanost(ockovanost);
    }

    @DeleteMapping("/api/ockovanost/{id}")
    public void deleteOckovanost(@PathVariable int id){
        ockovanostService.deleteOckovanost(id);
    }

    @PutMapping("/api/ockovanost/{id}")
    public void updateOckovanost(@PathVariable int id, @RequestBody Ockovanost ockovanost){
        ockovanostService.updateOckovanost(id, ockovanost);
    }

}
