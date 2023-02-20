package org.example;

import java.util.ArrayList;
import java.util.Scanner;  

import org.example.conta.Conta;
import org.example.conta.ContaService;
import org.example.conta.ContaCorrente;
import org.example.pessoa.Pessoa;

public class Main {
    public static void main(String[] args) {
        ContaService contaService = new ContaService();
        ArrayList<Conta> contas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        String operacao = "";
        while(!operacao.equals("4")){
            System.out.println("");
            System.out.println("- 1: Criar\n- 2: Lista\n- 3: Buscar\n- 4: Sair");
            System.out.print("Digite a operação: ");
            operacao = sc.nextLine();

            if(operacao.equals("1")){
                System.out.println("");
                System.out.print("Nome: ");
                String nome = sc.next();
                System.out.print("CPF: ");
                String cpf = sc.next();
                System.out.print("Saldo: ");
                float saldo = sc.nextFloat();
                System.out.print("Limite: ");
                float limite = sc.nextFloat();
                contaService.cadastrar(nome,cpf,saldo,limite);
            }

            if(operacao.equals("2")){

                for (Conta conta : contas) {
                    System.out.println(conta.toString());
                }
                System.out.println("");
            }

            if(operacao.equals("3")){
                System.out.print("Busque por CPF: ");
                String cpf = sc.next();
                Conta conta = contaService.buscar(cpf);
                System.out.println(conta != null ? conta.toString(): "Conta não encontrada.");
                System.out.println("");
            }

        }
        sc.close();
    }
}