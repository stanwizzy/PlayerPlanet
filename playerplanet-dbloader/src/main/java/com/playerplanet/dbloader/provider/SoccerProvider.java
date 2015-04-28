package com.playerplanet.dbloader.provider;

import com.playerplanet.core.exception.PlayerPlanetException;
import com.playerplanet.dbloader.command.Command;
import com.playerplanet.dbloader.command.SoccerCommand;
import com.playerplanet.dbloader.service.Service;
import com.playerplanet.dbloader.service.ServiceLoader;


public class SoccerProvider extends Provider {

    public SoccerProvider(){
        this.description = "soccer";
    }

    @Override
    public Command getCommand() {
        Service service = ServiceLoader.loadService("soccer");
        return new SoccerCommand(service);

    }
}
