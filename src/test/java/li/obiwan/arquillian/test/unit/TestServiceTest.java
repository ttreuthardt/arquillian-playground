package li.obiwan.arquillian.test.unit;

import javax.ejb.EJB;

import li.obiwan.arquillian.ejb.TestService;
import li.obiwan.arquillian.test.deployments.Deployments;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class TestServiceTest {

    @Deployment
    public static JavaArchive createDeployment() {
		return Deployments.createSimpleEjbDeployment(false);
    }
	
    @EJB
    TestService ts;
    
	@Test
	@InSequence(1)
	public void checkEjbInjection() {
		Assert.assertNotNull("ts must not be null", ts);
	}

	@Test
	@InSequence(2)
	public void greeter() {
		Assert.assertEquals("Hi, Thomas", ts.greeter("Thomas"));
	}
	
}
