package com.insper.partida.Cargo;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@RestController
@RequestMapping("/cargo")
public class CargoController {

    @Autowired
    private CargoService cargoService;
    
    @GetMapping
    public List<Cargo> allCargos(){
        return cargoService.allCargos();
    }

    @PostMapping
    public Cargo saveCargo(@RequestBody Cargo c){
        return cargoService.saveCargo(c);
    }
}
