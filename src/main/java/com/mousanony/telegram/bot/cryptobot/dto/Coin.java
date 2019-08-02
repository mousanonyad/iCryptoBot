package com.mousanony.telegram.bot.cryptobot.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 * @author mousanonyad
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coin {
    private String id;
    private String name;
    private String symbol;
    private Integer rank;
    @JsonAlias("price_usd")
    private String priceUsd;
    @JsonAlias("price_btc")
    private String priceBtc;
    @JsonAlias("percent_change_1h")
    private String percentChange1H;
    @JsonAlias("percent_change_24h")
    private String percentChange24H;
    @JsonAlias("percent_change_7d")
    private String percentChange7D;
    @JsonAlias("market_cap_usd")
    private String marketCapUsd;

    private static final DecimalFormat formatter = new DecimalFormat();

    static {
        DecimalFormatSymbols formatSymbols = formatter.getDecimalFormatSymbols();
        formatSymbols.setGroupingSeparator(' ');
        formatter.setDecimalFormatSymbols(formatSymbols);
    }

    public Coin() {
    }

    public String getMarketCapUsd() {
        double amount = Double.parseDouble(marketCapUsd);
        return formatter.format(amount);
    }

    public void setMarketCapUsd(String marketCapUsd) {
        this.marketCapUsd = marketCapUsd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(String priceUsd) {
        this.priceUsd = priceUsd;
    }

    public String getPriceBtc() {
        return priceBtc;
    }

    public void setPriceBtc(String priceBtc) {
        this.priceBtc = priceBtc;
    }

    public String getPercentChange1H() {
        return percentChange1H;
    }

    public void setPercentChange1H(String percentChange1H) {
        this.percentChange1H = percentChange1H;
    }

    public String getPercentChange24H() {
        return percentChange24H;
    }

    public void setPercentChange24H(String percentChange24H) {
        this.percentChange24H = percentChange24H;
    }

    public String getPercentChange7D() {
        return percentChange7D;
    }

    public void setPercentChange7D(String percentChange7D) {
        this.percentChange7D = percentChange7D;
    }

}