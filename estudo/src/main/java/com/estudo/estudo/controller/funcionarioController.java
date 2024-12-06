package com.estudo.estudo.controller;

import com.estudo.estudo.DTO.ControladorQuery;
import com.estudo.estudo.model.funcionario;
import com.estudo.estudo.service.funcionarioService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Funcionarios")
public class funcionarioController {

    private final funcionarioService funcService;

    public funcionarioController(funcionarioService funcService) {
        this.funcService = funcService;
    }

    @GetMapping
    public List<funcionario> list( @ModelAttribute ControladorQuery query ) {

        if ( query.getNome() != null && !query.getNome().isEmpty() ) {
            return funcService.BuscaLocalizada( "nome" , query.getNome() );
        }

        if ( query.getSalario() != null ) {
            System.out.println("Salário recebido: " + query.getSalario());
            return funcService.BuscaLocalizada( "salario" , String.valueOf(query.getSalario()) );
        }

        return funcService.listarTodos();
    }

    @GetMapping("/id")
    public Optional findById(long id ) {
        return funcService.buscarPorId( id );
    }

    @PostMapping
    public funcionario salvar( @RequestBody funcionario func ) {
        return funcService.NovoFuncionario( func );
    }

    @PutMapping
    public funcionario atualizar( @RequestParam Long id, @RequestBody funcionario func ) {
        System.out.println("Funcionário recebido: " + func);
        return funcService.EditarFuncionario( id, func );

    }

    @DeleteMapping
    public void remover(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) Double salario
    ) {
        if (id != null) {
            funcService.DeletarFuncionario("id", String.valueOf(id));
        }
        else if (nome != null) {
            funcService.DeletarFuncionario("nome", nome);
        }
        else if (salario != null) {
            funcService.DeletarFuncionario("salario", String.valueOf(salario));
        }
    }

}
