package models;

import org.simpleframework.xml.Element;

public class Tag extends org.nobel.highriseapi.entities.base.Entity {
	
	@Element
	private String name;
	
	public Tag(String name) {
		this.name = name;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
