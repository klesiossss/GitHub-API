package br.com.dev.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.dev.model.Developer;
import br.com.dev.service.DeveloperService;


@RestController
@RequestMapping("/dev")
public class DeveloperController {
	
	@Autowired
	DeveloperService developerService;
	
	public DeveloperController( DeveloperService developerService) {
		this.developerService = developerService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Developer>>obterPorId(@PathVariable Long id){
		 Optional<Developer> dev = developerService.obterPorId(id);
		return ResponseEntity.ok(dev);		
	}
	
	@GetMapping()
	public ResponseEntity<List<Developer>>ObterTodos(){

			List<Developer>devs = developerService.obterTodos();
		 return ResponseEntity.ok(devs);
	}
	
	
	@GetMapping("repos/{numOfPublicRepos}")
	public ResponseEntity<List<Developer>> obterPorNumeroDePublicRepos(@PathVariable Long numOfPublicRepos){
		List<Developer> devs = developerService.obterPorNumeroDePublicRepos(numOfPublicRepos);
		return ResponseEntity.ok(devs);
	}
	
	@GetMapping("followers/{numOfFollowers}")
	public ResponseEntity<List<Developer>> obterPorNumeroDeFollowers(@PathVariable Long numOfFollowers){
		List<Developer> devs = developerService.obterPorNumeroDeFollowers(numOfFollowers);
		return ResponseEntity.ok(devs);
	}
	
	
	@PostMapping
	public ResponseEntity<Developer> salvar(@RequestBody Developer developer){
		Developer dev = developerService.salvar(developer);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dev.getId()).toUri();
		return ResponseEntity.created(uri).body(dev);
	}
	
	
	@PutMapping
	public ResponseEntity<Developer> upadate(@RequestBody Developer developer){
		Developer dev = developerService.update(developer);
		return ResponseEntity.ok(dev);
	}
	
	
	@DeleteMapping
	public ResponseEntity<?> delete(@RequestBody Developer developer){
		 developerService.delete(developer);
		return ResponseEntity.ok().build();
	}
	
	
	
	
	
	

}
