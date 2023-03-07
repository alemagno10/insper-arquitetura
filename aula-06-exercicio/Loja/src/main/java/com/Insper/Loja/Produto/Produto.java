package com.Insper.Loja.Produto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class Produto {
    private String id;
    @NotNull
    @NotEmpty
    private String name;
    private Double price;
    private Integer supply;
}
