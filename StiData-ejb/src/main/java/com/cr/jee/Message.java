package com.cr.jee;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Message
 */
@Stateless
@LocalBean
public class Message {

    /**
     * Default constructor. 
     */
    public Message() {
        // TODO Auto-generated constructor stub
    }
    
    public String getMessage(){
    	String str[]= {"one", "two", "three"};
    	return str[(int)(Math.random()*str.length)];
    	
    }
    
    

}
