package com.playerplanet.core.mongo;


import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.playerplanet.core.exception.PlayerPlanetException;
import com.playerplanet.core.exception.PlayerPlanetRuntimeException;
import org.apache.log4j.Logger;

import java.net.UnknownHostException;

public class MongoConnectionManager {

    private MongoClient mongoClient;
    private final Mongo mongo;

    Logger logger = Logger.getLogger(MongoConnectionManager.class);

    public MongoConnectionManager(Mongo mongo){
        this.mongo = mongo;
    }

    public MongoClient initializeMongoClient(){
        if(this.mongoClient == null){
            try{
                logger.info("Accessing mongoClient for " + mongo.getMongoHost() + ":" + mongo.getMongoPort());
                mongoClient = new MongoClient(mongo.getMongoHost(),mongo.getMongoPort());
            }catch(UnknownHostException e){
                logger.error("could not connect to mongo db server: " + e.getMessage());
                throw new PlayerPlanetRuntimeException("Failed to connect to mongo db server: " + this.mongo.getMongoHost());
            }
        }
        return mongoClient;
    }

    public DBCollection getCollection(Mongo.COLLECTIONS colName) throws PlayerPlanetException{
        DB db = initializeMongoClient().getDB(mongo.getMongoDBName());
        if(db == null){
            throw new PlayerPlanetException("Could not find db: " + mongo.getMongoDBName());
        }
        DBCollection dbCollection = db.getCollection((colName.toString()));
        return dbCollection;
    }
}
