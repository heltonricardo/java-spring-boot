package io.github.heltonricardo.exerciciossb.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/*
 * Adicionamos algumas regras para validação de dados em alguns atributos.
 * NotBlank: não vazio; Min: valor mímino; Max: valor máximo. Para ser possível
 * usar essas anotações, é necessário adicionar a dependência Hibernate
 * Validator. Saiba como fazê-lo no final do arquivo INSTRUÇÔES.md, presente
 * nesse projeto.
 */

@Entity
public class Produto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	private String nome;
	
	@Min(0)
	private double preco;
	
	@Min(0) @Max(1)
	private double desconto;
	
	public Produto() {}
	
	public Produto(String nome, double preco, double desconto) {
		this.nome = nome;
		this.preco = preco;
		this.desconto = desconto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
}
