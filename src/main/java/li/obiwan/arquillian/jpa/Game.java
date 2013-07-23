package li.obiwan.arquillian.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Game.findAll", query = "Select g from Game g")
public class Game implements Serializable {
	
	private static final long serialVersionUID = 2839088942012499278L;

	private Long id;
    private String title;
 
    public Game() {}
 
    public Game(String title) {
        this.title = title;
    }
 
    @Id @GeneratedValue
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
    @Override
    public String toString() {
        return "Game@" + hashCode() + "[id = " + id + "; title = " + title + "]";
    }
}