package projeto.projeto_spring_boot_api.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import projeto.projeto_spring_boot_api.model.Filme;
import projeto.projeto_spring_boot_api.service.FilmeService;

@RestController
@RequestMapping("/users")
public class FilmeController {

	private final FilmeService filmeService;
	
	public FilmeController(FilmeService filmeService) {
		this.filmeService = filmeService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Filme> findById(@PathVariable int id){
		var filme = filmeService.findById(id);
		return ResponseEntity.ok(filme);
	}
	
	@PostMapping
	public ResponseEntity<Filme> findById(@RequestBody Filme filmeParaCriar){
		var filmeCriado = filmeService.create(filmeParaCriar);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(filmeCriado.getId())
			.toUri();
		return ResponseEntity.created(location).body(filmeCriado);
	} 
}
