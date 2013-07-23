package li.obiwan.arquillian.ejb;

import java.util.List;

import javax.ejb.Local;

import li.obiwan.arquillian.jpa.Game;

@Local
public interface GamesService {

	public Game createGame(String title);
	public Game findGame(long id);
	public boolean deleteGame(long id);
	public List<Game> findAll();
	
}
