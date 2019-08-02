package com.mousanony.telegram.bot.cryptobot.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mousanony.telegram.bot.cryptobot.dto.Coin;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author mousanonyad
 */
class RestService {

    private static final String GET_ALL_COIN_URL = "https://api.coinmarketcap.com/v1/ticker/";
    private static final String CONVERT_COIN_URL = "https://api.coinmarketcap.com/v1/ticker/id/?convert=symbol";


    RestService() {
        Unirest.setObjectMapper(new ObjectMapper() {
            com.fasterxml.jackson.databind.ObjectMapper mapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public String writeValue(Object value) {
                try {
                    return mapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return mapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Unirest.setDefaultHeader("accept", "application/json");
    }

    List<Coin> getAvailableCoins() throws UnirestException {
        HttpResponse<Coin[]> httpResponse = Unirest.get(GET_ALL_COIN_URL).asObject(Coin[].class);

        return Arrays.asList(httpResponse.getBody());
    }

    Coin getPrice(String coinID, String targetCoin) {
        try {
            return Unirest.get(CONVERT_COIN_URL.replace("id", coinID).replace("symbol", targetCoin)).asObject(Coin[].class).getBody()[0];
        } catch (UnirestException e) {
            //TODO logging
            e.printStackTrace();
            return null;
        }
    }
}
