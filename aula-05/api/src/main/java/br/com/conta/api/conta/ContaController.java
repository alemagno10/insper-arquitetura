package br.com.conta.api.conta;

import br.com.conta.api.pessoa.Pessoa;
import br.com.conta.api.pessoa.PessoaController;
import br.com.conta.api.pessoa.PessoaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {

    private PessoaService pessoaService = PessoaService.getInstance();
    private ContaService contaService = ContaService.getInstance();

    @GetMapping
    public List<Conta> getContas() {
        return contaService.listar();
    }

    @PostMapping
    public Conta salvarConta(@RequestBody )

}
