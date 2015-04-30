package com.playerplanet.service.api.init;


public class MongoDataAccessFactory {

    private static MongoConnectionManager mongoConnectionManager;
    private static Configuration configuration;

    public static void init(){

        Configuration conf = new Configuration();
        Mongo Mongo = new Mongo(conf.getHost(),conf.getPort(),conf.getDb());
        MongoConnectionManager = new MongoConnectionManager(mongo);
    }

    public static MongoDataAccess getMongoDataAccess(){
        return new MongoDataAccess(mongoConnectionManager);
    }
}
