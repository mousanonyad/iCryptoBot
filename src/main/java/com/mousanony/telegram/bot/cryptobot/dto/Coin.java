package com.mousanony.telegram.bot.cryptobot.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

/**
 * @author mousanonyad
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coin implements ICoin {
    private String id;
    private String name;
    private String symbol;
    private Integer rank;
    @JsonAlias("price_usd")
    private BigDecimal priceUsd;
    @JsonAlias("price_btc")
    private BigDecimal priceBtc;
    @JsonAlias("percent_change_1h")
    private String percentChange1H;
    @JsonAlias("percent_change_24h")
    private String percentChange24H;
    @JsonAlias("percent_change_7d")
    private String percentChange7D;
    @JsonAlias("market_cap_usd")
    private BigDecimal marketCapUsd;
    private BigDecimal amount;

    @Override
    public BigDecimal getMarketCapUsd() {
        return marketCapUsd;
    }

    @Override
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public BigDecimal getAmount() {
        return amount;
    }

    public Coin() {
    }

    public Coin(Coin coin) {
        this.id = coin.id;
        this.name = coin.name;
        this.symbol = coin.symbol;
        this.rank = coin.rank;
        this.priceUsd = coin.priceUsd;
        this.priceBtc = coin.priceBtc;
        this.percentChange1H = coin.percentChange1H;
        this.percentChange24H = coin.percentChange24H;
        this.percentChange7D = coin.percentChange7D;
        this.marketCapUsd = coin.marketCapUsd;
    }

    @Override
    public BigDecimal getPrice() {
        return priceUsd;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public String getCustomSymbol() {
        return symbol;
    }

    @Override
    public Integer getRank() {
        return rank;
    }

    @Override
    public BigDecimal getPriceUsd() {
        return priceUsd;
    }

    @Override
    public BigDecimal getPriceBtc() {
        return priceBtc;
    }

    @Override
    public String getPercentChange1H() {
        return percentChange1H;
    }

    @Override
    public String getPercentChange24H() {
        return percentChange24H;
    }

    @Override
    public String getPercentChange7D() {
        return percentChange7D;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "name='" + name + '\'' +
                ", rank=" + rank +
                ", priceUsd=" + priceUsd +
                ", percentChange1H='" + percentChange1H + '\'' +
                ", percentChange24H='" + percentChange24H + '\'' +
                ", percentChange7D='" + percentChange7D + '\'' +
                ", marketCapUsd=" + marketCapUsd +
                ", amount=" + amount +
                '}';
    }
}