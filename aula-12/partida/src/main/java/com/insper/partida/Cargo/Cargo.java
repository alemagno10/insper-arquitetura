package com.insper.partida.Cargo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.insper.partida.Funcionario.Funcionario;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String salary;
    
    @JsonIgnore
    @OneToMany(mappedBy = "funcionarios")
    private List<Funcionario> func;
}
