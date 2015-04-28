package com.playerplanet.dbloader.provider;

import com.playerplanet.dbloader.command.Command;

public class BasketballProvider extends Provider {

    public BasketballProvider(){
        this.description = "basketball";
    }

    @Override
    public Command getCommand() {
        return null;
    }
}
