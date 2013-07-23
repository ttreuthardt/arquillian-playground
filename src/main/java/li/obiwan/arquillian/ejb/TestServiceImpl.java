package li.obiwan.arquillian.ejb;

import javax.ejb.Stateless;

@Stateless
public class TestServiceImpl implements TestService {

	public String greeter(String name) {
		return "Hi, " + name;
	}

}
