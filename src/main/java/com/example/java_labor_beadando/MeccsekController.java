package com.example.java_labor_beadando;

import com.example.java_labor_beadando.modelclasses.Meccsek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

class MeccsekController {

    @Autowired
    private final com.example.java_labor_beadando.repositories.dataRepository dataRepository;

    MeccsekController(com.example.java_labor_beadando.repositories.dataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @GetMapping("/meccs")
    Iterable<Meccsek>olvasMind(){
        return dataRepository.findAll();
    }

    @GetMapping("/meccs/{id}")
    Meccsek olvasEgy(@PathVariable Integer id)
    {
        return dataRepository.findById(id)
                .orElseThrow(() -> new MeccsekNotFoundException(id));
    }

    @PostMapping("/meccs")
    Meccsek meccsekFeltolt(@RequestBody Meccsek ujMeccs) {
        return dataRepository.save(ujMeccs);
    }

    @PutMapping("/meccs/{id}")
    Meccsek meccsekModosit(@RequestBody Meccsek Meccsadat, @PathVariable Integer id) {
        return dataRepository.findById(id)
                .map(a -> {
                    a.setBelepo(Meccsadat.getBelepo());
                    a.setDatum(Meccsadat.getDatum());
                    a.setKezdes(Meccsadat.getKezdes());
                    a.setTipus(Meccsadat.getTipus());
                    return dataRepository.save(a);
                })
                .orElseGet(() -> {
                    Meccsadat.setId(id);
                    return dataRepository.save(Meccsadat);
                });
    }

    @DeleteMapping("/meccs/{id}")
    void torolMeccs(@PathVariable Integer id) {
        dataRepository.deleteById(id);
    }
}

