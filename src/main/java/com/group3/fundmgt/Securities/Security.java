package com.group3.fundmgt.Securities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
public class Security {
    @Id
    private String symbol;

    @Column(nullable = false,length = 10,scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private String assetClass;

    public Security() {

    }

    public Security(String symbol, BigDecimal price, String assetClass) {
        this.symbol = symbol;
        this.price = price;
        this.assetClass = assetClass;
    }

    public String getSymbol() {
        return symbol;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getAssetClass() {
        return assetClass;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setAssetClass(String assetClass) {
        this.assetClass = assetClass;
    }
}
