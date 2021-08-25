package com.group3.fundmgt.position;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.group3.fundmgt.fund.Fund;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table

public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long positionId;

    @Column(nullable = false)
    private String securitySymbol;

    @Column(nullable = false,length = 10,scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private String AssetClass;

    @Column(nullable = false)
    private int quantity;


    @JsonIgnore
    //避免无限递归//
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
    //可选属性optional=false,表示fund不能为空。删除文章，不影响用户
    @JoinColumn(name="fund_id")//设置在position表中的关联字段(外键)
    private Fund fund;

    public Position() {
    }

    public Position(Long positionId, String securitySymbol, BigDecimal price, String assetClass, int quantity, Fund fund) {
        this.positionId = positionId;
        this.securitySymbol = securitySymbol;
        this.price = price;
        AssetClass = assetClass;
        this.quantity = quantity;
        this.fund = fund;
    }

    public Long getPositionId() {
        return positionId;
    }

    public String getSecuritySymbol() {
        return securitySymbol;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getAssetClass() {
        return AssetClass;
    }

    public int getQuantity() {
        return quantity;
    }

    public Fund getFund() {
        return fund;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public void setSecuritySymbol(String securitySymbol) {
        this.securitySymbol = securitySymbol;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setAssetClass(String assetClass) {
        AssetClass = assetClass;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setFund(Fund fund) {
        this.fund = fund;
    }

    //删除toString方法避免无限递归
//    @Override
//    public String toString() {
//        return "Position{" +
//                "positionID=" + positionID +
//                ", securitySymbol='" + securitySymbol + '\'' +
//                ", price=" + price +
//                ", AssetClass='" + AssetClass + '\'' +
//                ", quantity=" + quantity +
//                ", fund=" + fund +
//                '}';
//    }
}
