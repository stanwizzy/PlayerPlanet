package com.playerplanet.service.resource;

import com.playerplanet.service.api.Pojo;
import com.playerplanet.service.api.init.MongoDataAccessFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


@Path("/api/soccer")
public class PlayerPlanetSoccerResource {

    /**
     * API to get statistics of a soccer player
     * Returns a json object with player statistics
     * If more than one player resolves to the name, it returns list of player names
     * @param player
     * @return Player Object
     */
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/player")
    public Player getPlayer(@QueryParam("player") String player){
        MongoDataAccess mongoDataAccess =MongoDataAccessFactory.getMongoDataAccess();
    }

    /**
     * API to get statistics of a soccer team
     * Returns a json object with team statistics
     * If more than one player resolves to the name, it returns list of player names
     * @param team
     * @return Team Object
     */
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/team")
    public List<Player> getTeam(@QueryParam("team") String team){

        return null;

    }

}
