package br.com.conta.api.conta;
import br.com.conta.api.pessoa.Pessoa;
import br.com.conta.api.pessoa.PessoaService;

import java.util.ArrayList;
import java.util.List;

public class ContaService {

    private static ContaService contaService = null;
    private ContaService(){}

    public static ContaService getInstance(){
        if(contaService == null){
            contaService = new ContaService();
        } return contaService;
    }
    
    private PessoaService pessoaService = PessoaService.getInstance();
    private List<Conta> contas = new ArrayList<>();

    public void cadastrar(String cpf, Float saldo, Float limite) {
        Pessoa p = pessoaService.getPessoa(cpf);
        Conta conta = new ContaCorrente(saldo, p, limite);
        contas.add(conta);
    }

    public List<Conta> listar() {
        return contas;
    }

    public Conta buscar(String cpf) {
        Conta conta = null;
        for (Conta c : contas) {
            if (c.getPessoa().getCpf().equals(cpf)) {
                conta = c;
                break;
            }
        }
        return conta;
    }

}
