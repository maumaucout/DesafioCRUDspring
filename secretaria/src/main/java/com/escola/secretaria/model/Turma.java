package com.escola.secretaria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity // Essa classe é uma entidade do JPA.
@Table(name = "tb_turma") // Essa entidade dentro do banco de dados será uma tabela e o nome será postagem.
public class Turma {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)// No banco de dados, este atributo vai ser a primarykey, chave primária.
	private long id;
	
	@NotNull // Não pode retornar vazio.
	@Size(min = 5, max =10) //Quantidade de caracteres.
	private String turma;
	
	@NotNull
	boolean ativo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
