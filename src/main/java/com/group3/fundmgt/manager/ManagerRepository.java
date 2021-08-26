package com.group3.fundmgt.manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, String> {

    @Query(nativeQuery = true,
            value = "select sum(v.value),v.asset_class from\n" +
                    "                    (SELECT asset_class,price*quantity value FROM position as p,\n" +
                    "                    (select fund_id from fund where manager_employee_id=?1) as f\n" +
                    "                     where p.fund_id=f.fund_id) v\n" +
                    "                    group by asset_class")
    public List getValueGroupByAssetClass(String employeeId);
}
