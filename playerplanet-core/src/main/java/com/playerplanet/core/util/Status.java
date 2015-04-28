package com.playerplanet.core.util;

public enum Status {

    OK(0),ERROR(1);

    private int description;

    private Status(int description){
        this.description = description;
    }

    public int getDescription(){
        return description;
    }

}
