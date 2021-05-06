package br.com.dev;

import br.com.dev.model.Developer;
import br.com.dev.service.DeveloperService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import br.com.dev.api.GitHubAPI;

import java.util.List;

@SpringBootApplication
public class GitHubApiApplication  implements CommandLineRunner {
	
	@Autowired
	DeveloperService ds = new DeveloperService();
	
	public static void main(String[] args) {
		SpringApplication.run(GitHubApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//ds.download();
	}

}
