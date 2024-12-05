package com.estudo.estudo.service;

import com.estudo.estudo.DTO.ControladorQuery;
import com.estudo.estudo.model.funcionario;
import com.estudo.estudo.repository.funcionarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class funcionarioService {

    private final funcionarioRepository func;

    public funcionarioService(funcionarioRepository func) {
        this.func = func;
    }

    public List<funcionario> listarTodos() {
        return func.findAll();
    }

    public Optional<funcionario> buscarPorId(Long id) {
        return func.findById( id );
    }

    public List<funcionario> BuscaLocalizada(String campo, String Valor){

        switch(campo){

            case "nome":
                return func.findByNomeContaining( Valor );
            case "salario":
                return func.findBySalario( Integer.parseInt(Valor) );
            default:
                return (List<funcionario>) new IllegalArgumentException("Campo inválido!");
        }
    }

    public funcionario NovoFuncionario(funcionario funcionario){
        return func.save(funcionario);
    }

    public funcionario EditarFuncionario(ControladorQuery query, funcionario funcionario){
        funcionario retorno = func.findById(query.getId()).orElseThrow(() -> new RuntimeException("Funcionário não encontrado!"));

        if ( funcionario.getNome() != null && !funcionario.getNome().isBlank() ){
            retorno.setNome(funcionario.getNome());
        }

        if ( funcionario.getSalario() != null ){
            retorno.setSalario(funcionario.getSalario());
        }

        if ( funcionario.getDataAdmissao() != null ){
            retorno.setDataAdmissao(funcionario.getDataAdmissao());
        }

        return  func.save(retorno);

    }

    public void DeletarFuncionario( String campo, String Valor){
        List<funcionario> funcionario = BuscaLocalizada(campo,Valor);
        func.deleteAll(funcionario);
    }

}
