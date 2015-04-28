package com.playerplanet.core.config;

import com.playerplanet.core.exception.PlayerPlanetException;
import com.playerplanet.core.exception.PlayerPlanetRuntimeException;
import com.playerplanet.core.util.SupportedAttributes;
import org.apache.log4j.Logger;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class Configuration {

    public Configuration(){
        this(true);
    }

    private static final String SOCCERPROPERTIES_APP= "soccer-app-config.yml";
    private static final String SOCCERPROPERTIES_ATTRIBUTES= "soccer-attributes-config.yml";
    // private static final String BASKETBALLROPERTIES="";
    //private static final String FOOTBALLPROPERTIES="";

    private static ArrayList<String> defaultResources;
    private ArrayList<String> allResources;
    private Properties properties ;
    private ClassLoader classLoader;
    private SupportedAttributes supportedAttributes;
    private static final Logger logger = Logger.getLogger(Configuration.class);

    static{
        defaultResources = new ArrayList<>();
        defaultResources.add(SOCCERPROPERTIES_APP);
        // defaultResources.add(BASKETBALLROPERTIES);
        //defaultResources.add(FOOTBALLPROPERTIES);
    }


    public Configuration(boolean loadDefaults){
        //TODO
        allResources = new ArrayList<>(defaultResources);
        this.classLoader = Thread.currentThread().getContextClassLoader();

    }

    public void addResource(String resource) {
        if (resource != null && !resource.isEmpty()) {
            logger.info("Adding resource " + resource);
            if (resource != null || !resource.isEmpty()) {
                synchronized (this){
                    allResources.add(resource);
                }
                loadConfiguration();
            } else {
                logger.error("Could not add resource " + resource);
            }
        }
    }

    private void loadConfiguration(){
        synchronized (this){
            properties = null;
        }
    }

    public void set(String name, String value){
        if(name == null || value == null || name.isEmpty() || value.isEmpty()){
            logger.error("Could not set property of empty object ");
            return;
        }

        synchronized(this){
            properties = getProps();
            String oldValue = null;
            if(properties.containsKey(name)){
                oldValue = properties.getProperty(name);
            }
            if(!value.equals(oldValue)) {
                logger.info("Overriding property " + name);
                properties.setProperty(name,value);
            }else{
                logger.warn("Property already exists, could not set property: " + name);
            }
        }
    }

    public String get(String name) throws Exception{
        String value;
        if(!name.isEmpty()  || name != null){

            synchronized (this){
                Properties properties = getProps();
                value =properties.getProperty(name);
            }
            if(value == null){
                throw new PlayerPlanetException("Empty property vale for " + name);
            }
        }else{
            logger.error("Could not fetch value for empty key");
            throw new PlayerPlanetRuntimeException("Could not fetch value for empty key");
        }
        return value;
    }

    public SupportedAttributes getSupportedAttributes(){
        //TODO handle exceptions
        if(supportedAttributes == null) {
            InputStream resourceStream = classLoader.getResourceAsStream(SOCCERPROPERTIES_ATTRIBUTES);
            Yaml yaml = new Yaml(new Constructor(SupportedAttributes.class));
            supportedAttributes = (SupportedAttributes) yaml.load(resourceStream);
            if (supportedAttributes == null) {
                throw new PlayerPlanetRuntimeException("Could not load empty property file");
            }
        }
        return supportedAttributes;
    }


    private Properties getProps(){

        synchronized (this) {
            if (properties == null) {
                properties = new Properties();
                Yaml yaml = new Yaml();
                for (String resource : allResources) {
                    logger.info("Loading property file: " + resource);
                    InputStream resourceStream = classLoader.getResourceAsStream(resource);
                    if(resourceStream == null){
                        throw new PlayerPlanetRuntimeException("");
                    }

                        Map<String, String> map = (Map<String, String>) yaml.load(resourceStream);
                        if (map == null) {
                            throw new PlayerPlanetRuntimeException("Could not load empty property file");
                        }
                        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
                        while (iterator.hasNext()) {
                            Map.Entry<String, String> entry = iterator.next();
                            if (entry == null) {
                                logger.error("could not load empty property from: " + resource);
                            } else {
                                properties.setProperty(entry.getKey(), entry.getValue());
                            }

                    }
                }
            }
        }
        return properties;
    }
}
