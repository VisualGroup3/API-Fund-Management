package com.group3.fundmgt.fund;

import com.fasterxml.jackson.annotation.*;
import com.group3.fundmgt.manager.Manager;
import com.group3.fundmgt.position.Position;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;


@Entity
@Table(name = "fund")

public class Fund {
    // 1.建表
    @Id
    private String fundId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long size;

    // length表示长度 ， scale表示小数点后位数
    @Column(nullable = false,length = 3,scale = 2)
    private BigDecimal equityPercentage;

    @Column(nullable = false,length = 3,scale = 2)
    private BigDecimal fixIncPercentage;

    @Column(nullable = false,length = 3,scale = 2)
    private BigDecimal commodPercentage;

    @Column(nullable = false,length = 3,scale = 2)
    private BigDecimal cashPercentage;

    @OneToMany(mappedBy = "fund",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    //级联保存、更新、删除、刷新;延迟加载。当删除用户，会级联删除该用户的所有文章
    //拥有mappedBy注解的实体类为关系被维护端
    //mappedBy="fund"中的fund是Position中的fund属性
    private List<Position> positionList;

    //避免无限递归//
    @JsonIgnore
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
    //可选属性optional=false,表示manager不能为空。
    @JoinColumn(name = "manager_employeeId")
    private Manager manager;

    // 2.生成构造方法
    public Fund(){}


    public Fund(String fundId, String name, Long size, BigDecimal equityPercentage, BigDecimal fixIncPercentage, BigDecimal commodPercentage, BigDecimal cashPercentage, List<Position> positionList, Manager manager) {
        this.fundId = fundId;
        this.name = name;
        this.size = size;
        this.equityPercentage = equityPercentage;
        this.fixIncPercentage = fixIncPercentage;
        this.commodPercentage = commodPercentage;
        this.cashPercentage = cashPercentage;
        this.positionList = positionList;
        this.manager = manager;
    }

    public String getFundId() {
        return fundId;
    }

    public String getName() {
        return name;
    }

    public Long getSize() {
        return size;
    }

    public BigDecimal getEquityPercentage() {
        return equityPercentage;
    }

    public BigDecimal getFixIncPercentage() {
        return fixIncPercentage;
    }

    public BigDecimal getCommodPercentage() {
        return commodPercentage;
    }

    public BigDecimal getCashPercentage() {
        return cashPercentage;
    }

    public List<Position> getPositionList() {
        return positionList;
    }

    public Manager getManager() {
        return manager;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public void setEquityPercentage(BigDecimal equityPercentage) {
        this.equityPercentage = equityPercentage;
    }

    public void setFixIncPercentage(BigDecimal fixIncPercentage) {
        this.fixIncPercentage = fixIncPercentage;
    }

    public void setCommodPercentage(BigDecimal commodPercentage) {
        this.commodPercentage = commodPercentage;
    }

    public void setCashPercentage(BigDecimal cashPercentage) {
        this.cashPercentage = cashPercentage;
    }

    public void setPositionList(List<Position> positionList) {
        this.positionList = positionList;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

//    @Override
//    public String toString() {
//        return "Fund{" +
//                "fundId='" + fundId + '\'' +
//                ", name='" + name + '\'' +
//                ", size=" + size +
//                ", equityPercentage=" + equityPercentage +
//                ", fixIncPercentage=" + fixIncPercentage +
//                ", commodPercentage=" + commodPercentage +
//                ", cashPercentage=" + cashPercentage +
//                ", positionList=" + positionList +
//                ", manager=" + manager +
//                '}';
//    }
}
