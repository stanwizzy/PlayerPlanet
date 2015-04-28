package com.playerplanet.dbloader.command;

import com.playerplanet.core.util.Status;
import com.playerplanet.dbloader.service.Service;


public class SoccerCommand extends Command {

    private Service service;

    public SoccerCommand(Service service){
        this.service = service;
    }

    @Override
    public Status execute() {

        return Status.OK;
    }
}
