package li.obiwan.arquillian.test.unit;

import java.net.URL;

import li.obiwan.arquillian.servlet.TestServlet;
import li.obiwan.arquillian.test.deployments.Deployments;
import li.obiwan.arquillian.test.util.StreamReaderUtil;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.descriptor.api.Descriptors;
import org.jboss.shrinkwrap.descriptor.api.webapp30.WebAppDescriptor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
@RunAsClient  // -> without this annotation and the testable = false the @ArquillianResource injection will not work
public class ServletTest {

	@Deployment(testable = false)
    public static WebArchive createDeployment() {
		WebArchive war = Deployments.createSimpleWarDeployment(false);
		// register test servlet
        war.setWebXML(new StringAsset(Descriptors.create(WebAppDescriptor.class).version("3.0")
                .createServlet()
                    .servletName(TestServlet.class.getSimpleName())
                    .servletClass(TestServlet.class.getName()).up()
                .createServletMapping()
                    .servletName(TestServlet.class.getSimpleName())
                    .urlPattern(TestServlet.URL_PATTERN).up()
                .exportAsString()));
		
		return war;
    }

    @ArquillianResource(TestServlet.class)
    URL servletUrl;
    
    @Test
    @InSequence(1)
    public void checkUrlInjection() {
    	Assert.assertNotNull("servletUrl should not be null", servletUrl);
    	
    	System.out.println(servletUrl.toString());
    }
   
    @Test
    @InSequence(2)
    public void checkServlet() throws Exception {
        String requestUrl = servletUrl + TestServlet.URL_PATTERN;
        String body = StreamReaderUtil.readAllAndClose(new URL(requestUrl).openStream());

        Assert.assertEquals("Verify that the servlet was deployed and returns expected result", TestServlet.RESPONSE, body.trim());
    }

}
