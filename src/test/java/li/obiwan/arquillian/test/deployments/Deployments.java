package li.obiwan.arquillian.test.deployments;

import li.obiwan.arquillian.ejb.GamesService;
import li.obiwan.arquillian.ejb.GamesServiceImpl;
import li.obiwan.arquillian.ejb.TestService;
import li.obiwan.arquillian.ejb.TestServiceImpl;
import li.obiwan.arquillian.jpa.Game;
import li.obiwan.arquillian.jpa.GameConsole;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

public class Deployments {

	public static JavaArchive createSimpleEjbDeployment(boolean printContent) {
		JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
				.addClasses(TestService.class, TestServiceImpl.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

		if (printContent) {
			System.out.println(jar.toString(true));
		}
		return jar;
	}

	public static JavaArchive createEclipseLinkDeployment(boolean printContent) {
		JavaArchive jar = createJPADeployment();
		jar.addAsManifestResource("eclipselink-persistence.xml",
				"persistence.xml");

		if (printContent) {
			System.out.println(jar.toString(true));
		}
		return jar;
	}

	public static JavaArchive createHibernateDeployment(boolean printContent) {
		JavaArchive jar = createJPADeployment()
				.addAsManifestResource("hibernate-persistence.xml",
						"persistence.xml");

		if (printContent) {
			System.out.println(jar.toString(true));
		}
		return jar;
	}

	private static JavaArchive createJPADeployment() {
		JavaArchive jar = ShrinkWrap
				.create(JavaArchive.class)
				.addClasses(GamesService.class, GamesServiceImpl.class,
						Game.class, GameConsole.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		return jar;
	}
}
