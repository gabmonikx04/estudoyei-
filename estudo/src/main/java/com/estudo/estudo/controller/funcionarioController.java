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
    public List<funcionario> list( ControladorQuery query ) {

        if ( query.getNome() != null && !query.getNome().isEmpty() ) {
            return funcService.BuscaLocalizada( "nome" , query.getNome() );
        }

        if ( query.getSalario() != null ) {
            return funcService.BuscaLocalizada( "salario" , String.valueOf(query.getSalario()) );
        }

        return funcService.listarTodos();
    }

    @GetMapping("/id")
    public Optional findById(long id ) {
        return funcService.buscarPorId( id );
    }

    @PostMapping
    public void salvar( funcionario func ) {
        funcService.NovoFuncionario( func );
    }

    @PutMapping
    public void atualizar( @RequestParam ControladorQuery query, @RequestBody funcionario func ) {

        funcService.EditarFuncionario( query, func );

    }


}
