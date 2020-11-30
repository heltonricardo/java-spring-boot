package io.github.heltonricardo.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.heltonricardo.exerciciossb.model.entities.Cliente;

/*
 * Quando usamos RequestMapping em uma classe, todos os métodos a ela
 * associados e mapeados terão o mesmo início de URL. A URL completa do método
 * obterCliente, por exemplo, será localhost:8080/clientes/qualquer. Quando a
 * anotação tem somente a propriedade "path", é possível omitir o nome dela,
 * como feito em obterCliente().
 * 
 * O método obterClientePorId1() possui uma URL com parâmetro. Nesse caso a URL
 * completa será: "localhost:8080/clientes/id" sendo "id" um valor inteiro e
 * com o mesmo nome do parâmetro da assinatura do método. A variável do
 * parâmetro da função deve possuir a anotação PathVariable. Um exemplo de URL
 * válida nesse caso é: "localhost:8080/clientes/123".
 * 
 * Já em obterClientePorId2() usamos o modelo mais convencional, acessando a
 * URL "localhost:8080/clientes?id=987", por exemplo, teremos a resposta para a
 * requisição. Se existir mais de um parâmetro, deve-se separá-los com o
 * caractere "&". Exemplo: "google.com/search?q=Ubuntu&hl=ar-MA". Podemos
 * inserir o nome do parâmetro que será inserido na URL e o valor padrão caso
 * não seja entrado um valor para determinado parâmetro.
 */

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

	@GetMapping("/qualquer")
	public Cliente obterCliente() {
		return new Cliente(13, "Helton", "123.456.789-09");
	}
	
	@GetMapping("/{id}")
	public Cliente obterClientePorId1(@PathVariable int id) {
		return new Cliente(id, "Maria", "321.654.987.98");
	}
	
	@GetMapping
	public Cliente obterClientePorId2(
			@RequestParam(name = "id", defaultValue = "1") int num) {
		return new Cliente(num, "Pedro", "789.654.987.98");
	}
}
