package br.com.dev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dev.model.Developer;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {
	Optional<Developer> findById(Long id);
	Optional<Developer> findByLogin(String login);


	List<Developer>findByPublicReposBetween(Long min, Long max);
	
	
	List<Developer>findByFollowersBetween( Long min, Long max);

}
