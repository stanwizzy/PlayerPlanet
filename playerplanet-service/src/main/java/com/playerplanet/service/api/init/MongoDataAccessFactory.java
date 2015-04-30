package com.playerplanet.service.api.init;


import com.playerplanet.core.config.Configuration;
import com.playerplanet.core.mongo.Mongo;
import com.playerplanet.core.mongo.MongoAccess;
import com.playerplanet.core.mongo.MongoConnectionManager;

public class MongoDataAccessFactory {

    private static MongoConnectionManager mongoConnectionManager;
    private static Configuration configuration;

    public static void init() throws Exception {

        Configuration conf = new Configuration();
        Mongo mongo = new Mongo(conf.get("host"),Integer.parseInt(conf.get("port")),conf.get("db"));
        MongoConnectionManager mongoConnectionManager = new MongoConnectionManager(mongo);
    }

    public static MongoAccess getMongoDataAccess(){
        return new MongoAccess(mongoConnectionManager);
    }
}
