package br.com.dev.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class GitHubResponse {

	
	private String login;
	private Long public_repos;
	private Long followers;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Long getPublic_repos() {
		return public_repos;
	}
	public void setPublic_repos(Long public_repos) {
		this.public_repos = public_repos;
	}
	public Long getFollowers() {
		return followers;
	}
	public void setFollowers(Long followers) {
		this.followers = followers;
	}
	
	public GitHubResponse(String login, Long public_repos, Long followers) {
		super();
		this.login = login;
		this.public_repos = public_repos;
		this.followers = followers;
	}
	
	public GitHubResponse() {
		
	}
	

}
