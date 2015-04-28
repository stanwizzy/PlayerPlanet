package com.playerplanet.dbloader.provider;

import com.playerplanet.core.exception.PlayerPlanetException;
import com.playerplanet.dbloader.command.Command;
import com.playerplanet.dbloader.util.Request;

public abstract class Provider {

    protected String description;

    public boolean isForRequest(Request request) throws PlayerPlanetException {
        if(request.getRequestDescription().equalsIgnoreCase(description)){
            return true;
        }else{
            return false;
        }
    }

    public abstract Command getCommand();

    @Override
    public String toString(){
        return description;
    }
}
