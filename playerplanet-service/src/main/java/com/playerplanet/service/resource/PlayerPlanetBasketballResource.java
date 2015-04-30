package com.playerplanet.service.resource;

import com.playerplanet.service.api.Pojo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/api/basketball")
public class PlayerPlanetBasketballResource{

    /**
     * API to get statistics of a basketball player
     * Returns a json object with player statistics
     * If more than one player resolves to the name, it returns list of player names
     * @param player
     * @return Player Object
     */
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/player")
    public Pojo getPlayer(@QueryParam("player") String player){
        return new Pojo(1, player);
    }

    /**
     * API to get statistics of a basketball team
     * Returns a json object with team statistics
     * If more than one player resolves to the name, it returns list of player names
     * @param team
     * @return Team Object
     */
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("/team")
    public List<Pojo> getTeam(@QueryParam("team") String team){
        List<Pojo> list = new ArrayList<>();
        Pojo pojo =  new Pojo(1, team);
        list.add(pojo);
        return list;

    }
}
