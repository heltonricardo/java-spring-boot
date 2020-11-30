package io.github.heltonricardo.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.heltonricardo.exerciciossb.models.Cliente;

/*
 * Quando usamos RequestMapping em uma classe, todos os métodos a ela
 * associados e mapeados terão o mesmo início de URL. A URL completa do método
 * obterCliente, por exemplo, será localhost:8080/clientes/qualquer. Quando a
 * anotação tem somente a propriedade "path", é possível omitir o nome dela,
 * como feito em obterCliente().
 */

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

	@GetMapping("/qualquer")
	public Cliente obterCliente() {
		return new Cliente(13, "Helton", "123.456.789-09");
	}
}
