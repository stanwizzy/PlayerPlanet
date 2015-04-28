package com.playerplanet.core.config;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConfigurationTest {

    private Configuration configuration;

    @Before
    public void setUp(){

        configuration = new Configuration(false);
        configuration.addResource("soccer-configTest.yml");
    }

    @Test
    public void testContent(){

        try{
            Assert.assertEquals("Testing content of file", "www.google.com", configuration.get("search.url"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test(expected = Exception.class)
    public void testNull() throws Exception{
        Assert.assertEquals("Testing null entry", "naira", configuration.get("blabla"));
    }

    @Test
    public void testSetContent(){

        try{
            configuration.set("name","philip");
            configuration.set("age", "19");
            Assert.assertEquals("Testing content of file", "philip", configuration.get("name"));
            Assert.assertEquals("Testing content of file", "19", configuration.get("age"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testSetOveride(){

        try{
            configuration.set("name","philip");
            configuration.set("name","john");
            Assert.assertEquals("Testing content of file", "john", configuration.get("name"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
