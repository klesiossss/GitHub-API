package br.com.dev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.api.GitHubAPI;
import br.com.dev.exception.DuplicatedResourceException;
import br.com.dev.exception.ResourceNotFoundException;
import br.com.dev.model.Developer;
import br.com.dev.model.GitHubResponse;
import br.com.dev.repository.DeveloperRepository;

@Service
public class DeveloperService {
	
	@Autowired
	private DeveloperRepository developerRepository;

	
	public Optional<Developer> obterPorId(Long id) {
		return developerRepository.findById(id);
	}
	
	public List<Developer> obterTodos(){
		return developerRepository.findAll();
	}
	
	public List<Developer> obterPorNumeroDePublicRepos(Long numOfPublicRepos){
		Long min = (long) (numOfPublicRepos - (numOfPublicRepos * 0.1)); 
		Long max = (long) (numOfPublicRepos + (numOfPublicRepos * 0.1));
		
		return developerRepository.findByPublicReposBetween(min, max);
	}
	
	public List<Developer> obterPorNumeroDeFollowers(Long numOfFollowers){
		Long min = (long) (numOfFollowers - (numOfFollowers * 0.1)); 
		Long max = (long) (numOfFollowers + (numOfFollowers * 0.1));
		
		return developerRepository.findByFollowersBetween(min,max);
	}
	
	
	
	public Developer salvar(Developer developer) {
		boolean podeSalvar = developerRepository.findByLogin(developer.getLogin()).isEmpty();
		if(podeSalvar)
		developerRepository.save(developer);
		else throw new DuplicatedResourceException();
		return developer;
	}
	
	public Developer update(Developer developer) {
		boolean podeAtualizar = developerRepository.findById(developer.getId()).isPresent() && developer.getId() != null;
		if(podeAtualizar) developerRepository.save(developer);
		else throw new ResourceNotFoundException();
		return developer;
	}
	
	public void delete(Developer developer) {
		boolean podeDeletar = developerRepository.findById(developer.getId()).isPresent() && developer.getId() != null;
		if(podeDeletar) developerRepository.delete(developer);
		
	}
	
	public void download() {
		GitHubAPI gitGubApi = new GitHubAPI();
		List<Developer> dev = gitGubApi.getApi();

		for (Developer d : dev) {
			developerRepository.save(d);
		}
	}
	
	
}
