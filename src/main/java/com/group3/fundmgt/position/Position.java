package com.group3.fundmgt.position;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.group3.fundmgt.fund.Fund;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table

public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long securityID;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private LocalDate datePurchased;

    @JsonIgnore
    //避免无限递归//
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    //可选属性optional=false,表示author不能为空。删除文章，不影响用户
    @JoinColumn(name="fund_id")//设置在position表中的关联字段(外键)
    private Fund fund;

    public Position() {
    }

    public Position(Long id, Long securityID, int quantity, LocalDate datePurchased, Fund fund) {
        this.id = id;
        this.securityID = securityID;
        this.quantity = quantity;
        this.datePurchased = datePurchased;
        this.fund = fund;
    }

    public Position(Long securityID, int quantity, LocalDate datePurchased, Fund fund) {
        this.securityID = securityID;
        this.quantity = quantity;
        this.datePurchased = datePurchased;
        this.fund = fund;
    }

    public Fund getFund() {
        return fund;
    }

    public void setFund(Fund fund) {
        this.fund = fund;
    }

    public Long getId() {
        return id;
    }

    public Long getSecurityID() {
        return securityID;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getDatePurchased() {
        return datePurchased;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSecurityID(Long securityID) {
        this.securityID = securityID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDatePurchased(LocalDate datePurchased) {
        this.datePurchased = datePurchased;
    }


    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", securityID=" + securityID +
                ", quantity=" + quantity +
                ", datePurchased=" + datePurchased +
                ", fund=" + fund +
                '}';
    }
}
