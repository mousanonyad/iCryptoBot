package com.mousanony.telegram.bot.cryptobot.dto;

import java.math.BigDecimal;

/**
 * @author mousanonyad
 */
public interface ICoin {
    BigDecimal getMarketCapUsd();

    BigDecimal getPrice();

    String getId();

    String getName();

    String getSymbol();

    String getTargetCoin();

    Integer getRank();

    BigDecimal getPriceUsd();

    BigDecimal getPriceBtc();

    String getPercentChange1H();

    String getPercentChange24H();

    String getPercentChange7D();

    BigDecimal getAmount();

    void setAmount(BigDecimal amount);
}
