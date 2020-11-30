package io.github.heltonricardo.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * DESAFIO: Implementar uma classe para responder às seguintes requisições:
 *		/calculadora/somar/10/20  
 *		/calculadora/subtrair?a=100&b=39  
 */

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

	@GetMapping("/somar/{a}/{b}")
	public int soma(@PathVariable int a, @PathVariable int b) {
		return a + b;
	}
	
	@GetMapping("/subtrair")
	public int subtracao(
			@RequestParam int a, @RequestParam int b) {
		return a - b;
	}
}
