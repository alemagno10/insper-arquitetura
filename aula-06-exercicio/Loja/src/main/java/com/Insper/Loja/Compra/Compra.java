package com.Insper.Loja.Compra;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
public class Compra {
    private String id;
    private LocalDateTime date;
    private List<item> items = new ArrayList<>();
}
