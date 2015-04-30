package com.playerplanet.core.mongo;


import com.mongodb.DBCollection;
import com.playerplanet.core.exception.PlayerPlanetException;
import com.playerplanet.core.model.Player;
import org.mongojack.JacksonDBCollection;

public class MongoAccess {

    private final MongoConnectionManager mongoConnectionManager;

    public MongoAccess(MongoConnectionManager mongoConnectionManager) {
        this.mongoConnectionManager = mongoConnectionManager;
    }

    private JacksonDBCollection<Player, Object> getJacksonDBCollection(boolean isArchive) throws PlayerPlanetException{
        DBCollection dbCollection;

        if(isArchive){
            dbCollection = mongoConnectionManager.getCollection(Mongo.COLLECTIONS.archive);
        }else{
            dbCollection = mongoConnectionManager.getCollection(Mongo.COLLECTIONS.current);
        }
        return JacksonDBCollection.wrap(dbCollection,Player.class);
    }

    /**
     * Method to drop a collection from mongo db
     *
     * @param collection
     * @throws PlayerPlanetException
     */
    public void dropCollection(Mongo.COLLECTIONS collection) throws PlayerPlanetException{
        mongoConnectionManager.getCollection(collection).drop();
    }


}
