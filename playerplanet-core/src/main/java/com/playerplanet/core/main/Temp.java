package com.playerplanet.core.main;

import com.playerplanet.core.config.Configuration;
import com.playerplanet.core.util.SupportedAttributes;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.util.Map;

/**
 * Created by stanley on 4/5/2015.
 */
public class Temp {

    public static void main(String[] args) {
     /*   ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream resourceStream = classLoader.getResourceAsStream("soccer-attributes-config.yml");
        if(resourceStream == null){
            throw new RuntimeException();
        }
        Yaml yaml = new Yaml(new Constructor(SupportedAttributes.class));

        SupportedAttributes attr = (SupportedAttributes) yaml.load(resourceStream);
        System.out.println(attr.getOffensive());*/

        Configuration conf = new Configuration();
        SupportedAttributes sup = conf.getSupportedAttributes();
        System.out.println(sup.getDefensive());

    }
}
