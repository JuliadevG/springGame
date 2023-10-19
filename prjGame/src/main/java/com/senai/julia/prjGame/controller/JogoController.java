package com.senai.julia.prjGame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.senai.julia.prjGame.services.JogoServices;
import com.senai.julia.prjGame.entities.Jogo;

@RestController
@RequestMapping("/jogos")
public class JogoController {
	private final JogoServices JogoServices;
	
	@Autowired
	public JogoController(JogoServices JogoServices) {
		this.JogoServices = JogoServices;
	}
	
	@PostMapping
	public Jogo creatJogo(@RequestBody Jogo Jogo) {
		return JogoServices.saveJogo(Jogo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Jogo> getJogo (@PathVariable Long id) {
		Jogo jogo = JogoServices.getJogoById(id);
		if (jogo != null) {
			return ResponseEntity.ok(jogo);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@GetMapping
	public List<Jogo>getAllJogo(){
		return JogoServices.getAllJogo();
	}
	
	@GetMapping("/home")
	public String paginaInicial() {
		return "index";
	}
	
	@DeleteMapping("/(id)")
	public void deleteJogo (@PathVariable Long id) {
		JogoServices.deleteJogo(id);
	}
}