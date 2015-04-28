package com.playerplanet.dbloader.provider;

import com.playerplanet.core.exception.PlayerPlanetException;
import com.playerplanet.dbloader.command.Command;
import com.playerplanet.dbloader.util.Request;

public class CompositeProvider extends Provider {

    public CompositeProvider(){
        this.description = "composite";
    }

    @Override
    public Command getCommand() {
        return null;
    }
}
