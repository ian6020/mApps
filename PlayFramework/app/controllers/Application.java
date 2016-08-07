package controllers;

import play.*;
import play.mvc.*;
import resources.TagResource;
import play.data.validation.*;

import java.util.*;

import org.nobel.highriseapi.HighriseClient;
import org.nobel.highriseapi.InvalidUserCredentialsException;
import org.nobel.highriseapi.entities.Person;
import org.nobel.highriseapi.resources.PersonResource;

import models.*;

public class Application extends Controller {

    public static void index() {
    	    	
    	List<JContact> cList = null;
    	List<Person> plist = null;
    	HighriseClient hrclient = HighriseClient.create("https://personal2672.highrisehq.com/");
    	try {
    		hrclient.auth("chris6020", "wayne6020");
    		PersonResource pRes = hrclient.getResource(PersonResource.class);
    		TagResource tRes = hrclient.getResource(TagResource.class);;
    		
    		plist = pRes.getAll();
    		//List<Tag> tags = tRes.getAll();
    		cList = new ArrayList<JContact>();
    		for(Person one : plist) {
    			JContact jc = new JContact(one);
    			jc.setTags(tRes.getAll(one));
    			
    			jc.save();
    			cList.add(jc);
    		}
    		
			
		} catch (InvalidUserCredentialsException e) {
			e.printStackTrace();
		}
        render(plist);
    }

    public static void sayHello() {
    	List<JContact> plist = null;
    	try{
    		plist = JContact.find("order by id desc").fetch();
    	} catch (Exception e) {
			e.printStackTrace();
		}
        render(plist);
    }
}