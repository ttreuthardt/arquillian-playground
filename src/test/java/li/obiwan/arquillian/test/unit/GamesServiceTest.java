package li.obiwan.arquillian.test.unit;

import java.util.List;

import javax.ejb.EJB;

import li.obiwan.arquillian.ejb.GamesService;
import li.obiwan.arquillian.jpa.Game;
import li.obiwan.arquillian.test.deployments.Deployments;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.persistence.Cleanup;
import org.jboss.arquillian.persistence.CleanupStrategy;
import org.jboss.arquillian.persistence.TestExecutionPhase;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(Arquillian.class)
//@DataSource(value="testDatabase")
@Cleanup(phase = TestExecutionPhase.DEFAULT, 
         strategy = CleanupStrategy.USED_TABLES_ONLY)  // -> this required to keep the SEQUENCE table untouched. 
@UsingDataSet("data.xml")
//@CreateSchema(value="createDDL.jdbc")
public class GamesServiceTest {

    @Deployment
    public static JavaArchive createDeployment() {
//		return Deployments.createHibernateDeployment(false);
		return Deployments.createEclipseLinkDeployment(false);
    }
	
    @EJB
    GamesService gs;
    
	@Test
	@InSequence(1)
	public void checkEjbInjection() {
		Assert.assertNotNull("gs must not be null", gs);
	}

	@Test
	@InSequence(2)
	public void createGame() {
		Game game = gs.createGame("first game");
		Assert.assertNotNull(game);
		Assert.assertEquals("first game", game.getTitle());
		
		List<Game> games = gs.findAll();
		Assert.assertEquals(5, games.size());
	}

	@Test
	@InSequence(3)
	public void findAll() {
		List<Game> games = gs.findAll();
		Assert.assertEquals(4, games.size());
	}
	
}
