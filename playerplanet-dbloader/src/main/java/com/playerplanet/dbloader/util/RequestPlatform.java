package com.playerplanet.dbloader.util;


import com.playerplanet.core.exception.PlayerPlanetException;
import com.playerplanet.core.util.Sport;
import org.apache.log4j.Logger;

public class RequestPlatform {

    private Logger logger = Logger.getLogger(RequestPlatform.class);

    public RequestPlatform(){

    }

    public Request createRequest(String[] args) throws PlayerPlanetException{
        if (args.length != 1){
            throw new PlayerPlanetException("Incorrect arguments parsed, please supply one of soccer|basketball|baseball|football|composite");
        }

        String sportArg = args[0];
        logger.info("Preparing request for arg: " + sportArg);

        Sport[] sports = Sport.values();
        Sport requestedSport = null;
        for(Sport sport : sports){
            if(sport.getDescription().equals(sportArg)){
                requestedSport = sport;
                break;
            }
        }
        if(requestedSport == null){
            logger.error("wrong arguments supplied");
            throw new PlayerPlanetException("Wrong arguments supplied, Please provide correct argumens");
        }
        Request request = new Request(requestedSport);

        return request;
    }
}
