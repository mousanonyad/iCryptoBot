package com.mousanony.telegram.bot.cryptobot.services;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.mousanony.telegram.bot.cryptobot.dto.ICoin;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * @author mousanonyad
 */
public class RestServiceIT {

    private RestService restService;

    @BeforeTest
    public void setUp() {
        restService = new RestService();
    }

    @Test
    public void testGetAvailableCrypto() throws UnirestException {
        List<ICoin> availableICoins = restService.getAvailableCoins();
        assertEquals(availableICoins.size(), 100);
    }

    @Test
    public void testGetUSDPrice() {
        ICoin litecoin = restService.getUsdPrice("litecoin");
        assertEquals(litecoin.getSymbol(), "LTC");
    }

    @Test
    public void testGetPrice() {
        ICoin litecoin = restService.getCustomPrice("litecoin", "RUB");
        assertEquals(litecoin.getSymbol(), "LTC");
        assertEquals(litecoin.getCustomSymbol(), "RUB");
    }
}