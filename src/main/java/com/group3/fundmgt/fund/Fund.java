package com.group3.fundmgt.fund;

import com.fasterxml.jackson.annotation.*;
import com.group3.fundmgt.position.Position;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "fund")

public class Fund {
    // 1.建表
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fundId;

    @Column(nullable = false)
    private String name;


    @OneToMany(mappedBy = "fund",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    //级联保存、更新、删除、刷新;延迟加载。当删除用户，会级联删除该用户的所有文章
    //拥有mappedBy注解的实体类为关系被维护端
    //mappedBy="fund"中的fund是Position中的fund属性
    private List<Position> positionList;

    // 2.生成构造方法
    public Fund(){}

    public Fund(Long fundId, String name, List<Position> positionList) {
        this.fundId = fundId;
        this.name = name;
        this.positionList = positionList;
    }

    public Fund(String name, List<Position> positionList) {
        this.name = name;
        this.positionList = positionList;
    }

    public Fund(String name) {
        this.name = name;
    }

    // 3.生成set和get和toString方法
    public Long getFundId() {
        return fundId;
    }

    public void setFundId(Long fundId) {
        this.fundId = fundId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Position> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<Position> positionList) {
        this.positionList = positionList;
    }

    @Override
    public String toString() {
        return "Fund{" +
                "fundId=" + fundId +
                ", name='" + name + '\'' +
                ", positionList=" + positionList +
                '}';
    }
}
