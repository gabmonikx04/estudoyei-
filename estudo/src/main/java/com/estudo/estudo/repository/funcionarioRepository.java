package com.estudo.estudo.repository;

import com.estudo.estudo.model.funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface funcionarioRepository extends JpaRepository<funcionario, Long> {
    List<funcionario> findByNomeContaining(String nome);
    List<funcionario> findBySalario(Double salario);
    List<funcionario> findByDataAdmissao(LocalDate dataAdmissao );
}
