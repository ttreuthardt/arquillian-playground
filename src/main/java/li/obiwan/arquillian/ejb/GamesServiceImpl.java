package li.obiwan.arquillian.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import li.obiwan.arquillian.jpa.Game;

@Stateless
public class GamesServiceImpl implements GamesService {

	@PersistenceContext(name = "arquillian-playground")
	EntityManager em;

	@Override
	public List<Game> findAll() {
		TypedQuery<Game> query = em.createQuery("Select g from Game g",
				Game.class);
		List<Game> resultList = query.getResultList();
		return resultList;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Game createGame(String title) {
		Game game = new Game(title);
		em.persist(game);
//		 em.flush();
//		em.detach(game);
		return game;
	}

	@Override
	public Game findGame(long id) {
		return em.find(Game.class, id);
	}

	@Override
	public boolean deleteGame(long id) {
		Game game = em.find(Game.class, id);
		if (game != null) {
			em.remove(game);
			return true;
		} else {
			return false;
		}
	}

}
