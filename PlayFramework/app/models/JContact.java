package models;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.nobel.highriseapi.entities.Person;

import play.db.jpa.Model;

@Entity
@Root(name = "Contact", strict = false)
public class JContact extends Model {
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<JTag> tags;
	
	@Element(name="firstname") 
	private String fname;
	
	@Element(name="lastname") 
	private String lname;
	
	@Element(name="title") 
	private String title;
	
	public JContact(String fname, String lname, String title) {
		this.fname = fname;
		this.lname = lname;
		this.title = title;
		tags = new ArrayList<JTag>();
	}
	
	public JContact(Person person) {
		this.fname = person.getFirstName();
		this.lname = person.getLastName();
		this.title = person.getTitle();
		tags = new ArrayList<JTag>();
	}

	public List<JTag> getTags() {
		return tags;
	}
	
	public void setTags(List<Tag> jTags) {
    	for(Tag one : jTags)
    		tags.add(new JTag(one));
    	
    }
	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
