package com.senai.julia.prjGame.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.senai.julia.prjGame.entities.Jogo;
import com.senai.julia.prjGame.repositories.JogoRepository;


@Service
public class JogoServices {
	private final JogoRepository JogoRepository;
	
	@Autowired
	public JogoServices (JogoRepository JogoRepository) {
		this.JogoRepository = JogoRepository;
	}
	
	public Jogo saveJogo(Jogo Jogo) {
		return JogoRepository.save(Jogo);
	}
	
	public Jogo getJogoById(Long id) {
		return JogoRepository.findById(id).orElse(null);
	}
	
	public List<Jogo> getAllJogo(){
		return JogoRepository.findAll();
	}
	
	public void deleteJogo(Long id) {
		JogoRepository.deleteById(id);
	}
}