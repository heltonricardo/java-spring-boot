package io.github.heltonricardo.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Em Spring Boot usamos anotações para mapear classes e métodos para URLs,
 * para que, a partir das URLs, um método possa ser chamado e reu retorno
 * devolvido para o browser.
 * 
 * A anotação RestController serve para que o Spring Boot considere essa classe
 * um controlador.
 * 
 * RequestMapping serve para mapear uma requisição para determinado método. A
 * propriedade padrão para o RequestMapping é o GET, então abaixo só foi
 * usada como exemplo didático. Assim que usamos essa anotação, já é possível
 * acessar e testar através da URL padrão (localhost:8080), mas para
 * personalizar usamos a propriedade path, e no exemplo, poderemos testar
 * através da URL "localhost:8080/ola".
 * 
 * O GetMapping já é uma anotação própria para requisições do tipo GET. Nela
 * também é possível acrescentar a propriedade path (que aceita mais de uma URL
 * usando um array de dados). E responderá a todas elas com o mesmo método.
 */

@RestController
public class PrimeiroController {

//	@RequestMapping(method = RequestMethod.GET, path = "/ola")
	@GetMapping(path = { "/ola", "/ola2", "/teste" })
	public String Ola() {
		return "Olá, Spring Boot!";
	}
}
