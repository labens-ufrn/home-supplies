package br.ufrn.bsi.supplies.entity;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {

    @Test
    public void fullNameTest() {
    	User user = new User("tacianosilva", "Taciano", "Silva");
    	
        String expected = "Taciano Silva";
        String result = user.fullName();
        Assert.assertEquals(expected, result);
    }
    
    @Test
    public void withoutNameTest() {
    	User user = new User("semnome", "", "");
     
        String expected = "";
        String result = user.fullName();
        Assert.assertEquals(expected, result);
    }
}
