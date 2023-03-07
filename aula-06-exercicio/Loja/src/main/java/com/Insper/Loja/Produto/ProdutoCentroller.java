package com.Insper.Loja.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import java.util.*;

@RestController
@RequestMapping("/product")
public class ProdutoCentroller {

    @Autowired
    private ProdutoService productService;

    @GetMapping
    public List<Produto> getProducts(){
        return productService.allProducts();
    }

    @PostMapping
    public Produto saveItem(@RequestBody @Valid Produto product){
        return productService.saveProduct(product);
    }

    @DeleteMapping
    public Produto deleteItem(@RequestParam String id){
        return productService.deleteProduct(id);
    }

    @PutMapping
    public Produto editItem(@RequestBody @Valid Produto product){
        return productService.editProduct(product);
    }
}

        