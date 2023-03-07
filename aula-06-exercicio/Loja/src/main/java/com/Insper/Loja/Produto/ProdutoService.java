package com.Insper.Loja.Produto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService {
    private List<Produto> products = new ArrayList<>();

    public List<Produto> allProducts(){
        return products;
    }

    public Produto saveProduct(Produto product){
        product.setId(UUID.randomUUID().toString());
        products.add(product);
        return product;
    }

    public Produto deleteProduct(String id){
        for (Produto p : products) {
            if(id.equals(p.getId())){
                products.remove(p);
                return p;
            }
        }
        return null;
    }

    public Produto editProduct(Produto product){
        if(deleteProduct(product.getId()) != null){
            products.add(product);
            return product;
        }
        return null;
    }

    public Produto getProduct(String id){
        for (Produto p : products) {
            if(id.equals(p.getId())){
                return p;
            }
        }
        return null;
    }
}
