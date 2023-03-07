package com.Insper.Loja.Compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Insper.Loja.Produto.ProdutoService;

import java.util.*;

@Service
public class CompraService {
    private List<Compra> purchases = new ArrayList<>();

    @Autowired
    private ProdutoService produtoService;

    public List<Compra> allPurchases(){
        return purchases;
    }

    public Compra savePurchase(Compra p){
        p.setId(UUID.randomUUID().toString());
        purchases.add(p);
        return p;
    }
}
