package io.github.heltonricardo.exerciciossb.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.heltonricardo.exerciciossb.model.entities.Produto;
import io.github.heltonricardo.exerciciossb.model.repositories.ProdutoRepository;

/*
 * Autowired é usada quando fazemos o que é chamado de Dependence Injection
 * (Injeção de Dependência) que é um tipo de Inversion of Control (Inversão de
 * Controle). Quando uma classe A depende de uma classe B, normalmente
 * instanciamos um objeto de B em A. Porém, se a classe A está sob controle de
 * um framework, podemos deixar também sob responsabilidade do framework
 * instanciar o objeto B dentro de A. Por isso o nome Inversão de Controle:
 * as responsabilidades são invertidas para framework, que fará grande parte do
 * trabalho. Pode-se notar que em nenhum momento instanciamos a classe
 * ProdutoController, pois ela está anotada com @RestController e isso faz com
 * que ela seja agora responsabilidade de um framework. Todas os controllers
 * foram instanciados e controlados automaticamente por esse mesmo framework,
 * que nesse caso é o Spring Boot.
 * 
 * A anotação ResponseBody não é necessária. Serve somente para deixar claro
 * que o Produto retornado faz parte do corpo da resposta.
 * 
 * Ao invés de recebermos cada atributo de um objeto no parâmetro da função,
 * podemos receber simplesmente o próprio objeto (pense nas situações onde são
 * muitos atributos), isso ajuda na organização do código.
 * 
 * Usamos a anotação Valid para que só seja executado o código da função se
 * o produto for válido, ou seja, na classe produtos temos anotações para
 * validar um produto, e ele somente será aceito na função se todas as
 * validações estejam corretas.
 * 
 */

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@PostMapping
	public @ResponseBody Produto novoProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}
	
	@GetMapping
	public Iterable<Produto> oberterProdutos() {
		return produtoRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Produto> obterProdutoPorId(@PathVariable int id) {
		return produtoRepository.findById(id);
	}
}
