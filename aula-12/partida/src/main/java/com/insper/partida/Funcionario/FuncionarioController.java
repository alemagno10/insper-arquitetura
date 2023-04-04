package com.insper.partida.Funcionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/funcionario")

public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;
    
    @GetMapping
    public List<Funcionario> listFuncionarios(@RequestParam(required = false) Integer id){
        return funcionarioService.listFuncionarios(id);
    }

    @PostMapping
    public Funcionario saveFuncionario(@RequestBody Funcionario c){
        return funcionarioService.saveFuncionario(c);
    }
}
