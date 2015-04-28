package com.playerplanet.core.http;

import com.playerplanet.core.exception.PlayerPlanetException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class HttpClient {

    private static final Client client = ClientBuilder.newClient();

    public Object getResource(Class resourceClass, String url) throws PlayerPlanetException {

        if(url != null && !url.isEmpty() && resourceClass != null) {

            return client.target(url)
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .get(resourceClass);
        }else{
            throw new PlayerPlanetException("Could not launch http request for empty resource");
        }
    }

    public Object getResourceWithQueryParams(Class resourceClass,String url,String paramKey,String paramValue) throws PlayerPlanetException {
        if(url != null && !url.isEmpty() && resourceClass != null) {

            return client.target(url)
                    .queryParam(paramKey,paramValue)
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .get(resourceClass);
        }else{
            throw new PlayerPlanetException("Could not launch http request for empty resource");
        }
    }
}
