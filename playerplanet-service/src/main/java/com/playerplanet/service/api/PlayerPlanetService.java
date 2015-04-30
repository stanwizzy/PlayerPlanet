package com.playerplanet.service.api;

import com.playerplanet.service.api.init.MongoDataAccessFactory;
import com.playerplanet.service.resource.PlayerPlanetBasketballResource;
import com.playerplanet.service.resource.PlayerPlanetFootballResource;
import com.playerplanet.service.resource.PlayerPlanetSoccerResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.apache.log4j.Logger;


public class PlayerPlanetService extends Application<PlayerPlanetConfiguration> {

    private static final Logger logger = Logger.getLogger(PlayerPlanetService.class);
    @Override
    public void initialize(Bootstrap bootstrap) {
        MongoDataAccessFactory.init();
    }


    @Override
    public void run(PlayerPlanetConfiguration playerPlanetConfiguration, Environment environment) throws Exception {
        final PlayerPlanetSoccerResource soccerResource = new PlayerPlanetSoccerResource();
        final PlayerPlanetBasketballResource basketballResource = new PlayerPlanetBasketballResource();
        final PlayerPlanetFootballResource footballResource = new PlayerPlanetFootballResource();
        environment.jersey().register( soccerResource);
        environment.jersey().register( footballResource);
        environment.jersey().register( basketballResource);
    }

    public static void main(String[] args) {
        try {
            new PlayerPlanetService().run(new String[]{"server"} );
        } catch (Exception e) {
            logger.error("Error executing program");
        }
    }
}
