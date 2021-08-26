package com.group3.fundmgt.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, String> {

    @Query(nativeQuery = true,
            value = "select sum(value),asset_class from (SELECT asset_class,price*quantity value " +
                    "FROM position where position.fund_id=?1) a group by asset_class")
    public List getValueGroupByAssetClass(String fundID);
}
