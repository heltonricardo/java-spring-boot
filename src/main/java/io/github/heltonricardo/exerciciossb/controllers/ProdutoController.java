package io.github.heltonricardo.exerciciossb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.heltonricardo.exerciciossb.model.entities.Produto;
import io.github.heltonricardo.exerciciossb.model.repositories.ProdutoRepository;

/*
 * A anotação ResponseBody não é necessária. Serve somente para deixar claro
 * que o Produto retornado faz parte do corpo da resposta.
 */

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@PostMapping
	public @ResponseBody Produto novoProduto(@RequestParam String nome) {
		Produto produto = new Produto(nome);
		produtoRepository.save(produto);
		return produto;
	}
}
