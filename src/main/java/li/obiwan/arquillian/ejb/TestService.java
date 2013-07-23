package li.obiwan.arquillian.ejb;

import javax.ejb.Local;

@Local
public interface TestService {

	public String greeter(String name);
	
}
