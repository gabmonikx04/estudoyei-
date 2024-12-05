package com.estudo.estudo.DTO;

import java.time.LocalDate;

public class ControladorQuery {

    private Long id;
    private String nome;
    private Double salario;
    private LocalDate dataAdmissao;

    public ControladorQuery() {
    }

    public ControladorQuery(Long id, String nome, Double salario, LocalDate dataAdmissao) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
        this.dataAdmissao = dataAdmissao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }
}
