package com.group3.fundmgt.position;

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

    public Position() {
    }

    public Position(Long id, Long securityID, int quantity, LocalDate datePurchased) {
        this.id = id;
        this.securityID = securityID;
        this.quantity = quantity;
        this.datePurchased = datePurchased;
    }

    public Position(Long securityID, int quantity, LocalDate datePurchased) {
        this.securityID = securityID;
        this.quantity = quantity;
        this.datePurchased = datePurchased;
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
                '}';
    }
}
