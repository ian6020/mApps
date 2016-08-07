package models.lists;


import org.nobel.highriseapi.entities.EntityList;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import models.JTag;
import models.Tag;

import java.util.ArrayList;
import java.util.List;

@Root(strict = false)
public class TagList implements EntityList<Tag> {

    @ElementList(inline = true, entry = "tag", required = false)
    protected List<Tag> tags = new ArrayList<Tag>();

    public List<Tag> getEntities() {
        return tags;
    }
}
