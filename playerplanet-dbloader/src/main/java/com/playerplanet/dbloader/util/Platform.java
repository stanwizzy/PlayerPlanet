package com.playerplanet.dbloader.util;

import com.playerplanet.core.exception.PlayerPlanetException;
import com.playerplanet.dbloader.command.Command;
import com.playerplanet.dbloader.provider.Provider;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Platform {

    private Request request;
    private List<Provider> providers;
    private Logger logger = Logger.getLogger(Platform.class);

    public Platform(Request request){
        this.request = request;
        this.providers = new ArrayList<>();
    }

    public void registerProvider(Provider provider){
        if(provider != null && !providers.contains(provider)){
            logger.debug("Registering provider " + provider.toString());
            providers.add(provider);
        }else{
            logger.info("Could not register provider " + provider.toString());
        }
    }

    public Command createCommand() throws PlayerPlanetException{

        logger.info("Creating command... ");
        Provider requestProvider = null;

        for(Provider provider: providers){
            if(provider.isForRequest(request)){
                requestProvider = provider;
                break;
            }
        }

        if(requestProvider == null){
            throw new PlayerPlanetException("Could not create command from null object");
        }
        logger.info("Command created successfully");
        return requestProvider.getCommand();

    }
}
