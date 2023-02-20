package org.example.conta;
import java.util.ArrayList;
import java.util.List;

import org.example.conta.Conta;
import org.example.conta.ContaCorrente;
import org.example.pessoa.Pessoa;

public class ContaService {
    private List<Conta> contas = new ArrayList<>();

    public void cadastrar(String nome, String cpf, Float saldo, Float limite){
        Pessoa pes = new Pessoa(nome, cpf);
        contas.add(new ContaCorrente(saldo, pes, limite));
    }

    public List<Conta> listar(){
        return contas;
    }

    public Conta buscar(String cpf){
        for (Conta conta : contas) {
            if(conta.getPessoa().getCpf().equals(cpf)){
                return conta;
            }                   
        } return null;
    }
}
