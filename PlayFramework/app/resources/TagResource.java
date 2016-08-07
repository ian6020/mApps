package resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.nobel.highriseapi.HighriseClientConfig;
import org.nobel.highriseapi.entities.Person;
import org.nobel.highriseapi.resources.base.EntityCacheProvider;
import org.nobel.highriseapi.resources.base.EntityIdComparator;
import org.nobel.highriseapi.resources.base.EntityResource;
import org.nobel.highriseapi.resources.base.RestResourceConfig;

import models.JContact;
import models.Tag;
import models.lists.TagList;

public class TagResource extends EntityResource<Tag> {

	public TagResource(HighriseClientConfig clientConfig, EntityCacheProvider entityCacheProvider) {
		super(clientConfig, entityCacheProvider);
	}

	@Override
	protected RestResourceConfig getEntityConfig() {
		throw new IllegalStateException("'Get by id' is not supported for Tags.");
	}

	@Override
	protected RestResourceConfig getEntityListConfig() {
		return createResourceConfig("tags.xml", TagList.class);
	}
	
	public Tag getTagByName(String name) {
        List<Tag> tags = getAll();
        for (Tag tag : tags) {
            if (tag.getName().equals(name)) {
                return tag;
            }
        }
        throw new RuntimeException("Tag '" + name + "' not found");
    }

    public Tag create(Tag tag) {
        throw new UnsupportedOperationException("Not supported for tags, use create(tag,person)");
    }

    public Tag create(Tag tag, Person person) {
        String url = buildResourceUrl(getBaseUrl(), "people/" + person.getId() + "/tags.xml");
        return (Tag) createRemoteEntityAccesor(Tag.class, url).createEntity(tag);
    }
    
    
    public List<Tag> getAll(Person person) {
    	String url = buildResourceUrl(getBaseUrl(), "people/" + person.getId() + "/tags.xml");
        List<Tag> tagList=  createRemoteEntityAccesor(TagList.class, url).getEntityList();
        Collections.sort(tagList, new EntityIdComparator());
        
        return tagList;
    }

}
