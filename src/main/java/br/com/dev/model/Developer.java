package br.com.dev.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Developer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String login;
	private Long publicRepos;
	private Long followers;
	

	public Developer(Long id, String login, Long publicRepos, Long followers) {
		super();
		this.id = id;
		this.login = login;
		this.publicRepos = publicRepos;
		this.followers = followers;
	}
	
	public Developer(String login, Long publicRepos, Long followers) {
		this.login = login;
		this.publicRepos = publicRepos;
		this.followers = followers;
	}
	
	public Developer() {	
	}

    public Developer(GitHubResponse gitHubResponse) {
		this.login = gitHubResponse.getLogin();
		this.followers = gitHubResponse.getFollowers();
		this.publicRepos = gitHubResponse.getPublic_repos();
    }


    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Long getPublicRepos() {
		return publicRepos;
	}
	public void setPublicRepos(Long publicRepos) {
		this.publicRepos = publicRepos;
	}
	public Long getFollowers() {
		return followers;
	}
	public void setFollowers(Long followers) {
		this.followers = followers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((followers == null) ? 0 : followers.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((publicRepos == null) ? 0 : publicRepos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Developer other = (Developer) obj;
		if (followers == null) {
			if (other.followers != null)
				return false;
		} else if (!followers.equals(other.followers))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (publicRepos == null) {
			if (other.publicRepos != null)
				return false;
		} else if (!publicRepos.equals(other.publicRepos))
			return false;
		return true;
	}

	
	
	

}
