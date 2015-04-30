package com.playerplanet.core.mongo;


public class Mongo {


    public enum COLLECTIONS
    {
        current,
        archive
    }

    private final String mongoHost;
    private final int mongoPort;
    private final String mongoDBName;

    public Mongo(String mongoHost, int mongoPort, String mongoDBName) {
        this.mongoHost = mongoHost;
        this.mongoPort = mongoPort;
        this.mongoDBName = mongoDBName;
    }

    public String getMongoHost() {
        return mongoHost;
    }

    public int getMongoPort() {
        return mongoPort;
    }

    public String getMongoDBName() {
        return mongoDBName;
    }

}
