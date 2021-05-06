package br.com.dev.api;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



import br.com.dev.model.Developer;
import br.com.dev.model.GitHubResponse;


public class GitHubAPI {
	RestTemplate restTemplate = new RestTemplate();


	String urlBase = "https://api.github.com/users";


	public List<Developer> getApi() {
		HttpHeaders header = new HttpHeaders();

		header.set("Accept", "application/vnd.github.v3+json");
		header.set("User-Agent","klesiossss");
		header.set("username","12345");


		HttpEntity<String> entity = new HttpEntity<>("parameters", header);

		ResponseEntity<GitHubResponse[]> repos = restTemplate.exchange(urlBase, HttpMethod.GET, entity, GitHubResponse[].class);
		List<GitHubResponse> res = Arrays.asList(repos.getBody());
		List<String> logins = res.stream().map(GitHubResponse::getLogin).collect(Collectors.toList());


		List<GitHubResponse> devs = new ArrayList<GitHubResponse>();
		for (int i = 0; i < logins.size(); i++) {
			//devs.get(i).setLogin(logins.get(i));
			ResponseEntity<GitHubResponse> r = restTemplate.exchange(urlBase + "/" + logins.get(i),HttpMethod.GET,entity, GitHubResponse.class);
			devs.add(r.getBody());
			System.out.println(devs.get(i).getLogin());
			System.out.println(i);
		}
			return devs.stream().map(Developer::new).collect(Collectors.toList());
	}

}
