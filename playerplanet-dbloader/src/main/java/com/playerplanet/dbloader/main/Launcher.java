package com.playerplanet.dbloader.main;

import com.playerplanet.core.exception.PlayerPlanetException;
import com.playerplanet.core.util.Status;
import com.playerplanet.dbloader.command.Command;
import com.playerplanet.dbloader.provider.BasketballProvider;
import com.playerplanet.dbloader.provider.CompositeProvider;
import com.playerplanet.dbloader.provider.SoccerProvider;
import com.playerplanet.dbloader.util.Platform;
import com.playerplanet.dbloader.util.Request;
import com.playerplanet.dbloader.util.RequestPlatform;
import org.apache.log4j.Logger;

public class Launcher {

    private Logger logger = Logger.getLogger(Launcher.class);

    private int run(String[] args){
        try {
            RequestPlatform requestPlatform = new RequestPlatform();
            Request request = requestPlatform.createRequest(args);

            Platform platform = buildPlatform(request);
            Command command = platform.createCommand();

            Status status = command.execute();
            return status.getDescription();
        }catch(PlayerPlanetException e){
            logger.error(e.getMessage());
            return Status.ERROR.getDescription();
        }
    }

    private Platform buildPlatform(Request request){
        Platform platform = new Platform(request);

        platform.registerProvider(new BasketballProvider());
        platform.registerProvider(new SoccerProvider());
        platform.registerProvider(new CompositeProvider());

        return platform;
    }


    public static void main(String[] args) {

        Launcher launcher = new Launcher();
        System.exit(launcher.run(args));
    }
}
