package com.mousanony.telegram.bot.cryptobot.services;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.mousanony.telegram.bot.cryptobot.dto.Coin;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * @author mousanonyad
 */
public class RestServiceTest {

    private RestService restService;

    @BeforeTest
    public void setUp() {
        restService = new RestService();
    }

    @Test
    public void testGetAvailableCrypto() throws UnirestException {
        List<Coin> availableCoins = restService.getAvailableCoins();
        assertEquals(availableCoins.size(), 100);
    }

    @Test
    public void testGetPrice() {
        Coin litecoin = restService.getPrice("litecoin", "USD");
        assertEquals(litecoin.getSymbol(), "LTC");

        Coin ethereum = restService.getPrice("ethereum", "BTC");
        assertEquals(ethereum.getSymbol(), "ETH");
    }
}