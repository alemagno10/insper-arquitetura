package org.example.conta;

import org.example.pessoa.Pessoa;

public class Conta {

    private Float saldo = 0f;
    private Pessoa pessoa;

    public Conta() {}

    public Conta(Float saldo, Pessoa pessoa) {
        this.saldo = saldo;
        if (pessoa == null) {
            throw new IllegalStateException();
        }

        this.pessoa = pessoa;
    }

    public void deposito(Float valor) {
        saldo += valor;
    }

    public void saque(Float valor) {
        if (saldo - valor < 0) {
            System.out.println("Saque invalido");
        } else {
            saldo -= valor;
        }
    }

    public String toString(){
        return pessoa.getNome()+" CPF: "+pessoa.getCpf();
    }

    public Float getSaldo() {
        return saldo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
