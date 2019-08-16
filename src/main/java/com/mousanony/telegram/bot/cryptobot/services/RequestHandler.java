package com.mousanony.telegram.bot.cryptobot.services;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.mousanony.telegram.bot.cryptobot.dto.ICoin;
import com.mousanony.telegram.bot.cryptobot.view.Response;
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
public class RequestHandler {

    private static final Pattern PATTERN = Pattern.compile("^\\d*\\.?\\d$");
    private static final List<String> availableCurrencies = Arrays.asList(
            "AUD", "BRL", "CAD", "CHF", "CNY", "EUR", "GBP",
            "HKD", "IDR", "INR", "JPY", "KRW", "MXN", "RUB");

    private List<ICoin> availableCoins;

    private Map<String, String> coinSymbolAndIdMap;

    private RestService restService;

    public RequestHandler() {
        this.restService = new RestService();
        updateAvailableCoins();

    }

    public void updateAvailableCoins() {
        try {
            this.availableCoins = restService.getAvailableCoins();
        } catch (UnirestException e) {
            //TODO logging
            e.printStackTrace();
        }

        coinSymbolAndIdMap = availableCoins.stream().collect(Collectors.toMap(ICoin::getSymbol, ICoin::getId));
    }


    public Response parseStringMessage(Message message) {
        Response response = new Response();
        if (message.getText() == null)
            return response.withError("Something went wrong. Where is your message?");

        List<String> splitRequest = Arrays.asList(message.getText().toUpperCase().split(" "));

        BigDecimal count = null;
        if (isContainsDigit(splitRequest.get(0))) {
            count = new BigDecimal(splitRequest.get(0));
            splitRequest.remove(0);
        }

        //check coin
        if (!isValidCoin(splitRequest.get(0))) {
            return response.withError("I don't know this coin.");
        }

        ICoin coin;
        //need custom price?
        if (splitRequest.size() == 2 && (isValidCoin(splitRequest.get(1)) || isValidCurrency(splitRequest.get(1)))) {
            coin = restService.getCustomPrice(coinSymbolAndIdMap.get(splitRequest.get(0)), splitRequest.get(1));
            calculateAmount(coin, count);
        //get usd price
        } else {
            coin = restService.getUsdPrice(coinSymbolAndIdMap.get(splitRequest.get(0)));
        }
        calculateAmount(coin, count);
        return response.withCoin(coin);
    }

    private void calculateAmount(ICoin coin, BigDecimal count) {
        coin.setAmount(coin.getPrice().multiply(count != null ? count : BigDecimal.ONE));
    }

    private boolean isValidCoin(String coinToCheck) {
        return availableCoins.stream().anyMatch(coin -> coin.getSymbol().equals(coinToCheck));
    }

    private boolean isValidCurrency(String currencyToCheck) {
        return availableCurrencies.stream().anyMatch(currency -> currency.equals(currencyToCheck));
    }

    private boolean isContainsDigit(String stringToCheck) {
        return PATTERN.matcher(stringToCheck).find();
    }

}
