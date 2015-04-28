package com.playerplanet.dbloader.util;

import com.playerplanet.core.exception.PlayerPlanetException;

public class Request{

    private Sport sport;

    public Request(Sport sport){
        if(sport != null) {
            this.sport = sport;
        }
    }

    public String getRequestDescription() throws PlayerPlanetException{
        String result;
        if(sport == null) {
            throw new PlayerPlanetException("Cannot retrieve description from null object");
        }else {
            result = sport.getDescription();
        }
        return result;
    }
}
