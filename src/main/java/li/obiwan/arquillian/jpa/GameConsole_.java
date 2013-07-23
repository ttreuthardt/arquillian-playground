package li.obiwan.arquillian.jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-07-21T00:24:02.848+0200")
@StaticMetamodel(GameConsole.class)
public class GameConsole_ {
	public static volatile SingularAttribute<GameConsole, Long> id;
	public static volatile ListAttribute<GameConsole, Game> games;
	public static volatile SingularAttribute<GameConsole, String> name;
}
