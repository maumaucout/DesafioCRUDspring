package com.escola.secretaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.escola.secretaria.model.Turma;
import com.escola.secretaria.repository.TurmaRepository;

@RestController // Informa para o spring que essa classe é a controladora.
@RequestMapping("/turma") // Informa para o spring que essa classe é a controladora.
@CrossOrigin("*") // Vai aceitar requisições de qualquer origem.

public class TurmaController {
	
	@Autowired // Todos os serviços dessa interface do tipo postagem repository será acessado a partir do controller.
	private TurmaRepository repository;
	
	@GetMapping // Sempre vim uma requisição externa através da RI "postagens" ele irá disparar este método.
	public ResponseEntity<List<Turma>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Turma> GetById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/turma/{turma}") //SubROTA para que não tenha duplicidade com o método acima, para não ter conflito.
	public ResponseEntity<List<Turma>> GetByTitulo(@PathVariable String turma){
		return ResponseEntity.ok(repository.findAllByTurmaContainingIgnoreCase(turma)); // Este IgnoreCase desconsidera letras maiusculas e minusculas.
	}
	
	@PostMapping //Método POST para criar - CREATED
	public ResponseEntity<Turma> post (@RequestBody Turma turma){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(turma));	
	}
	
	@PutMapping //Método PUT para alteração - Feito alteração, return OK
	public ResponseEntity<Turma> put (@RequestBody Turma turma){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(turma));	
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}	
		
}
