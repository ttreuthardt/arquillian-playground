package li.obiwan.arquillian.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class GameConsole implements Serializable {

	private static final long serialVersionUID = -466671280430178637L;
	
	private Long id;
	private String name;
	private List<Game> games;

	public GameConsole() {
	}

	public GameConsole(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany
	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	@Override
	public String toString() {
		return "GameConsole [id=" + id + ", name=" + name + ", games=" + games+ "]";
	}


}
