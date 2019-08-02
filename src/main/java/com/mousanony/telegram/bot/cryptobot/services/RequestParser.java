package com.mousanony.telegram.bot.cryptobot.services;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.mousanony.telegram.bot.cryptobot.dto.Coin;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author mousanonyad
 */
public class RequestParser {

    private static final Pattern PATTERN = Pattern.compile("^\\d*\\.?\\d$");
    private static final List<String> availableCurrencies = Arrays.asList(
            "AUD", "BRL", "CAD", "CHF", "CNY", "EUR", "GBP",
            "HKD", "IDR", "INR", "JPY", "KRW", "MXN", "RUB");

    private List<Coin> availableCoin;

    private Map<String, String> coinSymbolAndIdMap;

    private RestService restService;

    public RequestParser() {
        this.restService = new RestService();
        updateAvailableCoins();

    }

    public void updateAvailableCoins() {
        try {
            this.availableCoin = restService.getAvailableCoins();
        } catch (UnirestException e) {
            //TODO logging
            e.printStackTrace();
        }

        coinSymbolAndIdMap = availableCoin.stream().collect(Collectors.toMap(Coin::getSymbol, Coin::getId));
    }


    public Response parseStringMessage(Message message) {
        Response response = new Response();
        if (message.getText() == null)
            return response.withError("Something went wrong. Where is your message?");

        List<String> splitRequest = Arrays.asList(message.getText().toUpperCase().split(" "));

        BigDecimal amountToCalculate = null;

        //эта штука универсальная
        if (isContainsDigit(splitRequest.get(0))) {
            amountToCalculate = new BigDecimal(splitRequest.get(0));
            splitRequest.remove(0);
        }

        //check coin
        if (!isValidCoin(splitRequest.get(0))) {
            return response.withError("I don't know this coin.");
        }

        //check target coin
        if (splitRequest.size() == 2) {
            if (isValidCoin(splitRequest.get(1)) || isValidCurrency(splitRequest.get(1))) {
                Coin coin = restService.getPrice(coinSymbolAndIdMap.get(splitRequest.get(0)), splitRequest.get(1));
                return response.withCoin(coin);
            }
        }

        restService.getPrice(coinSymbolAndIdMap.get(splitRequest.get(0)), "USD");

        return response;
    }

    private boolean isValidCoin(String coinToCheck) {
        return availableCoin.stream().anyMatch(coin -> coin.getSymbol().equals(coinToCheck));
    }

    private boolean isValidCurrency(String currencyToCheck) {
        return availableCurrencies.stream().anyMatch(currency -> currency.equals(currencyToCheck));
    }

    private boolean isContainsDigit(String stringToCheck) {
        return PATTERN.matcher(stringToCheck).find();
    }

}
