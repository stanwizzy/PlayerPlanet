package com.playerplanet.service.api.init;


import org.apache.log4j.Logger;

public class PlayerPlanetServiceInitializer  {

    private static final Logger logger = Logger.getLogger(PlayerPlanetServiceInitializer.class);

    public void init(){
        logger.info("Calling init method of PlayerPlanetServiceInitializer");

        MongoDataAccessFactory.init();

        /**TODO:
         * 1. Look for backlog files loaded when DB was offline
         * 2. If files are present load them into mongoDB.
         */
    }
}
