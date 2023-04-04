package com.insper.partida.Funcionario;

import com.insper.partida.Cargo.Cargo;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String age;
    private String identifier;
    
    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private Cargo cargo;
}
