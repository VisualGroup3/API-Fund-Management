package com.group3.fundmgt.fund;

import com.group3.fundmgt.position.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FundRepository extends JpaRepository<Fund,String> {

    @Query(nativeQuery = true,
            value = "select sum(value),asset_class from (SELECT asset_class,price*quantity value " +
            "FROM position where position.fund_id=?1) a group by asset_class")
    public List getValueGroupByAssetClass(String fundID);

    @Query(nativeQuery = true,
            value ="select sum(quantity*price) value,security_symbol from position where fund_id=?1 group by security_symbol" )
    public List getValueGroupBySecurity(String fundID);
}
