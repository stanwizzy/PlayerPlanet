package com.playerplanet.core.util;


import java.util.List;
import java.util.Map;

public class SupportedAttributes {

    private List<String> defensive;
    private List<String> offensive;
    private List<String> general;

    public List<String> getGeneral() {
        return general;
    }

    public void setGeneral(List<String> general) {
        this.general = general;
    }

    public List<String> getDefensive() {
        return defensive;
    }

    public void setDefensive(List<String> defensive) {
        this.defensive = defensive;
    }

    public List<String> getOffensive() {
        return offensive;
    }

    public void setOffensive(List<String> offensive) {
        this.offensive = offensive;
    }

}
