package com.playerplanet.core.model.attribute;

import com.playerplanet.core.exception.PlayerPlanetException;
import com.playerplanet.core.util.Sport;

import static com.playerplanet.core.util.Sport.*;


public class AttributeFactory {

   // private static Logger logger = Logger.getLogger(AttributeFactory.class);

    public static Attribute getAttribute(Sport sport,String orientation) throws PlayerPlanetException{
        Attribute attribute = null;
        switch(sport){
            case SOCCER:
                if(orientation.equalsIgnoreCase("attacking")){
                    attribute = new SoccerAttackingAttribute();
                }else if(orientation.equalsIgnoreCase("defending")){
                    attribute = new SoccerDefensiveAttribute();
                }else{
                    throw new PlayerPlanetException("Please supply supported attribute orientation");
                }
                break;
        }
        if(attribute != null){
            return attribute;
        }else{
            throw new PlayerPlanetException("Wrong parameters supplied to Attribute factory");
        }
    }
}
